package com.mariusiliescu.model.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marius on 27.05.2016.
 */
@Entity
public class Researcher extends Client {

    @OneToMany
    private Map<Task, StatusDificultyPair> taskList;

    public Researcher(AuthentificationData authentificationData) {
        this.authentificationData = authentificationData;
        taskList = new HashMap<Task, StatusDificultyPair>();
    }

    public void addTask(Task task, TaskStatus taskStatus, int dificulty) {
        taskList.put(task, new StatusDificultyPair(dificulty, taskStatus));
    }

}
