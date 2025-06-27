package com.jmg.tondeuse.adapter.in.rest.mapper;

import com.jmg.tondeuse.adapter.in.rest.dto.MowerRequest;
import com.jmg.tondeuse.adapter.in.rest.dto.MowerResponce;
import com.jmg.tondeuse.adapter.in.rest.dto.PositionJson;
import com.jmg.tondeuse.domain.model.Mower;
import com.jmg.tondeuse.domain.model.Position;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MowerMapper {

    private final PositionMapper positionMapper;

    public MowerMapper(PositionMapper positionMapper) {
        this.positionMapper = positionMapper;
    }

    public Mower toMower(MowerRequest mowerRequest){
        Position position = positionMapper.toPosition(mowerRequest.getStart_position());
        return new Mower(mowerRequest.getId(),position,mowerRequest.getOrientation(),mowerRequest.getInstructions());
    }

    public List<Mower> toMower(List<MowerRequest> mowerRequests){
        return mowerRequests.stream().map(this::toMower).toList();
    }

    public MowerResponce toRespoce(Mower mower){
        PositionJson position = positionMapper.toPositionJson(mower.getPosition());
        return MowerResponce.builder().id(mower.getId()).position(position).orientation(mower.getOrientation()).build();
    }
    public List<MowerResponce> toRespoce(List<Mower> mower){
        return mower.stream().map(this::toRespoce).toList();
    }
}
