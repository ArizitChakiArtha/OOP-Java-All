package bd.edu.aiub.oop.courseproject.exception;

/**
 * Checked exception for repository/file failures.
 */
public class RepositoryException extends Exception {
    /**
     * Creates repository exception.
     *
     * @param message error message
     */
    public RepositoryException(String message) { super(message); }

    /**
     * Creates repository exception with cause.
     *
     * @param message error message
     * @param cause original exception
     */
    public RepositoryException(String message, Throwable cause) { super(message, cause); }
}
