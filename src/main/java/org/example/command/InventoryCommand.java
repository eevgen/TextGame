package org.example.command;

import org.example.model.Player;

public class InventoryCommand implements Command {

    private Player player;

    public InventoryCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }
}
