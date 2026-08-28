package EmployeeAccounting;

public class BaseEmployee implements Employee {
    private String department;

    public BaseEmployee(String department) {
        this.department = department;
    }

    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public double calculateSalary() {
        return 0;
    }

    @Override
    public int getExperienceYears() {
        return 0;
    }
}
