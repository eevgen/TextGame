package org.example.command;

import org.example.model.Item;
import org.example.model.Player;

public class DropCommand implements Command {

    private Player hrac;
    private Item predmet;

    public DropCommand(Player hrac, Item predmet) {
        this.hrac = hrac;
        this.predmet = predmet;
    }

    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }
}
