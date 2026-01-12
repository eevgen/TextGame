package org.example.model.commands;

import org.example.interfaces.Command;
import org.example.model.Backpack;
import org.example.model.Character;
import org.example.model.Item;
import org.example.model.Location;
import org.example.service.BackpackService;
import org.example.service.LocationService;

import java.util.ArrayList;
import java.util.List;

public class PickupItemCommand implements Command {

    private Item item;
    private Character character;
    private Location currentLocation;

    public PickupItemCommand(Item item, Character character, Location currentLocation) {
        this.item = item;
        this.character = character;
        this.currentLocation = currentLocation;
    }


    @Override
    public void execute() {
        System.out.println(item.getTitle() + " picked up");

        BackpackService.addItems(character.getBackpack(), item);
        System.err.println("Items in backpack: " +
                BackpackService.getAllItemsString(character.getBackpack()));

        LocationService.removeItems(currentLocation, item);
        System.err.println("Items in " + currentLocation.getName() + ": " +
                LocationService.getAllItemsString(currentLocation));
    }

    @Override
    public void undo() {
        System.out.println(item.getTitle() + " was removed from backpack");

        BackpackService.removeItems(character.getBackpack(), item);
        System.err.println("Items in backpack: " +
                BackpackService.getAllItemsString(character.getBackpack()));

        LocationService.addItems(currentLocation, item);
        System.err.println("Items in " + currentLocation.getName() + ": " +
                LocationService.getAllItemsString(currentLocation));
    }

    private Backpack getBackpack() {
        return character.getBackpack();
    }
}
