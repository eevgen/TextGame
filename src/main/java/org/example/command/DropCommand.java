package org.example.command;

import org.example.model.Item;
import org.example.model.Player;

/**
 * Drops item from backpack to current location.
 * Usage: poloz [item] (e.g., poloz kniha, poloz mapa)
 * @author Yevhen Kalenichenko
 */
public class DropCommand implements Command {

    private Player player;
    private String itemId;

    /**
     * Creates drop command.
     * @param player the player
     * @param itemId item id to drop
     */
    public DropCommand(Player player, String itemId) {
        this.player = player;
        this.itemId = itemId;
    }

    /**
     * Executes dropping item from backpack to location.
     */
    @Override
    public void execute() {
        if (itemId == null || itemId.trim().isEmpty()) {
            System.out.println("Co chceš položit? Použij: poloz [předmět]");
            return;
        }

        Item item = player.getBackpack().findItem(itemId.trim());

        if (item == null) {
            System.out.println("Předmět '" + itemId + "' nemáš v batohu.");
            return;
        }

        player.getBackpack().removeItem(item);
        player.getCurrentLocation().addItem(item);

        System.out.println("Položil jsi: " + item.getName());
    }

    @Override
    public void undo() {
    }
}
