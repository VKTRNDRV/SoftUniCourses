package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    public static boolean isNumberValid(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUrlValid(String URL) {
        for (int i = 0; i < URL.length(); i++) {
            if (Character.isDigit(URL.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();
        for(String url : urls){
            if(isUrlValid(url)){
                output.append("Browsing: ")
                        .append(url)
                        .append("!")
                        .append(System.lineSeparator());
            }else {
                output.append("Invalid URL!")
                        .append(System.lineSeparator());
            }
        }
        return output.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();
        for(String number : numbers){
            if(isNumberValid(number)){
                output.append("Calling... ")
                        .append(number)
                        .append(System.lineSeparator());
            }else {
                output.append("Invalid number!")
                        .append(System.lineSeparator());
            }
        }
        return output.toString().trim();
    }
}
