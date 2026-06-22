package bd.edu.aiub.oop.assignment.midterm;

/**
 * Abstract bank account with common account operations.
 */
public abstract class BankAccount {
    private String accountNumber;
    private Customer customer;
    private double balance;

    /**
     * Creates account.
     *
     * @param accountNumber account number
     * @param customer account owner
     * @param openingBalance opening balance
     * @throws AccountException when opening balance violates policy
     */
    public BankAccount(String accountNumber, Customer customer, double openingBalance) throws AccountException {
        setAccountNumber(accountNumber);
        setCustomer(customer);
        if (openingBalance < getMinimumOpeningBalance()) throw new AccountException("Opening balance below minimum.");
        this.balance = openingBalance;
    }

    /** @return account number */
    public String getAccountNumber() { return accountNumber; }

    /** @param accountNumber account number */
    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) throw new IllegalArgumentException("Account number required.");
        this.accountNumber = accountNumber.trim();
    }

    /** @return customer */
    public Customer getCustomer() { return customer; }

    /** @param customer account owner */
    public void setCustomer(Customer customer) {
        if (customer == null) throw new IllegalArgumentException("Customer required.");
        this.customer = customer;
    }

    /** @return balance */
    public double getBalance() { return balance; }

    /**
     * Deposits money.
     *
     * @param amount deposit amount
     * @throws AccountException when amount is invalid
     */
    public void deposit(double amount) throws AccountException {
        if (amount <= 0) throw new AccountException("Deposit amount must be positive.");
        balance += amount;
    }

    /**
     * Withdraws money.
     *
     * @param amount withdrawal amount
     * @throws AccountException when policy denies withdrawal
     */
    public void withdraw(double amount) throws AccountException {
        if (amount <= 0) throw new AccountException("Withdrawal must be positive.");
        if (!canWithdraw(amount)) throw new AccountException("Withdrawal denied.");
        balance -= amount;
    }

    /**
     * Checks withdrawal policy.
     *
     * @param amount requested amount
     * @return true when withdrawal is allowed
     */
    public boolean canWithdraw(double amount) { return balance - amount >= 0; }

    /**
     * Gets account type.
     *
     * @return account type
     */
    public abstract String getAccountType();

    /**
     * Gets minimum opening balance.
     *
     * @return minimum balance
     */
    public abstract double getMinimumOpeningBalance();

    /**
     * Calculates yearly benefit or charge.
     *
     * @return yearly benefit; negative means charge
     */
    public abstract double calculateYearlyBenefit();

    /**
     * Builds account summary.
     *
     * @return summary text
     */
    public String describe() {
        return getAccountType() + " | " + accountNumber + " | " + customer.getName() + " | Balance " + String.format("%.2f", balance);
    }
}
