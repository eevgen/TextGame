package org.example.command;

import org.example.model.NPC;
import org.example.model.Player;

public class TalkCommand implements Command {

    private Player hrac;
    private String postava;

    public TalkCommand(Player hrac, String postava) {
        this.hrac = hrac;
        this.postava = postava;
    }

    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }
}
