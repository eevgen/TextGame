package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private String name;

    ArrayList<Item> items =  new ArrayList<>();

    public Location(String name, ArrayList<Item> items) {
        this.name = name;
        this.items = items;
    }

    public void add(Item... itemsToAdd) {
        items.addAll(List.of(itemsToAdd));
    }

    public void remove(Item... itemsToRemove) {
        items.removeAll(List.of(itemsToRemove));
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
