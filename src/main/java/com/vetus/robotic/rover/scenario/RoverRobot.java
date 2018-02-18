package com.vetus.robotic.rover.scenario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RoverRobot {
    private static final Logger LOG = LoggerFactory.getLogger(RoverRobot.class);

    private final State state;
    private final Plateau plateau;

    public RoverRobot(State state, Plateau plateau) {
        this.state = state;
        this.plateau = plateau;
    }

    public void move() {
        Position newPosition = getNewPosition();

        if (plateau.isValid(newPosition)) {
            this.state.setPosition(newPosition);
        }
        LOG.info("Current [{}]", this.state);
    }

    public void turnLeft() {
        state.setDirection(state.getDirection().turnLeft());
        LOG.info("Current [{}]", this.state);
    }

    public void turnRight() {
        state.setDirection(state.getDirection().turnRight());
        LOG.info("Current [{}]", this.state);
    }

    public State getCurrentState() {
        return state;
    }

    private Position getNewPosition() {
        Position position = state.getPosition();
        int x = position.getX();
        int y = position.getY();
        switch (state.getDirection()) {
            case N:
                return new Position(x, y + 1);
            case S:
                return new Position(x, y - 1);
            case E:
                return new Position(x + 1, y);
            case W:
                return new Position(x - 1, y);
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
