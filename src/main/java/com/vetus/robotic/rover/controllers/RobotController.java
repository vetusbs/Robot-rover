package com.vetus.robotic.rover.controllers;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vetus.robotic.rover.scenario.Command;
import com.vetus.robotic.rover.scenario.Direction;
import com.vetus.robotic.rover.scenario.State;
import com.vetus.robotic.rover.services.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/")
public class RobotController {

    @Autowired
    private RoverService roverService;
    @Autowired
    private ObjectMapper mapper;
    private static final TypeReference TYPE_REFERENCE_DIRECTIONS = new TypeReference<List<Direction>>() {
    };

    @GetMapping("/position")
    public State getPosition() {
        return roverService.getRobot().getCurrentState();
    }

    @PostMapping("/rover")
    public ResponseEntity<?> move(@RequestParam("sequence") String seguence) {
        List<Command> commands = convertSequenceToRobotCommands(seguence);

        roverService.execute(commands);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private List<Command> convertSequenceToRobotCommands(@RequestParam("sequence") String seguence) {
        char[] chars = seguence.toCharArray();

        List<Command> commands = new ArrayList<>();
        for (char ch : chars) {
            try {
                commands.add(Command.valueOf(String.valueOf(ch)));
            } catch (IllegalArgumentException exception) {
                throw new RobotException("Wrong commands sequence", HttpStatus.BAD_REQUEST);
            }

        }
        return commands;
    }

    @ExceptionHandler({RobotException.class})
    public ResponseEntity<Object> handleException(RobotException e) {
        return new ResponseEntity<>(e.getStatusCode());
    }
}
