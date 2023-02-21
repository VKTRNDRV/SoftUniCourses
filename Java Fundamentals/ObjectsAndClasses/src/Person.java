import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){return name;}

    public int getAge(){return age;}

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= peopleCount; i++) {
            String[] currentCommand = scan.nextLine().split(" ");
            Person currentPerson = new Person(currentCommand[0], Integer.parseInt(currentCommand[1]));
            if(currentPerson.getAge() > 30){
                System.out.printf("%s - %d%n", currentPerson.getName(), currentPerson.getAge());
            }
        }
    }
}
