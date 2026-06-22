package bd.edu.aiub.oop.assignment.midterm;

/**
 * Checked exception for bank-account business rules.
 */
public class AccountException extends Exception {
    /**
     * Creates exception.
     *
     * @param message error message
     */
    public AccountException(String message) { super(message); }
}
