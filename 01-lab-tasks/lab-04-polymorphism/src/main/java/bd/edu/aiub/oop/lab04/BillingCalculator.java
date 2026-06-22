package bd.edu.aiub.oop.lab04;

/**
 * Demonstrates method overloading as compile-time polymorphism.
 */
public class BillingCalculator {
    /**
     * Calculates basic bill.
     *
     * @param unitPrice unit price
     * @param quantity quantity
     * @return total bill
     */
    public double calculate(double unitPrice, int quantity) {
        validate(unitPrice, quantity);
        return unitPrice * quantity;
    }

    /**
     * Calculates bill with discount.
     *
     * @param unitPrice unit price
     * @param quantity quantity
     * @param discount discount from 0 to 1
     * @return discounted bill
     */
    public double calculate(double unitPrice, int quantity, double discount) {
        if (discount < 0 || discount > 1) throw new IllegalArgumentException("Discount must be 0 to 1.");
        double total = calculate(unitPrice, quantity);
        return total - total * discount;
    }

    /**
     * Calculates bill with discount and VAT.
     *
     * @param unitPrice unit price
     * @param quantity quantity
     * @param discount discount from 0 to 1
     * @param vat VAT from 0 to 1
     * @return final bill
     */
    public double calculate(double unitPrice, int quantity, double discount, double vat) {
        if (vat < 0 || vat > 1) throw new IllegalArgumentException("VAT must be 0 to 1.");
        double subtotal = calculate(unitPrice, quantity, discount);
        return subtotal + subtotal * vat;
    }

    private void validate(double unitPrice, int quantity) {
        if (unitPrice <= 0 || quantity <= 0) throw new IllegalArgumentException("Price and quantity must be positive.");
    }
}
