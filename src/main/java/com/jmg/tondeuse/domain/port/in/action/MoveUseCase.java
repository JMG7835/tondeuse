package com.jmg.tondeuse.domain.port.in.action;

import com.jmg.tondeuse.domain.model.DirectionEnum;
import com.jmg.tondeuse.domain.model.Garden;
import com.jmg.tondeuse.domain.model.Mower;

public interface MoveUseCase {
    Mower move(final DirectionEnum direction, Mower mower, Garden garden);
}
