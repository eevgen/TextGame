package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private List<Item> items;
    private int maxCapacity;

    public Backpack(int maxCapacity) {
        this.items = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    public boolean addItem(Item item) {
        if (!isFull()) {
            items.add(item);
            return true;
        }
        return false;
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean hasItem(String name) {
        return findItem(name) != null;
    }

    public Item findItem(String id) {
        for (Item item : items) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }

    public boolean isFull() {
        return items.size() >= maxCapacity;
    }
}
