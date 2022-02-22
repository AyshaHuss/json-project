import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/OtherTeacherServices")
public class OtherTeacherServices extends HttpServlet {
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
        String action = request.getParameter("action");

        if(action.equals("allCourses")){
            coursesServices.loadPreviousCourses();
            teacherServices.loadPreviousUsers();
            request.setAttribute("num", coursesServices.getCoursesNumber());
            request.setAttribute("allCourses", coursesServices.getCoursesInfo());
            request.getRequestDispatcher("ViewCourses.jsp").forward(request, response);
        }
        else if(action.equals("putMark")){
            request.setAttribute("username", username);
            teacherServices.loadPreviousUsers();
            studentServices.loadPreviousUsers();
            coursesServices.loadPreviousCourses();
            request.setAttribute("myCourses", teacherServices.getCourses(username));
            request.getRequestDispatcher("PutMark.jsp").forward(request, response);

        }
        else if(action.equals("myCourses")) {
            teacherServices.loadPreviousUsers();
            coursesServices.loadPreviousCourses();
            request.setAttribute("myCourses", teacherServices.getCourses(username));
            request.setAttribute("myCoursesNum", teacherServices.getCourses(username).size());
            request.getRequestDispatcher("ViewTeacherCourses.jsp").forward(request, response);
        }
        else if(action.equals("myStudents")){
            request.setAttribute("username", username);
            teacherServices.loadPreviousUsers();
            studentServices.loadPreviousUsers();
            coursesServices.loadPreviousCourses();
            request.setAttribute("myCourses", teacherServices.getCourses(username));
            request.getRequestDispatcher("ViewMyStudents.jsp").forward(request, response);
        }

    }
}
