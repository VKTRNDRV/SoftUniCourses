import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String thisLine = scanner.nextLine();
        while (!thisLine.equals("print")){
            switch (thisLine){
                case "cancel":
                    if(!printerQueue.isEmpty()){
                        System.out.printf("Canceled %s%n", printerQueue.pop());
                    }else{
                        System.out.println("Printer is on standby");
                    }
                    break;

                default:
                    printerQueue.add(thisLine);
                    break;
            }
            thisLine = scanner.nextLine();
        }

        while (!printerQueue.isEmpty()){
            System.out.println(printerQueue.remove());
        }
    }
}
