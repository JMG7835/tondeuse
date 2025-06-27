package com.jmg.tondeuse.application.services.action;

import com.jmg.tondeuse.adapter.in.rest.dto.MowerResult;
import com.jmg.tondeuse.domain.model.Garden;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mow {

    private final MoveServices moveServices;
    private final GardenServices gardenServices;


    public Mow( MoveServices moveServices, GardenServices gardenServices) {
        this.moveServices = moveServices;
        this.gardenServices = gardenServices;
    }

    public MowerResult start(Garden garden) {
        MowerResult mowerResult = new MowerResult(new ArrayList<>());

        return mowerResult;
    }
}
