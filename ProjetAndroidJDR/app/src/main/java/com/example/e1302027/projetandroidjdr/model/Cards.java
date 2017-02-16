package com.example.e1302027.projetandroidjdr.model;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by jonathan on 08/11/2016.
 */

public class Cards {

    private int chooseCard;


    public int chooseCards(int nCards){
        int num = 0;
        int choose = 0;
        Random r = new Random();
        for(int i =0; i < nCards; i++){
            choose = r.nextInt(54)+1;
            System.out.println("chooseCard is:  "+choose);
            num = num + choose;
        }
        return chooseCard = num;
    }

    public void interpCards(int numCard){
        for(int i =0; i <52; i++){
            //if (i = ecards)
        }
    }
}
