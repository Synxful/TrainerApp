package com.example.student.trainerapp;

/**
 * Created by student on 18.10.2017.
 */

public class TaskCreator {

    String aufgabe1;

    public TaskCreator() {}


    public void taskCreator() {
        aufgabe1 = "Die erste Aufgabe besteht darin 5x mal im Kreis zu springen du JOCKEL!";


    }

    public String getTask() {
        return aufgabe1;
    }

    public void setTask(String task) {
        this.aufgabe1 = aufgabe1;
    }
}
