package infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Fahrzeug;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FahrzeugRepo {

    private static final String FILE = "fahrzeuge.json";
    private ObjectMapper mapper = new ObjectMapper();

    public FahrzeugRepo() {
        mapper.writerWithDefaultPrettyPrinter();
    }

    public List<Fahrzeug> loadFahrzeuge() {
        try {
            File file = new File(FILE);
            if (!file.exists()) return new ArrayList<>();

            Fahrzeug[] arr = mapper.readValue(file, Fahrzeug[].class);
            List<Fahrzeug> list = new ArrayList<>();

                for (Fahrzeug f : arr) {
                    list.add(f);
                }

            return list;

        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void saveFahrzeuge(List<Fahrzeug> fahrzeuge) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE), fahrzeuge);
        } catch (IOException e) {
            System.out.println("Existiert schon");
        }
    }
}
