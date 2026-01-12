package org.example.service;

import org.example.model.Backpack;
import org.example.model.Item;
import org.example.model.Location;

public class LocationService {

    public static String getAllItemsString(Location location) {
        StringBuilder finalString = new StringBuilder();
        for(Item item : location.getItems()) {
            finalString.append(item.getTitle()).append(" ");
        }
        return finalString.toString();
    }

    public static void addItems(Location location, Item... items) {
        location.add(items);
    }

    public static void removeItems(Location location, Item... items) {
        location.remove(items);
    }

}
