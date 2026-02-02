package org.example.command;

import org.example.model.Item;
import org.example.model.Player;

public class PickupCommand implements Command {

    private Player hrac;
    private String predmetId;

    public PickupCommand(Player hrac, String predmetId) {
        this.hrac = hrac;
        this.predmetId = predmetId;
    }

    @Override
    public void execute() {
        // chek if predmetId is provided
        if (predmetId == null || predmetId.isEmpty()) {
            System.out.println("Co chceš sebrat? Použij: vezmi [předmět]");
            return;
        }

        // find predmet in current location
        Item predmet = hrac.getAktualniLokace().findItem(predmetId);

        if (predmet == null) {
            System.out.println("Předmět '" + predmetId + "' se zde nenachází.");
            return;
        }

        // check if item is transferable
        if (!predmet.isPrenositelny()) {
            System.out.println("Předmět '" + predmet.getNazev() + "' nelze sebrat.");
            return;
        }

        // check if backpack is full
        if (hrac.getBatoh().jePlny()) {
            System.out.println("Batoh je plný! Nejprve něco polož.");
            return;
        }

        // add item to backpack and remove from location
        hrac.getBatoh().pridatPredmet(predmet);
        hrac.getAktualniLokace().odebratPredmet(predmet);

        System.out.println("Sebral jsi: " + predmet.getNazev());
    }

    @Override
    public void undo() {

    }
}
