package bd.edu.aiub.oop.assignment.midterm;

/**
 * Customer model for bank assignment.
 */
public class Customer {
    private String id;
    private String name;
    private String phone;

    /**
     * Creates customer.
     *
     * @param id customer ID
     * @param name customer name
     * @param phone phone number
     */
    public Customer(String id, String name, String phone) {
        setId(id);
        setName(name);
        setPhone(phone);
    }

    /** @return customer ID */
    public String getId() { return id; }

    /** @param id customer ID */
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("Customer ID required.");
        this.id = id.trim();
    }

    /** @return name */
    public String getName() { return name; }

    /** @param name customer name */
    public void setName(String name) {
        if (name == null || name.trim().length() < 2) throw new IllegalArgumentException("Name required.");
        this.name = name.trim();
    }

    /** @return phone */
    public String getPhone() { return phone; }

    /** @param phone phone number */
    public void setPhone(String phone) {
        if (phone == null || phone.trim().length() < 6) throw new IllegalArgumentException("Phone required.");
        this.phone = phone.trim();
    }
}
