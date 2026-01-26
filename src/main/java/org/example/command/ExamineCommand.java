package org.example.command;

import org.example.model.Player;

public class ExamineCommand implements Command {

    private Player player;
    private String target;

    public ExamineCommand(Player player, String target) {
        this.player = player;
        this.target = target;
    }

    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }
}
