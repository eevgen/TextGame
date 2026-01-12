package org.example.service;

import org.example.model.Backpack;
import org.example.model.Item;

public class BackpackService {

    public static String getAllItemsString(Backpack backpack) {
        StringBuilder finalString = new StringBuilder();
        for(Item item : backpack.getItems()) {
            finalString.append(item.getTitle()).append(" ");
        }
        return finalString.toString();
    }

    public static void addItems(Backpack backpack, Item... items) {
        backpack.add(items);
    }

    public static void removeItems(Backpack backpack, Item... items) {
        backpack.remove(items);
    }

}
