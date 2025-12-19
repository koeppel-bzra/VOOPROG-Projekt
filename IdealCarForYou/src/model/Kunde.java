package model;

import java.time.LocalDate;

public class Kunde {
    private int kundenId;
    private String vorName;
    private String nachName;
    private String strasse;
    private String plz;
    private String wohnort;
    private String telefonPrivat;
    private String telefonMobile;
    private String email;
    private LocalDate geburtsdatum;

    public Kunde(int kundenId, String nachName, String vorName) {
        this.kundenId = kundenId;
        this.nachName = nachName;
        this.vorName = vorName;
    }

    public String toString() {
        return kundenId + " - " + vorName + " - " + nachName;
    }

    public int getKundenId() {
        return kundenId;
    }

    public void setKundenId(int kundenId) {
        this.kundenId = kundenId;
    }

    public String getTelefonPrivat() {
        return telefonPrivat;
    }

    public void setTelefonPrivat(String telefonPrivat) {
        this.telefonPrivat = telefonPrivat;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getNachName() {
        return nachName;
    }

    public void setNachName(String nachName) {
        this.nachName = nachName;
    }

    public String getVorName() {
        return vorName;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    public String getTelefonMobile() {
        return telefonMobile;
    }

    public void setTelefonMobile(String telefonMobile) {
        this.telefonMobile = telefonMobile;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
