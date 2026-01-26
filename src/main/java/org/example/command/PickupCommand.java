package org.example.command;

import org.example.model.Item;
import org.example.model.Player;

public class PickupCommand implements Command {

    private Player player;
    private Item item;

    public PickupCommand(Player player, Item item) {
        this.player = player;
        this.item = item;
    }

    @Override
    public void execute() {
    }

    @Override
    public void undo() {

    }
}
