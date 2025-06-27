package com.jmg.tondeuse.adapter.in.rest.dto;

import com.jmg.tondeuse.domain.model.CardinalPointEnum;
import com.jmg.tondeuse.domain.model.DirectionEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class MowerRequest {
    @NotBlank(message = "id can't by empty")
    private String id;
    @NotNull(message = "start_position can't by empty")
    @Valid
    private PositionJson start_position;
    @NotNull(message = "orientation can't by empty")
    private CardinalPointEnum orientation;
    @NotEmpty(message = "instructions can't by empty")
    private List<DirectionEnum> instructions;
}
