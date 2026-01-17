package org.example.command;

import org.example.model.Player;

public class GoCommand implements Command {

    private Player hrac;
    private String smer;

    public GoCommand(Player hrac, String smer) {
        this.hrac = hrac;
        this.smer = smer;
    }

    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }
}
