package org.example.command;

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
        if (cil == null || cil.isEmpty()) {
            System.out.println("\n" + hrac.getAktualniLokace().getPopis());
            return;
        }

        // find item in current location
        Item predmetVLokaci = hrac.getAktualniLokace().findItem(cil);
        if (predmetVLokaci != null) {
            System.out.println("\n" + predmetVLokaci.getNazev() + ": " + predmetVLokaci.getPopis());
            return;
        }

        // find item in backpack
        Item predmetVBatohu = hrac.getBatoh().findItem(cil);
        if (predmetVBatohu != null) {
            System.out.println("\n" + predmetVBatohu.getNazev() + ": " + predmetVBatohu.getPopis());
            return;
        }

        // find NPC in current location
        NPC postava = hrac.getAktualniLokace().findPostava(cil);
        if (postava != null) {
            System.out.println("\n" + postava.getJmeno() + " - " + postava.getDialog());
            return;
        }

        System.out.println("Nenašel jsi nic takového.");
    }

    @Override
    public void undo() {
    }
}
