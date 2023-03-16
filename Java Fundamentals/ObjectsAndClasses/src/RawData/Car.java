package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Car {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <=  carsCount; i++) {
            String[] line = scanner.nextLine().split(" ");
            String model = line[0];
            int engineSpeed = Integer.parseInt(line[1]);
            int enginePower = Integer.parseInt(line[2]);
            int cargoWeight = Integer.parseInt(line[3]);
            String cargoType = line[4];
            int t1Age = Integer.parseInt(line[6]);
            double t1Pressure = Double.parseDouble(line[5]);
            int t2Age = Integer.parseInt(line[8]);
            double t2Pressure = Double.parseDouble(line[7]);
            int t3Age = Integer.parseInt(line[10]);
            double t3Pressure = Double.parseDouble(line[9]);
            int t4Age = Integer.parseInt(line[12]);
            double t4Pressure = Double.parseDouble(line[11]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType,
                    t1Age, t1Pressure, t2Age, t2Pressure, t3Age, t3Pressure ,t4Age, t4Pressure);
            car.addToCarsList();
        }

        String command = scanner.nextLine();
        switch (command){
            case "fragile":
                for(Car car : cars){
                    if(car.cargo.getType().equals("fragile")){
                        boolean isFragile = false;
                        if(car.tyre1.getPressure() < 1){
                            isFragile = true;
                        } else if (car.tyre2.getPressure() < 1) {isFragile = true;
                        } else if (car.tyre3.getPressure() < 1) {isFragile = true;
                        } else if (car.tyre4.getPressure() < 1) {isFragile = true;
                        }

                        if(isFragile) {
                            System.out.println(car.getModel());
                        }
                    }
                }
                break;

            case "flamable":
                for(Car car : cars){
                    if(car.cargo.getType().equals("flamable") && car.engine.getPower() > 250){
                        System.out.println(car.getModel());
                    }
                }
                break;
        }
    }
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tyre tyre1;
    private Tyre tyre2;
    private Tyre tyre3;
    private Tyre tyre4;
    private static List<Car> cars = new ArrayList<>();

    public String getModel() {return model;}
    public Engine getEngine() {return engine;}
    public Cargo getCargo() {return cargo;}
    public Tyre getTyre1() {return tyre1;}
    public Tyre getTyre2() {return tyre2;}
    public Tyre getTyre3() {return tyre3;}
    public Tyre getTyre4() {return tyre4;}

    public void setModel(String model) {this.model = model;}
    public void setEngine(Engine engine) {this.engine = engine;}
    public void setCargo(Cargo cargo) {this.cargo = cargo;}
    public void setTyre1(Tyre tyre1) {this.tyre1 = tyre1;}
    public void setTyre2(Tyre tyre2) {this.tyre2 = tyre2;}
    public void setTyre3(Tyre tyre3) {this.tyre3 = tyre3;}
    public void setTyre4(Tyre tyre4) {this.tyre4 = tyre4;}

    public void addToCarsList(){
        cars.add(this);
    }

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
               int tyre1Age, double tyre1Pressure, int tyre2Age, double tyre2Pressure, int tyre3Age, double tyre3Pressure, int tyre4Age, double tyre4Pressure){
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tyre1 = new Tyre(tyre1Age, tyre1Pressure);
        this.tyre2 = new Tyre(tyre2Age, tyre2Pressure);
        this.tyre3 = new Tyre(tyre3Age, tyre3Pressure);
        this.tyre4 = new Tyre(tyre4Age, tyre4Pressure);
    }

    public class Engine{
        private int speed;
        private int power;
        public void setSpeed(int speed) {this.speed = speed;}
        public void setPower(int power) {this.power = power;}
        public int getSpeed() {return speed;}
        public int getPower() {return power;}

        public Engine(int speed, int power){
            this.speed = speed;
            this.power = power;
        }
    }

    public class Cargo{
        private int weight;
        private String type;
        public void setWeight(int weight) {this.weight = weight;}
        public void setType(String type) {this.type = type;}
        public int getWeight() {return weight;}
        public String getType() {return type;}

        public Cargo(int weight, String type){
            this.weight = weight;
            this.type = type;
        }
    }

    public class Tyre{
        private int age;
        private double pressure;
        public void setAge(int age) {this.age = age;}
        public void setPressure(double pressure) {this.pressure = pressure;}
        public int getAge() {return age;}
        public double getPressure() {return pressure;}

        public Tyre(int age, double pressure){
            this.age = age;
            this.pressure = pressure;
        }
    }
}
