package solid;

public class Printer {

    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    public void printSum(double sum) {
        System.out.printf((SUM) + "%n", sum);
    }

    public void printAverage(double average) {
        System.out.printf((AVERAGE) + "%n", average);
    }
}
