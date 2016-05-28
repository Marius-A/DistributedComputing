package com.mariusiliescu.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by Marius on 27.05.2016.
 */
@Entity
public class Task {
    @Id
    @GeneratedValue
    private int taskId;
    @NotNull
    private int dificultyLevel;
    @NotNull
    private String sourceCode;

    public Task(int dificultyLevel, String sourceCode) {
        this.dificultyLevel = dificultyLevel;
        this.sourceCode = sourceCode;
    }

    public int getDificultyLevel() {
        return dificultyLevel;
    }

    public void setDificultyLevel(int dificultyLevel) {
        this.dificultyLevel = dificultyLevel;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }
}
