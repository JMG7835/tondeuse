package com.jmg.tondeuse.adapter.in.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MowerResponce {
    private String id;
    private PositionJson position;
    private String orientation;
}
