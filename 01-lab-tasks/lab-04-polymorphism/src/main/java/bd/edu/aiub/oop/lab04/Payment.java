package bd.edu.aiub.oop.lab04;

/**
 * Base payment class for runtime polymorphism.
 */
public class Payment {
    private double amount;

    /**
     * Creates a payment.
     *
     * @param amount payment amount
     */
    public Payment(double amount) { setAmount(amount); }

    /** @return payment amount */
    public double getAmount() { return amount; }

    /** @param amount payment amount */
    public void setAmount(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive.");
        this.amount = amount;
    }

    /**
     * Processes the payment.
     *
     * @return processing message
     */
    public String process() { return "Generic payment processed: " + String.format("%.2f", amount); }
}
