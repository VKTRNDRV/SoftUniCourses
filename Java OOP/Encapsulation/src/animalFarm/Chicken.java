package animalFarm;

public class Chicken {
    private String name;
    private Integer age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setAge(int age){
        if(age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private void setName(String name){
        if(name.trim().equals("")){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private double calculateProductPerDay(){
        if(age > 11){
            return 0.75;

        } else if (age > 5) {
            return 1;
        }

        return 2;
    }

    public double productPerDay(){
        return this.calculateProductPerDay();
    }

    @Override
    public String toString(){
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day."
                , this.getName(), this.getAge(), this.calculateProductPerDay());
    }
}
