package transportnieSredstva;

import interfaces.ImeetVint;

public abstract class VodniiTransport extends TransportnieSredstva implements ImeetVint {
    // Используем конструктор по умолчанию, где perevozitGruzi = true
    public VodniiTransport(String name) {
        super(name);
    }

    public VodniiTransport(String name, boolean perevozitGruzi) {
        super(name, perevozitGruzi);
    }
}
