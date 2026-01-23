package controller;

import infrastructure.FahrzeugRepo;
import model.*;

import java.util.List;

public class FahrzeugController {
    private CarManageModel model;
    private FahrzeugRepo fahrzeugRepo;

    public FahrzeugController(CarManageModel model, FahrzeugRepo fahrzeugRepo) {
        this.model = model;
        this.fahrzeugRepo = fahrzeugRepo;
    }

    // Fahrzeug hinzufügen
    public void addFahrzeug(Fahrzeug fahrzeug) {
        model.addFahrzeug(fahrzeug);
    }

    // Alle Fahrzeuge zurückgeben
    public List<Fahrzeug> alleFahrzeuge() {
        return model.getFahrzeuge();
    }

    // Speichern
    public void speichern() {
        // getrennt speichern, damit JSON sauber bleibt
        fahrzeugRepo.saveAutos(model.getAutos());
        fahrzeugRepo.saveTransporter(model.getTransporter());
    }
}
