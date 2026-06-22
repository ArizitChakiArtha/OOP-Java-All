package bd.edu.aiub.oop.assignment.finalterm;

/**
 * Student in grading system.
 */
public class Student {
    private String id;
    private String name;

    /**
     * Creates student.
     *
     * @param id student ID
     * @param name student name
     */
    public Student(String id, String name) { setId(id); setName(name); }

    /** @return student ID */
    public String getId() { return id; }

    /** @param id student ID */
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("ID required.");
        this.id = id.trim();
    }

    /** @return name */
    public String getName() { return name; }

    /** @param name student name */
    public void setName(String name) {
        if (name == null || name.trim().length() < 2) throw new IllegalArgumentException("Name required.");
        this.name = name.trim();
    }
}
