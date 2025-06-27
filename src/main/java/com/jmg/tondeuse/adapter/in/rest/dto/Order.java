package com.jmg.tondeuse.adapter.in.rest.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    @NotNull(message = "field is required")
    @Valid
    private FieldJson field;
    @NotEmpty(message = "One mower is required")
    @Valid
    private List<MowerRequest> mowers;
}
