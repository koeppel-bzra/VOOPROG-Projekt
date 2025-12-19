package infrastructure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GeneralRepo<T> {
    protected abstract String getFileName();

    public List<T> load() {
        File file = new File(getFileName());
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) input.readObject();
        }

        catch (Exception ex) {
            return new ArrayList<>();
        }
     }


     public void save(List<T> data) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(getFileName()))) {
            output.writeObject(data);
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }
     }
}
