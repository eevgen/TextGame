package org.example.controller;

import org.example.model.Location;
import org.example.model.Player;
import org.example.service.CommandParser;

import java.util.Scanner;

public class GameController {

    private Player hrac;
    private Location startovniLokace;
    private CommandController commandController;
    private CommandParser parser;
    private boolean hraProbiha;

    private final static Scanner scanner = new Scanner(System.in);

    private Location currentLocation;

    public GameController(Player hrac, Location startovniLokace) {
        this.hrac = hrac;
        this.startovniLokace = startovniLokace;
        this.commandController = new CommandController();
        this.parser = new CommandParser(hrac);
        this.hraProbiha = false;
    }

    public void start() {

        String userInput = "";
        while (!userInput.equals("konec")) {
            hrac.getAktualniLokace().showExits();
            userInput = scanner.nextLine();
            zpracovatPrikaz(userInput);
        }

    }

    public void zpracovatPrikaz(String vstup) {
        parser.parsovat(vstup);
    }

    public boolean zkontrolovatVyhru() {
        return false;
    }

    public void ukoncitHru() {

    }
}
