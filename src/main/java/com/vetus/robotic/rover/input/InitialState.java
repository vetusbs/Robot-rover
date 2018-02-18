package com.vetus.robotic.rover.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vetus.robotic.rover.scenario.Direction;
import com.vetus.robotic.rover.scenario.Plateau;
import com.vetus.robotic.rover.scenario.Position;

public class InitialState {
    @JsonProperty("topRightCorner")
    private Plateau plateau;
    @JsonProperty("roverPosition")
    private Position position;
    @JsonProperty("roverDirection")
    private Direction direction;

    public Plateau getPlateau() {
        return plateau;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}
