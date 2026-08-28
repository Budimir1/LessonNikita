package EmployeeAccounting;

public class Manager extends BaseEmployee implements Employee {
    private double baseSalary;
    private double bonus;
    private int experienceYears;

    public Manager(String department, double baseSalary, double bonus, int experienceYears) {
        super(department);
        if (baseSalary < 0) {
            throw new IllegalArgumentException("baseSalary cannot be negative");
        }
        if (bonus < 0) {
            throw new IllegalArgumentException("bonus cannot be negative");
        }
        if (experienceYears < 0) {
            throw new IllegalArgumentException("experienceYears cannot be negative");
        }
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.experienceYears = experienceYears;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    @Override
    public int getExperienceYears() {
        return experienceYears;
    }
}
