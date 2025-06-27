package com.jmg.tondeuse.domain.port.in.action;

import com.jmg.tondeuse.domain.model.DirectionEnum;

public interface ChangeDirectionUseCase {
    void move(DirectionEnum direction);
}
