package org.example.model;

public class Player extends Character {

    private int zdravi;

    public Player(String jmeno, Location aktualniLokace, Backpack batoh, int zdravi) {
        super(jmeno, aktualniLokace, batoh);
        this.zdravi = zdravi;
    }

    public int getZdravi() {
        return zdravi;
    }

    public void setZdravi(int zdravi) {
        this.zdravi = zdravi;
    }
}
