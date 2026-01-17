package org.example.command;

import org.example.model.Player;

public class ExamineCommand implements Command {

    private Player hrac;
    private String cil;

    public ExamineCommand(Player hrac, String cil) {
        this.hrac = hrac;
        this.cil = cil;
    }

    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }
}
