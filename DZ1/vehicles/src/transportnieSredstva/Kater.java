package transportnieSredstva;

public class Kater extends VodniiTransport{
    public Kater() {
        super("Катер");
    }


    @Override
    public void vint() {
        System.out.println("Катер: Вращается винт.");
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