import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentServices {
    private static List<Student> studentList = new ArrayList<Student>();

    public void loadPreviousUsers() {
        String fileName = "C:/Users/Home/Desktop/final-project/jsp/json-files/Students.json";
        //String fileName = "/usr/local/tomcat/json/Students.json";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(fileName);
            studentList = objectMapper.readValue(file, new TypeReference<List<Student>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFullName(String username) {
        for (Student student : studentList) {
            if (student.getUsername().equals(username))
                return student.getFullName();
        }
        return null;
    }

    public void addNewUser(Student std) {
        studentList.add(std);
    }


    public void addCourse(String username, String courseName) {
        for (Student student : studentList) {
            if (student.getUsername().equals(username))
                student.addCourse(courseName);
        }
    }

    public void removeCourse(String username, String courseName) {
        for (Student student : studentList) {
            if (student.getUsername().equals(username))
                student.removeCourse(courseName);
        }
    }

    public String getStdId(String fullName){
        for(Student student: studentList)
            if(student.getFullName().equals(fullName))
                return student.getId();
        return null;
    }

    public String getUsername(String id) {
        for (Student student : studentList)
            if (student.getId().equals(id))
                return student.getUsername();
        return null;
    }

    public List<String> getStdCoursesNames(String username) {
        for (Student student : studentList)
            if (student.getUsername().equals(username))
                return student.getCoursesNames();
        return  null;
    }



    public Map<String, Integer> getMyCourses(String username){
        for(Student student: studentList)
            if(student.getUsername().equals(username))
                return student.getCourses();
        return null;
    }

    public void updatePassword(String username, String password){
        for (Student student : studentList)
            if (student.getUsername().equals(username))
                student.setPassword(password);

    }

    public void setAddress(String username, Address address){
        for (Student student : studentList)
            if (student.getUsername().equals(username))
                student.setAddress(address);
    }


    public void updateEmail(String username, String email){
        for(Student student: studentList)
            if(student.getUsername().equals(username))
                student.setEmail(email);
    }


    public void updateMark(String stdId, String courseName, int mark){
        for(Student student: studentList)
            if(student.getId().equals(stdId)) {
                student.updateMark(courseName, mark);
            }
    }


    public   List<String> getStudentsName(){
        List<String> stdNames = new ArrayList<String>();
        for(Student student: studentList)
            stdNames.add(student.getFullName());

        return stdNames;
    }


    public String getFullNameByUsername(String username){
        for(Student student: studentList)
            if(student.getUsername().equals(username))
                return student.getFullName();
        return null;
    }



    public void saveToFile() {
        String fileName = "C:/Users/Home/Desktop/final-project/jsp/json-files/Students.json";
        //String fileName = "/usr/local/tomcat/json/Students.json";

        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectMapper objectMapper = new ObjectMapper();
            String toJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentList);

            fileOutputStream.write(toJson.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
