package com.example.e1302027.projetandroidjdr.model;

import java.util.Random;

/**
 * Created by jonathan on 08/11/2016.
 */

public class Dice {

    private int result;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int rollDice(int nSides){
        int num = 0;
        int roll = 0;
        Random  r = new Random();
        if(nSides >=3)
        {
            roll = r.nextInt(nSides)+1;
            System.out.println("Roll is:  "+roll);
            num = num + roll;
        }
        else
        {
            System.out.println("Error num needs to be from 3");
        }
        return result = num;
    }

    public int rollNDice(int nDice, int nSides, int mult){
        int num = 0;
        int roll = 0;
        Random  r = new Random();
        if(nSides >=3)
        {
            for (int i = 0; i<nDice; i++){
                roll = r.nextInt(nSides)+1;
                System.out.println("Roll is:  "+roll);
                num = num + roll;
            }
            System.out.println("Num is:  " + num);
            num = num*mult;
            System.out.println("Result is:  " + num);
        }
        else
        {
            System.out.println("Error num needs to be from 3");
        }
        return result = num;
    }
}
