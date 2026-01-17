package org.example.service;

import org.example.command.Command;

public class CommandParser {

    private CommandFactory factory;

    public CommandParser() {
        this.factory = new CommandFactory();
    }

    public Command parsovat(String vstup) {
        return null;
    }

    public String[] rozdelitVstup(String vstup) {
        return null;
    }
}
