package com.jmg.tondeuse.application.services.action;

import com.jmg.tondeuse.adapter.in.rest.dto.FieldJson;
import com.jmg.tondeuse.adapter.in.rest.mapper.PositionMapper;
import com.jmg.tondeuse.domain.model.Garden;
import com.jmg.tondeuse.domain.model.Mower;
import com.jmg.tondeuse.domain.model.Position;
import com.jmg.tondeuse.domain.port.in.action.GardenUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GardenServices implements GardenUseCase {
    @Override
    public Garden create(Position position, List<Mower> mowers) {
        return new Garden(new String[position.getY()][position.getX()],mowers);
    }

    //use code for save position in garden if mower block other mowers
    @Override
    public Garden updateMowersPosition(Garden garden,Mower mower) {
        String[][] field = garden.getField();
        Position position = mower.getPosition();
        field[position.getY()][position.getX()] = mower.getId();
        garden.setField(field);
        return garden;
    }


}
