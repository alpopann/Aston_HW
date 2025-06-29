package transportnieSredstva;

public abstract class TransportnieSredstva {
    private String name;
    private final boolean perevozitGruzi;

    // Конструктор по умолчанию: perevozitGruzi = true
    public TransportnieSredstva(String name) {
        this.name = name;
        this.perevozitGruzi = true;
    }

    // Перегруженный конструктор для явной установки perevozitGruzi
    public TransportnieSredstva(String name, boolean perevozitGruzi) {
        this.name = name;
        this.perevozitGruzi = perevozitGruzi;
    }

    public String getName() {
        return name;
    }

    public boolean etoPerevozcik() {
        return perevozitGruzi;
    }
    public abstract void vozitGruzi();
}
