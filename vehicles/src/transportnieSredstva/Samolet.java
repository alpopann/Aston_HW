package transportnieSredstva;

public class Samolet extends VozdushniiTransport {
    public Samolet() {
        // По умолчанию perevozitGruzi = true
        super("Самолет");
    }

    @Override
    public int kolvoKoles() {
        return 6;
    }

    @Override
    public void vint() {
        System.out.println("Самолет: Вращается винт.");
    }

    @Override
    public void krylia(){
        System.out.println("Самолет: Крылья стабилизируются.");
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
