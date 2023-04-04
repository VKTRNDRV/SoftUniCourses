import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, ArrayDeque<Double>> studentsGradesMap = new TreeMap<>();
        int studentsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < studentsCount; i++) {
            String[] gradeArr = scanner.nextLine().split(" ");
            String studentName = gradeArr[0];
            double grade = Double.parseDouble(gradeArr[1]);
            if(studentsGradesMap.containsKey(studentName)){
                studentsGradesMap.get(studentName).add(grade);
            }else{
                studentsGradesMap.put(studentName, new ArrayDeque<>());
                studentsGradesMap.get(studentName).add(grade);
            }
        }

        for(Map.Entry<String, ArrayDeque<Double>> entry : studentsGradesMap.entrySet()){
            String name = entry.getKey();
            double avgGrade = 0;
            System.out.print(name + " -> ");
            ArrayDeque<Double> gradesStack = entry.getValue();
            int gradesCount = gradesStack.size();
            while (!gradesStack.isEmpty()){
                double grade = gradesStack.pop();
                avgGrade += grade;
                System.out.printf("%.2f ", grade);
            }

            avgGrade /= gradesCount;
            System.out.printf("(avg: %.2f)%n", avgGrade);
        }
    }
}
