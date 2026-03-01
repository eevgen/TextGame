package org.example.command;

import org.example.model.Item;
import org.example.model.Location;
import org.example.model.Player;

/**
 * Uses item from backpack. Each item has specific effect.
 * Usage: pouzij [item] (e.g., pouzij klic, pouzij mec)
 * @author Text Game Team
 */
public class UseCommand implements Command {

    private Player player;
    private String itemId;

    /**
     * Creates use command.
     * @param player the player
     * @param itemId item id to use
     */
    public UseCommand(Player player, String itemId) {
        this.player = player;
        this.itemId = itemId;
    }

    /**
     * Executes item use if item exists in backpack and is usable.
     */
    @Override
    public void execute() {
        if (itemId == null || itemId.trim().isEmpty()) {
            System.out.println("Co chceš použít? Použij: pouzij [předmět]");
            return;
        }

        Item item = player.getBackpack().findItem(itemId.trim());

        if (item == null) {
            System.out.println("Předmět '" + itemId + "' nemáš v batohu.");
            return;
        }

        if (!item.isUsable()) {
            System.out.println("Předmět '" + item.getName() + "' nelze použít.");
            return;
        }

        switch (itemId.trim().toLowerCase()) {
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
        Location nextLocation = player.getCurrentLocation().getExit("jih");
        if (nextLocation != null && nextLocation.isLocked()) {
            nextLocation.unlock();
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
