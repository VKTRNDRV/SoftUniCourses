import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String hometown;

    public Student(String firstName, String lastName, int age, String hometown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hometown = hometown;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public String getHometown(){
        return hometown;
    }
    public void setHometown(String hometown){
        this.hometown = hometown;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Student> studentsList = new ArrayList<>();

        while (true){
            String[] currentLine = scan.nextLine().split(" ");
            if(currentLine[0].equals("end")){
                break;
            }

            String firstName = currentLine[0];
            String lastName = currentLine[1];
            int age = Integer.parseInt(currentLine[2]);
            String hometown = currentLine[3];

            if(!Student.isPresent(studentsList, firstName, lastName)) {
                Student currentStudent = new Student(firstName, lastName, age, hometown);
                studentsList.add(currentStudent);

            }else{
                Student rewrittenStudent = getStudent(studentsList, firstName, lastName);
                rewrittenStudent.setFirstName(firstName);
                rewrittenStudent.setLastName(lastName);
                rewrittenStudent.setAge(age);
                rewrittenStudent.setHometown(hometown);
            }
        }

        String filterTown = scan.nextLine();
        for(Student currentStudent : studentsList){
            if(currentStudent.getHometown().equals(filterTown)){
                String firstName = currentStudent.getFirstName();
                String lastName = currentStudent.getLastName();
                int age = currentStudent.getAge();
                System.out.printf("%s %s is %d years old%n", firstName, lastName, age);
            }
        }
    }

    public static boolean isPresent(List<Student> list, String firstName, String lastName){
        boolean isPresent = false;
        for(Student currentStudent : list){
            if(currentStudent.getFirstName().equals(firstName) && currentStudent.getLastName().equals(lastName)){
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }

    public static Student getStudent(List<Student> list, String firstName, String lastName){
        Student existingStudent = null;
        for(Student currentStudent : list){
            String currentFirstName = currentStudent.getFirstName();
            String currentLastName = currentStudent.getLastName();
            if(currentFirstName.equals(firstName) && currentLastName.equals(lastName)){
                existingStudent = currentStudent;
                break;
            }
        }
        return existingStudent;
    }
}
