package org.example.service;

import com.google.gson.Gson;
import org.example.dto.ItemDTO;
import org.example.model.Item;
import org.example.model.Location;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class ItemService {

    private Map<String, Item> allItems = new HashMap<>();

    public void scrapItems() {
        Reader reader = null;
        try {
            reader = new FileReader("docs/json/items.json");
            Gson gson = new Gson();

            ItemDTO[] itemDTOS = gson.fromJson(reader, ItemDTO[].class);

            for(ItemDTO dto : itemDTOS) {
                Item item = new Item(
                        dto.getId(),
                        dto.getName(),
                        dto.getDescription(),
                        dto.isPrenositelny(),
                        dto.isPouzitelny()
                );

                allItems.put(item.getId(), item);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }  finally {

            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public Item findItem(String id) {
        return allItems.get(id);
    }

    public Item createItem(String id) {
        Item original = allItems.get(id);
        if(original == null) {
            return null;
        }

        return new Item (
                original.getId(),
                original.getNazev(),
                original.getPopis(),
                original.isPrenositelny(),
                original.isPouzitelny()
        );
    }
}
