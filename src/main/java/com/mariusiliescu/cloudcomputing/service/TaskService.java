package com.mariusiliescu.cloudcomputing.service;

import com.mariusiliescu.cloudcomputing.model.Task;

import java.util.List;

public interface TaskService {
    long save(Task task);

    Task findById(Long taskId);
    Task findByOwnerId(String ownerId);
    Task findByResolverId(String resolverId);
    List<Task> getArrTasks(Long idUser);
    List<Task> getArrTasksH(Long idUser);
}
