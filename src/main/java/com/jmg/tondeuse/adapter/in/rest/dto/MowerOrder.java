package com.jmg.tondeuse.adapter.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MowerOrder {
    private Field field;
    private List<MowerRequest> mowers;
}
