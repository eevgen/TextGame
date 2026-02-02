package org.example.service;

import lombok.Getter;
import org.example.command.*;
import org.example.model.Item;
import org.example.model.Player;

import java.util.List;

@Getter
public class CommandFactory {

    private Player player;
    private ItemService itemService;

    public CommandFactory(Player player, ItemService itemService) {
        this.itemService = itemService;
        this.player = player;
    }

    public Command vytvorPrikaz(String nazev, String parametr) {

        if(nazev == null
        ) {
            return null;
        }

        return switch (nazev) {
            case "jdi" -> new GoCommand(player, parametr);
            case "vezmi" -> new PickupCommand(player, parametr);
            case "poloz" -> new DropCommand(player, parametr);
            case "batoh" -> new InventoryCommand(player);
            case "prozkoumej" -> new ExamineCommand(player, parametr);
            case "mluv" -> new TalkCommand(player, parametr);
            case "pouzij" -> new UseCommand(player, parametr);
            case "pomoc" -> new HelpCommand();
            case "konec" -> new EndCommand();
            default -> {
                System.out.println("Neznámý příkaz: " + nazev);
                yield null;
            }
        };

    }
}
