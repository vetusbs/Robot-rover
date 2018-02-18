package com.vetus.robotic.rover.controllers;

import com.vetus.robotic.rover.RoverRobotConfig;
import com.vetus.robotic.rover.scenario.Command;
import com.vetus.robotic.rover.scenario.RoverRobot;
import com.vetus.robotic.rover.services.RoverService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RobotController.class, secure = false)
@Import(RoverRobotConfig.class)
public class RobotControllerTest {
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private MockMvc mvc;

    @MockBean
    private RoverService roverService;
    @Autowired
    private RoverRobot roverRobot;

    @Test
    public void shouldCallToRobotServiceWithProperCommandsWhenCommandsArePassed() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/rover")
                .param("sequence", "LRMLRM"))
                .andExpect(status().isOk());

        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(roverService).execute(argumentCaptor.capture());
        List<Command> commands = argumentCaptor.getValue();
        assertEquals(6, commands.size());
        assertEquals(Command.L, commands.get(0));
        assertEquals(Command.R, commands.get(1));
        assertEquals(Command.M, commands.get(2));
        assertEquals(Command.L, commands.get(3));
        assertEquals(Command.R, commands.get(4));
        assertEquals(Command.M, commands.get(5));
    }

    @Test
    public void shouldReturnTheStateOfRobot() throws Exception {
        when(roverService.getRobot()).thenReturn(roverRobot);

        mvc.perform(MockMvcRequestBuilders.get("/position"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.position.x").value(1))
                .andExpect(jsonPath("$.position.y").value(2))
                .andExpect(jsonPath("$.direction").value("N"));
    }

    @Test
    public void shouldReturn400WhenListOfCommandsIsWrong() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/rover")
                .param("sequence", "ASD"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturn400WhenListOfCommandsIsNotSent() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/rover"))
                .andExpect(status().isBadRequest());
    }
}