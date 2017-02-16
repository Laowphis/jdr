package com.example.e1302027.projetandroidjdr.model;

/**
 * Created by jonathan on 08/11/2016.
 */

public enum ECards {
ECards;
    enum Rank{
        Ace(1),
        Two(2),
        Three(3),
        Four(4),
        Five(5),
        Six(6),
        Seven(7),
        Eight(8),
        Nine(9),
        Ten(10),
        Jack(11),
        Queen(12),
        King(13);

        private int rank = 0;
        Rank(int rank) {
            this.rank = rank;
        }
    }

    enum Suits{
        Hearts,
        Spades,
        Diamond,
        Clubs;
    }

}
