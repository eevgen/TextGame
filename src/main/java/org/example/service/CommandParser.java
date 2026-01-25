package org.example.service;

import org.example.command.Command;
import org.example.model.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandParser {

    private CommandFactory factory;
    private Player player;

    public CommandParser(Player player) {
        this.factory = new CommandFactory(player);
        this.player = player;
    }

    public Command parsovat(String vstup) {

        if (vstup == null || vstup.trim().isEmpty()) {
            return null;
        }

        String[] words = rozdelitVstup(vstup);

        return factory.vytvorPrikaz(words[0],
                words.length > 1 ? words[1] : null);
    }

    public String[] rozdelitVstup(String vstup) {
        return vstup.trim().toLowerCase().split("\\s+");
    }
}
