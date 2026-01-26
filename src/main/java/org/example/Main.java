package org.example;

import org.example.controller.CommandController;
import org.example.controller.GameController;
import org.example.model.Backpack;
import org.example.model.Location;
import org.example.model.Player;
import org.example.service.CommandFactory;
import org.example.service.CommandParser;
import org.example.service.ItemService;
import org.example.service.LocationService;

public class Main {

    public static void main(String[] args) {
        LocationService locationService = new LocationService();
        ItemService itemService = new ItemService();

        itemService.scrapItems();
        locationService.createWorld(itemService);

        Location startLocation = locationService.getStartLocation();
        Backpack batoh = new Backpack(10);
        Player hrac = new Player("Jack", startLocation, batoh, 100);

        CommandFactory factory = new CommandFactory(hrac, itemService);
        CommandParser parser = new CommandParser(factory);
        GameController controller = new GameController(parser, locationService);

        controller.start();
    }
}
