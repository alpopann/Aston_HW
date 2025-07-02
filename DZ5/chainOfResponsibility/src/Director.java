public class Director extends ApprovalHandler {
    @Override
    public void handleRequest(int amount) {
        if (amount <= 5000) {
            System.out.println("Director approved $" + amount);
        } else if (next != null) {
            next.handleRequest(amount);
        }
    }
}