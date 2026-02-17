package d3.hw;

@FunctionalInterface // to allow only one abstract method
public interface AccountValidator {
    boolean validate(BankAccount account);
}
