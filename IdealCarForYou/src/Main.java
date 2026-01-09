import controller.*;
import model.*;
import infrastructure.*;

public class Main {
    public static void main(String[] args) {
        FahrzeugRepo fahrzeugRepo = new FahrzeugRepo();
        KundenRepo kundenRepo = new KundenRepo();
        AdminRepo adminRepo = new AdminRepo();

        CarManageModel model = new CarManageModel();

        model.getFahrzeug().addAll(fahrzeugRepo.loadFahrzeuge());
        model.getKunden().addAll(kundenRepo.loadKunden());
        model.getBenutzer().addAll(adminRepo.loadBenutzer());

        Benutzer admin = new Benutzer("Admin", Rolle.ADMIN);
        Benutzer manager = new Benutzer("Fahrzeugpark Manager", Rolle.ADMIN);

        FahrzeugController fahrzeugController = new FahrzeugController(model, manager, fahrzeugRepo);
        KundenController kundenController = new KundenController(model, manager, kundenRepo);

        Auto auto = new Auto(model.getNextFahrzeugId(), "BMW", "X5", AufbauArt.Kleinwagen, true);
        Auto auto2 = new Auto(model.getNextFahrzeugId(), "Porsche", "M1", AufbauArt.Limousine, false);
        fahrzeugController.addFahrzeug(auto);
        fahrzeugController.addFahrzeug(auto2);

        Kunde kunde = new Kunde(model.getNextKundenId(),  "Müller", "Alex");
        Kunde kunde2 = new Kunde(model.getNextKundenId(), "Emele", "Noel");
        kundenController.addKunde(kunde);
        kundenController.addKunde(kunde2);

        System.out.println("--- Autos ---");
        for (Fahrzeug f : fahrzeugController.alleFahrzeuge()) {
            System.out.println(f.toString());
        }

        System.out.println("");

        System.out.println("--- Kunden ---");
        for (Kunde k : kundenController.alleKunden()) {
            System.out.println(k.toString());
        }

        fahrzeugController.speichern();
        kundenController.speichern();
    }
}
