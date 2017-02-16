package com.example.e1302027.projetandroidjdr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

/**
 * Created by e1302027 on 31/10/2016.
 */
public class EditActivity extends AppCompatActivity {

    private static final int NEW_CHARACTER_STATS = 1;

    private EditText nameE;
    private Spinner race;
    private Spinner classe;
    private RadioGroup univers;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);



        Button buttonNextStep = (Button) findViewById(R.id.buttonStats);
        buttonNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), EditStatsActivity.class);
                //, NEW_CHARACTER_STATS);

                nameE = (EditText) findViewById(R.id.editText);
                String name = nameE.getText().toString();

                race = (Spinner) findViewById(R.id.spinnerRace);
                String race_ = race.toString();

                classe = (Spinner) findViewById(R.id.spinnerClass);
                String classe_ = classe.toString();

                univers = (RadioGroup) findViewById(R.id.univers);
                boolean medi = true;
                switch (univers.getCheckedRadioButtonId()) {
                    case R.id.radioButtonMedi : medi = true; break;
                    case R.id.radioButtonCyber : medi = false; break;
                }

                /*Intent intent = getIntent();*/
                intent.putExtra("name", name);
                intent.putExtra("race", race_);
                intent.putExtra("classe", classe_);
                intent.putExtra("univers", medi);
               // setResult(RESULT_OK, intent);
                startActivity(intent);
//                finish();


                SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name", name);
                editor.putString("race", race_);
                editor.putString("classe", classe_);
                editor.putBoolean("univers", medi);
                editor.commit();

            }
        });


        RadioButton buttonMedi = (RadioButton) findViewById(R.id.radioButtonMedi);
        if (buttonMedi.isChecked()){
            System.out.println("Medival Fantasy");
        }

        RadioButton buttonCyber = (RadioButton) findViewById(R.id.radioButtonCyber);
        if(buttonCyber.isChecked()){
            System.out.println("Cyber Punk");
        }


    }
}
