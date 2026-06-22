package bd.edu.aiub.oop.lab08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contact book using ArrayList for ordering and HashMap for fast lookup.
 */
public class ContactBook {
    private final List<Contact> contacts = new ArrayList<>();
    private final Map<String, Contact> byPhone = new HashMap<>();

    /**
     * Adds a unique contact.
     *
     * @param contact contact to add
     */
    public void add(Contact contact) {
        if (contact == null) throw new IllegalArgumentException("Contact required.");
        if (byPhone.containsKey(contact.getPhone())) throw new IllegalArgumentException("Duplicate contact.");
        contacts.add(contact);
        byPhone.put(contact.getPhone(), contact);
    }

    /**
     * Finds a contact by phone.
     *
     * @param phone phone number
     * @return contact or null
     */
    public Contact find(String phone) { return byPhone.get(phone); }

    /**
     * Returns all contacts.
     *
     * @return defensive copy
     */
    public List<Contact> all() { return new ArrayList<>(contacts); }

    /**
     * Replaces all contacts.
     *
     * @param loadedContacts contacts loaded from file
     */
    public void replaceAll(List<Contact> loadedContacts) {
        contacts.clear();
        byPhone.clear();
        for (Contact contact : loadedContacts) add(contact);
    }
}
