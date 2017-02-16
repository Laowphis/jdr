package com.example.e1302027.projetandroidjdr;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.e1302027.projetandroidjdr.model.Dice;

/**è
 * Created by e1302027 on 31/10/2016.
 */
public class DiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        Button buttonD6 = (Button) findViewById(R.id.buttonD6);
        buttonD6.setOnClickListener(new View.OnClickListener() {
            private int textViewHistDice;

            @Override
            public void onClick(View v) {
                /*Dice dice=new Dice();
                textViewHistDice = dice.rollDice(6);*/
                dice(6);
            }
        });

        Button buttonD10 = (Button) findViewById(R.id.buttonD10);
        buttonD10.setOnClickListener(new View.OnClickListener() {
            private int textViewHistDice;

            @Override
            public void onClick(View v) {
                dice(10);
            }
        });

        Button buttonD20 = (Button) findViewById(R.id.buttonD20);
        buttonD20.setOnClickListener(new View.OnClickListener() {
            private int textViewHistDice;

            @Override
            public void onClick(View v) {
                dice(20);
            }
        });

        Button buttonD100 = (Button) findViewById(R.id.buttonD100);
        buttonD100.setOnClickListener(new View.OnClickListener() {
            private int textViewHistDice;

            @Override
            public void onClick(View v) {
                dice(100);

            }
        });

        //ERROR: resizing partition e2fsck failed with exit code 8

    }

    public void dice(int nSides){

        Dice dice=new Dice();
        dice.rollDice(nSides);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(dice.getResult()));
        builder.setCancelable(true);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert =  builder.create();
        alert.show();
    }
}
