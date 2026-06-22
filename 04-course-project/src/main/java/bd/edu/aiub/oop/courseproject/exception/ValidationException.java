package bd.edu.aiub.oop.courseproject.exception;

/**
 * Checked exception for validated business/domain failures.
 */
public class ValidationException extends Exception {
    /**
     * Creates validation exception.
     *
     * @param message error message
     */
    public ValidationException(String message) { super(message); }
}
