import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/AddCourse")
public class AddCourse extends HttpServlet {
    CoursesServices coursesServices = new CoursesServices();
    TeacherServices teacherServices = new TeacherServices();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        teacherServices.loadPreviousUsers();
        coursesServices.loadPreviousCourses();
        request.setAttribute("teachers",teacherServices.getTeachersNames());
        request.setAttribute("allCourses", coursesServices.getCoursesInfo());
        request.setAttribute("num", coursesServices.getCoursesNumber());


        request.getRequestDispatcher("AddNewCourse.jsp").forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        coursesServices.loadPreviousCourses();
        teacherServices.loadPreviousUsers();
        TeacherServices teacherServices = new TeacherServices();
        String courseName = request.getParameter("courseName");
        String teacherName = request.getParameter("name");
        int mxStd = Integer.parseInt(request.getParameter("maxStd"));
        String id = teacherServices.getIdByName(teacherName);



        coursesServices.addNewCourse(new Course(courseName, id, mxStd));
        teacherServices.addCourses(id, courseName);

        teacherServices.saveToFile();
        coursesServices.saveToFile();

        request.setAttribute("allCourses", coursesServices.getCoursesInfo());
        request.setAttribute("length", coursesServices.getCoursesNumber());
        request.setAttribute("teachers",teacherServices.getTeachersNames());
        request.setAttribute("num", coursesServices.getCoursesNumber());

        request.setAttribute("msg", "course added");
        request.getRequestDispatcher("AddNewCourse.jsp").forward(request, response);




    }
}
