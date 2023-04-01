import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String activationKey = scanner.nextLine();
        while (true){
            String[] commandArr = scanner.nextLine().split(">>>");
            if(commandArr[0].equals("Generate")){break;}
            String command = commandArr[0];
            switch (command){
                case "Contains":
                    String substring = commandArr[1];
                    if(activationKey.contains(substring)){
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    }else{
                        System.out.println("Substring not found!");
                    }
                    break;

                case "Flip":
                    String UpperLower = commandArr[1];
                    int sliceStartIndex = Integer.parseInt(commandArr[2]);
                    int sliceEndIndex = Integer.parseInt(commandArr[3]);
                    StringBuilder tempStrBuilder = new StringBuilder(activationKey);
                    if(UpperLower.equals("Upper")){
                        for (int i = sliceStartIndex; i < sliceEndIndex; i++) {
                            char thisChar = tempStrBuilder.charAt(i);
                            if(Character.isLetter(thisChar) && Character.isLowerCase(thisChar)){
                                char thisNewChar = Character.toUpperCase(thisChar);
                                tempStrBuilder.deleteCharAt(i);
                                tempStrBuilder.insert(i, thisNewChar);
                            }
                        }

                    }else if(UpperLower.equals("Lower")){
                        for (int i = sliceStartIndex; i < sliceEndIndex; i++) {
                            char thisChar = tempStrBuilder.charAt(i);
                            if(Character.isLetter(thisChar) && Character.isUpperCase(thisChar)){
                                char thisNewChar = Character.toLowerCase(thisChar);
                                tempStrBuilder.deleteCharAt(i);
                                tempStrBuilder.insert(i, thisNewChar);
                            }
                        }

                    }
                    activationKey = tempStrBuilder.toString();
                    System.out.println(activationKey);
                    break;

                case "Slice":
                    int startIndex = Integer.parseInt(commandArr[1]);
                    int endIndex = Integer.parseInt(commandArr[2]);
                    StringBuilder tempSB = new StringBuilder(activationKey);
                    tempSB = tempSB.delete(startIndex, endIndex);
                    activationKey = tempSB.toString();
                    System.out.println(activationKey);
                    break;
            }
        }

        System.out.printf("Your activation key is: %s%n", activationKey);
    }
}
