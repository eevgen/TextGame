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

        if (hrac.getBatoh().getPredmety().isEmpty()) {
            System.out.println("Batoh je prázdný.");
        } else {
            System.out.println("Předměty v batohu:");
            for (Item predmet : hrac.getBatoh().getPredmety()) {
                System.out.println("  - " + predmet.getNazev() + " - " + predmet.getPopis());
            }
        }

        System.out.println("═════════════════════\n");
    }

    @Override
    public void undo() {
    }
}
