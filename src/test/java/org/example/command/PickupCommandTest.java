package org.example.command;

import org.example.model.Backpack;
import org.example.model.Item;
import org.example.model.Location;
import org.example.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PickupCommandTest {

    private Player player;
    private Location location;
    private Item sword;
    private Item unportableItem;

    @BeforeEach
    void setUp() {
        location = new Location("Lesní cesta", "Příjemná cesta lesem");
        player = new Player("Jack", location, new Backpack(5), 100);

        sword = new Item("mec", "Meč", "Ostrý meč", true, true);
        unportableItem = new Item("socha", "Socha", "Těžká socha", false, false);

        location.addItem(sword);
        location.addItem(unportableItem);
    }

    @Test
    void testPickupValidItem() {
        assertEquals(2, location.getItems().size(), "Lokace by měla mít 2 itemy na začátku");

        PickupCommand command = new PickupCommand(player, "mec");
        command.execute();

        assertTrue(player.getBackpack().hasItem("mec"), "Meč by měl být v batohu");
        assertEquals(1, location.getItems().size(), "Jedna položka by měla zůstat v lokaci");
    }

    @Test
    void testPickupNonPortableItem() {
        PickupCommand command = new PickupCommand(player, "socha");
        command.execute();

        assertFalse(player.getBackpack().hasItem("socha"), "Socha by neměla být v batohu");
        assertTrue(location.getItems().contains(unportableItem), "Socha by měla zůstat v lokaci");
    }

    @Test
    void testPickupItemNotInLocation() {
        PickupCommand command = new PickupCommand(player, "neexistuje");
        command.execute();

        assertEquals(2, location.getItems().size(), "Počet itemů by měl zůstat stejný");
    }

    @Test
    void testPickupWithoutParameter() {
        PickupCommand command = new PickupCommand(player, null);
        command.execute();

        assertEquals(0, player.getBackpack().getItems().size(), "Batoh by měl zůstat prázdný");
    }

    @Test
    void testPickupToFullBackpack() {
        Player playerSmallBackpack = new Player("Jack", location, new Backpack(1), 100);
        Item item1 = new Item("item1", "Item 1", "Test", true, true);
        Item item2 = new Item("item2", "Item 2", "Test", true, true);

        location.addItem(item1);
        location.addItem(item2);

        PickupCommand command1 = new PickupCommand(playerSmallBackpack, "item1");
        command1.execute();

        PickupCommand command2 = new PickupCommand(playerSmallBackpack, "item2");
        command2.execute();

        assertEquals(1, playerSmallBackpack.getBackpack().getItems().size(), "Batoh by měl obsahovat jen 1 item");
        assertTrue(location.getItems().contains(item2), "Druhý item by měl zůstat v lokaci");
    }
}
