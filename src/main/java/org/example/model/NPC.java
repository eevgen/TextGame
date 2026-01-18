package org.example.model;

public class NPC extends Character {

    private String dialog;
    private Item odmenaPredmet;
    private boolean promluveno;

    public NPC(String jmeno, Location aktualniLokace, Backpack batoh, String dialog, Item odmenaPredmet) {
        super(jmeno, aktualniLokace, batoh);
        this.dialog = dialog;
        this.odmenaPredmet = odmenaPredmet;
        this.promluveno = false;
    }

    public String getDialog() {
        return dialog;
    }

    public String promluvitSi() {
        promluveno = true;
        return dialog;
    }

    public Item datOdmenu() {
        return odmenaPredmet;
    }

    public boolean bylPromluveno() {
        return promluveno;
    }
}
