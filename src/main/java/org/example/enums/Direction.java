package org.example.enums;

import lombok.Getter;

@Getter
public enum Direction {
    NORTH("Sever"),
    EAST("Východ"),
    SOUTH("Jih"),
    WEST("Západ");

    private String title;

    Direction(String title) {
        this.title = title;
    }

    public static Direction fromString(String text ){

        for (Direction direction : Direction.values()) {
            if (direction.title.equalsIgnoreCase(text)) {
                return direction;
            }
        }

        throw new IllegalArgumentException("Unknown direction: " + text);

    }
}
