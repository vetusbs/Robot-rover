package com.vetus.robotic.rover;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vetus.robotic.rover.input.InitialState;
import com.vetus.robotic.rover.scenario.*;
import com.vetus.robotic.rover.services.RoverService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;

@Configuration
public class RoverRobotConfig {
    @Bean
    public RoverService roverService(RoverRobot roverRobot) {
        return new RoverService(roverRobot);
    }

    @Bean
    public RoverRobot roverRobot(InitialState initialState) {
        return new RoverRobot(new State(initialState.getPosition(), initialState.getDirection()), initialState.getPlateau());
    }

    @Bean
    public InitialState initialState(ObjectMapper objectMapper) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("initial-state.json").getFile());

        InitialState initialState = objectMapper.readValue(file, InitialState.class);
        return initialState;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
