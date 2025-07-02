public class EuropeanToUSAdapter implements Charger {
    private final EuropeanSocket socket;
    public EuropeanToUSAdapter(EuropeanSocket socket) {
        this.socket = socket;
    }
    @Override
    public void charge() {
        socket.provide220V();
        System.out.println("Adapter converts 220V to 110V");
    }
}