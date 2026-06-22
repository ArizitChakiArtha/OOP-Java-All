package bd.edu.aiub.oop.lab07;

/**
 * Checked exception for invalid CGPA input.
 */
public class InvalidCgpaException extends Exception {
    /**
     * Creates exception.
     *
     * @param message error message
     */
    public InvalidCgpaException(String message) { super(message); }
}
