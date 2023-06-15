package MockExam18;

import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // initializing peaks array
        String[][] peaks = new String[5][3];
        peaks[0][0] = "Vihren";
        peaks[0][1] = "80";
        peaks[0][2] = "f";
        peaks[1][0] = "Kutelo";
        peaks[1][1] = "90";
        peaks[1][2] = "f";
        peaks[2][0] = "Banski Suhodol";
        peaks[2][1] = "100";
        peaks[2][2] = "f";
        peaks[3][0] = "Polezhan";
        peaks[3][1] = "60";
        peaks[3][2] = "f";
        peaks[4][0] = "Kamenitza";
        peaks[4][1] = "70";
        peaks[4][2] = "f";

        // reading input
        int[] line1 = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] line2 = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> allFood = new ArrayDeque<>();
        ArrayDeque<Integer> allStamina = new ArrayDeque<>();
        for(int c : line1){allFood.push(c);}
        for(int d : line2){allStamina.add(d);}

        // iterate every day
        int currentDay;
        int peakNumber = 0;
        boolean isLastPeakClimbed = false;
        for (currentDay = 1; currentDay <= 7; currentDay++) {

            // get food and stamina
            int food = allFood.pop();
            int stamina = allStamina.poll();
            int product = food + stamina;

            // update peaks and peak number IF peak climbed
            if(product >= Integer.parseInt(peaks[peakNumber][1])){
                peaks[peakNumber][2] = "t";
                peakNumber++;
            }

            // break if last peak climbed
            if(peakNumber >= peaks.length){
                isLastPeakClimbed = true;
                break;
            }
        }

        // print output
        if(isLastPeakClimbed){
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        }else{
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if(peaks[0][2].equals("t")) {
            System.out.println("Conquered peaks:");
            for (int i = 0; i < peaks.length; i++) {
                if(peaks[i][2].equals("t")){
                    System.out.println(peaks[i][0]);
                }else {
                    break;
                }
            }
        }
    }
}
