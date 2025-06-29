package transportnieSredstva;

import interfaces.ImeetKolesa;

public abstract class NazemniiTransport extends TransportnieSredstva implements ImeetKolesa {
    // Используем конструктор по умолчанию, где perevozitGruzi = true
    public NazemniiTransport(String name) {
        super(name);
    }

    public NazemniiTransport(String name, boolean perevozitGruzi) {
        super(name, perevozitGruzi);
    }
}
