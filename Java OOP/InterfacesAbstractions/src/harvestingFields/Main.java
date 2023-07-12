package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Field[] allfields = RichSoilLand.class.getDeclaredFields();

        while (!command.equals("HARVEST")){
            for(Field field : allfields){
                int modifier = field.getModifiers();
                String modifierName = getModifierString(modifier);
                String typeName = field.getType().getSimpleName();
                String name = field.getName();
                if(command.equals(modifierName) || command.equals("all")){
                    System.out.printf("%s %s %s\n", modifierName, typeName, name);
                }
            }


            command = scanner.nextLine();
        }
    }

    private static String getModifierString(int modifier) {
        if(Modifier.isPublic(modifier)){
            return "public";
        } else if (Modifier.isProtected(modifier)) {
            return "protected";
        } else if (Modifier.isPrivate(modifier)) {
            return "private";
        }
        return "";
    }
}

