package transportnieSredstva;

public class Tanker extends VodniiTransport{

    public Tanker() {
        super("Танкер");
    }


    @Override
    public void vint() {
        System.out.println("Танкер: Вращается винт.");
    }


    @Override
    public void vozitGruzi() {
        if (etoPerevozcik()) {
            System.out.println(getName() + ": Возит грузы.");
        } else {
            System.out.println(getName() + ": Не предназначен для перевозки грузов.");
        }
    }
}
