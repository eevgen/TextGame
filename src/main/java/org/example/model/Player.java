package org.example.model;

/**
 * Game player - controlled by user, has health points.
 * @author Text Game Team
 */
public class Player extends Character {

    private int health;

    /**
     * Creates player with health points.
     * @param name player name
     * @param currentLocation starting location
     * @param backpack player's backpack
     * @param health starting health points
     */
    public Player(String name, Location currentLocation, Backpack backpack, int health) {
        super(name, currentLocation, backpack);
        this.health = health;
    }

    /**
     * Gets current health points.
     * @return health value
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets health points.
     * @param health new health value
     */
    public void setHealth(int health) {
        this.health = health;
    }
}
