package org.example.model;

public class Item {

    private String nazev;
    private String popis;
    private boolean prenositelny;
    private boolean pouzitelny;

    public Item(String nazev, String popis, boolean prenositelny, boolean pouzitelny) {
        this.nazev = nazev;
        this.popis = popis;
        this.prenositelny = prenositelny;
        this.pouzitelny = pouzitelny;
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    public boolean jePrenositelny() {
        return prenositelny;
    }

    public boolean jePouzitelny() {
        return pouzitelny;
    }
}
