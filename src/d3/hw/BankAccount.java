package d3.hw;

public class BankAccount {
    private final int accountId;
    private final String accountHolder;
    private double balance;
    private final AccountType accountType;
    private boolean isActive;

    // all args const.
    public BankAccount(int accountId, String accountHolder, double balance, AccountType accountType, boolean isActive) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountType = accountType;
        this.isActive = isActive;
    }

    // getters
    public boolean isActive() {
        return isActive;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public int getAccountId() {
        return accountId;
    }

    // setters
    public void setActive(boolean active) {
        isActive = active;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // to string
    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId=" + accountId +
                ", accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                ", accountType=" + accountType +
                ", isActive=" + isActive +
                '}';
    }
}
