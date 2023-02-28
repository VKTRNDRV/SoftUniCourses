import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<String>> compEmployeesMap = new LinkedHashMap<>();
        while (true){
            String[] thisLine = scan.nextLine().split(" -> ");
            if(thisLine[0].equals("End")){break;}
            String company = thisLine[0];
            String employeeID = thisLine[1];
            if(!compEmployeesMap.containsKey(company)){
                compEmployeesMap.put(company, new ArrayList<>());
                compEmployeesMap.get(company).add(employeeID);
            }else{
                if(!compEmployeesMap.get(company).contains(employeeID)){
                    compEmployeesMap.get(company).add(employeeID);
                }
            }
        }

        for(Map.Entry<String, ArrayList<String>> thisEntry : compEmployeesMap.entrySet()){
            System.out.printf("%s%n", thisEntry.getKey());
            for(String thisEmloyee : thisEntry.getValue()){
                System.out.printf("-- %s%n", thisEmloyee);
            }
        }
    }
}
