package org.example.controller;

import org.example.model.Location;
import org.example.model.Player;
import org.example.service.CommandParser;

public class GameController {

    private Player hrac;
    private Location startovniLokace;
    private CommandController commandController;
    private CommandParser parser;
    private boolean hraProbiha;

    public GameController(Player hrac, Location startovniLokace) {
        this.hrac = hrac;
        this.startovniLokace = startovniLokace;
        this.commandController = new CommandController();
        this.parser = new CommandParser();
        this.hraProbiha = false;
    }

    public void start() {

    }

    public void zpracovatPrikaz(String vstup) {

    }

    public boolean zkontrolovatVyhru() {
        return false;
    }

    public void ukoncitHru() {

    }
}
