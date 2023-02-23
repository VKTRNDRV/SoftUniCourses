import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Member {
    private String name;
    private String id;
    private int age;

    public Member(String name, String id, int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Member> membersList = new ArrayList<>();
        while (true){
            String[] currentLine = scanner.nextLine().split(" ");
            if(currentLine[0].equals("End")){break;}
            Member member = new Member(currentLine[0], currentLine[1], Integer.parseInt(currentLine[2]));
            membersList.add(member);
        }

        membersList.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for(Member currentMember : membersList){
            System.out.printf("%s with ID: %s is %d years old.%n",
                    currentMember.getName(), currentMember.getId(), currentMember.getAge());
        }
    }
}
