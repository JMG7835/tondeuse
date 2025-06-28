package com.jmg.tondeuse.adapter.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MowerResult {
    private List<MowerResponce> mowers;
}
