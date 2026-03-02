package org.example.command;

import org.example.model.Item;
import org.example.model.NPC;
import org.example.model.Player;

/**
 * Talks to NPC and receives dialog. May receive reward item.
 * Usage: mluv [npc] (e.g., mluv babicka, mluv vila)
 * @author Yevhen Kalenichenko
 */
public class TalkCommand implements Command {

    private Player player;
    private String character;

    /**
     * Creates talk command.
     * @param player the player
     * @param character NPC name to talk to
     */
    public TalkCommand(Player player, String character) {
        this.player = player;
        this.character = character;
    }

    /**
     * Executes talking to NPC if exists in location.
     * Displays dialog and gives reward if available.
     */
    @Override
    public void execute() {
        if (character == null || character.trim().isEmpty()) {
            System.out.println("S kým chceš mluvit? Použij: mluv [postava]");
            return;
        }

        NPC npc = player.getCurrentLocation().findCharacter(character.trim());

        if (npc == null) {
            System.out.println("Postava '" + character + "' se zde nenachází.");
            return;
        }

        // display dialog
        String dialog = npc.speak();
        System.out.println("\n" + npc.getName() + ": \"" + dialog + "\"\n");

        // give reward if available and not already given
        if (!npc.hasSpoken()) {
            Item reward = npc.giveReward();
            if (reward != null) {
                if (player.getBackpack().addItem(reward)) {
                    System.out.println(npc.getName() + " ti dal: " + reward.getName());
                } else {
                    System.out.println("Batoh je plný, nemůžeš přijmout odměnu!");
                }
            }
        }
    }

    @Override
    public void undo() {
    }
}
