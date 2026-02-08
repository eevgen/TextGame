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
            System.out.println("Tímto směrem se nelze jít.");
            return;
        }

        player.setCurrentLocation(nextLocation);
        GameController.displayLocation(nextLocation);

    }

    @Override
    public void undo() {
    }
}
