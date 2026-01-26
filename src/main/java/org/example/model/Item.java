package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {

    private String id;
    private String nazev;
    private String popis;
    private boolean prenositelny;
    private boolean pouzitelny;

}
