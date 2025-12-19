package infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Kunde;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KundenRepo {

    private static final String FILE = "kunden.json";
    private ObjectMapper mapper = new ObjectMapper();

    public List<Kunde> loadKunden() {
        try {
            File file = new File(FILE);
            if (!file.exists()) return new ArrayList<>();

            Kunde[] arr = mapper.readValue(file, Kunde[].class);
            List<Kunde> list = new ArrayList<>();
            for (Kunde k : arr) {
                list.add(k);
            }

            return list;

        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void saveKunden(List<Kunde> kunden) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE), kunden);
        } catch (IOException e) {
            System.out.println("Existiert schon");
        }
    }
}
