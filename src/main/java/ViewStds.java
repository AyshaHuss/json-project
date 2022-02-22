import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/ViewStds")
public class ViewStds extends HttpServlet {
    TeacherServices teacherServices = new TeacherServices();
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
        String courseName = request.getParameter("name");
        session.setAttribute("cName", courseName);
        session.setAttribute("username", username);
        request.setAttribute("cName", courseName);
        request.setAttribute("msg", "students in "+courseName+" are :  ");
        request.setAttribute("std", coursesServices.getStdUsernames(courseName));
        request.setAttribute("num", coursesServices.getStdUsernames(courseName).size());
        request.setAttribute("allCourses", coursesServices.getCoursesInfo());
        request.setAttribute("stdNames", coursesServices.getStdFullName(courseName));
        teacherServices.loadPreviousUsers();
        request.setAttribute("myCourses", teacherServices.getCourses(username));
        request.getRequestDispatcher("PutMark.jsp").forward(request, response);

    }
}
