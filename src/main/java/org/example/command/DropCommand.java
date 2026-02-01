package org.example.command;

import org.example.model.Item;
import org.example.model.Player;

public class DropCommand implements Command {

    private Player hrac;
    private String predmetId;

    public DropCommand(Player hrac, String predmetId) {
        this.hrac = hrac;
        this.predmetId = predmetId;
    }

    @Override
    public void execute() {
        // check if predmetId is provided
        if (predmetId == null || predmetId.isEmpty()) {
            System.out.println("Co chceš položit? Použij: poloz [předmět]");
            return;
        }

        // find predmet in backpack
        Item predmet = hrac.getBatoh().findItem(predmetId);

        if (predmet == null) {
            System.out.println("Předmět '" + predmetId + "' nemáš v batohu.");
            return;
        }

        // remove item from backpack and add to current location
        hrac.getBatoh().odebratPredmet(predmet);
        hrac.getAktualniLokace().pridatPredmet(predmet);

        System.out.println("Položil jsi: " + predmet.getNazev());
    }

    @Override
    public void undo() {
    }
}
