package infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import model.Auto;
import model.Transporter;
import model.Fahrzeug;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FahrzeugRepo {
    private static final String AUTO_FILE = "autos.json";
    private static final String TRANSPORTER_FILE = "transporter.json";

    private ObjectMapper mapper;

    public FahrzeugRepo() {
        mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(java.time.LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(java.time.LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);
    }

    // Autos speichern
    public void saveAutos(List<Auto> autos) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(AUTO_FILE), autos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Transporter speichern
    public void saveTransporter(List<Transporter> transporter) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(TRANSPORTER_FILE), transporter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Autos laden
    public List<Auto> loadAutos() {
        try {
            File file = new File(AUTO_FILE);
            if (!file.exists()) return new ArrayList<>();
            Auto[] arr = mapper.readValue(file, Auto[].class);
            List<Auto> list = new ArrayList<>();
            for (Auto a : arr) list.add(a);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Transporter laden
    public List<Transporter> loadTransporter() {
        try {
            File file = new File(TRANSPORTER_FILE);
            if (!file.exists()) return new ArrayList<>();
            Transporter[] arr = mapper.readValue(file, Transporter[].class);
            List<Transporter> list = new ArrayList<>();
            for (Transporter t : arr) list.add(t);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
