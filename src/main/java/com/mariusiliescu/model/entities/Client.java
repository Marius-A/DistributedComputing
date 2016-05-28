package com.mariusiliescu.model.entities;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 * This class strore all details of a particular client
 * Created by Marius on 25.05.2016.
 */
@MappedSuperclass
public abstract class Client {
    @Id
    protected long clientId;
    @OneToOne
    protected AuthentificationData authentificationData;

    public abstract void addTask(Task task, TaskStatus taskStatus, int taskDificulty);
}
