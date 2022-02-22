import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ViewMyStds", value = "/ViewMyStds")
public class ViewMyStds extends HttpServlet {
    CoursesServices coursesServices = new CoursesServices();
    StudentServices studentServices = new StudentServices();
    TeacherServices teacherServices = new TeacherServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       coursesServices.loadPreviousCourses();
       studentServices.loadPreviousUsers();
       teacherServices.loadPreviousUsers();
       HttpSession session = request.getSession();

        String username = (String) session.getAttribute("username");

        String courseName = request.getParameter("name");
        String action = request.getParameter("action");


        request.setAttribute("myCourses", teacherServices.getCourses(username));
        if(action.equals("allStd")){
            //request.setAttribute("stdNames", coursesServices.getStdFullName(courseName));
            //request.setAttribute("num", coursesServices.getStdFullName(courseName).size());
            request.setAttribute("allStd", coursesServices.getAllStd(courseName));
        }
        else if(action.equals("passStd")){
            request.setAttribute("stdNames",coursesServices.getPassesStd(courseName));
            request.setAttribute("num", coursesServices.getPassesStd(courseName).size());
            request.setAttribute("passStd",coursesServices.getPassesStd(courseName));
        }
        else if(action.equals("failStd")){
            request.setAttribute("stdNames", coursesServices.getFailedStd(courseName));
            request.setAttribute("num", coursesServices.getFailedStd(courseName).size());
            request.setAttribute("failStd", coursesServices.getFailedStd(courseName));


        }

        //request.setAttribute("num", coursesServices.getStdFullName(courseName).size());
        request.setAttribute("ch_action",action);
        request.getRequestDispatcher("ViewMyStudents.jsp").forward(request, response);

    }
}
