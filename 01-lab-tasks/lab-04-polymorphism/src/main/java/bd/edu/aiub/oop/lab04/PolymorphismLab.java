package bd.edu.aiub.oop.lab04;

/**
 * Demonstrates overloading, overriding, and dynamic method dispatch.
 */
public class PolymorphismLab {
    /**
     * Runs polymorphism examples.
     *
     * @param args unused arguments
     */
    public static void main(String[] args) {
        BillingCalculator calculator = new BillingCalculator();
        System.out.println(calculator.calculate(500, 2));
        System.out.println(calculator.calculate(500, 2, 0.10));
        System.out.println(calculator.calculate(500, 2, 0.10, 0.15));

        Payment[] payments = {new Payment(100), new CashPayment(200), new CardPayment(300, "4589")};
        for (Payment payment : payments) {
            System.out.println(payment.process());
        }
    }
}
