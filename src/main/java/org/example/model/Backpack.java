package org.example.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Backpack {

    private static final ArrayList<Item> items = new ArrayList<>();

    public void add(Item... itemsToAdd) {
        items.addAll(Arrays.asList(itemsToAdd));
    }

    public void remove(Item... itemsToRemove) {
        items.removeAll(Arrays.asList(itemsToRemove));
    }

    public ArrayList<Item> getItems() {
        return items;
    }

}
