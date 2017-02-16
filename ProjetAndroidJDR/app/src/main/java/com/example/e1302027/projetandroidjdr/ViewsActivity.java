package com.example.e1302027.projetandroidjdr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jonathan on 08/11/2016.
 */
public class ViewsActivity extends AppCompatActivity {

    private static final int MAIN_MENU = 1;

    private Char model;
    private static final int ADD_CONTACT = 1;
    private static final int EDIT_CONTACT = 2;
    private ListView listCharacter;
    private CharacterAdapter adapter;
    private Character character;
    private  String name;
    private  String race;
    private  String classe;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);

//        if(savedInstanceState ==null){
//            Bundle extras = getIntent().getExtras();
//            if (extras == null) {
//                name=null;
//                race=null;
//                classe=null;
//
//            }
//            else{
//                name = extras.getString("name");
//                race = extras.getString("race");
//                classe = extras.getString("classe");
//            }
//        }
//        else{
//            name=(String)savedInstanceState.getSerializable("name");
//            race=(String)savedInstanceState.getSerializable("race");
//            classe=(String)savedInstanceState.getSerializable("classe");
//        }
//
//
//        // Get data via the key
//
//            TextView nameEdit = (TextView) findViewById(R.id.tName);
//            nameEdit.setText(name);
//
//            TextView raceEdit = (TextView) findViewById(R.id.tRace);
//            raceEdit.setText(race);
//
//            TextView classeEdit = (TextView) findViewById(R.id.tClasse);
//            classeEdit.setText(classe);


//        Intent intent = getIntent();
//        if(intent.hasExtra("character")){
//            character = intent.getParcelableExtra("character");
//
//            TextView nameEdit = (TextView) findViewById(R.id.tName);
//            nameEdit.setText(character.getName());
//            TextView raceEdit = (TextView) findViewById(R.id.tRace);
//            raceEdit.setText(character.getRace());
//            TextView classeEdit = (TextView) findViewById(R.id.tClasse);
//            classeEdit.setText(character.getClasse());
//
//
//        }

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

        Intent test = getIntent();
        System.out.println("character : " + test.getParcelableExtra("character"));

        listCharacter = (ListView) findViewById(R.id.ListViewChar);
        adapter = new CharacterAdapter(getApplicationContext(), model.getCharacter());
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
        listCharacter.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                model.getCharacter().remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

    }

    public class CharacterAdapter extends ArrayAdapter<Character> {

        class ViewHolder {
            TextView name;
            TextView race;
            TextView classe;
        }

        public CharacterAdapter(Context context, List<Character> list) {
            super(context, android.R.layout.simple_list_item_1, list);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.characters_items, null);
                holder = new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.tName);
                holder.race = (TextView) convertView.findViewById(R.id.tRace);
                holder.classe = (TextView) convertView.findViewById(R.id.tClasse);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Character character = getItem(position);

            character.toString();

            holder.name.setText(character.getName());
            holder.race.setText(character.getRace());
            holder.classe.setText(character.getClasse());
            return convertView;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_CONTACT && resultCode == RESULT_OK) {
            /*Character character = data.getParcelableExtra("contact");*/
            String name = data.getParcelableExtra("name");
            String race = data.getParcelableExtra("race");
            String classe = data.getParcelableExtra("classe");
            String force = data.getParcelableExtra("force");
            String forcemental = data.getParcelableExtra("forcemental");
            String agilite = data.getParcelableExtra("agilite");
            String endurance = data.getParcelableExtra("endurance");
            String inteligence = data.getParcelableExtra("inteligence");
            String cc = data.getParcelableExtra("cc");
            String ct = data.getParcelableExtra("ct");
            String charisme = data.getParcelableExtra("charisme");
            String chance = data.getParcelableExtra("chance");


//            SharedPreferences sp = getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
//            String name = null, race = null, classe = null, force = null, forcemental = null, agilite = null, endurance = null, inteligence = null, cc = null, ct = null, charisme = null, chance = null;
//            name = sp.getString("name", name);
//            race = sp.getString("race", race);
//            classe = sp.getString("classe", classe);
//            force = sp.getString("force", force);
//            forcemental = sp.getString("forcemental", forcemental);
//            agilite = sp.getString("agilite", agilite);
//            endurance = sp.getString("endurance", endurance);
//            inteligence = sp.getString("inteligence", inteligence);
//            cc = sp.getString("cc", cc);
//            ct = sp.getString("ct", ct);
//            charisme = sp.getString("charisme", charisme);
//            chance = sp.getString("chance", chance);

            Character character = new Character(name, race, classe, Integer.getInteger(force), Integer.getInteger(forcemental), Integer.getInteger(charisme), Integer.getInteger(chance), Integer.getInteger(inteligence), Integer.getInteger(endurance), Integer.getInteger(cc), Integer.getInteger(ct), Integer.getInteger(agilite));
            model.getCharacter().add(character);
            adapter.notifyDataSetChanged();
        }
        if (requestCode == EDIT_CONTACT && resultCode == RESULT_OK) {
            Character character = data.getParcelableExtra("character");
            long id = data.getLongExtra("id", -1);
            if (id != -1) {
                model.getCharacter().remove((int) id);
                model.getCharacter().add(character);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
