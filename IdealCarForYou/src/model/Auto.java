package model;

public class Auto extends Fahrzeug {
    private AufbauArt aufbauArt;
    private boolean navigation;


    public Auto(int fahrzeugId, String marke, String modell, AufbauArt aufbauart, boolean navigation) {
        super(fahrzeugId, marke, modell);
        this.aufbauArt = aufbauart;
        this.navigation = navigation;
    }

    public AufbauArt getAufbauArt() {
        return aufbauArt;
    }

    public boolean hasNavigation() {
        return navigation;
    }
}
