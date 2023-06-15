package MockExam18.softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public String insert(Student student) {
        if (data.contains(student)) {
            return "Student is already in the hall.";
        }

        if (data.size() >= capacity) {
            return "The hall is full.";
        }

        data.add(student);
        return "Added student " +
                student.getFirstName() +
                " " +
                student.getLastName() +
                ".";
    }

    public String remove(Student student) {
        if (data.remove(student)) {
            return "Removed student " +
                    student.getFirstName() +
                    " " +
                    student.getLastName() +
                    ".";
        } else {
            return "Student not found.";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : data) {
            if (student.getFirstName().equals(firstName) &&
                    student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append("Hall size: ")
                .append(getCount())
                .append(System.lineSeparator());
        for (Student student : data) {
            statistics.append(student)
                    .append(System.lineSeparator());
        }
        return statistics.toString().trim();
    }
}
