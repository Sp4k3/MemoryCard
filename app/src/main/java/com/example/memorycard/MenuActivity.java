package com.example.memorycard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener
{
    Button buttonFacile;
    Button buttonIntermediaire;
    Button buttonDifficile;
    Button buttonImpossible;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);

        buttonFacile = (Button) findViewById(R.id.buttonFacile);
        buttonFacile.setOnClickListener(this);
        buttonIntermediaire = (Button) findViewById(R.id.buttonIntermediaire);
        buttonIntermediaire.setOnClickListener(this);
        buttonDifficile = (Button) findViewById(R.id.buttonDifficile);
        buttonDifficile.setOnClickListener(this);
        buttonImpossible = (Button) findViewById(R.id.buttonImpossible);
        buttonImpossible.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.equals(buttonFacile))
        {
            Intent mainActivity = new Intent(MenuActivity.this, MainActivity.class);
            mainActivity.putExtra("int", 3);
            startActivity(mainActivity);
        }
        else if(v.equals(buttonIntermediaire))
        {
            Intent mainActivity = new Intent(MenuActivity.this, MainActivity.class);
            mainActivity.putExtra("int", 7);
            startActivity(mainActivity);
        }
        else if(v.equals(buttonDifficile))
        {
            Intent mainActivity = new Intent(MenuActivity.this, MainActivity.class);
            mainActivity.putExtra("int", 13);
            startActivity(mainActivity);
        }
        else if(v.equals(buttonImpossible))
        {
            Intent mainActivity = new Intent(this, MainActivity.class);
            startActivity(mainActivity);
        }
    }
}
