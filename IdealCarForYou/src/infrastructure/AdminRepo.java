package infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Benutzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminRepo {

    private static final String FILE = "benutzer.json";
    private ObjectMapper mapper = new ObjectMapper();

    public List<Benutzer> loadBenutzer() {
        try {
            File file = new File(FILE);
            if (!file.exists()) return new ArrayList<>();

            Benutzer[] arr = mapper.readValue(file, Benutzer[].class);
            List<Benutzer> list = new ArrayList<>();
            for (Benutzer b : arr) list.add(b);
            return list;

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void saveBenutzer(List<Benutzer> benutzer) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE), benutzer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
