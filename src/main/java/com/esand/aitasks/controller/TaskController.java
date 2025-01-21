package com.esand.aitasks.controller;

import com.esand.aitasks.client.TestClient;
import com.esand.aitasks.entity.Task;
import com.esand.aitasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskrepository;

    @Autowired
    private TestClient testClient;

    @GetMapping
    public ResponseEntity<Flux<Task>> findAll() {
        return ResponseEntity.ok(taskrepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Mono<Task>> create(@RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskrepository.save(task));
    }

    @PostMapping("/testai")
    public ResponseEntity<Flux<String>> testeai(@RequestBody String requestBody) {
        return ResponseEntity.status(HttpStatus.CREATED).body(testClient.getResponse(requestBody));
    }
}