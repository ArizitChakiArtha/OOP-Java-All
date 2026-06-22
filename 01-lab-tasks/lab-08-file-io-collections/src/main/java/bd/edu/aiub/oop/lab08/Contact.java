package bd.edu.aiub.oop.lab08;

/**
 * Contact model used for ArrayList, HashMap, and file I/O practice.
 */
public class Contact {
    private String phone;
    private String name;
    private String email;

    /**
     * Creates a contact.
     *
     * @param phone phone number
     * @param name contact name
     * @param email email address
     */
    public Contact(String phone, String name, String email) {
        setPhone(phone);
        setName(name);
        setEmail(email);
    }

    /** @return phone */
    public String getPhone() { return phone; }

    /** @param phone phone number */
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("01\\d{9}")) throw new IllegalArgumentException("BD phone must start with 01 and contain 11 digits.");
        this.phone = phone;
    }

    /** @return name */
    public String getName() { return name; }

    /** @param name contact name */
    public void setName(String name) {
        if (name == null || name.trim().length() < 2) throw new IllegalArgumentException("Name is required.");
        this.name = name.trim();
    }

    /** @return email */
    public String getEmail() { return email; }

    /** @param email email address */
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("Valid email required.");
        this.email = email.trim().toLowerCase();
    }

    /**
     * Converts contact to CSV.
     *
     * @return CSV row
     */
    public String toCsv() { return phone + "," + name.replace(",", " ") + "," + email; }

    /**
     * Parses a contact from CSV.
     *
     * @param row CSV row
     * @return contact
     */
    public static Contact fromCsv(String row) {
        String[] parts = row.split(",", -1);
        if (parts.length != 3) throw new IllegalArgumentException("Invalid contact row.");
        return new Contact(parts[0], parts[1], parts[2]);
    }

    /**
     * Converts object to text.
     *
     * @return display text
     */
    @Override
    public String toString() { return phone + " | " + name + " | " + email; }
}
