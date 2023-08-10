package com.springboot.reactive.webflux;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/taskSchedules")
public class TaskScheduleController {

    private TaskScheduleService taskScheduleService;

    @Autowired
    public TaskScheduleController(TaskScheduleService taskScheduleService) {
        this.taskScheduleService = taskScheduleService;
    }


    @GetMapping("/index")
    @Operation(description = "greeting")
    public Mono<ResponseEntity<String>> index(){
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body("Hello World"));
    }

    @GetMapping()
    @Operation(description = "get the entire list of task schedule")
    public ResponseEntity<Flux<TaskSchedule>> getAllTaskSchedule(){
        return ResponseEntity.ok(taskScheduleService.getAllTaskSchedule());

    }


}