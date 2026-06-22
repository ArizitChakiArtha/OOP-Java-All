package bd.edu.aiub.oop.exam.finalterm;

/**
 * Person superclass for final practical.
 */
public class Person {
    private String id;
    private String name;

    /**
     * Creates person.
     *
     * @param id ID
     * @param name name
     */
    public Person(String id, String name) { setId(id); setName(name); }

    /** @return ID */
    public String getId() { return id; }

    /** @param id ID */
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("ID required.");
        this.id = id.trim();
    }

    /** @return name */
    public String getName() { return name; }

    /** @param name name */
    public void setName(String name) {
        if (name == null || name.trim().length() < 2) throw new IllegalArgumentException("Name required.");
        this.name = name.trim();
    }

    /**
     * Builds description.
     *
     * @return description
     */
    public String describe() { return id + " | " + name; }
}
