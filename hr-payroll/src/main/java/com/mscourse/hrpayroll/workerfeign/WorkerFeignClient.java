package com.mscourse.hrpayroll.workerfeign;

import com.mscourse.hrpayroll.entities.Worker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@FeignClient(name = "hr-worker", url = "${hr-worker.host}", path = "/workers")
@Component
public interface WorkerFeignClient {

    @GetMapping
    ResponseEntity<List<Worker>> findAll();
    @GetMapping(value = "/{id}")
    ResponseEntity<Optional<Worker>> findById(@PathVariable("id") Long id);
}
