package com.mariusiliescu.cloudcomputing.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Marius on 27.05.2016.
 */
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long taskId;

    @NotNull
    private int dificultyLevel;

    private double result;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="owner_id")
    private User owner;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="resolver_id")
    private User resolver;

    private Date dateAdded;

    private Date dateSolved;

    /**
     * Task class general constructor
     * @param dificultyLevel
     * @param owner
     */
    public Task(int dificultyLevel, User owner) {
        this.taskId=0L;
        this.owner=owner;
        this.dificultyLevel = dificultyLevel;
        this.status = TaskStatus.unsolved;
        this.result = 0.0;
    }

    /**
     * Task class default constructor
     */
    public Task() {
        this.taskId=0L;
        this.dificultyLevel = 0;
        this.status = TaskStatus.unsolved;
        this.result = 0.0;
    }

    /**
     * Task dificulty level getter
     * @return task dificulty level
     */
    public int getDificultyLevel() {
        return dificultyLevel;
    }

    /**
     * Task dificulty level setter
     * @param dificultyLevel
     */
    public void setDificultyLevel(int dificultyLevel) {
        this.dificultyLevel = dificultyLevel;
    }

    /**
     * Task id getter
     * @return
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * Task result getter
     * @return task result
     */
    public Double getTaskResult() {
        return result;
    }

    /**
     * Task result setter
     * @param result
     */
    public void setTaskResult(Double result) {
        this.result = result;
    }

    /**
     * Task status getter
     * @return task status
     * @see TaskStatus
     */
    public TaskStatus getStatus() {
        return status;
    }

    /**
     * Task status getter
     * @param status
     * @see TaskStatus
     */
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    /**
     * Task owner getter
     * @return task owner
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Task owner setter
     * @param owner
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * Task resolver getter
     * @return task resolver
     */
    public User getResolver() {
        return resolver;
    }

    /**
     * Task resolver setter
     * @param resolver
     */
    public void setResolver(User resolver) {
        this.resolver = resolver;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }


    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateSolved() {
        return dateSolved;
    }

    public void setDateSolved(Date dateSolved) {
        this.dateSolved = dateSolved;
    }
}
