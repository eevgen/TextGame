package org.example;

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
        Backpack backpack = new Backpack(10);
        Player player = new Player("Jack", startLocation, backpack, 100);

        CommandFactory factory = new CommandFactory(player, itemService);
        CommandParser parser = new CommandParser(factory);
        GameController controller = new GameController(parser);

        controller.start();
    }
}
