package org.example.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.controller.GameController;
import org.example.model.Location;
import org.example.model.Player;

/**
 * Moves player in specified direction if exit exists and not locked.
 * Usage: jdi [direction] (e.g., jdi north, jdi sever)
 * @author Yevhen Kalenichenko
 */
@Getter
@Setter
@AllArgsConstructor
public class GoCommand implements Command {

    private Player player;
    private String direction;

    /**
     * Executes movement in given direction.
     */
    @Override
    public void execute() {

        if (direction == null || direction.trim().isEmpty()) {
            System.out.println("Kterým směrem chceš jít? Použij: jdi [směr]");
            return;
        }

        Location currentLocation = player.getCurrentLocation();
        Location nextLocation = currentLocation.getExit(direction);

        if(nextLocation == null) {
            System.out.println("Tímto směrem se nelze jít.");
            return;
        }

        if(nextLocation.isLocked()) {
            System.out.println("Tímto směrem se nelze jít. Cesta je zamčená!");
            return;
        }

        player.setCurrentLocation(nextLocation);
        GameController.displayLocation(nextLocation);

    }

    @Override
    public void undo() {
    }
}
