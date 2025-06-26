package com.jmg.tondeuse.adapter.in.rest.dto;

import com.jmg.tondeuse.domain.model.Position;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class MowerRequest {
    private String id;
    private Position start_position;
    private String orientation;
    private List<String> instructions;
}
