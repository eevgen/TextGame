package org.example.service;

import lombok.Getter;
import org.example.command.Command;
import org.example.model.Player;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Parses user input and creates Command objects.
 * Splits input into command name and parameter.
 * @author Text Game Team
 */
@Getter
public class CommandParser {

    private CommandFactory factory;
    private Player player;

    /**
     * Creates parser with command factory.
     * @param factory the command factory
     */
    public CommandParser(CommandFactory factory) {
        this.factory = factory;
        player = factory.getPlayer();
    }

    /**
     * Parses user input into Command object.
     * @param input user input string
     * @return Command or null if input is empty or command not found
     */
    public Command parse(String input) {

        if (input == null || input.trim().isEmpty()) {
            return null;
        }

        String[] words = splitInput(input);

        return factory.createCommand(words[0],
                words.length > 1 ? words[1] : null);
    }

    /**
     * Splits input into words and converts to lowercase.
     * @param input the input string
     * @return array of words
     */
    public String[] splitInput(String input) {
        return input.trim().toLowerCase().split("\\s+");
    }
}
