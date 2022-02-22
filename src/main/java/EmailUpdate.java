import sun.rmi.runtime.Log;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/EmailUpdate")
public class EmailUpdate extends HttpServlet {
    LoginServices loginServices = new LoginServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String email = request.getParameter("email");

        loginServices.loadPreviousLoginInfo();

        String type = loginServices.getUserType(username);

        if(type.equals("admin")){
            AdminServices adminServices = new AdminServices();
            adminServices.loadPreviousUsers();
            adminServices.updateEmail(username, email);
            adminServices.saveToFile();
        }
        else if(type.equals("teacher")){
            TeacherServices teacherServices = new TeacherServices();
            teacherServices.loadPreviousUsers();
            teacherServices.updateEmail(username, email);
            teacherServices.saveToFile();
        }
        else if(type.equals("student")){
            StudentServices studentServices = new StudentServices();
            studentServices.loadPreviousUsers();
            studentServices.updateEmail(username, email);
            studentServices.saveToFile();
        }


        // userServices.loadPreviousUsers();
       // userServices.updateEmail(username, email);
       // userServices.saveToFile();
        //String newEmail = userServices.getEmail(username);
        String msg = "Email Updated " ;
        request.setAttribute("msg", msg);
        //request.setAttribute("username", username);
        request.getRequestDispatcher("EmailUpdate.jsp").forward(request, response);
    }
}
