public class ProxyDemo {
    public static void main(String[] args) {
        Image img = new ProxyImage("picture.jpg");
        img.display(); // загрузится и отобразится
        img.display(); // только отобразится
    }
}