package com.example.memorycard;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.example.memorycard.models.Card;
import com.example.memorycard.models.Deck;
import com.example.memorycard.models.Memory;
import com.example.memorycard.views.CardView;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Deck deck;
    FlexboxLayout flexboxlayout;
    Memory memory;
    Chronometer timer;
    Button buttonMelanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        memory = new Memory();

        timer = (Chronometer) findViewById(R.id.timer);
        /*timer.setText(00 + ":" + 00 + ":" + 00);
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer cArg) {
                long time = SystemClock.elapsedRealtime() - cArg.getBase() ;
                int h = (int) (time / 3600000);
                int m = (int) (time - h * 3600000) / 60000;
                int s = (int) (time - h * 3600000 - m * 60000) / 1000;
                //String hh = h < 10 ? "0" + h : h + "";
                String mm = m < 10 ? "0" + m : m + "";
                String ss = s < 10 ? "0" + s : s + "";
                cArg.setText(mm + ":" + ss);

            }
        });
        timer.start();*/

        Intent intent = getIntent();
        int nbPaire = intent.getIntExtra("int",0);

        setContentView(R.layout.activity_main);

        if(nbPaire != 0)
        {
            deck = new Deck(nbPaire);
        }
        else
        {
            deck = new Deck();
        }
        deck.shuffle();

        flexboxlayout = (FlexboxLayout) findViewById(R.id.FlexboxLayoutCards);
        buttonMelanger = (Button) findViewById(R.id.buttonMelanger);
        buttonMelanger.setOnClickListener(this);

        while(deck.count() > 0) {
            Card c = deck.draw();
            CardView cardView = new CardView(this, c);
            cardView.setOnClickListener(this);
            flexboxlayout.addView(cardView);
        }
    }

    @Override
    public void onBackPressed()
    {
        if(findViewById(R.id.frameLayout)!=null)
        {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v)
    {
        if(v.equals(buttonMelanger))
        {
            this.recreate();
        }
        else
        {
            Intent intent = getIntent();
            int nbPaire = intent.getIntExtra("int",13);
            int nbCartes = nbPaire*2;
            Memory memory = new Memory();

            int nbCardVisible=0;
            ArrayList<CardView> CardVisible = new ArrayList<>();

            boolean gagne = false;

            CardView cardview = (CardView) v;
            memory.setSelectCard(nbCartes, nbCardVisible, CardVisible, flexboxlayout, cardview, timer);
        }
    }
}