package transportnieSredstva;

public class Taksi extends NazemniiTransport {

    public Taksi() {
        super("Такси", false);
    }


    @Override
    public int kolvoKoles() {
        return 4;
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
