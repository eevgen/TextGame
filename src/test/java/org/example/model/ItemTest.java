package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testCreatePortableItem() {
        Item sword = new Item("mec", "Meč", "Ostrý meč", true, true);

        assertEquals("mec", sword.getId(), "ID by mělo být 'mec'");
        assertEquals("Meč", sword.getName(), "Jméno by mělo být 'Meč'");
        assertTrue(sword.isPortable(), "Meč by měl být přenosný");
        assertTrue(sword.isUsable(), "Meč by měl být použitelný");
    }

    @Test
    void testCreateNonPortableItem() {
        Item socha = new Item("socha", "Socha", "Těžká socha", false, false);

        assertFalse(socha.isPortable(), "Socha by neměla být přenosná");
        assertFalse(socha.isUsable(), "Socha by neměla být použitelná");
    }

    @Test
    void testItemProperties() {
        Item map = new Item("mapa", "Mapa", "Stará mapa do království", true, false);

        assertEquals("mapa", map.getId());
        assertEquals("Mapa", map.getName());
        assertEquals("Stará mapa do království", map.getDescription());
        assertTrue(map.isPortable(), "Mapa by měla být přenosná");
        assertFalse(map.isUsable(), "Mapa by neměla být přímo použitelná");
    }

    @Test
    void testItemEquality() {
        Item sword1 = new Item("mec", "Meč", "Ostrý meč", true, true);
        Item sword2 = new Item("mec", "Meč", "Ostrý meč", true, true);

        assertEquals(sword1.getId(), sword2.getId(), "Itemy se stejným ID by měly být stejné");
    }
}
