package com.example.ood_project.models;

import java.util.Observable;

public class TaskAssignmentObservable extends Observable {
    public void taskAssigned(String userName) {
        setChanged();
        notifyObservers(userName);
    }
}

