public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(250);
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(100);
    }
}