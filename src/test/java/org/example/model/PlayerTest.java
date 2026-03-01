package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;
    private Location startLocation;
    private Location nextLocation;

    @BeforeEach
    void setUp() {
        startLocation = new Location("Půda", "Stará zaprášená půda");
        nextLocation = new Location("Dům", "Starý dům");
        player = new Player("Jack", startLocation, new Backpack(10), 100);
    }

    @Test
    void testPlayerCreation() {
        assertEquals("Jack", player.getName(), "Jméno hráče by mělo být 'Jack'");
        assertEquals(startLocation, player.getCurrentLocation(), "Počáteční lokace by měla být 'Půda'");
        assertEquals(100, player.getHealth(), "Zdraví by mělo být 100");
    }

    @Test
    void testChangeLocation() {
        player.setCurrentLocation(nextLocation);

        assertEquals(nextLocation, player.getCurrentLocation(), "Lokace by měla být změněna na 'Dům'");
        assertNotEquals(startLocation, player.getCurrentLocation(), "Lokace by neměla být 'Půda'");
    }

    @Test
    void testPlayerBackpack() {
        Item sword = new Item("mec", "Meč", "Ostrý meč", true, true);
        player.getBackpack().addItem(sword);

        assertTrue(player.getBackpack().hasItem("mec"), "Hráč by měl mít meč v batohu");
    }

    @Test
    void testPlayerMultipleLocations() {
        Location location1 = new Location("Vesnice", "Malá vesnice");
        Location location2 = new Location("Les", "Temný les");
        Location location3 = new Location("Hrad", "Krásný hrad");

        player.setCurrentLocation(location1);
        assertEquals("Vesnice", player.getCurrentLocation().getName());

        player.setCurrentLocation(location2);
        assertEquals("Les", player.getCurrentLocation().getName());

        player.setCurrentLocation(location3);
        assertEquals("Hrad", player.getCurrentLocation().getName());
    }
}
