package org.example.command;

import org.example.model.Item;
import org.example.model.NPC;
import org.example.model.Player;

public class TalkCommand implements Command {

    private Player player;
    private String character;

    public TalkCommand(Player player, String character) {
        this.player = player;
        this.character = character;
    }

    @Override
    public void execute() {
        // check if character to talk to is specified
        if (character == null || character.isEmpty()) {
            System.out.println("S kým chceš mluvit? Použij: mluv [postava]");
            return;
        }

        // find NPC in current location
        NPC npc = player.getCurrentLocation().findCharacter(character);

        if (npc == null) {
            System.out.println("Postava '" + character + "' se zde nenachází.");
            return;
        }

        // display dialog
        String dialog = npc.speak();
        System.out.println("\n" + npc.getName() + ": \"" + dialog + "\"\n");

        // give reward if available and not already given
        if (npc.giveReward() != null && !npc.hasSpoken()) {
            Item reward = npc.giveReward();
            if (player.getBackpack().addItem(reward)) {
                System.out.println(npc.getName() + " ti dal: " + reward.getName());
            } else {
                System.out.println("Batoh je plný, nemůžeš přijmout odměnu!");
            }
        }
    }

    @Override
    public void undo() {
    }
}
