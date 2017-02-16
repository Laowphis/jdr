package com.example.e1302027.projetandroidjdr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private static final int NEW_CHARACTER = 1;
    private static final int ADD_CONTACT = 1;
    private static final int DICE = 2;
    private static final int CARDS = 3;
    private static final int VIEWS = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonNewCharacter = (Button) findViewById(R.id.buttonNewChar);
        buttonNewCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditActivity.class);
//                startActivity(intent);
                startActivityForResult(intent, ADD_CONTACT);
            }
        });

        Button buttonDice = (Button) findViewById(R.id.buttonDice);
        buttonDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DiceActivity.class);
                startActivityForResult(intent,DICE);
            }
        });

        Button buttonCards = (Button) findViewById(R.id.buttonCards);
        buttonCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CardsActivity.class);
                startActivityForResult(intent, CARDS);
            }
        });

        Button buttonViews = (Button) findViewById(R.id.buttonView);
        buttonViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewsActivity.class);
                startActivityForResult(intent, VIEWS);
            }
        });
    }
}
