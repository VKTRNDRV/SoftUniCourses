import java.util.Scanner;

public class ProjectsCreation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int numOfProjects = Integer.parseInt(scan.nextLine());

        int hrsPerProject = 3;

        int totalTime = numOfProjects * hrsPerProject;

        System.out.printf("The architect %s will need %d hours to complete %d project/s.", name, totalTime, numOfProjects);
    }
}
