package org.example.model;

/**
 * Non-player character - can be talked to and may give rewards.
 * @author Yevhen Kalenichenko
 */
public class NPC extends Character {

    private String dialog;
    private Item rewardItem;
    private boolean spoken;

    /**
     * Creates NPC with dialog and optional reward.
     * @param name NPC name
     * @param currentLocation NPC's location
     * @param backpack NPC's backpack (usually null)
     * @param dialog dialog text when talked to
     * @param rewardItem item given as reward (can be null)
     */
    public NPC(String name, Location currentLocation, Backpack backpack, String dialog, Item rewardItem) {
        super(name, currentLocation, backpack);
        this.dialog = dialog;
        this.rewardItem = rewardItem;
        this.spoken = false;
    }

    /**
     * Gets dialog text.
     * @return dialog string
     */
    public String getDialog() {
        return dialog;
    }

    /**
     * NPC speaks - marks as spoken and returns dialog.
     * @return dialog text
     */
    public String speak() {
        spoken = true;
        return dialog;
    }

    /**
     * Gets reward item if available.
     * @return reward item or null
     */
    public Item giveReward() {
        return rewardItem;
    }

    /**
     * Checks if NPC has been talked to.
     * @return true if NPC has spoken
     */
    public boolean hasSpoken() {
        return spoken;
    }
}
