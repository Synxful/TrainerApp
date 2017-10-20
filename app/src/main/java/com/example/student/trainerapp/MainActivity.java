package com.example.student.trainerapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int aufgabenZaehler = 1;
    int randomZahl;

    Toast showYes;
    Toast showNo;

    TextView punkte;
    TextView mainText;

    ImageButton YesButton;
    ImageButton NoButton;
    ImageView aufgabenBild;

    PunkteZaehler p;
    TaskCreator tc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextViews & Image Views
        punkte = (TextView) findViewById(R.id.punkte);
        mainText = (TextView) findViewById(R.id.mainText);
        aufgabenBild = (ImageView) findViewById(R.id.aufgabenBild);

        // ImageButtons
        YesButton = (ImageButton) findViewById(R.id.YesButton);
        NoButton = (ImageButton) findViewById(R.id.NoButton);

        p = new PunkteZaehler();
        p.setPunkte(0);
        punkte.setText("Punkte : " + p.getPunkte());
        punkte.setTextColor(Color.RED);

        tc = new TaskCreator();
        tc.createTask();
        mainText.setText("AUFGABE   " + aufgabenZaehler + " : \n" + "\n" + tc.getTask());

    }



    public void buttonYesClick(View view) {
        showYes = Toast.makeText(getApplicationContext().getApplicationContext(),"'GESCHAFFT'",Toast.LENGTH_SHORT);
        showYes.show();
        p.win();
        pruefePunktestand();
    }

    public void buttonNoClick(View view) {
        showNo = Toast.makeText(getApplicationContext().getApplicationContext(),"'NICHT GESCHAFFT'", Toast.LENGTH_SHORT);
        showNo.show();
        p.loose();
        pruefePunktestand();
    }

    public void pruefePunktestand() {

        if(p.getPunkte() < 1) {
            punkte.setText("Du hast weniger als 0 Punkte! " + "SPIEL ENDE !");
            YesButton.setEnabled(false);
            YesButton.setClickable(false);
            NoButton.setEnabled(false);
            NoButton.setClickable(false);
        } else {
            aufgabenZaehler++;
            punkte.setText("Punkte : " + p.getPunkte());
            tc.createTask();
            mainText.setText("AUFGABE   " + aufgabenZaehler + " : \n" + "\n" + tc.getTask());
            randomZahl = tc.aufgabenZahl()+1;
        }


        // Aufgaben Bilder Auswahl
        if (randomZahl == 1) {
            aufgabenBild.setImageResource(R.drawable.aufgabe1);
        } else if (randomZahl == 2) {
            aufgabenBild.setImageResource(R.drawable.aufgabe2);
        } else if (randomZahl == 3) {
            aufgabenBild.setImageResource(R.drawable.aufgabe3);
        } else if (randomZahl == 4) {
            aufgabenBild.setImageResource(R.drawable.aufgabe4);
        } else if(randomZahl == 5) {
            aufgabenBild.setImageResource(R.drawable.aufgabe5);
        }

        // Punktezahl Farben

        if(p.getPunkte() <= 30) {
            // red
            punkte.setTextColor(Color.RED);
        } else if (p.getPunkte() <= 120){
            // orange
            punkte.setTextColor(Color.parseColor("#ff9a35"));
        } else if (p.getPunkte() <= 250){
            // green
            punkte.setTextColor(Color.parseColor("#30d14b"));
        } else if (p.getPunkte() <= 500){
            // turkis
            punkte.setTextColor(Color.parseColor("#32c6d3"));
        } else if (p.getPunkte() <= 1000){
            // purple
            punkte.setTextColor(Color.parseColor("#710080"));
        }

    }
}
