import com.fasterxml.jackson.databind.ObjectMapper;
import sun.rmi.runtime.Log;
import sun.util.resources.cldr.fa.LocaleNames_fa;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@WebServlet(urlPatterns = "/Login")
public class Login extends HttpServlet {
    LoginServices loginServices = new LoginServices();




    User user = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loginServices.loadPreviousLoginInfo();
        String username = request.getParameter("username");
        String password = request.getParameter("pass");

        String type = null;
        if ((loginServices.isValidUser(username, password))) {
            request.setAttribute("username", username);
             type = loginServices.getUserType(username);
             request.setAttribute("type", type);


            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("type", type);


            if(type.equals("student")) {
                StudentServices studentServices = new StudentServices();
                studentServices.loadPreviousUsers();
                request.setAttribute("name",studentServices.getFullName(username));
                request.getRequestDispatcher("StudentServices.jsp").forward(request, response);
            }
            else if(type.equals("teacher")) {
                TeacherServices teacherServices = new TeacherServices();
                teacherServices.loadPreviousUsers();
                request.setAttribute("name",teacherServices.getFullName(username));
                request.getRequestDispatcher("TeacherServices.jsp").forward(request, response);
            }
            else if(type.equals("admin")) {
                AdminServices adminServices = new AdminServices();
               adminServices.loadPreviousUsers();
               request.setAttribute("name", adminServices.getFullName(username));
               request.getRequestDispatcher("AdminServices.jsp").forward(request, response);
            }

        } else {


            request.setAttribute("msg", "Invalid Login");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
    }
}

