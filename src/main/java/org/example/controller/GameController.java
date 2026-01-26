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
        }
    }

    public static void zobrazitLokaci(Location lokace) {
        System.out.println("\n══════════════════════════════════");
        System.out.println("Lokace: " + lokace.getNazev());
        System.out.println("──────────────────────────────────");
        System.out.println(lokace.getPopis());
        lokace.showExits();
        System.out.println("══════════════════════════════════\n");
    }

    public boolean zkontrolovatVyhru() {
        return false;
    }

    public void ukoncitHru() {

    }
}
