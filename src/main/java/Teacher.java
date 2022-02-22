import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Teacher extends User{

    private List<String> courses = new ArrayList<String>();
    public Teacher() {
        super();
    }

    public Teacher(String firstName, String lastName, String email, String type) {
        super(firstName, lastName, email, "teacher");
    }

    public void addCourse(String courseName){
        courses.add(courseName);
    }



    public List<String> getCourses(){
        return courses;
    }



}
