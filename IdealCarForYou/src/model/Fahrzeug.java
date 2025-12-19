package model;

import java.util.Date;

public abstract class Fahrzeug {
    private int fahrzeugId;
    private String marke;
    private String modell;
    private int hubraum;
    private TreibstoffArt treibstoffArt;
    private int kmStand;
    private int leistungsPs;
    private Date erstzulassung;
    private String aussenfarbe;
    private int leergewicht;


    public Fahrzeug(int fahrzeugId, String marke, String modell) {
        this.fahrzeugId = fahrzeugId;
        this.marke = marke;
        this.modell = modell;
    }


    public int getFahrzeugId() {
        return fahrzeugId;
    }

    public void setFahrzeugId(int fahrzeugId) {
        this.fahrzeugId = fahrzeugId;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public int getHubraum() {
        return hubraum;
    }

    public void setHubraum(int hubraum) {
        this.hubraum = hubraum;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public TreibstoffArt getTreibstoffArt() {
        return treibstoffArt;
    }

    public void setTreibstoffArt(TreibstoffArt treibstoffArt) {
        this.treibstoffArt = treibstoffArt;
    }

    public int getKmStand() {
        return kmStand;
    }

    public void setKmStand(int kmStand) {
        this.kmStand = kmStand;
    }

    public int getLeistungsPs() {
        return leistungsPs;
    }

    public void setLeistungsPs(int leistungsPs) {
        this.leistungsPs = leistungsPs;
    }

    public Date getErstzulassung() {
        return erstzulassung;
    }

    public void setErstzulassung(Date erstzulassung) {
        this.erstzulassung = erstzulassung;
    }

    public String getAussenfarbe() {
        return aussenfarbe;
    }

    public void setAussenfarbe(String aussenfarbe) {
        this.aussenfarbe = aussenfarbe;
    }

    public int getLeergewicht() {
        return leergewicht;
    }

    public void setLeergewicht(int leergewicht) {
        this.leergewicht = leergewicht;
    }
}
