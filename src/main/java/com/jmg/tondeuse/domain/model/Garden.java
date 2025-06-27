package com.jmg.tondeuse.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Garden {
    private String[][] field;
    private List<Mower> mowers;
}
