package org.example.controller;

import org.example.command.Command;

import java.util.Stack;

public class CommandController {

    private Stack<Command> history;

    public CommandController() {
        this.history = new Stack<>();
    }

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undo() {
        if (!history.isEmpty()) {
            history.pop().undo();
        }
    }

    public Stack<Command> getHistory() {
        return history;
    }
}
