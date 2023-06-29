package restaurant;

public class Main {
    public static void main(String[] args) {
        Cake cake = new Cake("cake");
        System.out.println(cake.getName());
        System.out.println(cake.getPrice());
        System.out.println(cake.getGrams());
        System.out.println(cake.getCalories());
    }
}
