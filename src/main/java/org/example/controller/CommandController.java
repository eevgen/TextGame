package org.example.controller;

import org.example.command.Command;

import java.util.Stack;

public class CommandController {

    private Stack<Command> historie;

    public CommandController() {
        this.historie = new Stack<>();
    }

    public void executeCommand(Command command) {
        command.execute();
        historie.push(command);
    }

    public void undo() {
        if (!historie.isEmpty()) {
            historie.pop().undo();
        }
    }

    public Stack<Command> getHistorie() {
        return historie;
    }
}
