package com.mariusiliescu.cloudcomputing.repository;

import com.mariusiliescu.cloudcomputing.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByOwnerId(String owner_id);
    Task findByResolverId(String resolver_id);
}
