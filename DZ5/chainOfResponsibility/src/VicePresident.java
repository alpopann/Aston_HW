public class VicePresident extends ApprovalHandler {
    @Override
    public void handleRequest(int amount) {
        if (amount <= 20000) {
            System.out.println("VP approved $" + amount);
        } else {
            System.out.println("Request for $" + amount + " requires CEO approval");
        }
    }
}