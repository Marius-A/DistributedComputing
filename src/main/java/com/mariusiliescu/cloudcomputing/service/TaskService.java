package com.mariusiliescu.cloudcomputing.service;

import com.mariusiliescu.cloudcomputing.model.Task;

public interface TaskService {
    long save(Task task);

    Task findByOwnerId(String ownerId);
    Task findByResolverId(String resolverId);
}
