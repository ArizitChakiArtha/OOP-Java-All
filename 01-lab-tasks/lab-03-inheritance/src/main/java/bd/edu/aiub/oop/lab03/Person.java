package bd.edu.aiub.oop.lab03;

/**
 * Base class for a university person.
 */
public class Person {
    private String id;
    private String name;
    private String email;

    /**
     * Creates a person.
     *
     * @param id unique ID
     * @param name full name
     * @param email email address
     */
    public Person(String id, String name, String email) {
        setId(id);
        setName(name);
        setEmail(email);
    }

    /** @return ID */
    public String getId() { return id; }

    /** @param id unique ID */
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("ID is required.");
        this.id = id.trim();
    }

    /** @return name */
    public String getName() { return name; }

    /** @param name full name */
    public void setName(String name) {
        if (name == null || name.trim().length() < 2) throw new IllegalArgumentException("Name is required.");
        this.name = name.trim();
    }

    /** @return email */
    public String getEmail() { return email; }

    /** @param email email address */
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("Valid email is required.");
        this.email = email.trim().toLowerCase();
    }

    /**
     * Builds a common description.
     *
     * @return description text
     */
    public String describe() {
        return id + " | " + name + " | " + email;
    }
}
