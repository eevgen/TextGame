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

        Location currentLocation = player.getCurrentLocation();
        Location nextLocation = currentLocation.getExit(direction);

        if(nextLocation == null) {
            System.out.println("There is no exit in that direction.");
            return;
        }

        player.setCurrentLocation(nextLocation);
        System.out.println("You moved to " + nextLocation.getName() + ".");

    }

    @Override
    public void undo() {
    }
}
