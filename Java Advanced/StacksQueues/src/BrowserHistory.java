import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> historyQueue = new ArrayDeque<>();
        ArrayDeque<String> forwardQueue = new ArrayDeque<>();
        while (true){
            String line = scanner.nextLine();
            if(line.equals("Home")){break;}

            if(line.equals("back")){
                if(historyQueue.size() >= 2){
                    forwardQueue.add(historyQueue.pop());
                    System.out.println(historyQueue.peek());
                }else{
                    System.out.println("no previous URLs");
                }

            }else if(line.equals("forward")){
                if(!forwardQueue.isEmpty()){
                    historyQueue.push(forwardQueue.removeLast());
                    System.out.println(historyQueue.peek());
                }else{
                    System.out.println("no next URLs");
                }

            }else{
                historyQueue.push(line);
                forwardQueue.clear();
                System.out.println(line);
            }
        }
    }
}
