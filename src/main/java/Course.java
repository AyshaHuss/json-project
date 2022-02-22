import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course implements Serializable {
    private String courseName;
    private String teacherId;
    private int maxStdNum;
    private Map<String, Integer> students = new HashMap<String, Integer>();
    StudentServices studentServices = new StudentServices();


    public Course(){
        super();
    }

    public Course(String courseName, String teacherId, int maxStdNum){
        super();
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.maxStdNum = maxStdNum;
    }


    public void addStd(String id){
        if(students.size()<maxStdNum)
        students.put(id,0);
    }

    public void removeStd(String id){
        students.remove(id);
    }

    public void updateMark(String id, int mark){
        students.replace(id, mark);
    }

    public Map<String , Integer> getStudents(){
        return students;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public int getMaxStdNum() {
        return maxStdNum;
    }


    @JsonIgnore
    public List<String> getStudentUsernames(){
        List<String> list = new ArrayList<>(students.keySet());
        return list;
    }


    @JsonIgnore
    public List<String> getStdFullName(){
        studentServices.loadPreviousUsers();
        List<String> list = new ArrayList<String>();
        for(String username : students.keySet())
            list.add(studentServices.getFullNameByUsername(username));
        return list;
    }



    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", teacherId='" + teacherId + '\'' +
                '}';
    }

    @JsonIgnore
    public Map<String, Integer> getPassStds(){
        Map<String, Integer> passed = new HashMap<String , Integer>();
        for(Map.Entry<String, Integer> entry : students.entrySet()){
            if(entry.getValue()>=50)
                passed.put(studentServices.getFullName(entry.getKey()), entry.getValue());
        }
           return passed;
    }

    @JsonIgnore
    public Map<String, Integer> getFailStds(){
        Map<String, Integer> fail = new HashMap<String , Integer>();
        for(Map.Entry<String, Integer> entry : students.entrySet()){
            if(entry.getValue()<50)
                fail.put(studentServices.getFullName(entry.getKey()), entry.getValue());
        }
        return fail;
    }


    @JsonIgnore
    public Map<String, Integer> getAllStds(){
        Map<String, Integer> allStd = new HashMap<String , Integer>();
        for(Map.Entry<String, Integer> entry : students.entrySet()){
                allStd.put(studentServices.getFullName(entry.getKey()), entry.getValue());
        }
        return allStd;

    }

}
