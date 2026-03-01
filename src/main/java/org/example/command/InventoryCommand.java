package org.example.command;

import org.example.model.Item;
import org.example.model.Player;

/**
 * Displays all items in player backpack.
 * Usage: batoh
 * @author Text Game Team
 */
public class InventoryCommand implements Command {

    private Player player;

    /**
     * Creates inventory command.
     * @param player the player
     */
    public InventoryCommand(Player player) {
        this.player = player;
    }

    /**
     * Executes showing all items in backpack.
     */
    @Override
    public void execute() {
        System.out.println("\n═══════ BATOH ═══════");

        if (player.getBackpack().getItems().isEmpty()) {
            System.out.println("Batoh je prázdný.");
        } else {
            System.out.println("Předměty v batohu:");
            for (Item item : player.getBackpack().getItems()) {
                System.out.println("  - " + item.getName() + " - " + item.getDescription());
            }
        }

        System.out.println("═════════════════════\n");
    }

    @Override
    public void undo() {
    }
}
