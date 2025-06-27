package com.jmg.tondeuse.adapter.in.rest.mapper;

import com.jmg.tondeuse.adapter.in.rest.dto.FieldJson;
import com.jmg.tondeuse.adapter.in.rest.dto.MowerRequest;
import com.jmg.tondeuse.adapter.in.rest.dto.MowerResponce;
import com.jmg.tondeuse.adapter.in.rest.dto.PositionJson;
import com.jmg.tondeuse.domain.model.Mower;
import com.jmg.tondeuse.domain.model.Position;
import org.springframework.stereotype.Component;

@Component
public class PositionMapper {
    public Position toPosition(PositionJson positionJson){
        return new Position(positionJson.x(),positionJson.y());
    }

    public Position toPositionFromField(FieldJson field){
        return new Position(field.max_x(), field.max_y());
    }

    public PositionJson toPositionJson(Position position){
       return new PositionJson(position.getX(), position.getY());
    }
}
