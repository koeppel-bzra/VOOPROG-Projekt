package controller;

import infrastructure.KundenRepo;
import model.*;

import java.util.List;

public class KundenController {
    private CarManageModel model;
    private Benutzer aktuellerBenutzer;
    private KundenRepo kundenRepo;

    public KundenController(CarManageModel model, Benutzer aktuellerBenutzer, KundenRepo kundenRepo) {
        this.model = model;
        this.aktuellerBenutzer = aktuellerBenutzer;
        this.kundenRepo = kundenRepo;
    }

}
