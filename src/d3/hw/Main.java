package d3.hw;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BankAccountService bankAccountService = new BankAccountService();

    public static void main(String[] args) {
        // list of accounts
        List<BankAccount> accounts = new ArrayList<>();

        // create 6 accounts
        accounts.add(new BankAccount(
                1,
                "Wesam Muneer",
                190.5,
                AccountType.CHECKING,
                true
        ));
        accounts.add(new BankAccount(
                2,
                "Sara Ali",
                750.0,
                AccountType.SAVING,
                true
        ));
        accounts.add(new BankAccount(
                3,
                "Omar Khalid",
                1200.0,
                AccountType.CHECKING,
                false
        ));
        accounts.add(new BankAccount(
                4,
                "Ahmed Jabber",
                1600.0,
                AccountType.BUSINESS,
                true
        ));
        accounts.add(new BankAccount(
                5,
                "Ali Ahmed",
                3000.0,
                AccountType.CHECKING,
                false
        ));
        accounts.add(new BankAccount(
                6,
                "Salman Saleh",
                480.0,
                AccountType.SAVING,
                true
        ));

        System.out.println("\n ** Running ** \n");

        System.out.println("Accounts with +1k balance:");
        // filter the accounts and print the account details
        bankAccountService.filterAndDisplay(
                accounts,
                acc -> acc.getBalance() > 1000,
                acc -> System.out.println(acc.toString())
        );

        System.out.println(" "); // divider

        System.out.println("Active accounts:");
        // get a list of active account names
        var listOfActiveAccounts = bankAccountService.transformAccounts(
                accounts,
                BankAccount::isActive, // acc -> acc.isActive()
                acc -> acc.getAccountHolder().substring(0, 1).toUpperCase() + acc.getAccountHolder().substring(1)
        );
        System.out.println(listOfActiveAccounts); // list of names

        System.out.println(" "); // divider

        // generate new account
        var defaultAccount = bankAccountService.generateDefaultAccount(
                () -> new BankAccount(
                        0,
                        "Unknown",
                        0.0,
                        AccountType.CHECKING,
                        false
                )
        );
        System.out.println("Generated account: " + defaultAccount.toString()); // print the generated account details

        System.out.println(" "); // divider

        // implement the validator and adjustor functions
        AccountValidator validator = acc -> acc.getBalance() > 500;
        BalanceAdjuster adjuster = balance -> balance * 1.10;

        var listOfAdjustedAccounts = bankAccountService.validateAndAdjustBalance(
                accounts,
                validator,
                adjuster
        );
        listOfAdjustedAccounts
                .forEach(acc -> System.out.println("Adjusted account (balance>500): " + acc.toString()));

        System.out.println(" "); // divider

        var counter = bankAccountService.countAccountsByType(accounts);
        System.out.println(String.format("Accounts of type (%s): %d and (%s): %d and (%s): %d",
                AccountType.CHECKING.toString().toLowerCase(),
                counter.get(AccountType.CHECKING.toString().toLowerCase()),
                AccountType.SAVING.toString().toLowerCase(),
                counter.get(AccountType.SAVING.toString().toLowerCase()),
                AccountType.BUSINESS.toString().toLowerCase(),
                counter.get(AccountType.BUSINESS.toString().toLowerCase())
        ));
    }
}
