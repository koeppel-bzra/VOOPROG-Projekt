package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Transporter extends Fahrzeug implements Serializable {
    private int maxZuladungInKg;

    public Transporter(int fahrzeugId, String marke, String modell, int hubraum, TreibstoffArt treibstoffArt, int kmStand, int leistungsPs, LocalDate erstzulassung, String aussenfarbe, int leergewicht, int maxZuladungInKg) {
        super(fahrzeugId, marke, modell, hubraum, treibstoffArt, kmStand, leistungsPs, erstzulassung, aussenfarbe, leergewicht);
        this.maxZuladungInKg = maxZuladungInKg;
    }

    @Override
    public String toString() {
        return "T" + getFahrzeugId() + " | " + getMarke() + " " + getModell();
    }

    public int getMaxZuladungInKg() {
        return maxZuladungInKg;
    }
}
