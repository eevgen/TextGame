package org.example.service;

import org.example.interfaces.Command;

import java.util.Stack;

public class CommandController {

    private static final Stack<Command> history = new Stack<>();


    public void executeCommand(Command command) {
        command.execute();
        history.add(command);
    }

    public void undo() {
        if(!history.isEmpty()) {
            history.pop().undo();
        }
    }



}
