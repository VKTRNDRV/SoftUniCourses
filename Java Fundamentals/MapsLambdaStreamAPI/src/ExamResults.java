import java.util.*;

public class ExamResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, ArrayList<Integer>>>
                langsStudsGradesMap = new LinkedHashMap<>();
        while (true){
            String[] thisLine = scan.nextLine().split("-");
            if(thisLine[0].equals("exam finished")){break;}
            String thisUsername = thisLine[0];

            // setting all banned user grades to -1
            if(thisLine[1].equals("banned")){
                for(Map.Entry<String, LinkedHashMap<String, ArrayList<Integer>>> thisLangEntry : langsStudsGradesMap.entrySet()){
                    for(Map.Entry<String, ArrayList<Integer>> currUserMap : thisLangEntry.getValue().entrySet()){
                        if(currUserMap.getKey().equals(thisUsername)){
                            for (int i = 0; i < currUserMap.getValue().size(); i++) {
                                currUserMap.getValue().set(i, -1);
                            }
                        }
                    }
                }
            // adding new grade
            }else{
                String thisLanguage = thisLine[1];
                int thisGrade = Integer.parseInt(thisLine[2]);

                if(!langsStudsGradesMap.containsKey(thisLanguage)){
                    langsStudsGradesMap.put(thisLanguage, new LinkedHashMap<>());
                }
                LinkedHashMap<String, ArrayList<Integer>> thisLanguageMap = langsStudsGradesMap.get(thisLanguage);
                if(!thisLanguageMap.containsKey(thisUsername)){
                    thisLanguageMap.put(thisUsername, new ArrayList<>());
                }
                thisLanguageMap.get(thisUsername).add(thisGrade);
            }
        }

        System.out.println("Results:");
        for(Map.Entry<String, LinkedHashMap<String, ArrayList<Integer>>> thisLanguageMap : langsStudsGradesMap.entrySet()){
            for(Map.Entry<String, ArrayList<Integer>> thisStudentEntry : thisLanguageMap.getValue().entrySet()){
                if(thisStudentEntry.getValue().get(0) != -1){
                    int maxGrade = thisStudentEntry.getValue().stream().mapToInt(Integer::intValue).max().getAsInt();
                    System.out.printf("%s | %d%n", thisStudentEntry.getKey(), maxGrade);
                }
            }
        }
        System.out.println("Submissions:");
        for(Map.Entry<String, LinkedHashMap<String, ArrayList<Integer>>> thisLanguageMap : langsStudsGradesMap.entrySet()){
            LinkedHashMap<String, ArrayList<Integer>> theseStudentsMap = thisLanguageMap.getValue();
            int submissionsCount = 0;
            for(ArrayList<Integer> thisStudent : theseStudentsMap.values()){
                submissionsCount += thisStudent.size();
            }
            System.out.printf("%s - %d%n", thisLanguageMap.getKey(), submissionsCount);
        }
    }
}
