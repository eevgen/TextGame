package org.example.command;

import org.example.model.Item;
import org.example.model.Player;

public class UseCommand implements Command {

    private Player player;
    private String itemId;

    public UseCommand(Player player, String itemId) {
        this.player = player;
        this.itemId = itemId;
    }

    @Override
    public void execute() {
        // check if itemId is provided
        if (itemId == null || itemId.isEmpty()) {
            System.out.println("Co chceš použít? Použij: pouzij [předmět]");
            return;
        }

        // find item in backpack
        Item item = player.getBackpack().findItem(itemId);

        if (item == null) {
            System.out.println("Předmět '" + itemId + "' nemáš v batohu.");
            return;
        }

        // check if item is usable
        if (!item.isUsable()) {
            System.out.println("Předmět '" + item.getName() + "' nelze použít.");
            return;
        }

        // use item based on its id
        switch (itemId.toLowerCase()) {
            case "klic":
                useKey();
                break;
            case "mec":
                useSword();
                break;
            case "mapa":
                useMap();
                break;
            default:
                System.out.println("Použil jsi " + item.getName() + ", ale nic se nestalo.");
                break;
        }
    }

    //use key to unlock golden gate
    private void useKey() {
        String locationName = player.getCurrentLocation().getName();
        if (locationName.equals("Zlatá brána")) {
            player.getCurrentLocation().unlock();
            System.out.println("Použil jsi zlatý klíč. Brána se s tichým zaskřípěním otevřela!");
        } else {
            System.out.println("Zde není co odemknout.");
        }
    }

    // use sword to scare away beasts
    private void useSword() {
        String locationName = player.getCurrentLocation().getName();
        if (locationName.equals("Doupě šelem")) {
            System.out.println("Vytrhl jsi meč a zahnal šelmy! Cesta je volná.");
        } else {
            System.out.println("Šelmy zde nejsou, meč teď nepotřebuješ.");
        }
    }

    // use map to show the path
    private void useMap() {
        System.out.println("\nProhlížíš mapu:");
        System.out.println("Cesta vede: Půda → Dům → Vesnice → Les → Tábor goblinů → Zlatá brána → Komnata harfy → Trůnní sál");
        System.out.println("Tip: Potřebuješ meč a klíč pro dokončení cesty.\n");
    }

    @Override
    public void undo() {
    }
}
