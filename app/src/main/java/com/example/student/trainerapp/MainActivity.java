package com.example.student.trainerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Toast showYes;
    Toast showNo;

    TextView punkte;
    TextView mainText;

    ImageButton YesButton;
    ImageButton NoButton;
    String test = " EINFACH NUR EIN TEST OB DIESER SCHEIß FUNKTIONIERT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";

    PunkteZaehler p;
    TaskCreator tc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        punkte = (TextView) findViewById(R.id.punkte);
        mainText = (TextView) findViewById(R.id.mainText);

        YesButton = (ImageButton) findViewById(R.id.YesButon);
        NoButton = (ImageButton) findViewById(R.id.NoButton);

        p = new PunkteZaehler();
        p.setPunkte(0);
        punkte.setText("Punkte : " + p.getPunkte());

        tc = new TaskCreator();
        tc.taskCreator();
        mainText.setText(tc.getTask());


    }

    public void buttonYesClick(View view) {
        pruefePunktestand();
        showYes = Toast.makeText(getApplicationContext().getApplicationContext(),"JA, als Antwort ausgewählt!",Toast.LENGTH_SHORT);
        showYes.show();
        p.win();
        punkte.setText("Punkte : " + p.getPunkte());
    }

    public void buttonNoClick(View view) {
        pruefePunktestand();
        showNo = Toast.makeText(getApplicationContext().getApplicationContext(),"NEIN, als Antwort ausgewählt!", Toast.LENGTH_SHORT);
        showNo.show();
        p.loose();
        punkte.setText("Punkte : " + p.getPunkte());
    }

    public void pruefePunktestand() {
        if(p.getPunkte() < 0) {
            punkte.setText("Du hast weniger als 0 Punkte! ");
            YesButton.setClickable(false);
            NoButton.setClickable(false);
        }
    }
}
