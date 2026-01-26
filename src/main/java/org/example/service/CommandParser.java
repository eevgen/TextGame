package org.example.service;

import lombok.Getter;
import org.example.command.Command;
import org.example.model.Player;

import java.util.ArrayList;
import java.util.Arrays;

@Getter
public class CommandParser {

    private CommandFactory factory;
    private Player player;

    public CommandParser(CommandFactory factory) {
        this.factory = factory;
        player = factory.getPlayer();
    }

    public Command parse(String input) {

        if (input == null || input.trim().isEmpty()) {
            return null;
        }

        String[] words = divideInput(input);

        return factory.makeCommand(words[0],
                words.length > 1 ? words[1] : null);
    }

    public String[] divideInput(String input) {
        return input.trim().toLowerCase().split("\\s+");
    }
}
