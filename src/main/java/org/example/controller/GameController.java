package org.example.controller;

import org.example.command.Command;
import org.example.model.Location;
import org.example.model.Player;
import org.example.service.CommandFactory;
import org.example.service.CommandParser;
import org.example.service.ItemService;

import java.util.Scanner;

public class GameController {

    private Player hrac;
    private CommandParser parser;
    private boolean hraProbiha;

    private final static Scanner scanner = new Scanner(System.in);

    public GameController(CommandParser parser) {
        this.parser = parser;
        this.hraProbiha = true;
        hrac = parser.getPlayer();
    }

    public void start() {
        System.out.println("=== Tajemství Království víl ===");
        System.out.println("Napiš 'pomoc' pro seznam příkazů.\n");

        zobrazitLokaci(hrac.getAktualniLokace());

        while (hraProbiha) {
            System.out.print("> ");
            String userInput = scanner.nextLine();

            if (userInput.equals("konec")) {
                hraProbiha = false;
                System.out.println("Hra ukončena. Nashledanou!");
                break;
            }

            zpracovatPrikaz(userInput);
        }
    }

    public void zpracovatPrikaz(String vstup) {
        Command command = parser.parsovat(vstup);
        if (command != null) {
            command.execute();

            // control game win condition
            if (zkontrolovatVyhru()) {
                System.out.println("\n╔══════════════════════════════════╗");
                System.out.println("║  GRATULUJEME! VYHRÁL JSI HRU!    ║");
                System.out.println("╚══════════════════════════════════╝");
                System.out.println("\nDostal ses do Trůnního sálu a splnil jsi své přání!");
                System.out.println("Jack může konečně vrátit své rodiče zpět.\n");
                hraProbiha = false;
            }
        }
    }

    public static void zobrazitLokaci(Location lokace) {
        System.out.println("\n══════════════════════════════════");
        System.out.println("Lokace: " + lokace.getNazev());
        System.out.println("──────────────────────────────────");
        System.out.println(lokace.getPopis());

        // show items in location
        if (!lokace.getPredmety().isEmpty()) {
            System.out.print("Předměty: ");
            for (int i = 0; i < lokace.getPredmety().size(); i++) {
                System.out.print(lokace.getPredmety().get(i).getNazev());
                if (i < lokace.getPredmety().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        // show npcs in location
        if (!lokace.getPostavy().isEmpty()) {
            System.out.print("Postavy: ");
            for (int i = 0; i < lokace.getPostavy().size(); i++) {
                System.out.print(lokace.getPostavy().get(i).getJmeno());
                if (i < lokace.getPostavy().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        lokace.showExits();
        System.out.println("══════════════════════════════════\n");
    }

    public boolean zkontrolovatVyhru() {
        // player wins if they reach the throne room location
        if (hrac.getAktualniLokace().getNazev().equals("Trůnní sál")) {
            return true;
        }
        return false;
    }

    public void ukoncitHru() {

    }
}
