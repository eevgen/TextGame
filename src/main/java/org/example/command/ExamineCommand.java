package org.example.command;

import org.example.controller.GameController;
import org.example.model.Item;
import org.example.model.NPC;
import org.example.model.Player;

public class ExamineCommand implements Command {

    private Player player;
    private String target;

    public ExamineCommand(Player player, String target) {
        this.player = player;
        this.target = target;
    }

    @Override
    public void execute() {
        // if no target is specified, describe the current location
        if (target == null || target.isEmpty()) {
            GameController.displayLocation(player.getCurrentLocation());
            return;
        }

        // find item in current location
        Item itemInLocation = player.getCurrentLocation().findItem(target);
        if (itemInLocation != null) {
            System.out.println("\n" + itemInLocation.getName() + ": " + itemInLocation.getDescription());
            return;
        }

        // find item in backpack
        Item itemInBackpack = player.getBackpack().findItem(target);
        if (itemInBackpack != null) {
            System.out.println("\n" + itemInBackpack.getName() + ": " + itemInBackpack.getDescription());
            return;
        }

        // find NPC in current location
        NPC npc = player.getCurrentLocation().findCharacter(target);
        if (npc != null) {
            System.out.println("\n" + npc.getName() + " - " + npc.getDialog());
            return;
        }

        System.out.println("Nenašel jsi nic takového.");
    }

    @Override
    public void undo() {
    }
}
