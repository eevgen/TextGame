package org.example.command;

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
    }

    @Override
    public void undo() {
    }
}
