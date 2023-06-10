package MockExam8.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        if (students.contains(student)) {
            return "Student is already in the university";
        } else if (students.size() >= capacity) {
            return "No seats in the university";
        } else {
            students.add(student);
            return "Added student " + student.getFirstName() + " " + student.getLastName();
        }
    }

    public String dismissStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return "Removed student " + student.getFirstName() + " " + student.getLastName();
        } else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        for (Student student : students) {
            statistics.append("==Student: First Name = ")
                    .append(student.getFirstName())
                    .append(", Last Name = ")
                    .append(student.getLastName())
                    .append(", Best Subject = ")
                    .append(student.getBestSubject())
                    .append("\n");
        }
        return statistics.toString().trim();
    }
}
