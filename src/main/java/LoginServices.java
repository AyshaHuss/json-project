import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LoginServices  {
    private static List<LoginInfo> logins = new ArrayList<LoginInfo>();

    public void loadPreviousLoginInfo(){
        String fileName = "C:/Users/Home/Desktop/final-project/jsp/json-files/Login.json";
        //String fileName = "/usr/local/tomcat/json/Login.json";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(fileName);
            logins = objectMapper.readValue(file, new TypeReference<List<LoginInfo>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isValidUser(String username, String password) {
        for (LoginInfo loginInfo : logins) {
            if (loginInfo.getUsername().equals(username) && loginInfo.getPassword().equals(password))
                return true;
        }
        return false;
    }

    public String getUserType(String username) {
        for (LoginInfo loginInfo : logins)
            if (loginInfo.getUsername().equals(username))
                return loginInfo.getType();
        return null;
    }


    public void updatePassword(String username, String password){
        for(LoginInfo loginInfo: logins){
            if(loginInfo.getUsername().equals(username))
                loginInfo.setPassword(password);
        }
    }

    public void addNewLogin(LoginInfo loginInfo){
        logins.add(loginInfo);
    }

    public void saveToFile(){
        String fileName = "C:/Users/Home/Desktop/final-project/jsp/json-files/Login.json";
        //String fileName = "/usr/local/tomcat/json/Login.json";

        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectMapper objectMapper = new ObjectMapper();
            String toJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(logins);

            fileOutputStream.write(toJson.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}
