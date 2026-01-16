package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Auto extends Fahrzeug implements Serializable {
    private AufbauArt aufbauArt;
    private Navigationssystem navigation;

    public Auto(int fahrzeugId, String marke, String modell, int hubraum, TreibstoffArt treibstoffArt, int kmStand, int leistungsPs, LocalDate erstzulassung, String aussenfarbe, int leergewicht, AufbauArt aufbauArt, Navigationssystem navigation) {
        super(fahrzeugId, marke, modell, hubraum, treibstoffArt, kmStand, leistungsPs, erstzulassung, aussenfarbe, leergewicht);
        this.aufbauArt = aufbauArt;
        this.navigation = navigation;
    }

    @Override
    public String toString() {
        return "A" + getFahrzeugId() + " | " + getMarke() + " " + getModell();
    }



    public AufbauArt getAufbauArt() {
        return aufbauArt;
    }

    public Navigationssystem hasNavigation() {
        return navigation;
    }
}
