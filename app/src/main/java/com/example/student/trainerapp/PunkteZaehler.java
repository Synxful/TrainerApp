package com.example.student.trainerapp;

/**
 * Created by student on 18.10.2017.
 */

public class PunkteZaehler extends MainActivity {

    int punkte;

    public PunkteZaehler() {
    }

    public void win() {
        int punkteDazu = 10;
        punkte = punkte + punkteDazu;
    }

    public void loose() {
        int punkteAbzug = 5;
        punkte = punkte - punkteAbzug;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }
}
