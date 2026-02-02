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
        if (postava == null || postava.isEmpty()) {
            System.out.println("S kým chceš mluvit? Použij: mluv [postava]");
            return;
        }

        // find NPC in current location
        NPC npc = hrac.getAktualniLokace().findPostava(postava);

        if (npc == null) {
            System.out.println("Postava '" + postava + "' se zde nenachází.");
            return;
        }

        // display dialog
        String dialog = npc.promluvitSi();
        System.out.println("\n" + npc.getJmeno() + ": \"" + dialog + "\"\n");

        // give reward if available and not already given
        if (npc.datOdmenu() != null && !npc.bylPromluveno()) {
            Item odmena = npc.datOdmenu();
            if (hrac.getBatoh().pridatPredmet(odmena)) {
                System.out.println(npc.getJmeno() + " ti dal: " + odmena.getNazev());
            } else {
                System.out.println("Batoh je plný, nemůžeš přijmout odměnu!");
            }
        }
    }

    @Override
    public void undo() {
    }
}
