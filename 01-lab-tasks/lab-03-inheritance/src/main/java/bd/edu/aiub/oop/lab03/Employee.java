package bd.edu.aiub.oop.lab03;

/**
 * Employee class that extends Person.
 */
public class Employee extends Person {
    private String designation;
    private double salary;

    /**
     * Creates an employee using super().
     *
     * @param id employee ID
     * @param name name
     * @param email email
     * @param designation designation
     * @param salary salary amount
     */
    public Employee(String id, String name, String email, String designation, double salary) {
        super(id, name, email);
        setDesignation(designation);
        setSalary(salary);
    }

    /** @return designation */
    public String getDesignation() { return designation; }

    /** @param designation job designation */
    public void setDesignation(String designation) {
        if (designation == null || designation.trim().isEmpty()) throw new IllegalArgumentException("Designation is required.");
        this.designation = designation.trim();
    }

    /** @return salary */
    public double getSalary() { return salary; }

    /** @param salary salary amount */
    public void setSalary(double salary) {
        if (salary < 0) throw new IllegalArgumentException("Salary cannot be negative.");
        this.salary = salary;
    }

    /**
     * Calculates salary.
     *
     * @return payable salary
     */
    public double calculateSalary() { return salary; }

    /**
     * Overrides person description.
     *
     * @return employee description
     */
    @Override
    public String describe() {
        return super.describe() + " | " + designation + " | Salary " + String.format("%.2f", calculateSalary());
    }
}
