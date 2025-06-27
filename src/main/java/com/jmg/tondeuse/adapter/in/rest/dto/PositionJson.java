package com.jmg.tondeuse.adapter.in.rest.dto;

import jakarta.validation.constraints.PositiveOrZero;

public record PositionJson(
        @PositiveOrZero(message = "x should be greater than or equal to 0")
        int x,
        @PositiveOrZero(message = "y should be greater than or equal to 0")
        int y) {
}
