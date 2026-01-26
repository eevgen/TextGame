package org.example.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {
    private String id;
    private String name;
    private String description;
    private boolean portable;
    private boolean usable;


}
