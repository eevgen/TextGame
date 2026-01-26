package org.example.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.controller.GameController;
import org.example.model.Location;
import org.example.model.Player;
@Getter
@Setter
@AllArgsConstructor
public class GoCommand implements Command {

    private Player player;
    private String direction;

    @Override
    public void execute() {

        GameController.newPage();

        Location currentLocation = player.getAktualniLokace();
        System.out.println("You are now in " + currentLocation.getName() + ".");
        GameController.zobrazitLokaci(currentLocation);

        Location nextLocation = currentLocation.getExit(direction);

        if(nextLocation == null) {
            System.out.println("There is no exit in that direction.");
            return;
        }

        if(nextLocation.isLocked()) {
            System.out.println("The way to " + nextLocation.getName() + " is locked." +
                    "\s You need " + nextLocation.getUnlockItemsIdsText()  + "to pass.");
            return;
        }

        player.setAktualniLokace(nextLocation);
        System.out.println("You moved to " + nextLocation.getName() + ".");

    }

    @Override
    public void undo() {
    }
}
