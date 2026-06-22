package bd.edu.aiub.oop.courseproject.model;

import bd.edu.aiub.oop.courseproject.exception.ValidationException;

/**
 * Abstract base model for people.
 */
public abstract class Person implements Identifiable, CsvConvertible {
    private String id;
    private String name;
    private String email;

    /**
     * Creates a person.
     *
     * @param id ID
     * @param name full name
     * @param email email address
     * @throws ValidationException when data is invalid
     */
    public Person(String id, String name, String email) throws ValidationException {
        setId(id);
        setName(name);
        setEmail(email);
    }

    /** @return ID */
    @Override
    public String getId() { return id; }

    /** @param id ID
     * @throws ValidationException when ID is empty */
    public void setId(String id) throws ValidationException {
        if (id == null || id.trim().isEmpty()) throw new ValidationException("ID is required.");
        this.id = id.trim();
    }

    /** @return full name */
    public String getName() { return name; }

    /** @param name full name
     * @throws ValidationException when name is invalid */
    public void setName(String name) throws ValidationException {
        if (name == null || name.trim().length() < 2) throw new ValidationException("Name must contain at least two characters.");
        this.name = name.trim();
    }

    /** @return email */
    public String getEmail() { return email; }

    /** @param email email address
     * @throws ValidationException when email is invalid */
    public void setEmail(String email) throws ValidationException {
        if (email == null || !email.contains("@")) throw new ValidationException("Valid email required.");
        this.email = email.trim().toLowerCase();
    }

    /**
     * Gets role name.
     *
     * @return role
     */
    public abstract String getRole();

    /**
     * Builds a common description.
     *
     * @return description
     */
    public String describe() { return getRole() + " | " + id + " | " + name + " | " + email; }
}
