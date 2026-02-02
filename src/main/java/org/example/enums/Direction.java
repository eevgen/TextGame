package org.example.enums;

import lombok.Getter;

@Getter
public enum Direction {
    NORTH("Sever", "sever"),
    EAST("Východ", "vychod"),
    SOUTH("Jih", "jih"),
    WEST("Západ", "zapad");

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
