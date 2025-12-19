package infrastructure;

import model.Fahrzeug;

import java.util.List;

public class FahrzeugRepo extends GeneralRepo {

    @Override
    protected String getFileName() {
        return "fahrzeuge.dat";
    }

    public List<Fahrzeug> loadFahrzeuge() {
        return load();
    }

    public void saveFahrzeuge(List<Fahrzeug> fahrzeuge) {
        save(fahrzeuge);
    }
}
