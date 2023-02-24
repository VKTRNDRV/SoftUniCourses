package CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;

    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public Employee(String name, double salary, String position, String department, String email){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = -1;
    }

    public Employee(String name, double salary, String position, String department, int age){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, String email, int age){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public String getPosition() {
        return position;
    }
    public String getDepartment() {
        return department;
    }
    public String getEmail() {
        return email;
    }
    public int getAge() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfLines = Integer.parseInt(scan.nextLine());

        List<List<Employee>> departmentsList = new ArrayList<>();
        for(int i = 1; i <= numOfLines; i++){
            String[] currentLine = scan.nextLine().split(" ");

            //assigning values to parameters of current employee
            String name = currentLine[0];
            double salary = Double.parseDouble(currentLine[1]);
            String position = currentLine[2];
            String department = currentLine[3];
            String email = "n/a";
            int age = -1;
            if(currentLine.length == 5) {
                try {
                    age = Integer.parseInt(currentLine[4]);
                } catch (NumberFormatException e) {
                    email = currentLine[4];
                }
            }
            if(currentLine.length == 6) {
                email = currentLine[4];
                age = Integer.parseInt(currentLine[5]);
            }

            //creating new employee
            Employee inputEmployee = new Employee(name, salary, position, department);
            if(!email.equals("n/a")){inputEmployee.setEmail(email);}
            if(age != -1){inputEmployee.setAge(age);}

            //adding them to existing department list or creating new one
            boolean isAdded = false;
            for(List<Employee> currentDepartmentList : departmentsList){
                Employee sampleEmployee = currentDepartmentList.get(0);
                if(sampleEmployee.getDepartment().equals(inputEmployee.getDepartment())){
                    currentDepartmentList.add(inputEmployee);
                    isAdded = true;
                    break;
                }
            }
            if(!isAdded){
                List<Employee> newDepartment = new ArrayList<>();
                departmentsList.add(newDepartment);
                newDepartment.add(inputEmployee);
            }
        }

        //calculating dep w/ highest average salary
        List<Employee> bestDepartment = departmentsList.get(0);
        double maxAverageSalary = 0.0;
        for(List<Employee> currentDepartment : departmentsList){
            double currDepAverageSalary = 0.0;
            for(Employee currentEmployee : currentDepartment){
                double currEmpSalary = currentEmployee.getSalary();
                currDepAverageSalary += currEmpSalary;
            }
            currDepAverageSalary /= currentDepartment.size();
            if(currDepAverageSalary > maxAverageSalary){
                bestDepartment = currentDepartment;
                maxAverageSalary = currDepAverageSalary;
            }
        }

        //sorting department
        bestDepartment.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                return (Double.compare(emp1.getSalary(), emp2.getSalary()) * -1);
            }
        });

        //printing out best department
        System.out.printf("Highest Average Salary: %s%n", bestDepartment.get(0).getDepartment());
        for(Employee currentEmployee : bestDepartment){
            String name = currentEmployee.getName();
            double salary = currentEmployee.getSalary();
            String email = currentEmployee.getEmail();
            int age = currentEmployee.getAge();
            System.out.printf("%s %.2f %s %d%n", name, salary, email, age);
        }
    }
}