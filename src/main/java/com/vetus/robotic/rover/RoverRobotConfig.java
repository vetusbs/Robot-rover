package com.vetus.robotic.rover;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vetus.robotic.rover.input.InitialState;
import com.vetus.robotic.rover.scenario.*;
import com.vetus.robotic.rover.services.RoverService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ClassUtils;

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
        ClassLoader defaultClassLoader = ClassUtils.getDefaultClassLoader();
        ResourceLoader resourceLoader = new DefaultResourceLoader(defaultClassLoader);
        Resource resource = resourceLoader.getResource("classpath:initial_state.json");

        return objectMapper.readValue(resource.getInputStream(), InitialState.class);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
