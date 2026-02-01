package org.example.enums;

import lombok.Getter;

@Getter
public enum Direction {
    SEVER("Sever", "sever"),
    VYCHOD("Východ", "vychod"),
    JIH("Jih", "jih"),
    ZAPAD("Západ", "zapad");

    private String title;
    private String jsonKey;

    Direction(String title, String jsonKey) {
        this.title = title;
        this.jsonKey = jsonKey;
    }

    public static Direction fromString(String text) {
        for (Direction direction : Direction.values()) {
            if (direction.jsonKey.equalsIgnoreCase(text) ||
                direction.title.equalsIgnoreCase(text)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("Unknown direction: " + text);
    }
}
