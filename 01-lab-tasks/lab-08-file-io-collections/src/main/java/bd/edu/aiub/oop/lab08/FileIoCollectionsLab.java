package bd.edu.aiub.oop.lab08;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Demonstrates file I/O with collections.
 */
public class FileIoCollectionsLab {
    /**
     * Runs ArrayList, HashMap, and File I/O demo.
     *
     * @param args unused arguments
     */
    public static void main(String[] args) {
        ContactBook book = new ContactBook();
        book.add(new Contact("01712345678", "Koushik Biswas Arko", "arko@example.com"));
        book.add(new Contact("01812345678", "AIUB Friend", "friend@example.com"));
        ContactFileRepository repository = new ContactFileRepository(Paths.get("target", "contacts.csv"));
        try {
            repository.save(book.all());
            ContactBook loaded = new ContactBook();
            loaded.replaceAll(repository.load());
            loaded.all().forEach(System.out::println);
        } catch (IOException exception) {
            System.out.println("File operation failed: " + exception.getMessage());
        }
    }
}
