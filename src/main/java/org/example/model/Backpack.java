package org.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Container for carrying items. Has limited capacity.
 * @author Text Game Team
 */
public class Backpack {

    private List<Item> items;
    private int maxCapacity;

    /**
     * Creates backpack with given capacity.
     * @param maxCapacity number of items that can be carried
     * @throws IllegalArgumentException if capacity is 0 or negative
     */
    public Backpack(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Backpack capacity must be greater than 0.");
        }
        this.items = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    /**
     * Adds item to backpack if not full.
     * @param item the item to add
     * @return true if item was added, false if backpack is full
     */
    public boolean addItem(Item item) {
        if (!isFull()) {
            items.add(item);
            return true;
        }
        return false;
    }

    /**
     * Removes item from backpack.
     * @param item the item to remove
     * @return true if item was removed
     */
    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    /**
     * Gets all items in backpack.
     * @return list of items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Checks if backpack contains item by id.
     * @param name the item id
     * @return true if item exists in backpack
     */
    public boolean hasItem(String name) {
        return findItem(name) != null;
    }

    /**
     * Finds item by id (case-insensitive).
     * @param id the item id
     * @return item or null if not found
     */
    public Item findItem(String id) {
        for (Item item : items) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Checks if backpack is at maximum capacity.
     * @return true if full
     */
    public boolean isFull() {
        return items.size() >= maxCapacity;
    }
}
