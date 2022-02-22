import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/AddressUpdate")
public class AddressUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginServices loginServices = new LoginServices();
        loginServices.loadPreviousLoginInfo();

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        String type = loginServices.getUserType(username);

        String city = request.getParameter("city");
        String streetName = request.getParameter("street");
        int buildingNum = Integer.parseInt(request.getParameter("buildingNum"));

        if(type.equals("admin")){
            AdminServices adminServices = new AdminServices();
            adminServices.loadPreviousUsers();
            adminServices.setAddress(username, new Address(city, streetName, buildingNum));
            adminServices.saveToFile();
        }
        else if(type.equals("teacher")){
            TeacherServices teacherServices = new TeacherServices();
            teacherServices.loadPreviousUsers();
            teacherServices.setAddress(username, new Address(city, streetName, buildingNum));
            teacherServices.saveToFile();
        }
        else if(type.equals("student")){
            StudentServices studentServices = new StudentServices();
            studentServices.loadPreviousUsers();
            studentServices.setAddress(username, new Address(city, streetName, buildingNum));
            studentServices.saveToFile();
        }




        String msg = "Address Updated";
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("AddressUpdate.jsp").forward(request, response);


    }
}
