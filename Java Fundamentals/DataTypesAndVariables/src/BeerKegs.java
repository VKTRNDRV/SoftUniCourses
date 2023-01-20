import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfKegs = Integer.parseInt(scan.nextLine());
        String largestKegName = new String();
        double largestKegVolume = 0;

        for (int i = 1; i <= numOfKegs ; i++){
            String currentKegName = scan.nextLine();
            double currentKegRadius = Double.parseDouble(scan.nextLine());
            int currentKegHeight = Integer.parseInt(scan.nextLine());

            double currentKegVolume = (Math.PI) * Math.pow(currentKegRadius,2) * currentKegHeight;
            if(currentKegVolume > largestKegVolume){
                largestKegName = currentKegName;
                largestKegVolume = currentKegVolume;
            }
        }
        System.out.println(largestKegName);
    }
}
