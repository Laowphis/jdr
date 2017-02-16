package com.example.e1302027.projetandroidjdr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonathan on 23/01/2017.
 */

public class Char {

    private List<Character> character;

    public List<Character> getCharacter() {
        if (character == null) character = new ArrayList<>();
        return character;
    }
//force, forcemental, charisme, chance, inte, endu, cc, ct, agi
    public void populate () {
        getCharacter().add(new Character("Borli", "Nain", "Guerrier", 48,48,45,51,30,33,45,39,51));
        toString();
        /*getCharacter().add(new Character());
        getCharacter().add(new Character());*/
    }

}
