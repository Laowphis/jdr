package com.example.e1302027.projetandroidjdr;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.e1302027.projetandroidjdr.model.Dice;

/**
 * Created by jonathan on 31/10/2016.
 */
public class EditStatsActivity extends AppCompatActivity {

    private static final int NEW_CHARACTER_QUALITY_DEFAULT = 1;
    private static final int ADD_CONTACT = 1;

    private int countChance =0;

    private EditText CC;
    private EditText CT;
    private EditText FOR;
    private EditText AGI;
    private EditText END;
    private EditText CHA;
    private EditText INT;
    private EditText FM;
    private TextView tVChanceVal;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_stats);

        Dice dice = new Dice();
        CC = (EditText) findViewById(R.id.editTextCc);
        dice.rollNDice(4, 6, 3);
        CC.setText(String.valueOf(dice.getResult()));
        CT = (EditText) findViewById(R.id.editTextCt);
        dice.rollNDice(4, 6, 3);
        CT.setText(String.valueOf(dice.getResult()));
        FOR = (EditText) findViewById(R.id.editTextFor);
        dice.rollNDice(4, 6, 3);
        FOR.setText(String.valueOf(dice.getResult()));
        AGI = (EditText) findViewById(R.id.editTextAgi);
        dice.rollNDice(4, 6, 3);
        AGI.setText(String.valueOf(dice.getResult()));
        END = (EditText) findViewById(R.id.editTextEnd);
        dice.rollNDice(4, 6, 3);
        END.setText(String.valueOf(dice.getResult()));
        CHA = (EditText) findViewById(R.id.editTextCha);
        dice.rollNDice(4, 6, 3);
        CHA.setText(String.valueOf(dice.getResult()));
        INT = (EditText) findViewById(R.id.editTextInt);
        dice.rollNDice(4, 6, 3);
        INT.setText(String.valueOf(dice.getResult()));
        FM = (EditText) findViewById(R.id.editTextFm);
        dice.rollNDice(4, 6, 3);
        FM.setText(String.valueOf(dice.getResult()));


        Button buttonNextStep = (Button) findViewById(R.id.buttonQualityDefault);
        buttonNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditQualityDefaultActivity.class);
                startActivityForResult(intent, ADD_CONTACT);

                String force = FOR.getText().toString();
                String forcemental = FM.getText().toString();
                String cc = CC.getText().toString();
                String ct = CT.getText().toString();
                String charisme = CHA.getText().toString();
                String agilite = AGI.getText().toString();
                String inteligence = INT.getText().toString();
                String endurance = END.getText().toString();
                String chance = tVChanceVal.getText().toString();
                /*Intent intent = getIntent();*/
                intent.putExtra("force", force);
                intent.putExtra("forcemental", forcemental);
                intent.putExtra("cc", cc);
                intent.putExtra("ct", ct);
                intent.putExtra("charisme", charisme);
                intent.putExtra("agilite", agilite);
                intent.putExtra("inteligence", inteligence);
                intent.putExtra("endurance", endurance);
                intent.putExtra("chance", chance);
                setResult(RESULT_OK, intent);
                finish();

                SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("force", force);
                editor.putString("forcemental", forcemental);
                editor.putString("cc", cc);
                editor.putString("ct", ct);
                editor.putString("charisme", charisme);
                editor.putString("agilite", agilite);
                editor.putString("inteligence", inteligence);
                editor.putString("endurance", endurance);
                editor.putString("chance", chance);
                editor.commit();

            }
        });

        Button buttonGeneChance = (Button) findViewById(R.id.buttonGeneChance);
        buttonGeneChance.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                chance();
            }
        });



    }

    public void chance(){
        if(countChance < 1){
            Dice dice=new Dice();
            dice.rollDice(100);
            tVChanceVal = (TextView) findViewById(R.id.textViewChanceVal);
            tVChanceVal.setText(String.valueOf(dice.getResult()));
            countChance++;
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.MesChance);
            builder.setCancelable(true);
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog alert =  builder.create();
            alert.show();
        }
    }
}
