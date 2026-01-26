package org.example.model;

public class NPC extends Character {

    private String dialog;
    private Item rewardItem;
    private boolean spoken;

    public NPC(String name, Location currentLocation, Backpack backpack, String dialog, Item rewardItem) {
        super(name, currentLocation, backpack);
        this.dialog = dialog;
        this.rewardItem = rewardItem;
        this.spoken = false;
    }

    public String getDialog() {
        return dialog;
    }

    public String speak() {
        spoken = true;
        return dialog;
    }

    public Item giveReward() {
        return rewardItem;
    }

    public boolean hasSpoken() {
        return spoken;
    }
}
