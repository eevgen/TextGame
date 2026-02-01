package org.example.command;

import org.example.model.Item;
import org.example.model.Player;

public class UseCommand implements Command {

    private Player hrac;
    private String predmetId;

    public UseCommand(Player hrac, String predmetId) {
        this.hrac = hrac;
        this.predmetId = predmetId;
    }

    @Override
    public void execute() {
        // check if predmetId is provided
        if (predmetId == null || predmetId.isEmpty()) {
            System.out.println("Co chceš použít? Použij: pouzij [předmět]");
            return;
        }

        // find item in backpack
        Item predmet = hrac.getBatoh().findItem(predmetId);

        if (predmet == null) {
            System.out.println("Předmět '" + predmetId + "' nemáš v batohu.");
            return;
        }

        // check if item is usable
        if (!predmet.isPouzitelny()) {
            System.out.println("Předmět '" + predmet.getNazev() + "' nelze použít.");
            return;
        }

        // use item based on its id
        switch (predmetId.toLowerCase()) {
            case "klic":
                useKlic();
                break;
            case "mec":
                useMec();
                break;
            case "mapa":
                useMapa();
                break;
            default:
                System.out.println("Použil jsi " + predmet.getNazev() + ", ale nic se nestalo.");
                break;
        }
    }

    //use key to unlock golden gate
    private void useKlic() {
        String lokaceId = hrac.getAktualniLokace().getNazev();
        if (lokaceId.equals("Zlatá brána")) {
            hrac.getAktualniLokace().odemknout();
            System.out.println("Použil jsi zlatý klíč. Brána se s tichým zaskřípěním otevřela!");
        } else {
            System.out.println("Zde není co odemknout.");
        }
    }

    // use sword to scare away beasts
    private void useMec() {
        String lokaceId = hrac.getAktualniLokace().getNazev();
        if (lokaceId.equals("Doupě šelem")) {
            System.out.println("Vytrhl jsi meč a zahnal šelmy! Cesta je volná.");
        } else {
            System.out.println("Šelmy zde nejsou, meč teď nepotřebuješ.");
        }
    }

    // use map to show the path
    private void useMapa() {
        System.out.println("\nProhlížíš mapu:");
        System.out.println("Cesta vede: Půda → Dům → Vesnice → Les → Tábor goblinů → Zlatá brána → Komnata harfy → Trůnní sál");
        System.out.println("Tip: Potřebuješ meč a klíč pro dokončení cesty.\n");
    }

    @Override
    public void undo() {
    }
}
