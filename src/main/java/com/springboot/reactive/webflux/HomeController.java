package com.springboot.reactive.webflux;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/index")
    public Mono<ResponseEntity<String>> index(){
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body("Hello World"));
    }
}