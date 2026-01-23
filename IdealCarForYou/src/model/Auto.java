package model;

import java.time.LocalDate;

public class Auto extends Fahrzeug {
    private AufbauArt aufbauArt;
    private Navigationssystem navigation;

    public Auto() { }

    public Auto(int fahrzeugId, String marke, String modell, int hubraum, TreibstoffArt treibstoffArt,
                int kmStand, int leistungsPs, LocalDate erstzulassung, String aussenfarbe, int leergewicht,
                AufbauArt aufbauArt, Navigationssystem navigation) {
        super(fahrzeugId, marke, modell, hubraum, treibstoffArt, kmStand, leistungsPs, erstzulassung, aussenfarbe, leergewicht);
        this.aufbauArt = aufbauArt;
        this.navigation = navigation;
    }

    public AufbauArt getAufbauArt() { return aufbauArt; }
    public void setAufbauArt(AufbauArt aufbauArt) { this.aufbauArt = aufbauArt; }

    public Navigationssystem getNavigation() { return navigation; }
    public void setNavigation(Navigationssystem navigation) { this.navigation = navigation; }

    @Override
    public String toString() {
        return "A" + getFahrzeugId() + " | " + getMarke() + " " + getModell();
    }
}
