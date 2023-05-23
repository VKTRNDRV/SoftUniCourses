package CompanyRoster;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linesCount = Integer.parseInt(scanner.nextLine());
        List<Department> departments = new ArrayList<>();
        while (linesCount > 0){
            String[] line = scanner.nextLine().split("\\s+");

            //parsing name, salary and position
            String name = line[0];
            double salary = Double.parseDouble(line[1]);
            String position = line[2];

            //parsing or creating department
            String departmentName = line[3];
            Department department;
            if(isDepartmentPresent(departments, departmentName)){
                department = getDepartmentByName(departments, departmentName);
            }else{
                department = new Department(departmentName);
                departments.add(department);
            }

            Employee employee = null;

            //parsing email and age
            if(line.length == 6) {
                String email = line[4];
                int age = Integer.parseInt(line[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }

            else if (line.length == 5) {
                String parameterForth = line[4];
                if(parameterForth.contains("@")) {
                    String email = parameterForth;
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(parameterForth);
                    employee = new Employee(name, salary, position, department, age);
                }
            }
            //4 параметъра -> name, salary, position, department
            else if (line.length == 4) {
                employee = new Employee(name, salary, position, department);
            }

            getDepartmentByName(departments, departmentName).addEmployee(employee);

            linesCount--;
        }

        //getting department with max salary
        Department maxSalaryDepartment = departments.get(0);
        double maxAvgSalary = maxSalaryDepartment.getAverageSalary();
        for(Department department : departments){
            double avgSalary = department.getAverageSalary();
            if(avgSalary >= maxAvgSalary){
                maxSalaryDepartment = department;
                maxAvgSalary = avgSalary;
            }
        }

        //sorting employees by salary desc
        List<Employee> sortedEmployees = maxSalaryDepartment
                .getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());

        //printing employees
        System.out.printf("Highest Average Salary: %s%n", maxSalaryDepartment.getName());
        for(Employee employee : sortedEmployees){
            System.out.printf("%s %.2f %s %d%n",
                    employee.getName(),
                    employee.getSalary(),
                    employee.getEmail(),
                    employee.getAge());
        }
    }

    public static boolean isDepartmentPresent(List<Department> departments, String departmentName){
        for(Department department : departments){
            if(department.getName().equals(departmentName)){
                return true;
            }
        }

        return false;
    }

    public static Department getDepartmentByName(List<Department> departments, String departmentName){
        for(Department department : departments){
            if(department.getName().equals(departmentName)){
                return department;
            }
        }

        return null;
    }
}
