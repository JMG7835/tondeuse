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
    static private Garden GARDEN = new Garden(new String[1][1], new ArrayList<>());

    @InjectMocks
    private MoveServices moveServices;

    @Test
    void testMoveRight() {
        Mower mower = new Mower(NAME, new Position(0, 0), CardinalPointEnum.N, new ArrayList<>());
        moveServices.move(DirectionEnum.D, mower, GARDEN);
        assertEquals(CardinalPointEnum.E, mower.getOrientation());
    }

    @Test
    void testMoveLeft() {
        Mower mower = new Mower(NAME, new Position(0, 0), CardinalPointEnum.N, new ArrayList<>());
        moveServices.move(DirectionEnum.G, mower, GARDEN);
        assertEquals(CardinalPointEnum.W, mower.getOrientation());
    }

    @Test
    void testMoveN() {
        Position position = new Position(0, 1);
        Mower mower = new Mower(NAME, new Position(0, 0), CardinalPointEnum.N, new ArrayList<>());
        moveServices.move(DirectionEnum.A, mower, GARDEN);
        assertEquals(CardinalPointEnum.N, mower.getOrientation());
        assertEquals(position.getX(), mower.getPosition().getX());
        assertEquals(position.getY(), mower.getPosition().getY());
    }

    @Test
    void testMovefrontBorder() {
        Position position = new Position(0, 1);
        Mower mower = new Mower(NAME, position, CardinalPointEnum.N, new ArrayList<>());
        moveServices.move(DirectionEnum.A, mower, GARDEN);
        assertEquals(CardinalPointEnum.N, mower.getOrientation());
        assertEquals(position.getX(), mower.getPosition().getX());
        assertEquals(position.getY(), mower.getPosition().getY());
    }

    @Test
    void testMoveE() {
        Position position = new Position(1, 0);
        Mower mower = new Mower(NAME, new Position(0, 0), CardinalPointEnum.E, new ArrayList<>());
        moveServices.move(DirectionEnum.A, mower, GARDEN);
        assertEquals(CardinalPointEnum.E, mower.getOrientation());
        assertEquals(position.getX(), mower.getPosition().getX());
        assertEquals(position.getY(), mower.getPosition().getY());
    }

    @Test
    void testMoveS() {
        Position position = new Position(1, 0);
        Mower mower = new Mower(NAME, new Position(1, 1), CardinalPointEnum.S, new ArrayList<>());
        moveServices.move(DirectionEnum.A, mower, GARDEN);
        assertEquals(CardinalPointEnum.S, mower.getOrientation());
        assertEquals(position.getX(), mower.getPosition().getX());
        assertEquals(position.getY(), mower.getPosition().getY());
    }

    @Test
    void testMoveW() {
        Position position = new Position(0, 1);
        Mower mower = new Mower(NAME, new Position(1, 1), CardinalPointEnum.W, new ArrayList<>());
        moveServices.move(DirectionEnum.A, mower, GARDEN);
        assertEquals(CardinalPointEnum.W, mower.getOrientation());
        assertEquals(position.getX(), mower.getPosition().getX());
        assertEquals(position.getY(), mower.getPosition().getY());
    }
}
