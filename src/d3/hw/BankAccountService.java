package d3.hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BankAccountService {
    public BankAccountService() {
    }

    /**
     * Function to filter and display the accounts using the built-in functional interfaces
     *
     * @param accounts Accounts to use the filter on them.
     * @param filter   Lambda function to filter the accounts using the Predicate<T>.
     * @param action   Lambda function to print the account details using the Consumer<T>.
     */
    public void filterAndDisplay(
            List<BankAccount> accounts,
            Predicate<BankAccount> filter, // .test() to calls the lambda function (take t return boolean)
            Consumer<BankAccount> action // .accept() to apply actions (take t return void)
    ) {
        // iterate over the accounts
        for (BankAccount account : accounts) {
            // validate if the account balance is greater than 1k
            if (filter.test(account)) {
                // print the account details
                action.accept(account);
            }
        }
    }

    /**
     * Function to transform accounts
     *
     * @param accounts    List of accounts to apply the filters on.
     * @param filter      Lambda function to filter the accounts using the Predicate<T>.
     * @param transformer Lambda function to apply changes using the Function<T, R>.
     * @return
     */
    public List<String> transformAccounts(
            List<BankAccount> accounts,
            Predicate<BankAccount> filter, // .test() to calls the provided lambda function (take t return boolean)
            Function<BankAccount, String> transformer // .apply() to calls the provided lambda function (take t and return r)
    ) {
        // result holder
        List<String> result = new ArrayList<>();

        // iterate over the accounts
        for (BankAccount account : accounts) {
            // check if the account activity
            if (filter.test(account)) {
                // transform the account to capitalize the first letter
                var accountName = transformer.apply(account);

                // add the account holder name in the array
                result.add(accountName);
            }
        }

        // return the account names
        return result;
    }

    /**
     * Function to generate default account
     *
     * @param supplier Lambda function to generate a new account the BankAccount constructor
     * @return New bank account.
     */
    public BankAccount generateDefaultAccount(
            Supplier<BankAccount> supplier // .get() to calls the lambda function (take void return r)
    ) {
        return supplier.get();
    }

    /**
     * Function to generate a default account.
     *
     * @param accounts  List of accounts to apply the filters on.
     * @param validator Lambda function to filter the accounts using the Custom Interface.
     * @param adjuster  Lambda function to adjust the account balance using the Custom Interface.
     * @return List of account names.
     */
    public List<BankAccount> validateAndAdjustBalance(
            List<BankAccount> accounts,
            AccountValidator validator,
            BalanceAdjuster adjuster
    ) {
        // result holder
        List<BankAccount> result = new ArrayList<>();

        // iterate over the accounts
        for (BankAccount account : accounts) {
            // if the account is valid
            if (validator.validate(account)) {
                // adjusting the account balance (bal * 1.10)
                adjuster.adjust(account.getBalance());

                // add the account to the result list
                result.add(account); // capitalize the first letter
            }
        }

        // return the updated accounts list
        return result;
    }

    // function to count accounts by type
    public Map<String, Integer> countAccountsByType(List<BankAccount> accounts) {
        // create the counter map with initial values
        Map<String, Integer> result = new HashMap<>();
        result.put("saving", 0);
        result.put("checking", 0);
        result.put("business", 0);


        // iterate over the accounts
        for (BankAccount account : accounts) {
            // count the accounts by type
            if (account.getAccountType().equals(AccountType.CHECKING)) {
                result.put("checking", result.get("checking") + 1);
            } else if (account.getAccountType().equals(AccountType.SAVING)) {
                result.put("saving", result.get("saving") + 1);
            } else {
                result.put("business", result.get("business") + 1);
            }
        }

        // return
        return result;
    }

}
