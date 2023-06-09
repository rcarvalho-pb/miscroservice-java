package com.ms.hrworker.resources;

import com.ms.hrworker.entities.Worker;
import com.ms.hrworker.repositories.WorkerJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
@RequiredArgsConstructor
@Slf4j
public class WorkerResources {

    @Value("${server.port}")
    private int port;

    private final WorkerJPARepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> workers = repository.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Worker>> findById(@PathVariable("id") Long id){
        log.info("PORT: " + port);

        return ResponseEntity.ok(repository.findById(id));
    }
}
