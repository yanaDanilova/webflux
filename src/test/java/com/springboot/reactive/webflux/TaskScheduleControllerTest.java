package com.springboot.reactive.webflux;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;


import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class TaskScheduleControllerTest {
    @Mock
    private TaskScheduleService taskScheduleService;

    @InjectMocks
    private TaskScheduleController taskScheduleController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllTaskSchedule() {

        HashMap<Integer,TaskSchedule> mockRepo = new HashMap<>(){{
            put(1,new TaskSchedule(1,"John Smith",
                    "06.08.2023","pending with project",
                    "work with project"));
        }};


        when(taskScheduleService.getAllTaskSchedule()).thenReturn(Flux.fromIterable(mockRepo.values()));
        ResponseEntity<Flux<TaskSchedule>> responseEntity = taskScheduleController.getAllTaskSchedule();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Flux<TaskSchedule> resultFlux = responseEntity.getBody();
        assertNotNull(resultFlux);
    }


}
