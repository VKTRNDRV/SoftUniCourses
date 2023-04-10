package StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        while (true)
        {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("Exit")){
                break;
            }
            String name = input[1];
            switch (input[0]){
                case "Create":
                    if(!studentSystem.containsName(name)){
                        int age = Integer.parseInt(input[2]);
                        double grade = Double.parseDouble(input[3]);
                        Student student = new Student(name, age, grade);
                        studentSystem.addStudent(student);
                    }
                    break;

                case "Show":
                    if(studentSystem.containsName(name)){
                        Student student = studentSystem.getStudent(name);
                        int age = student.getAge();
                        String commentary = student.getCommentary();
                        System.out.printf("%s is %d years old. %s.%n", name, age, commentary);

                    }
                    break;
            }
            //studentSystem.ParseCommand(input);
        }
    }
}
