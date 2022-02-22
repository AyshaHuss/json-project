import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AdminServices {
    private static List<Admin> adminList = new ArrayList<Admin>();
    public void loadPreviousUsers() {
        String fileName = "C:/Users/Home/Desktop/final-project/jsp/json-files/Admins.json";
        //String fileName = "/usr/local/tomcat/json/Admins.json";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(fileName);
            adminList = objectMapper.readValue(file, new TypeReference<List<Admin>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewUser(Admin admin) {
        adminList.add(admin);
    }

    public void updatePassword(String username, String password){
        for (Admin admin : adminList)
            if (admin.getUsername().equals(username))
                admin.setPassword(password);

    }


    public void setAddress(String username, Address address){
        for(Admin admin: adminList){
            if(admin.getUsername().equals(username))
                admin.setAddress(address);
        }
    }

    public void updateEmail(String username, String email){
        for(Admin admin: adminList){
            if(admin.getUsername().equals(username))
                admin.setEmail(email);
        }
    }

    public String getFullName(String username){
        for (Admin admin : adminList) {
            if (admin.getUsername().equals(username))
                return admin.getFullName();
        }
        return null;
    }

    public void saveToFile() {
        String fileName = "C:/Users/Home/Desktop/final-project/jsp/json-files/Admins.json";
        //String fileName = "/usr/local/tomcat/json/Admins.json";

        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectMapper objectMapper = new ObjectMapper();
            String toJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(adminList);

            fileOutputStream.write(toJson.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
