package controller;

import model.*;

import java.util.List;

public class FahrzeugController {
    private CarManageModel model;
    private Benutzer aktuellerBenutzer;

    public FahrzeugController(CarManageModel model, Benutzer aktuellerBenutzer) {
        this.model = model;
        this.aktuellerBenutzer = aktuellerBenutzer;
    }

    public void addFahrzeug(Fahrzeug fahrzeug) {
        if (aktuellerBenutzer.getRolle() != Rolle.FAHRZEUGMANAGER) {
            throw new SecurityException("Keine Berechtigung");
        }
        model.addFahrzeug(fahrzeug);
    }

    public void deleteFahrzeug(Fahrzeug fahrzeug) {
        if (aktuellerBenutzer.getRolle() != Rolle.FAHRZEUGMANAGER) {
            throw new SecurityException("Keine Berechtigung");
        }
        model.deleteFahrzeug(fahrzeug);
    }



    public List<Fahrzeug> sucheFahrzeug(String marke, String modell) {
        return model.sucheFahrzeug(marke, modell);
    }

    public List<Fahrzeug> alleFahrzeuge() {
        return model.getFahrzeug();
    }
}
