package org.example.command;

import org.example.model.Item;
import org.example.model.Player;

/**
 * Picks up item from current location and adds to backpack.
 * Usage: vezmi [item] (e.g., vezmi mec)
 * @author Text Game Team
 */
public class PickupCommand implements Command {

    private Player player;
    private String itemId;

    /**
     * Creates pickup command.
     * @param player the player
     * @param itemId item id to pick up
     */
    public PickupCommand(Player player, String itemId) {
        this.player = player;
        this.itemId = itemId;
    }

    /**
     * Executes item pickup if valid and backpack has space.
     */
    @Override
    public void execute() {
        if (itemId == null || itemId.trim().isEmpty()) {
            System.out.println("Co chceš sebrat? Použij: vezmi [předmět]");
            return;
        }

        Item item = player.getCurrentLocation().findItem(itemId.trim());

        if (item == null) {
            System.out.println("Předmět '" + itemId + "' se zde nenachází.");
            return;
        }

        if (!item.isPortable()) {
            System.out.println("Předmět '" + item.getName() + "' nelze sebrat.");
            return;
        }

        if (player.getBackpack().isFull()) {
            System.out.println("Batoh je plný! Nejprve něco polož.");
            return;
        }

        player.getBackpack().addItem(item);
        player.getCurrentLocation().removeItem(item);

        System.out.println("Sebral jsi: " + item.getName());
    }

    @Override
    public void undo() {

    }
}
