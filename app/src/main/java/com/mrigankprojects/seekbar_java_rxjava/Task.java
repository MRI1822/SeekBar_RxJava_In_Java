package com.mrigankprojects.seekbar_java_rxjava;

public class Task {

    private String description;
    private int priority;
    private Boolean isComplete;

    public Task(String description, int priority, Boolean isComplete){
        this.description = description;
        this.priority = priority;
        this.isComplete = isComplete;
    }

    // getters and setters
    public Boolean IsComplete(){
        return isComplete;
    }

    public String Description(){
        return description;
    }
}
