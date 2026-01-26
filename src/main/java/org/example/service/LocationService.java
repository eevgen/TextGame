package org.example.service;

import com.google.gson.Gson;
import org.example.dto.LocationDTO;
import org.example.enums.Direction;
import org.example.model.Item;
import org.example.model.Location;
import org.example.model.NPC;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationService {

    private static  final String PATH_TO_WORLD_FILE_JSON = "docs/json/world.json";

    private Map<String, Location> allLocations = new HashMap<>();

    public void createWorld(ItemService itemService) {
        Reader reader = null;
        try {

            Gson gson = new Gson();

            reader = new FileReader(PATH_TO_WORLD_FILE_JSON);
            LocationDTO[] locationDTOS = gson.fromJson(reader, LocationDTO[].class);

            for (LocationDTO dto : locationDTOS) {
                Location location = new Location(dto.getName(), dto.getDescription());

                // set locked status and unlock items
                location.setLocked(dto.isLocked());
                if (dto.getUnlockItems() != null) {
                    location.setUnlockItems(dto.getUnlockItems());
                }

                // add items
                for (String itemId : dto.getItems()) {
                    Item item = itemService.createItem(itemId);
                    location.addItem(item);
                }

                // add characters
                for (String charName : dto.getCharacters()) {
                    NPC character = createCharacter(charName);
                    location.addCharacter(character);
                }

                allLocations.put(dto.getId(), location);
            }

            for (LocationDTO dto : locationDTOS) {
                Location location = allLocations.get(dto.getId());
                dto.getExits().forEach((key, value) -> {
                    connectLocation(location,
                            Direction.fromString(key),
                            allLocations.get(value));
                });
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private NPC createCharacter(String name) {
        return switch (name) {
            case "babicka" -> new NPC("Babička", null, null,
                    "Buď opatrný, Jacku! Cesta je nebezpečná.", null);
            case "iris" -> new NPC("Iris", null, null,
                    "Pomůžu ti na tvé cestě.", null);
            case "rose" -> new NPC("Rose", null, null,
                    "Vezmi si tento meč, budeš ho potřebovat.",
                    null);
            default -> new NPC(name, null, null, "...", null);
        };
    }

    public Location getStartLocation() {
        return allLocations.get("puda");
    }

    public Location findLocation(String id) {
        return allLocations.get(id);
    }

    public void connectLocation(Location location1, Direction direction, Location location2) {
        location1.addExit(direction, location2);
    }

    public Map<String, Location> getAllLocations() {
        return allLocations;
    }
}
