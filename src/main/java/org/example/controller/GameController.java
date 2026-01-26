package org.example.controller;

import org.example.command.Command;
import org.example.model.Location;
import org.example.model.Player;
import org.example.service.CommandFactory;
import org.example.service.CommandParser;
import org.example.service.ItemService;

import java.util.Scanner;

public class GameController {

    private Player player;
    private CommandParser parser;
    private boolean gameRunning;

    private final static Scanner scanner = new Scanner(System.in);

    public GameController(CommandParser parser) {
        this.parser = parser;
        this.gameRunning = true;
        player = parser.getPlayer();
    }

    public void start() {
        System.out.println("=== Tajemství Království víl ===");
        System.out.println("Napiš 'pomoc' pro seznam příkazů.\n");

        displayLocation(player.getCurrentLocation());

        while (gameRunning) {
            System.out.print("> ");
            String userInput = scanner.nextLine();

            if (userInput.equals("konec")) {
                gameRunning = false;
                System.out.println("Hra ukončena. Nashledanou!");
                break;
            }

            processCommand(userInput);
        }
    }

    public void processCommand(String input) {
        Command command = parser.parse(input);
        if (command != null) {
            command.execute();
        }
    }

    public static void displayLocation(Location location) {
        System.out.println("\n══════════════════════════════════");
        System.out.println("Lokace: " + location.getName());
        System.out.println("──────────────────────────────────");
        System.out.println(location.getDescription());
        location.showExits();
        System.out.println("──────────────────────────────────");
        location.showItems();
        System.out.println("══════════════════════════════════\n");
    }

    public boolean checkWin() {
        return false;
    }

    public void endGame() {

    }
}
