package transportnieSredstva;

public class Gruzovik extends NazemniiTransport{

    public Gruzovik() {
        super("Грузовик");
    }


    @Override
    public int kolvoKoles() {
        return 8;
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
