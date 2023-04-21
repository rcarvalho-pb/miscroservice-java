package com.ms.hrworker.repositories;

import com.ms.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerJPARepository extends JpaRepository<Worker, Long> {
}
