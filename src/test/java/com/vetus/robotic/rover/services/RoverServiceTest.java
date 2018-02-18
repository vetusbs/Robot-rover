package com.vetus.robotic.rover.services;

import com.vetus.robotic.rover.scenario.Command;
import com.vetus.robotic.rover.scenario.RoverRobot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RoverServiceTest {

    @Mock
    private RoverRobot roverRobot;
    @InjectMocks
    private RoverService roverService;

    @Test
    public void shouldExecuteAllCommandsAgainstTheRobot() {
        List<Command> commandList = new ArrayList<>();
        commandList.add(Command.L);
        commandList.add(Command.R);
        commandList.add(Command.M);

        roverService.execute(commandList);

        verify(roverRobot).turnLeft();
        verify(roverRobot).turnRight();
        verify(roverRobot).move();
    }

}