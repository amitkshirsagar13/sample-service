package io.k8clusters.sample.controllers;

import io.k8clusters.sample.services.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("greet")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SampleController {

    private final GreetingService greetingService;

    public SampleController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    @GetMapping(value = "/{name}/{message}")
    public ResponseEntity<String> getBook(@PathVariable String name, @PathVariable String message) {
        return ResponseEntity.ok(greetingService.greetSomeone(String.format("%s XXXX ", name), String.format("%s!!!", message)).greetings());
    }
}