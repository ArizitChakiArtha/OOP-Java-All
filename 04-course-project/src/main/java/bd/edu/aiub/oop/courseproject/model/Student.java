package bd.edu.aiub.oop.courseproject.model;

import bd.edu.aiub.oop.courseproject.exception.ValidationException;
import bd.edu.aiub.oop.courseproject.util.CsvUtil;

/**
 * Student entity for the course project.
 */
public class Student extends Person {
    private String department;
    private int completedCredits;

    /**
     * Creates student.
     *
     * @param id student ID
     * @param name name
     * @param email email
     * @param department department
     * @param completedCredits completed credits
     * @throws ValidationException when data is invalid
     */
    public Student(String id, String name, String email, String department, int completedCredits) throws ValidationException {
        super(id, name, email);
        setDepartment(department);
        setCompletedCredits(completedCredits);
    }

    /** @return department */
    public String getDepartment() { return department; }

    /** @param department department
     * @throws ValidationException when department is empty */
    public void setDepartment(String department) throws ValidationException {
        if (department == null || department.trim().isEmpty()) throw new ValidationException("Department required.");
        this.department = department.trim().toUpperCase();
    }

    /** @return completed credits */
    public int getCompletedCredits() { return completedCredits; }

    /** @param completedCredits completed credits
     * @throws ValidationException when credits are invalid */
    public void setCompletedCredits(int completedCredits) throws ValidationException {
        if (completedCredits < 0 || completedCredits > 180) throw new ValidationException("Credits must be 0 to 180.");
        this.completedCredits = completedCredits;
    }

    /** @return role */
    @Override
    public String getRole() { return "Student"; }

    /** @return CSV row */
    @Override
    public String toCsv() {
        return CsvUtil.join(getId(), getName(), getEmail(), department, String.valueOf(completedCredits));
    }

    /**
     * Parses student from CSV.
     *
     * @param row CSV row
     * @return student
     * @throws ValidationException when row is invalid
     */
    public static Student fromCsv(String row) throws ValidationException {
        String[] parts = CsvUtil.split(row, 5);
        return new Student(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
    }

    /** @return description */
    @Override
    public String describe() {
        return super.describe() + " | " + department + " | Credits " + completedCredits;
    }
}
