import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfPieces = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> piecesMap = new LinkedHashMap<>();
        for (int i = 0; i < numOfPieces; i++) {
            String[] pieceArr = scanner.nextLine().split("\\|");
            String pieceName = pieceArr[0];
            String composer = pieceArr[1];
            String key = pieceArr[2];
            piecesMap.putIfAbsent(pieceName, new ArrayList<>());
            piecesMap.get(pieceName).add(composer);
            piecesMap.get(pieceName).add(key);
        }

        while (true) {
            String[] pieceArr = scanner.nextLine().split("\\|");
            if(pieceArr[0].equals("Stop")){break;}
            String command = pieceArr[0];
            String pieceName = pieceArr[1];

            switch (command){
                case "Add":
                    String composerName = pieceArr[2];
                    String pieceKey = pieceArr[3];
                    if(!piecesMap.containsKey(pieceName)){
                        piecesMap.put(pieceName, new ArrayList<>());
                        piecesMap.get(pieceName).add(composerName);
                        piecesMap.get(pieceName).add(pieceKey);
                        System.out.printf("%s by %s in %s added to the collection!%n", pieceName, composerName, pieceKey);
                    }else{
                        System.out.printf("%s is already in the collection!%n", pieceName);
                    }
                    break;

                case "Remove":
                    if(piecesMap.containsKey(pieceName)){
                        piecesMap.remove(pieceName);
                        System.out.printf("Successfully removed %s!%n", pieceName);
                    }else{
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                    }
                    break;

                case "ChangeKey":
                    String keyNew = pieceArr[2];
                    if(piecesMap.containsKey(pieceName)){
                        piecesMap.get(pieceName).remove(piecesMap.get(pieceName).size() - 1);
                        piecesMap.get(pieceName).add(keyNew);
                        System.out.printf("Changed the key of %s to %s!%n", pieceName, keyNew);
                    }else{
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                    }
                    break;

                default:
                    break;
            }
        }

        for(Map.Entry<String, List<String>> entry : piecesMap.entrySet()){
            String name = entry.getKey();
            String composer = entry.getValue().get(0);
            String key = entry.getValue().get(1);
            System.out.printf("%s -> Composer: %s, Key: %s%n", name, composer, key);
        }
    }
}
