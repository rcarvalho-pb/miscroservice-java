package com.ms.hrworker.resources;

import com.ms.hrworker.entities.Worker;
import com.ms.hrworker.repositories.WorkerJPARepository;
import lombok.RequiredArgsConstructor;
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
public class WorkerResources {

    private final WorkerJPARepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> workers = repository.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Worker>> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(repository.findById(id));
    }
}
