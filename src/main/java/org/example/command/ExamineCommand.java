package org.example.command;

import org.example.controller.GameController;
import org.example.model.Item;
import org.example.model.NPC;
import org.example.model.Player;

/**
 * Examines location, item, or NPC. Shows full description and details.
 * Usage: prozkoumej [target] (e.g., prozkoumej mec, prozkoumej babicka)
 * If no target specified, shows current location.
 * @author Yevhen Kalenichenko
 */
public class ExamineCommand implements Command {

    private Player player;
    private String target;

    /**
     * Creates examine command.
     * @param player the player
     * @param target item, NPC, or location to examine (null = current location)
     */
    public ExamineCommand(Player player, String target) {
        this.player = player;
        this.target = target;
    }

    /**
     * Executes examining target and displays description.
     */
    @Override
    public void execute() {
        if (target == null || target.trim().isEmpty()) {
            GameController.displayLocation(player.getCurrentLocation());
            return;
        }

        String trimmedTarget = target.trim();

        Item itemInLocation = player.getCurrentLocation().findItem(trimmedTarget);
        if (itemInLocation != null) {
            System.out.println("\n" + itemInLocation.getName() + ": " + itemInLocation.getDescription());
            return;
        }

        Item itemInBackpack = player.getBackpack().findItem(trimmedTarget);
        if (itemInBackpack != null) {
            System.out.println("\n" + itemInBackpack.getName() + ": " + itemInBackpack.getDescription());
            return;
        }

        NPC npc = player.getCurrentLocation().findCharacter(trimmedTarget);
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
