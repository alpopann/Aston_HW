package transportnieSredstva;

import interfaces.ImeetKolesa;
import interfaces.ImeetKrylia;
import interfaces.ImeetVint;

public abstract class VozdushniiTransport extends TransportnieSredstva implements ImeetKolesa, ImeetKrylia, ImeetVint {
    // Используем конструктор по умолчанию, где perevozitGruzi = true
    public VozdushniiTransport(String name) {
        super(name);
    }

    public VozdushniiTransport(String name, boolean perevozitGruzi) {
        super(name, perevozitGruzi);
    }

}