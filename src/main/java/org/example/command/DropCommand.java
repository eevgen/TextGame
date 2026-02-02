package org.example.command;

import org.example.model.Item;
import org.example.model.Player;

public class DropCommand implements Command {

    private Player player;
    private String itemId;

    public DropCommand(Player player, String itemId) {
        this.player = player;
        this.itemId = itemId;
    }

    @Override
    public void execute() {
        // check if itemId is provided
        if (itemId == null || itemId.isEmpty()) {
            System.out.println("Co chceš položit? Použij: poloz [předmět]");
            return;
        }

        // find item in backpack
        Item item = player.getBackpack().findItem(itemId);

        if (item == null) {
            System.out.println("Předmět '" + itemId + "' nemáš v batohu.");
            return;
        }

        // remove item from backpack and add to current location
        player.getBackpack().removeItem(item);
        player.getCurrentLocation().addItem(item);

        System.out.println("Položil jsi: " + item.getName());
    }

    @Override
    public void undo() {
    }
}
