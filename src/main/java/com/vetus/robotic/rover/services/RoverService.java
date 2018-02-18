package com.vetus.robotic.rover.services;

import com.vetus.robotic.rover.scenario.Command;
import com.vetus.robotic.rover.scenario.RoverRobot;

import java.util.List;

public class RoverService {
    private final RoverRobot robot;

    public RoverService(RoverRobot robot) {
        this.robot = robot;
    }

    public RoverRobot getRobot() {
        return robot;
    }

    public void execute(List<Command> commands) {
        commands.forEach(command -> {
            command.execute(robot);
        });
    }
}
