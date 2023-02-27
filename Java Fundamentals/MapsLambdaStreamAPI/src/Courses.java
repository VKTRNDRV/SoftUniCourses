import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, ArrayList<String>> coursesMap = new LinkedHashMap<>();
        while (true){
            String[] thisLine = scan.nextLine().split(" : ");
            if(thisLine[0].equals("end")){
                break;
            }
            String thisCourse = thisLine[0];
            String thisStudent = thisLine[1];
            if(!coursesMap.containsKey(thisCourse)){
                coursesMap.put(thisCourse, new ArrayList<>());
            }
            coursesMap.get(thisCourse).add(thisStudent);
        }

        for(Map.Entry<String, ArrayList<String>> thisEntry : coursesMap.entrySet()){
            System.out.printf("%s: %d%n", thisEntry.getKey(), thisEntry.getValue().size());
            for(String thisStudent : thisEntry.getValue()){
                System.out.printf("-- %s%n", thisStudent);
            }
        }
    }
}
