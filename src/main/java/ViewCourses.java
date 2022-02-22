import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/ViewCourses")
public class ViewCourses extends HttpServlet {
    CoursesServices coursesServices = new CoursesServices();
    TeacherServices teacherServices = new TeacherServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("allCourses",session.getAttribute("allCourses"));
        request.getRequestDispatcher("ViewCourses.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        coursesServices.loadPreviousCourses();
        teacherServices.loadPreviousUsers();
        int num = coursesServices.getCoursesNumber();
        request.setAttribute("coursesNames", coursesServices.getCoursesInfo());
        request.setAttribute("num", num);
        request.getRequestDispatcher("ViewCourses.jsp").forward(request, response);


    }
}
