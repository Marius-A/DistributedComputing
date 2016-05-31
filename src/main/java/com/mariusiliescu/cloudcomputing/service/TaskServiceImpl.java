package com.mariusiliescu.cloudcomputing.service;

import com.mariusiliescu.cloudcomputing.model.Task;
import com.mariusiliescu.cloudcomputing.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public long save(Task task) {
        return taskRepository.save(task).getTaskId();
    }


    @Override
    public Task findByOwnerId(String ownerId) {
        return taskRepository.findByOwnerId(ownerId);
    }

    @Override
    public Task findByResolverId(String resolverId) {
        return taskRepository.findByResolverId(resolverId);
    }

}
