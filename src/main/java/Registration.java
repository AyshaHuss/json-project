import com.fasterxml.jackson.databind.cfg.ConstructorDetector;
import sun.rmi.runtime.Log;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.peer.LabelPeer;
import java.io.IOException;

@WebServlet(urlPatterns = "/Registration")
public class Registration extends HttpServlet {
    LoginServices loginServices = new LoginServices();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loginServices.loadPreviousLoginInfo();

        String firstName = request.getParameter("fName");
        String lastName = request.getParameter("lName");
        String email = request.getParameter("email");
        String type = request.getParameter("userType");

        request.setAttribute("fName", firstName);
        request.setAttribute("lName", lastName);
        request.setAttribute("email", email);
        request.setAttribute("type", type);


        User user = null;
        if(type.equals("admin")){
            AdminServices adminServices = new AdminServices();
            user = new Admin(firstName, lastName, email, type);
            adminServices.addNewUser((Admin)user);
            adminServices.saveToFile();
        }
        else if(type.equals("teacher")){
            TeacherServices teacherServices = new TeacherServices();
            user = new Teacher(firstName, lastName, email, type);
            teacherServices.addNewUser((Teacher) user);
            teacherServices.saveToFile();
        }
        else if(type.equals("student")){
            StudentServices studentServices = new StudentServices();
            user = new Student(firstName, lastName, email, type);
            studentServices.addNewUser((Student) user);
            studentServices.saveToFile();
        }



        request.setAttribute("username", user.getUsername());
        request.setAttribute("password", user.getPassword());

        loginServices.addNewLogin(new LoginInfo(user.getUsername(), user.getPassword(), user.getType()));
        loginServices.saveToFile();
        request.getRequestDispatcher("Welcome.jsp").forward(request, response);

    }
}
