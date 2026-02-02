package org.example.command;

import org.example.model.Item;
import org.example.model.Player;

public class PickupCommand implements Command {

    private Player player;
    private String itemId;

    public PickupCommand(Player player, String itemId) {
        this.player = player;
        this.itemId = itemId;
    }

    @Override
    public void execute() {
        // check if itemId is provided
        if (itemId == null || itemId.isEmpty()) {
            System.out.println("Co chceš sebrat? Použij: vezmi [předmět]");
            return;
        }

        // find item in current location
        Item item = player.getCurrentLocation().findItem(itemId);

        if (item == null) {
            System.out.println("Předmět '" + itemId + "' se zde nenachází.");
            return;
        }

        // check if item is portable
        if (!item.isPortable()) {
            System.out.println("Předmět '" + item.getName() + "' nelze sebrat.");
            return;
        }

        // check if backpack is full
        if (player.getBackpack().isFull()) {
            System.out.println("Batoh je plný! Nejprve něco polož.");
            return;
        }

        // add item to backpack and remove from location
        player.getBackpack().addItem(item);
        player.getCurrentLocation().removeItem(item);

        System.out.println("Sebral jsi: " + item.getName());
    }

    @Override
    public void undo() {

    }
}
