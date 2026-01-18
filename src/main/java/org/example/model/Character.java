package org.example.model;

public abstract class Character {

    private String jmeno;
    private Location aktualniLokace;
    private Backpack batoh;

    public Character(String jmeno, Location aktualniLokace, Backpack batoh) {
        this.jmeno = jmeno;
        this.aktualniLokace = aktualniLokace;
        this.batoh = batoh;
    }

    public String getJmeno() {
        return jmeno;
    }

    public Location getAktualniLokace() {
        return aktualniLokace;
    }

    public void setAktualniLokace(Location aktualniLokace) {
        this.aktualniLokace = aktualniLokace;
    }

    public Backpack getBatoh() {
        return batoh;
    }
}
