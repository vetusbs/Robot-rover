package com.vetus.robotic.rover.scenario;

public class State {
    private Position position;
    private Direction direction;

    public State(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return new StringBuilder("x: ").append(position.getX())
                .append(", y: ").append(position.getY())
                .append(", direction: ").append(direction).toString();

    }
}
