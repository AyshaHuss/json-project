import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/CoursesServ")
public class CoursesServ extends HttpServlet {
    CoursesServices coursesServices = new CoursesServices();
    TeacherServices teacherServices = new TeacherServices();
    StudentServices studentServices = new StudentServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        coursesServices.loadPreviousCourses();
        studentServices.loadPreviousUsers();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        request.setAttribute("username", username);
        String action = request.getParameter("action");
        if(action.equals("newCourse")) {
            coursesServices.loadPreviousCourses();
            request.setAttribute("allCourses", coursesServices.getCoursesInfo());
            request.setAttribute("num", coursesServices.getCoursesNumber());
            request.setAttribute("coursesNames",coursesServices.getCoursesNames());
            request.getRequestDispatcher("RegisterCourse.jsp").forward(request, response);
        }
        else if(action.equals("myCourses")) {
            studentServices.loadPreviousUsers();
            request.setAttribute("myCourses", studentServices.getMyCourses(username));
            request.getRequestDispatcher("ViewStudentCourses.jsp").forward(request, response);
        }
        else if(action.equals("allCourses")) {
            coursesServices.loadPreviousCourses();
            teacherServices.loadPreviousUsers();
            request.setAttribute("num", coursesServices.getCoursesNumber());
            request.setAttribute("allCourses", coursesServices.getCoursesInfo());
            request.getRequestDispatcher("ViewCourses.jsp").forward(request, response);
        }
        else if(action.equals("remove")){
            request.setAttribute("username", username);
            studentServices.loadPreviousUsers();
            request.setAttribute("myCourses", studentServices.getStdCoursesNames(username));
            request.getRequestDispatcher("Remove.jsp").forward(request, response);
        }


    }
}
