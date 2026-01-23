package model;

import java.time.LocalDate;

public class Transporter extends Fahrzeug {
    private int maxZuladungInKg;

    public Transporter() { }

    public Transporter(int fahrzeugId, String marke, String modell, int hubraum, TreibstoffArt treibstoffArt,
                       int kmStand, int leistungsPs, LocalDate erstzulassung, String aussenfarbe, int leergewicht,
                       int maxZuladungInKg) {
        super(fahrzeugId, marke, modell, hubraum, treibstoffArt, kmStand, leistungsPs, erstzulassung, aussenfarbe, leergewicht);
        this.maxZuladungInKg = maxZuladungInKg;
    }

    public int getMaxZuladungInKg() { return maxZuladungInKg; }
    public void setMaxZuladungInKg(int maxZuladungInKg) { this.maxZuladungInKg = maxZuladungInKg; }

    @Override
    public String toString() {
        return "T" + getFahrzeugId() + " | " + getMarke() + " " + getModell();
    }
}
