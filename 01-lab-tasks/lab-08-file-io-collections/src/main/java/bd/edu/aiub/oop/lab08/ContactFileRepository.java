package bd.edu.aiub.oop.lab08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * File repository using BufferedReader and BufferedWriter.
 */
public class ContactFileRepository {
    private final Path file;

    /**
     * Creates a repository.
     *
     * @param file CSV file path
     */
    public ContactFileRepository(Path file) {
        if (file == null) throw new IllegalArgumentException("File path required.");
        this.file = file;
    }

    /**
     * Saves contacts.
     *
     * @param contacts contacts to save
     * @throws IOException when writing fails
     */
    public void save(List<Contact> contacts) throws IOException {
        Files.createDirectories(file.getParent());
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (Contact contact : contacts) {
                writer.write(contact.toCsv());
                writer.newLine();
            }
        }
    }

    /**
     * Loads contacts.
     *
     * @return loaded contacts
     * @throws IOException when reading fails
     */
    public List<Contact> load() throws IOException {
        List<Contact> result = new ArrayList<>();
        if (!Files.exists(file)) return result;
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String row;
            while ((row = reader.readLine()) != null) {
                if (!row.trim().isEmpty()) result.add(Contact.fromCsv(row));
            }
        }
        return result;
    }
}
