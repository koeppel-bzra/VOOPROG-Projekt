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

    public int getKundenId() {
        return kundenId;
    }

    public String getNachName() {
        return nachName;
    }
}
