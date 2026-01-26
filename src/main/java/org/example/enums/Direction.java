package org.example.enums;

import lombok.Getter;

@Getter
public enum Direction {
    SEVER("Sever", "sever"),
    VYCHOD("Východ", "vychod"),
    JIH("Jih", "jih"),
    ZAPAD("Západ", "zapad");

    private String title;
    private String id;

    Direction(String title, String jsonKey) {
        this.title = title;
        this.id = jsonKey;
    }

    public static Direction fromString(String text) {
        for (Direction direction : Direction.values()) {
            if (direction.id.equalsIgnoreCase(text) ||
                direction.title.equalsIgnoreCase(text)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("Unknown direction: " + text);
    }
}
