package com.mariusiliescu.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Marius on 27.05.2016.
 */
@Entity
public class StatusDificultyPair {
    @Id
    @GeneratedValue
    private int id;
    private int dificulty;
    private TaskStatus taskStatus;

    public StatusDificultyPair(int dificulty, TaskStatus taskStatus) {
        this.dificulty = dificulty;
        this.taskStatus = taskStatus;
    }
}
