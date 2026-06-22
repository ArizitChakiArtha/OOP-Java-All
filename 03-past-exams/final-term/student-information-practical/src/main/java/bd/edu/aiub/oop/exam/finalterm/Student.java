package bd.edu.aiub.oop.exam.finalterm;

/**
 * Student subclass for final practical.
 */
public class Student extends Person {
    private String department;

    /**
     * Creates student.
     *
     * @param id student ID
     * @param name name
     * @param department department
     */
    public Student(String id, String name, String department) {
        super(id, name);
        setDepartment(department);
    }

    /** @return department */
    public String getDepartment() { return department; }

    /** @param department department */
    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) throw new IllegalArgumentException("Department required.");
        this.department = department.trim().toUpperCase();
    }

    /**
     * Overrides description.
     *
     * @return description
     */
    @Override
    public String describe() { return super.describe() + " | " + department; }
}
