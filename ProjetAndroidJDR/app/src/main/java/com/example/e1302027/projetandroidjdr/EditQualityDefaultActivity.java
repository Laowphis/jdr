package com.example.e1302027.projetandroidjdr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.e1302027.projetandroidjdr.model.Cards;

/**
 * Created by jonathan on 31/10/2016.
 */
public class EditQualityDefaultActivity extends AppCompatActivity {

    private static final int NEW_CHARACTER_FINISH = 1;
    private static final int ADD_CONTACT = 1;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_quality_default);

        //Generate Quality & Defaults with 5 random cards
        Cards cards = new Cards();
        cards.chooseCards(5);

        Button buttonNextStep = (Button) findViewById(R.id.buttonFinish);
        buttonNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, ADD_CONTACT);

                setResult(ADD_CONTACT, intent);
                setResult(RESULT_OK, intent);
            }
        });

    }
}
