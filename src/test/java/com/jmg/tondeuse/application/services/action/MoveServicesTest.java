package com.jmg.tondeuse.application.services.action;

import com.jmg.tondeuse.domain.model.CardinalPointEnum;
import com.jmg.tondeuse.domain.model.DirectionEnum;
import com.jmg.tondeuse.domain.model.Garden;
import com.jmg.tondeuse.domain.model.Mower;
import com.jmg.tondeuse.domain.model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MoveServicesTest {
    static private String NAME = "test";
    static private Position POSITION00 = new Position(0, 0);
    static private Position POSITION01 = new Position(0, 1);
    static private Garden GARDEN = new Garden(new String[1][1], new ArrayList<>());

    @InjectMocks
    private MoveServices moveServices;

    @Test
    void testMoveRight() {
        Mower mower = new Mower(NAME, POSITION00, CardinalPointEnum.N, new ArrayList<>());
        moveServices.move(DirectionEnum.D, mower, GARDEN);
        assertEquals(CardinalPointEnum.E, mower.getOrientation());
    }

    @Test
    void testMoveLeft() {
        Mower mower = new Mower(NAME, POSITION00, CardinalPointEnum.N, new ArrayList<>());
        moveServices.move(DirectionEnum.G, mower, GARDEN);
        assertEquals(CardinalPointEnum.W, mower.getOrientation());
    }

    @Test
    void testMovefront() {
        Mower mower = new Mower(NAME, POSITION00, CardinalPointEnum.N, new ArrayList<>());
        moveServices.move(DirectionEnum.A, mower, GARDEN);
        assertEquals(CardinalPointEnum.N, mower.getOrientation());
        assertEquals(POSITION01.getX(), mower.getPosition().getX());
        assertEquals(POSITION01.getY(), mower.getPosition().getY());
    }

    @Test
    void testMovefrontBorder() {
        Mower mower = new Mower(NAME, POSITION01, CardinalPointEnum.N, new ArrayList<>());
        moveServices.move(DirectionEnum.A, mower, GARDEN);
        assertEquals(CardinalPointEnum.N, mower.getOrientation());
        assertEquals(POSITION01.getX(), mower.getPosition().getX());
        assertEquals(POSITION01.getY(), mower.getPosition().getY());
    }
}
