package EmployeesTeams;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        if(firstName.length() < 3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        if(lastName.length() < 3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.###");
        df.setMaximumFractionDigits(3);
        df.setMinimumFractionDigits(1);

        return String.format("%s %s gets %s leva"
                , this.getFirstName()
                , this.getLastName()
                , df.format(this.getSalary()));
    }

    public void increaseSalary(double bonus){
        if(this.getAge() >= 30){
            this.setSalary(this.getSalary() * (1 + bonus/100));
        }else{
            this.setSalary(this.getSalary() * (1 + bonus/200));
        }
    }
}
