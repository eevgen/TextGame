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

    private Map<String, Location> vsechnyLokace = new HashMap<>();

    public void vytvorSvet(ItemService itemService) {
        Reader reader = null;
        try {

            Gson gson = new Gson();

            reader = new FileReader(PATH_TO_WORLD_FILE_JSON);
            LocationDTO[] locationDTOS = gson.fromJson(reader, LocationDTO[].class);

            for (LocationDTO dto : locationDTOS) {
                Location location = new Location(dto.getName(), dto.getDescription());

                // add items
                for (String itemId : dto.getItems()) {
                    Item item = itemService.createItem(itemId);
                    location.pridatPredmet(item);
                }

                // add characters
                for (String charName : dto.getCharacters()) {
                    NPC postava = vytvorPostavu(charName);
                    location.pridatPostavu(postava);
                }

                vsechnyLokace.put(dto.getId(), location);
            }

            for (LocationDTO dto : locationDTOS) {
                Location location = vsechnyLokace.get(dto.getId());
                dto.getExits().forEach((key, value) -> {
                    connectLocation(location,
                            Direction.fromString(key),
                            vsechnyLokace.get(value));
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

    private NPC vytvorPostavu(String nazev) {
        return switch (nazev) {
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
            default -> new NPC(nazev, null, null, "...", null);
        };
    }

    public Location getStartLocation() {
        return vsechnyLokace.get("puda");
    }

    public Location findLocation(String id) {
        return vsechnyLokace.get(id);
    }

    public void connectLocation(Location location1, Direction direction, Location location2) {
        location1.pridatVychod(direction, location2);
    }

    public Map<String, Location> getAllLocations() {
        return vsechnyLokace;
    }
}
