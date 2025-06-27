package com.jmg.tondeuse.application.services.action;

import com.jmg.tondeuse.domain.model.CardinalPointEnum;
import com.jmg.tondeuse.domain.model.DirectionEnum;
import com.jmg.tondeuse.domain.model.Garden;
import com.jmg.tondeuse.domain.model.Mower;
import com.jmg.tondeuse.domain.port.in.action.MoveUseCase;
import org.springframework.stereotype.Service;

@Service
public class MoveServices implements MoveUseCase {

    @Override
    public Mower move(DirectionEnum direction, Mower mower, Garden garden) {
        switch (direction) {
            case A -> front(mower, garden);
            case D -> turnRight(mower);
            case G -> turnLeft(mower);
        }
        return mower;

    }

    private void turnRight(Mower mower) {
        switch (mower.getOrientation()) {
            case E -> mower.setOrientation(CardinalPointEnum.S);
            case N -> mower.setOrientation(CardinalPointEnum.E);
            case S -> mower.setOrientation(CardinalPointEnum.W);
            case W -> mower.setOrientation(CardinalPointEnum.N);
        }
    }

    private void turnLeft(Mower mower) {
        switch (mower.getOrientation()) {
            case E -> mower.setOrientation(CardinalPointEnum.N);
            case N -> mower.setOrientation(CardinalPointEnum.W);
            case S -> mower.setOrientation(CardinalPointEnum.E);
            case W -> mower.setOrientation(CardinalPointEnum.S);
        }
    }

    private void front(Mower mower, Garden garden) {
        switch (mower.getOrientation()) {
            case E -> mower.setOrientation(CardinalPointEnum.N);
            case N -> mower.setOrientation(CardinalPointEnum.W);
            case S -> mower.setOrientation(CardinalPointEnum.E);
            case W -> mower.setOrientation(CardinalPointEnum.S);
        }
    }
}
