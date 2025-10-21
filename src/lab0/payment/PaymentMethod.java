package lab0.payment;

public interface PaymentMethod {
    boolean charge(double amount);
}