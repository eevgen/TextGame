package org.example.service;

import lombok.Getter;
import org.example.command.*;
import org.example.model.Item;
import org.example.model.Player;

import java.util.List;

/**
 * Factory for creating game commands from command names.
 * Maps command strings to Command objects using switch statement.
 * @author Text Game Team
 */
@Getter
public class CommandFactory {

    private Player player;
    private ItemService itemService;

    /**
     * Creates factory with player and item service.
     * @param player the game player
     * @param itemService service for item operations
     */
    public CommandFactory(Player player, ItemService itemService) {
        this.itemService = itemService;
        this.player = player;
    }

    /**
     * Creates command from command name and optional parameter.
     * @param name command name (e.g., "jdi", "vezmi")
     * @param parameter optional command parameter
     * @return Command object or null if command not found
     */
    public Command createCommand(String name, String parameter) {

        if(name == null) {
            return null;
        }

        return switch (name) {
            case "jdi" -> new GoCommand(player, parameter);
            case "vezmi" -> new PickupCommand(player, parameter);
            case "poloz" -> new DropCommand(player, parameter);
            case "batoh" -> new InventoryCommand(player);
            case "prozkoumej" -> new ExamineCommand(player, parameter);
            case "mluv" -> new TalkCommand(player, parameter);
            case "pouzij" -> new UseCommand(player, parameter);
            case "pomoc" -> new HelpCommand();
            case "napoveda" -> new HintCommand(player);
            case "konec" -> new EndCommand();
            default -> {
                System.out.println("Neznámý příkaz: " + name);
                yield null;
            }
        };

    }
}
