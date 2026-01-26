package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Location {

    private String nazev;
    private String popis;
    private Map<Direction, Location> vychody;
    private List<Item> predmety;
    private List<NPC> postavy;
    private boolean zamceno;

    public Location(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        this.vychody = new HashMap<>();
        this.predmety = new ArrayList<>();
        this.postavy = new ArrayList<>();
        this.zamceno = false;
    }

    public void pridatVychod(Direction smer, Location lokace) {
        vychody.put(smer, lokace);
    }

    public Location getVychod(String smer) {
        try {
            Direction direction = Direction.fromString(smer);
            return vychody.get(direction);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public void pridatPredmet(Item predmet) {
        predmety.add(predmet);
    }

    public void odebratPredmet(Item predmet) {
        predmety.remove(predmet);
    }

    public Item findItem(String id) {
        for (Item item : predmety) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }

    public void pridatPostavu(NPC postava) {
        postavy.add(postava);
    }

    public boolean jeZamceno() {
        return zamceno;
    }

    public void odemknout() {
        this.zamceno = false;
    }

    public void showExits() {
        System.out.print("Východy: ");
        for (Direction direction : vychody.keySet()) {
            System.out.print(direction.getJsonKey() + " ");
        }
        System.out.println();
    }

}
