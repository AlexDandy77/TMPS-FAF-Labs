package lab1.payment;

public class CardPayment implements PaymentMethod {
    private final String maskedCard;

    public CardPayment(String maskedCard) { this.maskedCard = maskedCard; }

    @Override
    public boolean charge(double amount) {
        System.out.println("[Card] Charging " + amount + " using " + maskedCard);
        return true;
    }
}