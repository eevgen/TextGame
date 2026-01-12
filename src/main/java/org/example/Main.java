package org.example;

import org.example.interfaces.Command;
import org.example.model.Backpack;
import org.example.model.Character;
import org.example.model.Item;
import org.example.model.Location;
import org.example.model.commands.PickupItemCommand;
import org.example.service.CommandController;
import org.example.service.LocationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final CommandController controller = new CommandController();

    public static void main(String[] args) {

        Character character = new Character(new Backpack());
        Item redGem = new Item("Red gem", "");
        Item blueGem = new Item("Blue gem", "");
        Location location = new Location("Cave",
                new ArrayList<>(List.of(redGem, blueGem)));

        String enteredPhrase;
        System.out.print("There are two items on the flore: " +
                LocationService.getAllItemsString(location));
        System.out.println();
        do {
            enteredPhrase = scanner.nextLine();
            switch (enteredPhrase) {
                case "pick up red gem":
                    Command pickUpRedGemCommand = new PickupItemCommand(redGem, character, location);
                    controller.executeCommand(pickUpRedGemCommand);
                    break;
                case "pick up blue gem":
                    Command pickUpBlueGemCommand = new PickupItemCommand(blueGem, character, location);
                    controller.executeCommand(pickUpBlueGemCommand);
                    break;
                case "undo":
                    controller.undo();
                    break;
            }
        } while(!enteredPhrase.equals("exit"));

    }
}