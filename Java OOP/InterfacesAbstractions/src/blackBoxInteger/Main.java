package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt obj = constructor.newInstance();

        Field valueField = BlackBoxInt.class.getDeclaredField("innerValue");
        valueField.setAccessible(true);

        Method[] methods = BlackBoxInt.class.getDeclaredMethods();

        String[] line = scanner.nextLine().split("_");
        int parameter;
        while (!line[0].equals("END")){
            parameter = Integer.parseInt(line[1]);
            for(Method method : methods){
                if(method.getName().equals(line[0])){
                    method.setAccessible(true);
                    method.invoke(obj, parameter);
                }
            }
            System.out.println(valueField.get(obj));
            line = scanner.nextLine().split("_");
        }
    }
}

