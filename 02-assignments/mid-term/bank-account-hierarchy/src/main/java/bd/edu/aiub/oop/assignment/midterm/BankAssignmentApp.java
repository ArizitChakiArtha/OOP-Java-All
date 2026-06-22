package bd.edu.aiub.oop.assignment.midterm;

/**
 * Runs the mid-term Bank Account Hierarchy assignment.
 */
public class BankAssignmentApp {
    /**
     * Executes the assignment solution.
     *
     * @param args unused arguments
     */
    public static void main(String[] args) {
        try {
            Customer customer = new Customer("C-001", "Koushik Biswas Arko", "01712345678");
            Bank bank = new Bank();
            bank.addAccount(new SavingsAccount("S-1001", customer, 10000, 0.06));
            bank.addAccount(new CurrentAccount("C-2001", customer, 20000, 10000, 1200));
            for (BankAccount account : bank.getAccounts()) {
                account.deposit(2500);
                System.out.println(account.describe());
                System.out.println("Yearly benefit/charge: " + String.format("%.2f", account.calculateYearlyBenefit()));
            }
        } catch (AccountException exception) {
            System.out.println("Bank operation failed: " + exception.getMessage());
        }
    }
}
