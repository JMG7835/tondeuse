package com.jmg.tondeuse.adapter.in.rest.mapper;

import com.jmg.tondeuse.adapter.in.rest.dto.Order;
import com.jmg.tondeuse.domain.model.Garden;
import com.jmg.tondeuse.domain.model.Mower;
import com.jmg.tondeuse.domain.model.Position;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GardenMapper {
    private final PositionMapper positionMapper;
    private final MowerMapper mowerMapper;

    public GardenMapper(PositionMapper positionMapper, MowerMapper mowerMapper) {
        this.positionMapper = positionMapper;
        this.mowerMapper = mowerMapper;
    }

    public Garden toGarden(Order request){
        Position position = positionMapper.toPositionFromField(request.getField());
        List<Mower> mowers= mowerMapper.toMower(request.getMowers());

        return new Garden(new String[position.getY()][position.getX()],mowers);

    }

}
