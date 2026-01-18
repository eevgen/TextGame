package org.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {

    private String nazev;
    private String popis;
    private Map<String, Location> vychody;
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

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    public void pridatVychod(String smer, Location lokace) {
        vychody.put(smer, lokace);
    }

    public Location getVychod(String smer) {
        return vychody.get(smer);
    }

    public void pridatPredmet(Item predmet) {
        predmety.add(predmet);
    }

    public void odebratPredmet(Item predmet) {
        predmety.remove(predmet);
    }

    public List<Item> getPredmety() {
        return predmety;
    }

    public void pridatPostavu(NPC postava) {
        postavy.add(postava);
    }

    public List<NPC> getPostavy() {
        return postavy;
    }

    public boolean jeZamceno() {
        return zamceno;
    }

    public void odemknout() {
        this.zamceno = false;
    }
}
