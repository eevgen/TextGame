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

        boolean lastCommandWasGo = false;

        while (gameRunning) {
            if (lastCommandWasGo) {
                displayLocation(player.getCurrentLocation());
            }

            System.out.print("> ");
            String userInput = scanner.nextLine();

            lastCommandWasGo = userInput.startsWith("jdi ");

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

            // control game win condition
            if (checkWinCondition()) {
                System.out.println("\n╔══════════════════════════════════╗");
                System.out.println("║  GRATULUJEME! VYHRÁL JSI HRU!    ║");
                System.out.println("╚══════════════════════════════════╝");
                System.out.println("\nDostal ses do Trůnního sálu a splnil jsi své přání!");
                System.out.println("Jack může konečně vrátit své rodiče zpět.\n");
                gameRunning = false;
            }
        }
    }

    public static void displayLocation(Location location) {
        System.out.println("\n══════════════════════════════════");
        System.out.println("Lokace: " + location.getName());
        System.out.println("──────────────────────────────────");
        System.out.println(location.getDescription());

        // show items in location
        if (!location.getItems().isEmpty()) {
            System.out.print("Předměty: ");
            for (int i = 0; i < location.getItems().size(); i++) {
                System.out.print(location.getItems().get(i).getName());
                if (i < location.getItems().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        // show npcs in location
        if (!location.getCharacters().isEmpty()) {
            System.out.print("Postavy: ");
            for (int i = 0; i < location.getCharacters().size(); i++) {
                System.out.print(location.getCharacters().get(i).getName());
                if (i < location.getCharacters().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        location.showExits();
        System.out.println("══════════════════════════════════\n");
    }

    public boolean checkWinCondition() {
        // player wins if they reach the throne room location
        if (player.getCurrentLocation().getName().equals("Trůnní sál")) {
            return true;
        }
        return false;
    }

    public void endGame() {

    }
}
