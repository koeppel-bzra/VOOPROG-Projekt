package model;

import java.io.Serializable;

public class Benutzer implements Serializable {
    private String benutzername;
    private Rolle rolle;

    public Benutzer(String benutzername, Rolle rolle) {
        this.benutzername = benutzername;
        this.rolle = rolle;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public Rolle getRolle() {
        return rolle;
    }


}
