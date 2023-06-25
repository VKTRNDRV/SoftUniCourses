package shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split("[=;]");
        String[] secondLine = scanner.nextLine().split("[=;]");
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        // adding all people
        try {
            for (int i = 0; i < firstLine.length; i+=2) {
                String name = firstLine[i];
                double money = Double.parseDouble(firstLine[i+1]);
                Person person = new Person(name, money);
                people.add(person);
            }
        }catch (Exception e){
            System.out.print(e.getMessage());
            return;
        }

        // add all products
        try {
            for (int i = 0; i < secondLine.length; i+=2) {
                String name = secondLine[i];
                double cost = Double.parseDouble(secondLine[i+1]);
                Product product = new Product(name, cost);
                products.add(product);
            }
        }catch (Exception e){
            System.out.print(e.getMessage());
            return;
        }

        // iterate until end
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("END")){

            // get person
            String personName = command[0];
            Person person = null;
            for (Person p : people){
                if(p.getName().equals(personName)){
                    person = p;
                    break;
                }
            }

            // get product
            String productName = command[1];
            Product product = null;
            for (Product p : products){
                if(p.getName().equals(productName)){
                    product = p;
                    break;
                }
            }

            // add product or display error
            try {
                person.buyProduct(product);
                System.out.printf("%s bought %s\n", person.getName(), product.getName());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine().split(" ");
        }

        // print output
        for(Person person : people){
            System.out.println(person.toString());
        }
    }
}
