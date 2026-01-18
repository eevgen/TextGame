package org.example;

import org.example.controller.GameController;
import org.example.model.Backpack;
import org.example.model.Location;
import org.example.model.Player;
import org.example.service.LocationService;

public class Main {

    public static void main(String[] args) {
        LocationService locationService = new LocationService();
        Location startLocation = new Location("Půda", "Temná půda plná starých věcí");
        Backpack batoh = new Backpack(10);
        Player hrac = new Player("Jack", startLocation, batoh, 100);

        GameController gameController = new GameController(hrac, startLocation);
        gameController.start();
    }
}
