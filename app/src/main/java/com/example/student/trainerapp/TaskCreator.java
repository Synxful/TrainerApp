package com.example.student.trainerapp;

import java.util.Random;

/**
 * Created by Synxfulx on 18.10.2017.
 */

public class TaskCreator {

    int randomZahl;

    String aufgabe;
    String[] aufgabenArray = {"Mache 25 Liegestützen á 3 Wiederholungen.", "Mache 30 Situps á 3 Wiederholungen.", "Mache 15 Klimmzüge á 3 Wiederholungen.", "Mache 30 Crunches á 3 Wiederholungen.", "Laufe 3 Kilometer in unter 30 Minuten."};

    Random r = new Random();

    public TaskCreator() {}


    public void createTask() {
        randomZahl = (r.nextInt(aufgabenArray.length));
        aufgabe = aufgabenArray[randomZahl];
    }

    public String getTask() {
        return aufgabe;
    }

    public int aufgabenZahl() {
        return randomZahl;
    }

    public void setTask(String task) {
        this.aufgabe = aufgabe;
    }
}
