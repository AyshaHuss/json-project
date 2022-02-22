import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns= "/RemoveCourseServlet")
public class RemoveCourseServlet extends HttpServlet {
    CoursesServices coursesServices = new CoursesServices();
    StudentServices studentServices = new StudentServices();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        coursesServices.loadPreviousCourses();
        studentServices.loadPreviousUsers();
        String toRemove = request.getParameter("course");
        coursesServices.removeStudent(toRemove, username);
        studentServices.removeCourse(username, toRemove);
        studentServices.saveToFile();
        coursesServices.saveToFile();
        request.setAttribute("myCourses", studentServices.getStdCoursesNames(username));
        request.setAttribute("toRemove", "you choose "+toRemove+" course to remove");
        request.getRequestDispatcher("Remove.jsp").forward(request, response);

    }
}
