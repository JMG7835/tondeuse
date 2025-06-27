package com.jmg.tondeuse.adapter.in.rest.dto;

import jakarta.validation.constraints.PositiveOrZero;

public record FieldJson (
    @PositiveOrZero(message = "x should be greater than or equal to 0")
    int max_x,
    @PositiveOrZero(message = "x should be greater than or equal to 0")
    int max_y){
}
