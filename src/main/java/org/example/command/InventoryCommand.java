package org.example.command;

import org.example.model.Player;

public class InventoryCommand implements Command {

    private Player hrac;

    public InventoryCommand(Player hrac) {
        this.hrac = hrac;
    }

    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }
}
