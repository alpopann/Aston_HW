public class AdapterDemo {
    public static void main(String[] args) {
        EuropeanSocket euro = new EuropeanSocket();
        Charger charger = new EuropeanToUSAdapter(euro);
        charger.charge();
    }
}