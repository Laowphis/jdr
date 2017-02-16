package com.example.e1302027.projetandroidjdr.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jonathan on 08/11/2016.
 */

public class Character implements Parcelable {

    private String Name;
    private String Race;
    private String Classe;
    private int Force;
    private int ForceMental;
    private int Charisme;
    private int Chance;
    private int Inteligence;
    private int Endurance;
    private int Cc;
    private int Ct;
    private int Agilite;

    public Character(String name, String race, String classe, int force, int forceMental, int charisme, int chance, int inteligence, int endurance, int cc, int ct, int agilite) {
        this.Name = name;
        this.Race = race;
        this.Classe = classe;
        this.Force = force;
        this.ForceMental = forceMental;
        this.Charisme = charisme;
        this.Chance = chance;
        this.Inteligence = inteligence;
        this.Endurance = endurance;
        this.Cc = cc;
        this.Ct = ct;
        this.Agilite = agilite;
    }

    /*protected Character(Parcel in) {
        Name = in.readString();
        Race = in.readString();
        Classe = in.readString();
        Force = in.readInt();
        ForceMental = in.readInt();
        Charisme = in.readInt();
        Chance = in.readInt();
        Inteligence = in.readInt();
        Endurance = in.readInt();
        Cc = in.readInt();
        Ct = in.readInt();
        Agilite = in.readInt();
    }*/

    public String getName() { return Name; }

    public void setName(String name) {
        Name = name;
    }

    public String getRace() {
        return Race;
    }

    public void setRace(String race) {
        Race = race;
    }

    public String getClasse() {
        return Classe;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }

    public int getForce() {
        return Force;
    }

    public void setForce(int force) {
        Force = force;
    }

    public int getForceMental() {
        return ForceMental;
    }

    public void setForceMental(int forceMental) {
        ForceMental = forceMental;
    }

    public int getCharisme() {
        return Charisme;
    }

    public void setCharisme(int charisme) {
        Charisme = charisme;
    }

    public int getChance() {
        return Chance;
    }

    public void setChance(int chance) {
        Chance = chance;
    }

    public int getInteligence() {
        return Inteligence;
    }

    public void setInteligence(int inteligence) {
        Inteligence = inteligence;
    }

    public int getEndurance() {
        return Endurance;
    }

    public void setEndurance(int endurance) {
        Endurance = endurance;
    }

    public int getCc() {
        return Cc;
    }

    public void setCc(int cc) {
        Cc = cc;
    }

    public int getCt() {
        return Ct;
    }

    public void setCt(int ct) {
        Ct = ct;
    }

    public int getAgilite() {
        return Agilite;
    }

    public void setAgilite(int agilite) {
        Agilite = agilite;
    }


    static Parcelable.Creator<Character> CREATOR = new Parcelable.Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel source) {

            String Name = source.readString();
            String Race = source.readString();
            String Classe = source.readString();
            int Force = source.readInt();
            int ForceMental = source.readInt();
            int Charisme = source.readInt();
            int Chance = source.readInt();
            int Inteligence = source.readInt();
            int Endurance = source.readInt();
            int Cc = source.readInt();
            int Ct = source.readInt();
            int Agilite = source.readInt();

            return new Character(Name, Race,Classe, Force, ForceMental, Charisme, Chance, Inteligence, Endurance, Cc, Ct, Agilite);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Race);
        dest.writeString(Classe);
        dest.writeInt(Force);
        dest.writeInt(ForceMental);
        dest.writeInt(Charisme);
        dest.writeInt(Chance);
        dest.writeInt(Inteligence);
        dest.writeInt(Endurance);
        dest.writeInt(Cc);
        dest.writeInt(Ct);
        dest.writeInt(Agilite);
    }

    @Override
    public String toString() {
        return "Char{" +
                "name='" + Name + '\'' +
                ", race='" + Race + '\'' +
                ", classe=" + Classe + '\'' +
                ", cc='" + Cc + '\'' +
                ", ct='" + Ct + '\'' +
                ", force='" + Force + '\'' +
                ", agilite='" + Agilite + '\'' +
                ", endurance='" + Endurance + '\'' +
                ", charisme='" + Charisme + '\'' +
                ", intelignec='" + Inteligence + '\'' +
                ", forcemental='" + ForceMental + '\'' +
                ", chance='" + Chance + '\'' +
                '}';
    }

}
