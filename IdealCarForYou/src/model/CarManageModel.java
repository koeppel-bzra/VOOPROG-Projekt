package model;

import java.util.ArrayList;
import java.util.List;

public class CarManageModel {
    private ArrayList<Fahrzeug> fahrzeuge;
    private ArrayList<Kunde> kunden;
    private ArrayList<Benutzer> benutzer;

    private int fahrzeugIdCounter = 1;
    private int kundenIdCounter = 1;

    public CarManageModel() {
        this.fahrzeuge = new ArrayList<>();
        this.kunden = new ArrayList<>();
        this.benutzer = new ArrayList<>();
    }


    public int getNextFahrzeugId() {
        return fahrzeugIdCounter++;
    }

    public List<Fahrzeug> getFahrzeug() {
        return fahrzeuge;
    }

    public void addFahrzeug(Fahrzeug fahrzeug) {
        fahrzeuge.add(fahrzeug);
    }

    public void deleteFahrzeug(Fahrzeug fahrzeug) {
        fahrzeuge.remove(fahrzeug);
    }


    public int getNextKundenId() {
        return kundenIdCounter++;
    }

    public List<Kunde> getKunden() {
        return kunden;
    }

    public void addKunde(Kunde kunde) {
        kunden.add(kunde);
    }

    public void deleteKunde(Kunde kunde) {
        kunden.remove(kunde);
    }


    public List<Benutzer> getBenutzer() {
        return benutzer;
    }
}
