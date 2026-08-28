package EmployeeAccounting;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[] {
                new Manager("Sales", 3000, 500, 5),
                new Developer("IT", 25, 160, 3)
        };

        for (Employee e : employees) {
            System.out.println(e.getDepartment() + " " + e.calculateSalary() + " " + e.getExperienceYears());
        }
    }
}