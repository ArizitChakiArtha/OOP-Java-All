package bd.edu.aiub.oop.lab04;

/**
 * Card payment implementation.
 */
public class CardPayment extends Payment {
    private String cardLastFour;

    /**
     * Creates a card payment.
     *
     * @param amount payment amount
     * @param cardLastFour last four card digits
     */
    public CardPayment(double amount, String cardLastFour) {
        super(amount);
        setCardLastFour(cardLastFour);
    }

    /** @return last four card digits */
    public String getCardLastFour() { return cardLastFour; }

    /** @param cardLastFour last four card digits */
    public void setCardLastFour(String cardLastFour) {
        if (cardLastFour == null || !cardLastFour.matches("\\d{4}")) throw new IllegalArgumentException("Last four digits required.");
        this.cardLastFour = cardLastFour;
    }

    /**
     * Processes card payment.
     *
     * @return processing message
     */
    @Override
    public String process() { return "Card ****" + cardLastFour + " charged: " + String.format("%.2f", getAmount()); }
}
