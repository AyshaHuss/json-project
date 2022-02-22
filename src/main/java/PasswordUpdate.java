import sun.rmi.runtime.Log;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/PasswordUpdate")
public class PasswordUpdate extends HttpServlet {
    LoginServices loginServices = new LoginServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loginServices.loadPreviousLoginInfo();

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String password = request.getParameter("pass");


        String type = loginServices.getUserType(username);

        if(type.equals("admin")){
            AdminServices adminServices = new AdminServices();
            adminServices.loadPreviousUsers();
            adminServices.updatePassword(username, password);
            adminServices.saveToFile();
        }
        else if(type.equals("teacher")){
            TeacherServices teacherServices = new TeacherServices();
            teacherServices.loadPreviousUsers();
            teacherServices.updatePassword(username, password);
            teacherServices.saveToFile();
        }
        else if(type.equals("student")){
            StudentServices studentServices = new StudentServices();
            studentServices.loadPreviousUsers();
            studentServices.updatePassword(username, password);
            studentServices.saveToFile();
        }


        loginServices.updatePassword(username, password);
        loginServices.saveToFile();

        String msg = "Password Updated";
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("PasswordUpdate.jsp").forward(request, response);


    }
}
