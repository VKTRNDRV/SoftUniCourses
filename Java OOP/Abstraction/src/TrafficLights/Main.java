package TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lights = sc.nextLine().split("\\s+");
        int lightsCount = Integer.parseInt(sc.nextLine());

        // repeat lightsCount times
        while (lightsCount > 0){

            // print and update every light
            for (int i = 0; i < lights.length; i++) {
                String light = TrafficLight.valueOf(lights[i]).name();
                String nextLight = TrafficLight.valueOf(light).getNextLight();
                System.out.printf("%s ", nextLight);
                lights[i] = nextLight;
            }
            System.out.println();
            lightsCount--;
        }
    }
}
