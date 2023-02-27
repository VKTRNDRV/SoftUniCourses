import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Integer> resourcesMap = new LinkedHashMap<>();
        while (true){
            String thisResource = scan.nextLine();
            if(thisResource.equals("stop")){
                break;
            }
            int thisQty = Integer.parseInt(scan.nextLine());
            if(!resourcesMap.containsKey(thisResource)){
                resourcesMap.put(thisResource, thisQty);
            }else{
                resourcesMap.put(thisResource, resourcesMap.get(thisResource) + thisQty);
            }
        }

        for(Map.Entry<String, Integer> thisEntry : resourcesMap.entrySet()){
            String thisResource = thisEntry.getKey();
            int thisQty = thisEntry.getValue();
            System.out.printf("%s -> %d%n", thisResource, thisQty);
        }
    }
}
