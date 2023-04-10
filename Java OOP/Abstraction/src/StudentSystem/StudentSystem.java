package StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentsMap;

    public StudentSystem()
    {
        this.studentsMap = new HashMap<>();
    }

    public Map<String, Student> getStudentsMap() {
        return this.studentsMap;
    }

    public boolean containsName(String name){
        return this.studentsMap.containsKey(name);
    }

    public void addStudent(Student student){
        this.studentsMap.put(student.getName(), student);
    }

    public Student getStudent(String name){
        return this.studentsMap.get(name);
    }

}
