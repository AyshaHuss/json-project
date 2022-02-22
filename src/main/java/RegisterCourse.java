import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/RegisterCourse")
public class RegisterCourse extends HttpServlet {
    CoursesServices coursesServices = new CoursesServices();
    StudentServices studentServices = new StudentServices();
    TeacherServices teacherServices = new TeacherServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TeacherServices.loadPreviousUsers();
        coursesServices.loadPreviousCourses();
        request.setAttribute("allCourses", coursesServices.getCoursesInfo());
        request.setAttribute("num", coursesServices.getCoursesNumber());
        request.setAttribute("coursesNames", coursesServices.getCoursesNames());
        request.getRequestDispatcher("RegisterCourse.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        studentServices.loadPreviousUsers();
        coursesServices.loadPreviousCourses();
        teacherServices.loadPreviousUsers();
        String courseName = request.getParameter("course");
        HttpSession session = request.getSession();
        String stdUsername = (String) session.getAttribute("username");
        String msg = null;
        if(CoursesServices.getCourse(courseName).getStudents().size()< CoursesServices.getCourse(courseName).getMaxStdNum()) {
            coursesServices.addStudent(courseName, stdUsername);
            studentServices.addCourse(stdUsername, courseName);
            coursesServices.saveToFile();
            studentServices.saveToFile();
             msg = "course Added";
        }
        else{
             msg = "course full";
        }
        request.setAttribute("msg", msg);
        coursesServices.loadPreviousCourses();
        request.setAttribute("allCourses", coursesServices.getCoursesInfo());
        request.setAttribute("num", coursesServices.getCoursesNumber());
        request.setAttribute("coursesNames", coursesServices.getCoursesNames());
        request.getRequestDispatcher("RegisterCourse.jsp").forward(request, response);




    }
}
