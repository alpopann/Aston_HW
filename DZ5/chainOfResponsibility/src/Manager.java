public class Manager extends ApprovalHandler {
    @Override
    public void handleRequest(int amount) {
        if (amount <= 1000) {
            System.out.println("Manager approved $" + amount);
        } else if (next != null) {
            next.handleRequest(amount);
        }
    }
}