package controller;

import model.CarManageModel;
import model.Fahrzeug;

import java.util.ArrayList;
import java.util.List;

public class FahrzeugController {
    private List<Fahrzeug> fahrzeuge = new ArrayList<>();

    public void add(Fahrzeug fahrzeug) {
        fahrzeuge.add(fahrzeug);
    }

    public void remove(Fahrzeug fahrzeug) {
        fahrzeuge.add(fahrzeug);
    }
}
