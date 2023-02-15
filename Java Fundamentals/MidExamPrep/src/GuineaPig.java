import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double foodQty = Double.parseDouble(scan.nextLine())*1000;
        double hayQty = Double.parseDouble(scan.nextLine());
        double coverQty = Double.parseDouble(scan.nextLine());
        double guineaPigWeight = Double.parseDouble(scan.nextLine());
        double coverNeeded = guineaPigWeight / 3;

        int daysCount = 1;
        boolean areSuppliesEnough = true;

        while(daysCount <= 30){

            if(300 < foodQty){
                foodQty -= 300;
            }else{
                areSuppliesEnough = false;
                break;
            }

            if(daysCount % 2 == 0){
                double currentHayNeeded = (foodQty * 0.05) / 1000;
                if(currentHayNeeded <= hayQty){
                    hayQty -= currentHayNeeded;
                }else{
                    areSuppliesEnough = false;
                    break;
                }
            }

            if(daysCount % 3 == 0){
                if(coverNeeded <= coverQty){
                    coverQty -= coverNeeded;
                }else{
                    areSuppliesEnough = false;
                    break;
                }
            }

            daysCount++;
        }

        if(!areSuppliesEnough){
            System.out.println("Merry must go to the pet store!");
        }else{
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", foodQty/1000, hayQty, coverQty);
        }
    }
}
