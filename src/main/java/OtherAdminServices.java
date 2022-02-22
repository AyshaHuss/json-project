import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns= "/OtherAdminServices")
public class OtherAdminServices extends HttpServlet {
    TeacherServices teacherServices = new TeacherServices();
    CoursesServices coursesServices = new CoursesServices();
    StudentServices studentServices = new StudentServices();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action.equals("addUser"))
            request.getRequestDispatcher("NewRegistration.jsp").forward(request, response);
        else if(action.equals("newCourse")){
            teacherServices.loadPreviousUsers();
            coursesServices.loadPreviousCourses();
            request.setAttribute("num", coursesServices.getCoursesNumber());
            request.setAttribute("allCourses", coursesServices.getCoursesInfo());
            request.setAttribute("teachers",teacherServices.getTeachersNames());
            request.getRequestDispatcher("AddNewCourse.jsp").forward(request,response);
        }
        else if (action.equals("allCourses")){
            coursesServices.loadPreviousCourses();
            teacherServices.loadPreviousUsers();
            request.setAttribute("num", coursesServices.getCoursesNumber());
            request.setAttribute("allCourses", coursesServices.getCoursesInfo());
            request.getRequestDispatcher("ViewCourses.jsp").forward(request, response);
        }
        else if(action.equals("allTeachers")){
            teacherServices.loadPreviousUsers();
            request.setAttribute("allTeachers",teacherServices.getTeachersNames());
            request.setAttribute("num", teacherServices.getTeachersNames().size());
            request.getRequestDispatcher("ViewAllTeachers.jsp").forward(request, response);
        }

        else if(action.equals("allStudents")){
            studentServices.loadPreviousUsers();
            request.setAttribute("allStds", studentServices.getStudentsName());
            request.setAttribute("num",studentServices.getStudentsName().size());
            request.getRequestDispatcher("ViewAllStudents.jsp").forward(request, response);
        }

    }
}
