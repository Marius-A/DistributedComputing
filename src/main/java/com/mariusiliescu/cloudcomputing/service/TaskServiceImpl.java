package com.mariusiliescu.cloudcomputing.service;

import com.mariusiliescu.cloudcomputing.model.Task;
import com.mariusiliescu.cloudcomputing.model.TaskStatus;
import com.mariusiliescu.cloudcomputing.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public long save(Task task) {
        return taskRepository.save(task).getTaskId();
    }

    @Override
    public Task findById(Long taskId) {
        return taskRepository.findByTaskId(taskId);
    }


    @Override
    public Task findByOwnerId(String ownerId) {
        return taskRepository.findByOwnerId(ownerId);
    }

    @Override
    public Task findByResolverId(String resolverId) {
        return taskRepository.findByResolverId(resolverId);
    }

    @Override
    public List<Task> getArrTasks(Long idUser) {
        List<Task> otherTaskList = new ArrayList<>();
        List<Task> allTasks = taskRepository.findAll();
        for(Task t : allTasks){
            if(t.getOwner().getId() != idUser && t.getStatus() == TaskStatus.unsolved && t.getDificultyLevel() <5){
                otherTaskList.add(t);
            }
        }
        return otherTaskList;
    }

    @Override
    public List<Task> getArrTasksH(Long idUser) {
        List<Task> otherTaskList = new ArrayList<>();
        List<Task> allTasks = taskRepository.findAll();
        for(Task t : allTasks){
            if(t.getOwner().getId() != idUser && t.getStatus() == TaskStatus.unsolved && t.getDificultyLevel() >= 5){
                otherTaskList.add(t);
            }
        }
        return otherTaskList;
    }

}
