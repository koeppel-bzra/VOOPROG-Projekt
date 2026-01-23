package model;

import model.Auto;
import model.Transporter;
import model.Fahrzeug;

import java.util.ArrayList;
import java.util.List;

public class CarManageModel {
    private List<Fahrzeug> fahrzeuge;

    public CarManageModel() {
        fahrzeuge = new ArrayList<>();
    }

    public void addFahrzeug(Fahrzeug f) {
        fahrzeuge.add(f);
    }

    public List<Fahrzeug> getFahrzeuge() {
        return fahrzeuge;
    }

    public void deleteFahrzeug(Fahrzeug f) {
        fahrzeuge.remove(f);
    }

    public List<Auto> getAutos() {
        List<Auto> autos = new ArrayList<>();
        for (Fahrzeug f : fahrzeuge) {
            if (f instanceof Auto a) autos.add(a);
        }
        return autos;
    }

    public List<Transporter> getTransporter() {
        List<Transporter> transporter = new ArrayList<>();
        for (Fahrzeug f : fahrzeuge) {
            if (f instanceof Transporter t) transporter.add(t);
        }
        return transporter;
    }

    public int getNextFahrzeugId() {
        int max = 0;
        for (Fahrzeug f : fahrzeuge) {
            if (f.getFahrzeugId() > max) max = f.getFahrzeugId();
        }
        return max + 1;
    }
}
