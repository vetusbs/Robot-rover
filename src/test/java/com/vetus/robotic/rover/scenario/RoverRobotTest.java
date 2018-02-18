package com.vetus.robotic.rover.scenario;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverRobotTest {

    private RoverRobot roverRobot;

    @Test
    public void shouldNotMoveWhenPlateauSaysIsNotValid() {
        Position position = new Position(3, 4);
        roverRobot = new RoverRobot(new State(position, Direction.N), new Plateau(3, 4));

        roverRobot.move();

        assertEquals(position, roverRobot.getCurrentState().getPosition());
    }

    @Test
    public void shouldIncreaseYWhenMoveToNorth() {
        Position position = new Position(1, 1);
        roverRobot = new RoverRobot(new State(position, Direction.N), new Plateau(3, 4));

        roverRobot.move();

        assertEquals(2, roverRobot.getCurrentState().getPosition().getY());
        assertEquals(1, roverRobot.getCurrentState().getPosition().getX());
    }

    @Test
    public void shouldDecreaseYWhenMoveToSouth() {
        Position position = new Position(1, 1);
        roverRobot = new RoverRobot(new State(position, Direction.S), new Plateau(3, 4));

        roverRobot.move();

        assertEquals(0, roverRobot.getCurrentState().getPosition().getY());
        assertEquals(1, roverRobot.getCurrentState().getPosition().getX());
    }

    @Test
    public void shouldIncreaseXWhenMoveToEast() {
        Position position = new Position(1, 1);
        roverRobot = new RoverRobot(new State(position, Direction.E), new Plateau(3, 4));

        roverRobot.move();

        assertEquals(1, roverRobot.getCurrentState().getPosition().getY());
        assertEquals(2, roverRobot.getCurrentState().getPosition().getX());
    }

    @Test
    public void shouldDecreaseXWhenMoveToWest() {
        Position position = new Position(1, 1);
        roverRobot = new RoverRobot(new State(position, Direction.W), new Plateau(3, 4));

        roverRobot.move();

        assertEquals(1, roverRobot.getCurrentState().getPosition().getY());
        assertEquals(0, roverRobot.getCurrentState().getPosition().getX());
    }
}