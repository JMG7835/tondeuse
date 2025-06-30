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
    public void move(DirectionEnum direction, Mower mower, Garden garden) {
        switch (direction) {
            case A -> front(mower, garden);
            case D -> turnRight(mower);
            case G -> turnLeft(mower);
        }

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

        int maxX = garden.getField()[0].length;
        int maxY = garden.getField().length;
        int x = mower.getPosition().getX();
        int y = mower.getPosition().getY();
        switch (mower.getOrientation()) {
            case E:
                if (x < maxX) {
                    mower.getPosition().setX(x + 1);
                }
                break;
            case N :
                if (y < maxY) {
                    mower.getPosition().setY(y + 1);
                }
                break;
            case S :
                if (y > 0) {
                    mower.getPosition().setY(y - 1);
                }
                break;
            case W :
                if (x > 0) {
                    mower.getPosition().setX(x - 1);
                }
        }
    }
}
