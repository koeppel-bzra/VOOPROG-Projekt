package model;

import java.io.Serializable;

public class Transporter extends Fahrzeug implements Serializable {
    private int maxZuladungInKg;

    public Transporter(int fahrzeugId, String marke, String modell, int maxZuladungInKg) {
        super(fahrzeugId, marke, modell);
        this.maxZuladungInKg = maxZuladungInKg;
    }

    public int getMaxZuladungInKg() {
        return maxZuladungInKg;
    }
}
