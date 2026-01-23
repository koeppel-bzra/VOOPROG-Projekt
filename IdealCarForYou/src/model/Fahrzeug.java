package model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Fahrzeug implements Serializable {
    private int fahrzeugId;
    private String marke;
    private String modell;
    private int hubraum;
    private TreibstoffArt treibstoffArt;
    private int kmStand;
    private int leistungsPs;
    private LocalDate erstzulassung;
    private String aussenfarbe;
    private int leergewicht;

    public Fahrzeug() { }

    public Fahrzeug(int fahrzeugId, String marke, String modell, int hubraum, TreibstoffArt treibstoffArt,
                    int kmStand, int leistungsPs, LocalDate erstzulassung, String aussenfarbe, int leergewicht) {
        this.fahrzeugId = fahrzeugId;
        this.marke = marke;
        this.modell = modell;
        this.hubraum = hubraum;
        this.treibstoffArt = treibstoffArt;
        this.kmStand = kmStand;
        this.leistungsPs = leistungsPs;
        this.erstzulassung = erstzulassung;
        this.aussenfarbe = aussenfarbe;
        this.leergewicht = leergewicht;
    }

    public Fahrzeug(int fahrzeugId, String marke, String modell, LocalDate erstzulassung) {
        this.fahrzeugId = fahrzeugId;
        this.marke = marke;
        this.modell = modell;
        this.erstzulassung = erstzulassung;
    }

    // Getter & Setter
    public int getFahrzeugId() { return fahrzeugId; }
    public void setFahrzeugId(int fahrzeugId) { this.fahrzeugId = fahrzeugId; }
    public String getMarke() { return marke; }
    public void setMarke(String marke) { this.marke = marke; }
    public String getModell() { return modell; }
    public void setModell(String modell) { this.modell = modell; }
    public int getHubraum() { return hubraum; }
    public void setHubraum(int hubraum) { this.hubraum = hubraum; }
    public TreibstoffArt getTreibstoffArt() { return treibstoffArt; }
    public void setTreibstoffArt(TreibstoffArt treibstoffArt) { this.treibstoffArt = treibstoffArt; }
    public int getKmStand() { return kmStand; }
    public void setKmStand(int kmStand) { this.kmStand = kmStand; }
    public int getLeistungsPs() { return leistungsPs; }
    public void setLeistungsPs(int leistungsPs) { this.leistungsPs = leistungsPs; }
    public LocalDate getErstzulassung() { return erstzulassung; }
    public void setErstzulassung(LocalDate erstzulassung) { this.erstzulassung = erstzulassung; }
    public String getAussenfarbe() { return aussenfarbe; }
    public void setAussenfarbe(String aussenfarbe) { this.aussenfarbe = aussenfarbe; }
    public int getLeergewicht() { return leergewicht; }
    public void setLeergewicht(int leergewicht) { this.leergewicht = leergewicht; }

    @Override
    public String toString() {
        return fahrzeugId + " - " + marke + " - " + modell;
    }
}
