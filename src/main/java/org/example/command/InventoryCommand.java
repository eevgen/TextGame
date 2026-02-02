package org.example.command;

import org.example.model.Item;
import org.example.model.Player;

public class InventoryCommand implements Command {

    private Player player;

    public InventoryCommand(Player player) {
        this.player = player;
    }

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
