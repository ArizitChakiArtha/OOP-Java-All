package bd.edu.aiub.oop.assignment.midterm;

/**
 * Savings account with interest and minimum remaining balance rule.
 */
public class SavingsAccount extends BankAccount {
    private double interestRate;

    /**
     * Creates savings account.
     *
     * @param accountNumber account number
     * @param customer owner
     * @param openingBalance opening balance
     * @param interestRate interest rate
     * @throws AccountException when opening balance is invalid
     */
    public SavingsAccount(String accountNumber, Customer customer, double openingBalance, double interestRate) throws AccountException {
        super(accountNumber, customer, openingBalance);
        setInterestRate(interestRate);
    }

    /** @return interest rate */
    public double getInterestRate() { return interestRate; }

    /** @param interestRate annual interest rate */
    public void setInterestRate(double interestRate) {
        if (interestRate < 0 || interestRate > 1) throw new IllegalArgumentException("Interest rate must be 0 to 1.");
        this.interestRate = interestRate;
    }

    /** @return account type */
    @Override
    public String getAccountType() { return "Savings"; }

    /** @return minimum opening balance */
    @Override
    public double getMinimumOpeningBalance() { return 1000; }

    /** @return annual interest */
    @Override
    public double calculateYearlyBenefit() { return getBalance() * interestRate; }

    /** @return true when minimum balance remains */
    @Override
    public boolean canWithdraw(double amount) { return getBalance() - amount >= 500; }
}
