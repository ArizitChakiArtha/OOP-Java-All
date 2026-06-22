package bd.edu.aiub.oop.lab04;

/**
 * Cash payment implementation.
 */
public class CashPayment extends Payment {
    /**
     * Creates a cash payment.
     *
     * @param amount payment amount
     */
    public CashPayment(double amount) { super(amount); }

    /**
     * Processes cash payment.
     *
     * @return processing message
     */
    @Override
    public String process() { return "Cash received: " + String.format("%.2f", getAmount()); }
}
