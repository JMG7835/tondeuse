package com.jmg.tondeuse.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Mower {
    private String id;
    private Position position;
    private CardinalPointEnum orientation;
    private List<DirectionEnum> instructions;
}
