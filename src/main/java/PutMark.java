import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/PutMark")
public class PutMark extends HttpServlet {
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
        String courseName = (String) session.getAttribute("cName");
        String fullName = request.getParameter("stdName");
        int mark = Integer.parseInt(request.getParameter("mark"));
        String stdId = studentServices.getStdId(fullName);
        String username = studentServices.getUsername(stdId);

        coursesServices.updateMark(courseName, username, mark);
        studentServices.updateMark(stdId, courseName, mark);

        coursesServices.saveToFile();
        studentServices.saveToFile();



        request.setAttribute("stdNames", coursesServices.getStdFullName(courseName));
        request.setAttribute("myCourses", teacherServices.getCourses(username));

        request.setAttribute("students",coursesServices.getStudentsInfo(courseName));
        request.setAttribute("name",courseName);

        request.setAttribute("msg", fullName+" mark has been updated to "+ mark+" in "+courseName);
        request.getRequestDispatcher("PutMark.jsp").forward(request, response);
    }
}
