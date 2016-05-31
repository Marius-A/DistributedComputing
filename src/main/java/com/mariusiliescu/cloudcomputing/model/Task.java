package com.mariusiliescu.cloudcomputing.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    private String sourceCode;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="owner_id")
    private User owner;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="resolver_id")
    private User resolver;

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
        this.sourceCode="code"+taskId;
    }

    /**
     * Task class default constructor
     */
    public Task() {
        this.taskId=0L;
        this.dificultyLevel = 0;
        this.status = TaskStatus.unsolved;
        this.sourceCode="code"+taskId;
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
     * Task sourcecode getter
     * @return task sourcecode
     */
    public String getSourceCode() {
        return sourceCode;
    }

    /**
     * Task sourcecode setter
     * @param sourceCode
     */
    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
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
}
