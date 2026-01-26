package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class LocationDTO {

    private String id;
    private String name;
    private String description;
    private Map<String, String> exits;
    private List<String> items;
    private List<String> characters;
    private boolean locked;
    private List<String> unlockItems;

}
