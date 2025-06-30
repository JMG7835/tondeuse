package com.jmg.tondeuse.application.services.action;

import com.jmg.tondeuse.domain.model.DirectionEnum;
import com.jmg.tondeuse.domain.model.Garden;
import com.jmg.tondeuse.domain.model.Mower;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mow {

    private final MoveServices moveServices;


    public Mow(MoveServices moveServices) {
        this.moveServices = moveServices;
    }

    public List<Mower> start(Garden garden) {
        List<Mower> mowerResult = new ArrayList<>();

        garden.getMowers().forEach(mower -> {
            List<DirectionEnum> instructions = mower.getInstructions();
            instructions.forEach(instruction ->
                    moveServices.move(instruction, mower, garden)
            );
            mowerResult.add(mower);

        });
        return mowerResult;
    }
}
