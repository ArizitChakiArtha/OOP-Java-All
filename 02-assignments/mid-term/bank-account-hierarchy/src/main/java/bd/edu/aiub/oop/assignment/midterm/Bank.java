package bd.edu.aiub.oop.assignment.midterm;

import java.util.ArrayList;
import java.util.List;

/**
 * Bank container using a collection of accounts.
 */
public class Bank {
    private final List<BankAccount> accounts = new ArrayList<>();

    /**
     * Adds an account.
     *
     * @param account account to add
     * @throws AccountException when duplicate account exists
     */
    public void addAccount(BankAccount account) throws AccountException {
        if (account == null) throw new IllegalArgumentException("Account required.");
        if (findAccount(account.getAccountNumber()) != null) throw new AccountException("Duplicate account.");
        accounts.add(account);
    }

    /**
     * Finds account by number.
     *
     * @param accountNumber account number
     * @return account or null
     */
    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) return account;
        }
        return null;
    }

    /**
     * Lists accounts.
     *
     * @return defensive account list
     */
    public List<BankAccount> getAccounts() { return new ArrayList<>(accounts); }
}
