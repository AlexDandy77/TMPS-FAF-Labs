package lab0.payment;

public class PaypalPayment implements PaymentMethod {
    private final String account;

    public PaypalPayment(String account) { this.account = account; }

    @Override
    public boolean charge(double amount) {
        System.out.println("[PayPal] Charging " + amount + " from " + account);
        return true;
    }
}