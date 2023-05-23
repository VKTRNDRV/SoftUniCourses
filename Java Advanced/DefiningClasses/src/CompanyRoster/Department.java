package CompanyRoster;

import java.util.*;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name){
        setName(name);
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public double getAverageSalary(){
//        Set<Employee> employees = this.getEmployees();
//        int employeesCount = employees.size();
//        double totalSalary = 0;
//        for(Employee employee : employees){
//            totalSalary += employee.getSalary();
//        }
//
//        return totalSalary / employeesCount;

        return this.employees
                .stream()
                .mapToDouble(e -> e.getSalary())
                .average()
                .orElse(0.0);
    }


}
