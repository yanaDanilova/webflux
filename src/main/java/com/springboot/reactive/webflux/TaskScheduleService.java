package com.springboot.reactive.webflux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TaskScheduleService {
    Flux<TaskSchedule> getAllTaskSchedule();
}
