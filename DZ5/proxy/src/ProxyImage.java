public class ProxyImage implements Image {
    private final String filename;
    private RealImage real;
    public ProxyImage(String filename) {
        this.filename = filename;
    }
    @Override
    public void display() {
        if (real == null) {
            real = new RealImage(filename);
        }
        real.display();
    }
}