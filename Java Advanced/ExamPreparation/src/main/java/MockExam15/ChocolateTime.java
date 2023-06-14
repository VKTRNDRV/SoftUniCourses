package MockExam15;

import java.util.*;

public class ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // initialize collections
        Map<String, Double> chocolatesCacaoRatios = new HashMap<>();
        chocolatesCacaoRatios.put("Milk", 0.3);
        chocolatesCacaoRatios.put("Dark", 0.5);
        chocolatesCacaoRatios.put("Baking", 1.0);
        Map<String, Integer> producedChocolates = new TreeMap<>();
        ArrayDeque<Double> allMilk = new ArrayDeque<>();
        ArrayDeque<Double> allCacao = new ArrayDeque<>();

        // read input
        double[] line1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double[] line2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        for(double m : line1){allMilk.add(m);}
        for(double c : line2){allCacao.push(c);}

        // iterate until empty
        while (!allMilk.isEmpty() && !allCacao.isEmpty()){
            double milk = allMilk.poll();
            double cacao = allCacao.pop();
            double cacaoRatio = cacao / (milk + cacao);

            // produce chocolate IF ratio matched
            boolean isChocolateProduced = false;
            for(Map.Entry<String, Double> chocolateCacaoRatio : chocolatesCacaoRatios.entrySet()){
                if(cacaoRatio == chocolateCacaoRatio.getValue()){
                    String chocolateName = chocolateCacaoRatio.getKey();
                    if(!producedChocolates.containsKey(chocolateName)){
                        producedChocolates.put(chocolateName, 0);
                    }
                    producedChocolates.put(chocolateName, producedChocolates.get(chocolateName) + 1);
                    isChocolateProduced = true;
                    break;
                }
            }

            // re-add incremented milk IF no match
            if(!isChocolateProduced){
                milk += 10;
                allMilk.add(milk);
            }
        }

        // print output
        boolean areAllChocolatesProduced = true;
        for (String chocolateName : chocolatesCacaoRatios.keySet()){
            if (!producedChocolates.containsKey(chocolateName)) {
                areAllChocolatesProduced = false;
                break;
            }
        }
        if(areAllChocolatesProduced){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        for(Map.Entry<String, Integer> chocolate : producedChocolates.entrySet()){
            System.out.printf("# %s Chocolate --> %d\n", chocolate.getKey(), chocolate.getValue());
        }
    }
}
