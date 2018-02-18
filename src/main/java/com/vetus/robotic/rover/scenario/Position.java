package com.vetus.robotic.rover.scenario;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Position {
    private final int x;
    private final int y;

    @JsonCreator
    public Position(@JsonProperty("x") int x,@JsonProperty("y")  int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
