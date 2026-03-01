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

            if (locationDTOS == null || locationDTOS.length == 0) {
                throw new IllegalArgumentException("Soubor world.json neobsahuje žádné lokace.");
            }

            for (LocationDTO dto : locationDTOS) {
                if (dto.getId() == null || dto.getId().isEmpty()) {
                    throw new IllegalArgumentException("Lokace musí mít ID.");
                }
                Location location = new Location(dto.getName(), dto.getDescription());

                // add items
                for (String itemId : dto.getItems()) {
                    Item item = itemService.createItem(itemId);
                    if (item != null) {
                        location.addItem(item);
                    }
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
                    Location nextLocation = allLocations.get(value);
                    if (nextLocation == null) {
                        throw new IllegalArgumentException("Lokace '" + value + "' odkazovaná z '" + dto.getId() + "' neexistuje.");
                    }
                    connectLocation(location,
                            Direction.fromString(key),
                            nextLocation);
                });
            }

            // Lock the golden gate - can only be passed with key
            Location goldenGate = allLocations.get("zlata_brana");
            if (goldenGate != null) {
                goldenGate.lock();
            }

        } catch (FileNotFoundException e) {
            System.err.println("Chyba: Nelze načíst herní svět. Soubor '" + PATH_TO_WORLD_FILE_JSON + "' neexistuje.");
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            System.err.println("Chyba v konfiguraci hry: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.err.println("Neočekávaná chyba při načítání herního světa: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Varování: Nepodařilo se zavřít soubor world.json");
                }
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
            case "starosta" -> new NPC("Starosta", null, null,
                    "Vítej v naší vesnici, Jacku. Jsi připraven na dobrodružství?", null);
            case "selmy" -> new NPC("Šelmy", null, null,
                    "Grrr... Vrčení šelem...", null);
            case "goblin" -> new NPC("Goblin", null, null,
                    "Hihihi! Co tady děláš, lidský? Máš klíč pro nás?", null);
            case "vila" -> new NPC("Víla", null, null,
                    "Vítej v Království víl. Královna na tebe čeká v trůnním sále.", null);
            case "kralovna" -> new NPC("Královna", null, null,
                    "Vítej, Jacku. Děkuji ti, že jsi přišel. Potřebuji tvou pomoc.", null);
            case "aria" -> new NPC("Aria", null, null,
                    "Jsem Aria, asistentka královny. Je mi potěšením tě poznat.", null);
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
