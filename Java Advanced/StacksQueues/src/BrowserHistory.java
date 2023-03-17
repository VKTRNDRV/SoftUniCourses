import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> historyStack = new ArrayDeque<>();
        while (true){
            String line = scanner.nextLine();
            if(line.equals("Home")){break;}

            if(line.equals("back")){
                if(historyStack.size() >= 2){
                    historyStack.pop();
                    System.out.println(historyStack.peek());
                }else{
                    System.out.println("no previous URLs");
                }
            }else{
                historyStack.push(line);
                System.out.println(line);
            }
        }
    }
}
