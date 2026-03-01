package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Game item - can be picked up, used, or examined.
 * @author Text Game Team
 */
@Getter
@Setter
@AllArgsConstructor
public class Item {

    /** Unique item identifier (e.g., "mec", "mapa") */
    private String id;

    /** Display name shown to player */
    private String name;

    /** Item description for examine command */
    private String description;

    /** Can be picked up and carried in backpack */
    private boolean portable;

    /** Can be used with 'pouzij' command */
    private boolean usable;

}
