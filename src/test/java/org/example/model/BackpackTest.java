package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackpackTest {

    private Backpack backpack;
    private Item sword;
    private Item map;

    @BeforeEach
    void setUp() {
        backpack = new Backpack(5);
        sword = new Item("mec", "Meč", "Ostrý meč", true, true);
        map = new Item("mapa", "Mapa", "Stará mapa", true, false);
    }

    @Test
    void testAddItemSuccess() {
        boolean result = backpack.addItem(sword);
        assertTrue(result, "Měl by přidat item do batohu");
        assertEquals(1, backpack.getItems().size(), "Batoh by měl obsahovat 1 item");
    }

    @Test
    void testBackpackFull() {
        Backpack smallBackpack = new Backpack(1);
        Item item1 = new Item("item1", "Item 1", "Test", true, true);
        Item item2 = new Item("item2", "Item 2", "Test", true, true);

        smallBackpack.addItem(item1);
        boolean result = smallBackpack.addItem(item2);

        assertFalse(result, "Měl by se nezdařit přidat item do plného batohu");
    }

    @Test
    void testRemoveItem() {
        backpack.addItem(sword);
        boolean result = backpack.removeItem(sword);

        assertTrue(result, "Měl by odstranit item z batohu");
        assertEquals(0, backpack.getItems().size(), "Batoh by měl být prázdný");
    }

    @Test
    void testFindItemInBackpack() {
        backpack.addItem(sword);
        Item found = backpack.findItem("mec");

        assertNotNull(found, "Měl by najít meč v batohu");
        assertEquals("Meč", found.getName(), "Měl by vrátit správný item");
    }

    @Test
    void testFindItemNotInBackpack() {
        Item found = backpack.findItem("neexistuje");

        assertNull(found, "Měl by vrátit null pro neexistující item");
    }

    @Test
    void testInvalidBackpackCapacity() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Backpack(0);
        }, "Měl by vyhodit výjimku pro kapacitu 0");
    }

    @Test
    void testMultipleItems() {
        backpack.addItem(sword);
        backpack.addItem(map);

        assertEquals(2, backpack.getItems().size(), "Batoh by měl obsahovat 2 itemy");
        assertTrue(backpack.hasItem("mec"), "Měl by obsahovat meč");
        assertTrue(backpack.hasItem("mapa"), "Měl by obsahovat mapu");
    }
}
