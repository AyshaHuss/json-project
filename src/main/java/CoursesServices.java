import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoursesServices {
    private static List<Course> courses = new ArrayList<Course>();
    TeacherServices teacherServices = new TeacherServices();


    public void loadPreviousCourses() {
       String fileName = "C:/Users/Home/Desktop/final-project/jsp/json-files/Courses.json";
        //String fileName = "/usr/local/tomcat/json/Courses.json";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(fileName);
            courses = objectMapper.readValue(file, new TypeReference<List<Course>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public  Map<String, Integer> getStudentsInfo(String courseName) {
        for (Course course : courses)
            if (course.getCourseName().equals(courseName))
                return course.getStudents();
    return null;

    }
    public int getCoursesNumber(){
        return courses.size();
    }

    public void addNewCourse(Course course){
        courses.add(course);
    }

    public List<Course> getCourses(){
        return courses;
    }

    public List<String> getCoursesNames(){
        List<String> names = new ArrayList<String>();
        for (Course course: courses){
            names.add(course.getCourseName());
        }
        return names;
    }

    public List<String> getCoursesInfo(){
        teacherServices.loadPreviousUsers();
        List<String> info = new ArrayList<String>();
        teacherServices.loadPreviousUsers();
            for (Course course: courses){
                info.add("Course Name : "+course.getCourseName()+",  Teacher name : "+teacherServices.getFullNameById(course.getTeacherId()));
        }
            return info;
    }

    public static Course getCourse(String name){
        for (Course course : courses)
            if (course.getCourseName().equals(name))
                return course;
        return null;
    }



    public List<String> getStdUsernames(String courseName){
        for(Course course: courses)
            if(course.getCourseName().equals(courseName))
                return course.getStudentUsernames();
        return null;
    }

    public List<String> getStdFullName(String courseName){
        List<String> stdFullName = new ArrayList<String>();
        for(Course course: courses)
            if(course.getCourseName().equals(courseName))
                return course.getStdFullName();

        return null;
    }


    public void  addStudent(String courseName, String stdId){
        for (Course course : courses)
            if (course.getCourseName().equals(courseName) ) {
                course.addStd(stdId);
                saveToFile();
            }

    }


    public void removeStudent(String courseName, String stdId){
        for(Course course: courses)
            if(course.getCourseName().equals(courseName)){
                course.removeStd(stdId);
            }
            }



    public void updateMark(String courseName, String stdId, int mark){
        for (Course course : courses)
            if (course.getCourseName().equals(courseName)){
                course.updateMark(stdId, mark);
            }
    }


    public Map<String, Integer> getPassesStd (String name){
        Map<String , Integer> passedStd;
        for (Course course : courses)
            if (course.getCourseName().equals(name)){
                passedStd = course.getPassStds();
                return passedStd;
            }
        return null;
    }


    public Map<String, Integer> getFailedStd (String name){
        Map<String , Integer> failedStd;
        for (Course course : courses)
            if (course.getCourseName().equals(name)){
                failedStd = course.getFailStds();
                return failedStd;
            }
        return null;
    }



    public Map<String, Integer> getAllStd(String name){
        Map<String, Integer> allStd;
        for (Course course : courses)
            if (course.getCourseName().equals(name)){
                allStd = course.getAllStds();
                return allStd;
            }
        return null;

    }



    public void saveToFile(){
        String fileName = "C:/Users/Home/Desktop/final-project/jsp/json-files/Courses.json";
        //String fileName = "/usr/local/tomcat/json/Courses.json";
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectMapper objectMapper = new ObjectMapper();
            String toJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(courses);

            fileOutputStream.write(toJson.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}
