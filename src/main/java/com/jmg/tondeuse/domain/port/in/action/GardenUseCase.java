package com.jmg.tondeuse.domain.port.in.action;

import com.jmg.tondeuse.domain.model.Garden;
import com.jmg.tondeuse.domain.model.Mower;
import com.jmg.tondeuse.domain.model.Position;

import java.util.List;

public interface GardenUseCase {
    Garden updateMowersPosition(Garden garden,Mower mower);

}
