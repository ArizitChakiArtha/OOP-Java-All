package bd.edu.aiub.oop.lab02;

/**
 * Represents a student with strict encapsulation and constructor chaining.
 */
public class Student {
    private String id;
    private String name;
    private String department;
    private double cgpa;

    /**
     * Creates a default student.
     */
    public Student() {
        this("00-00000-0", "Unknown Student", "CSE", 0.00);
    }

    /**
     * Creates a student with identity only.
     *
     * @param id student ID
     * @param name student name
     */
    public Student(String id, String name) {
        this(id, name, "CSE", 0.00);
    }

    /**
     * Creates a full student object.
     *
     * @param id student ID
     * @param name student name
     * @param department department name
     * @param cgpa cumulative GPA
     */
    public Student(String id, String name, String department, double cgpa) {
        setId(id);
        setName(name);
        setDepartment(department);
        setCgpa(cgpa);
    }

    /** @return student ID */
    public String getId() { return id; }

    /** @param id student ID */
    public void setId(String id) {
        if (id == null || !id.matches("\\d{2}-\\d{5}-\\d")) {
            throw new IllegalArgumentException("ID format must be like 22-49234-3.");
        }
        this.id = id;
    }

    /** @return student name */
    public String getName() { return name; }

    /** @param name student name */
    public void setName(String name) {
        if (name == null || name.trim().length() < 2) {
            throw new IllegalArgumentException("Name must contain at least two characters.");
        }
        this.name = name.trim();
    }

    /** @return department */
    public String getDepartment() { return department; }

    /** @param department department name */
    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department is required.");
        }
        this.department = department.trim().toUpperCase();
    }

    /** @return CGPA */
    public double getCgpa() { return cgpa; }

    /** @param cgpa cumulative GPA */
    public void setCgpa(double cgpa) {
        if (cgpa < 0.0 || cgpa > 4.0) {
            throw new IllegalArgumentException("CGPA must be from 0.00 to 4.00.");
        }
        this.cgpa = cgpa;
    }

    /**
     * Builds a printable profile.
     *
     * @return profile text
     */
    public String describe() {
        return id + " | " + name + " | " + department + " | CGPA " + String.format("%.2f", cgpa);
    }
}
