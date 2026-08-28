package EmployeeAccounting;

public class Developer extends BaseEmployee implements Employee {
    private double hourlyRate;
    private int hoursWorked;
    private int experienceYears;

    public Developer(String department, double hourlyRate, int hoursWorked, int experienceYears) {
        super(department);
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("hourlyRate cannot be negative");
        }
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("hoursWorked cannot be negative");
        }
        if (experienceYears < 0) {
            throw new IllegalArgumentException("experienceYears cannot be negative");
        }
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.experienceYears = experienceYears;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public int getExperienceYears() {
        return experienceYears;
    }
}