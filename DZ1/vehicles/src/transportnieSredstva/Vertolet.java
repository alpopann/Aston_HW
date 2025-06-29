package transportnieSredstva;

public class Vertolet extends VozdushniiTransport {
    public Vertolet() {
        // По умолчанию perevozitGruzi = true
        super("Вертолет");
    }

    @Override
    public int kolvoKoles() {
        return 2;
    }

    @Override
    public void vint() {
        System.out.println("Вертолет: Вращается винт.");
    }

    @Override
    public void krylia(){
        System.out.println("Вертолет: Ротор Вращается.");
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
