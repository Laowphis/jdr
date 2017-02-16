package com.example.e1302027.projetandroidjdr;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.e1302027.projetandroidjdr.model.Char;
import com.example.e1302027.projetandroidjdr.model.Character;

import java.util.List;

/**
 * Created by jonathan on 24/01/2017.
 */
public class ViewCharActivity extends AppCompatActivity {

    private static final int MAIN_MENU = 1;

    private Char model;
    private static final int ADD_CONTACT = 1;
    private static final int EDIT_CONTACT = 2;
    private ListView listCharacter;
    private CharacterAdapter adapter;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);

        Button buttonReturn = (Button) findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, MAIN_MENU);
            }
        });

        model = new Char();
        model.populate();

        listCharacter = (ListView) findViewById(R.id.ListViewChar);
        adapter = new ViewCharActivity.CharacterAdapter(getApplicationContext(), model.getCharacter());
        listCharacter.setAdapter(adapter);
        listCharacter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ViewCharActivity.class);
                Character character = model.getCharacter().get((int) id);

                character.toString();

                intent.putExtra("character", character);
                intent.putExtra("id", id);
                startActivityForResult(intent, EDIT_CONTACT);
            }
        });

    }

    public class CharacterAdapter extends ArrayAdapter<Character> {

        class ViewHolder {
            TextView name;
            TextView race;
            TextView classe;
            TextView force;
            TextView forcemental;
            TextView charisme;
            TextView chance;
            TextView inteligence;
            TextView endurance;
            TextView cc;
            TextView ct;
            TextView agilite;
        }

        public CharacterAdapter(Context context, List<Character> list) {
            super(context, android.R.layout.simple_list_item_1, list);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.character_items, null);
                holder = new ViewCharActivity.CharacterAdapter.ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.tName);
                holder.race = (TextView) convertView.findViewById(R.id.tRace);
                holder.classe = (TextView) convertView.findViewById(R.id.tClasse);
                holder.force = (TextView) convertView.findViewById(R.id.tforce);
                holder.forcemental = (TextView) convertView.findViewById(R.id.tFm);
                holder.charisme = (TextView) convertView.findViewById(R.id.tCha);
                holder.chance = (TextView) convertView.findViewById(R.id.tCh);
                holder.inteligence = (TextView) convertView.findViewById(R.id.tInt);
                holder.endurance = (TextView) convertView.findViewById(R.id.tend);
                holder.cc = (TextView) convertView.findViewById(R.id.tCc);
                holder.ct = (TextView) convertView.findViewById(R.id.tCt);
                holder.agilite = (TextView) convertView.findViewById(R.id.tagilite);
                convertView.setTag(holder);
            } else {
                holder = (ViewCharActivity.CharacterAdapter.ViewHolder) convertView.getTag();
            }

            Character character = getItem(position);

            character.toString();

            holder.name.setText(character.getName());
            holder.race.setText(character.getRace());
            holder.classe.setText(character.getClasse());
            holder.force.setText(String.valueOf(character.getForce()));
            holder.forcemental.setText(String.valueOf(character.getForceMental()));
            holder.charisme.setText(String.valueOf(character.getCharisme()));
            holder.chance.setText(String.valueOf(character.getChance()));
            holder.inteligence.setText(String.valueOf(character.getInteligence()));
            holder.endurance.setText(String.valueOf(character.getEndurance()));
            holder.cc.setText(String.valueOf(character.getCc()));
            holder.ct.setText(String.valueOf(character.getCt()));
            holder.agilite.setText(String.valueOf(character.getAgilite()));
            return convertView;
        }
    }

}
