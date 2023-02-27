import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalLines = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, ArrayList<Double>> studentsGradesMap = new LinkedHashMap<>();
        for (int i = 1; i <= totalLines; i++) {
            String thisStudent = scan.nextLine();
            double thisGrade = Double.parseDouble(scan.nextLine());
            if(!studentsGradesMap.containsKey(thisStudent)){
                studentsGradesMap.put(thisStudent, new ArrayList<>());
            }
            studentsGradesMap.get(thisStudent).add(thisGrade);
        }

        for(Map.Entry<String, ArrayList<Double>> thisStudent : studentsGradesMap.entrySet()){
            String thisName = thisStudent.getKey();
            double avgGrade = 0.0;
            for(double thisGrade : thisStudent.getValue()){
                avgGrade += thisGrade;
            }
            avgGrade /= thisStudent.getValue().size();
            if(avgGrade >= 4.50){
                System.out.printf("%s -> %.2f%n", thisName, avgGrade);
            }
        }

    }
}
