import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.sun.xml.internal.ws.addressing.WsaTubeHelper;
import org.omg.CORBA.WStringSeqHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends User {

    private Map<String, Integer> courses = new HashMap<String , Integer>();

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, String email, String type) {
        super(firstName, lastName, email, "student");
    }


    public void addCourse(String courseName){
        courses.put(courseName, 0);
    }


    public void removeCourse(String courseName){
        courses.remove(courseName);
    }

    public Map<String, Integer> getCourses(){
        return courses;
    }


    public void updateMark(String courseName, int mark){
        courses.replace(courseName, mark);
    }

    @JsonIgnore
    public List<String> getCoursesNames(){
        List<String> list = new ArrayList<>(courses.keySet());
        return list;
    }


}
