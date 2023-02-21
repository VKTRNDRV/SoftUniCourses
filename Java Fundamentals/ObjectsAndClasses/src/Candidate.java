import java.util.*;

public class Candidate {
    public String firstName;
    public String lastName;
    public double grade;

    public Candidate(String firstName, String lastName, double grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public double getGrade(){return grade;}

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int candidatesCount = Integer.parseInt(scan.nextLine());
        List<Candidate> candidatesList = new ArrayList<>();

        for (int i = 1; i <= candidatesCount; i++) {
            String[] currentLine = scan.nextLine().split(" ");
            Candidate currentCandidate = new Candidate(currentLine[0], currentLine[1], Double.parseDouble(currentLine[2]));
            candidatesList.add(currentCandidate);
        }

        candidatesList.sort(new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
                return Double.compare(o2.getGrade(), o1.getGrade());
            }
        });

        for(Candidate candidate : candidatesList){
            System.out.printf("%s %s: %.2f%n", candidate.getFirstName(), candidate.getLastName(), candidate.getGrade());
        }
    }
}
