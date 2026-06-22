package bd.edu.aiub.oop.assignment.midterm;

/**
 * Current account with overdraft and service charge.
 */
public class CurrentAccount extends BankAccount {
    private double overdraftLimit;
    private double serviceCharge;

    /**
     * Creates current account.
     *
     * @param accountNumber account number
     * @param customer owner
     * @param openingBalance opening balance
     * @param overdraftLimit overdraft limit
     * @param serviceCharge annual service charge
     * @throws AccountException when opening balance is invalid
     */
    public CurrentAccount(String accountNumber, Customer customer, double openingBalance, double overdraftLimit, double serviceCharge) throws AccountException {
        super(accountNumber, customer, openingBalance);
        setOverdraftLimit(overdraftLimit);
        setServiceCharge(serviceCharge);
    }

    /** @return overdraft limit */
    public double getOverdraftLimit() { return overdraftLimit; }

    /** @param overdraftLimit overdraft limit */
    public void setOverdraftLimit(double overdraftLimit) {
        if (overdraftLimit < 0) throw new IllegalArgumentException("Overdraft cannot be negative.");
        this.overdraftLimit = overdraftLimit;
    }

    /** @return service charge */
    public double getServiceCharge() { return serviceCharge; }

    /** @param serviceCharge annual service charge */
    public void setServiceCharge(double serviceCharge) {
        if (serviceCharge < 0) throw new IllegalArgumentException("Service charge cannot be negative.");
        this.serviceCharge = serviceCharge;
    }

    /** @return account type */
    @Override
    public String getAccountType() { return "Current"; }

    /** @return minimum opening balance */
    @Override
    public double getMinimumOpeningBalance() { return 5000; }

    /** @return negative service charge */
    @Override
    public double calculateYearlyBenefit() { return -serviceCharge; }

    /** @return true when overdraft limit allows withdrawal */
    @Override
    public boolean canWithdraw(double amount) { return getBalance() - amount >= -overdraftLimit; }
}
