package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private List<Item> predmety;
    private int maximalniKapacita;

    public Backpack(int maximalniKapacita) {
        this.predmety = new ArrayList<>();
        this.maximalniKapacita = maximalniKapacita;
    }

    public boolean pridatPredmet(Item predmet) {
        if (!jePlny()) {
            predmety.add(predmet);
            return true;
        }
        return false;
    }

    public boolean odebratPredmet(Item predmet) {
        return predmety.remove(predmet);
    }

    public List<Item> getPredmety() {
        return predmety;
    }

    public boolean maPredmet(String nazev) {
        for (Item predmet : predmety) {
            if (predmet.getNazev().equals(nazev)) {
                return true;
            }
        }
        return false;
    }

    public boolean jePlny() {
        return predmety.size() >= maximalniKapacita;
    }
}
