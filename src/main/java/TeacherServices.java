import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TeacherServices {
    private static List<Teacher> teacherList = new ArrayList<Teacher>();

    public void loadPreviousUsers() {
        String fileName = "C:/Users/Home/Desktop/final-project/jsp/json-files/Teachers.json";
        //String fileName = "/usr/local/tomcat/json/Teachers.json";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(fileName);
            teacherList = objectMapper.readValue(file, new TypeReference<List<Teacher>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCourses(String id, String courseName) {
        for (Teacher teacher : teacherList) {
            if (teacher.getId().equals(id))
                teacher.addCourse(courseName);
        }
    }


    public void updatePassword(String username, String password){
        for (Teacher teacher : teacherList)
            if (teacher.getUsername().equals(username))
                teacher.setPassword(password);

    }

    public void setAddress(String username, Address address) {
        for (Teacher teacher : teacherList)
            if (teacher.getUsername().equals(username))
                teacher.setAddress(address);

    }

    public void updateEmail(String username, String email){
        for(Teacher teacher: teacherList)
            if(teacher.getUsername().equals(username))
                teacher.setEmail(email);
    }


    public List<String> getCourses(String username){
        for(Teacher teacher: teacherList)
            if(teacher.getUsername().equals(username))
                return teacher.getCourses();
        return null;
    }

    public void addNewUser(Teacher teacher) {
        teacherList.add(teacher);
    }

    public  String getFullName(String username){
        for (Teacher teacher : teacherList) {
            if (teacher.getUsername().equals(username))
                return teacher.getFullName();
        }
        return null;
    }

    public String getIdByName(String name){
        for(Teacher teacher: teacherList)
            if(teacher.getFullName().equals(name))
                return teacher.getId();
        return null;
    }


    public String getFullNameById(String id){
        for (Teacher teacher : teacherList) {
            if (teacher.getId().equals(id))
                return teacher.getFullName();
        }
        return null;
    }


    public List<String>getTeachersNames(){
        List<String> teacherNames = new ArrayList<String>();
        for(Teacher teacher: teacherList)
            teacherNames.add(teacher.getFullName());
        return teacherNames;
    }


    public void saveToFile() {
        //String fileName = "/usr/local/tomcat/json/Teachers.json";
        String fileName = "C:/Users/Home/Desktop/final-project/jsp/json-files/Teachers.json";
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectMapper objectMapper = new ObjectMapper();
            String toJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(teacherList);

            fileOutputStream.write(toJson.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
