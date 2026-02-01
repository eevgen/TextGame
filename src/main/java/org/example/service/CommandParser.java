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
