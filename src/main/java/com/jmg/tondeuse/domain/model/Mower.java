package com.jmg.tondeuse.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Mower {
    private String id;
    private Position position;
    private String orientation;
}
