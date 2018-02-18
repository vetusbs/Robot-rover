package com.vetus.robotic.rover.scenario;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Plateau {

    private final int x;
    private final int y;

    @JsonCreator
    public Plateau(@JsonProperty("x") int x, @JsonProperty("y") int y) {
        this.x = x;
        this.y = y;
    }

    boolean isValid(Position position) {
        return position.getY() >= 0
                && position.getX() >= 0
                && position.getX() <= x
                && position.getY() <= y;
    }
}
