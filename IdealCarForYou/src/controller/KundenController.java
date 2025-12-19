package controller;

import model.*;

import java.util.List;

public class KundenController {
    private CarManageModel model;
    private Benutzer aktuellerBenutzer;

    public KundenController(CarManageModel model, Benutzer aktuellerBenutzer) {
        this.model = model;
        this.aktuellerBenutzer = aktuellerBenutzer;
    }

    public void addKunde(Kunde kunde) {
        if (aktuellerBenutzer.getRolle() != Rolle.FAHRZEUGMANAGER) {
            throw new SecurityException("Keine Berechtigung");
        }
        model.addKunde(kunde);
    }

    public void deleteKunde(Kunde kunde) {
        if (aktuellerBenutzer.getRolle() != Rolle.FAHRZEUGMANAGER) {
            throw new SecurityException("Keine Berechtigung");
        }
        model.deleteKunde(kunde);
    }

    public List<Kunde> alleKunden() {
        return model.getKunden();
    }
}
