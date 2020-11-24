package com.example.reto2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reto2.R;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import comm.HTTPSWebUtilDomi;
import model.Pokemon;
import model.User;
import modelAPI.PokemonAPI;
import modelAPI.Type;
import view.PokemonAdapter;

public class MyPokemonActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText catchPokemonET;
    private Button catchBtn;
    private TextView myPokemonTV;
    private ConstraintLayout pokemonSearchCL;
    private LinearLayoutManager layoutManager;
    private PokemonAdapter adapter;
    private Button searchBtn;
    private EditText searchET;
    private User myUser;
    private RecyclerView pokemonList;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pokemon);

        catchPokemonET = findViewById(R.id.catchPokemonET);
        catchBtn = findViewById(R.id.catchBtn);
        myPokemonTV = findViewById(R.id.myPokemonTV);
        pokemonSearchCL = findViewById(R.id.pokemonSearchCL);
        searchBtn = findViewById(R.id.searchBtn);
        searchET = findViewById(R.id.searchET);
        pokemonList = findViewById(R.id.pokemonList);

        myUser = (User) getIntent().getExtras().getSerializable("myUser");

        pokemonList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        pokemonList.setLayoutManager(layoutManager);
        adapter = new PokemonAdapter();
        adapter.setUser(myUser.getId());
        pokemonList.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();

        catchBtn.setOnClickListener(this);
        searchBtn.setOnClickListener(this);

        loadMyPokemons();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadMyPokemons();
    }

    public void loadMyPokemons(){
        Query query = db.collection("users").whereEqualTo("id", myUser.getId());
        query.get().addOnCompleteListener( task -> {
            if(task.isSuccessful()){
                for(QueryDocumentSnapshot document : task.getResult()){
                    myUser = document.toObject(User.class);
                }
            }
            ArrayList<Pokemon> pokemons = new ArrayList<>();
            if(!myUser.getMyPokemons().isEmpty()){
                for(int i = 0; i < myUser.getMyPokemons().size(); i++){
                    Query q = db.collection("pokemon").whereEqualTo("name", myUser.getMyPokemons().get(i));
                    q.get().addOnCompleteListener(tsk ->{
                        if(tsk.isSuccessful()){
                            for(QueryDocumentSnapshot dc : tsk.getResult()){
                                Pokemon pokemon = dc.toObject(Pokemon.class);
                                pokemons.add(pokemon);
                            }
                                adapter.clear();
                                adapter.addPokemons(pokemons);
                        }
                    });
                }

            }

        });

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.catchBtn:
                String name = catchPokemonET.getText().toString()
                        .toLowerCase()
                        .replaceAll(" ", "");
                if (myUser.getMyPokemons().contains(name)) {
                    Toast.makeText(this, "Ya tienes a este Pokemon!", Toast.LENGTH_LONG).show();
                } else {
                    Query query = db.collection("pokemon").whereEqualTo("name", name);
                    query.get().addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            if (task.getResult().size() > 0) {
                                for(QueryDocumentSnapshot document : task.getResult()){
                                    Pokemon pokemon = document.toObject(Pokemon.class);
                                    myUser.getMyPokemons().add(pokemon.getName());
                                    db.collection("users").document(myUser.getId()).set(myUser);
                                    adapter.addPokemon(pokemon);
                                    Toast.makeText(this, "¡Enhorabuena! Has atrapado a " + pokemon.getName(), Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            } else
                                getPokemonFromAPI(name);

                        } else
                            Toast.makeText(this, "No se encontró el pokemon especificado", Toast.LENGTH_SHORT).show();
                    });
                }
                break;
            case R.id.searchBtn:

                break;
        }
    }

    public void getPokemonFromAPI(String name) {
        if(!name.isEmpty()) {
            new Thread(() -> {
                HTTPSWebUtilDomi https = new HTTPSWebUtilDomi();
                Gson gson = new Gson();
                String json = https.GETrequest("https://pokeapi.co/api/v2/pokemon/" + name + "/");
                PokemonAPI pokemon = gson.fromJson(json, PokemonAPI.class);
                if (pokemon != null) {
                    ArrayList<String> types = new ArrayList<>();
                    for (Type type : pokemon.getTypes())
                        types.add(type.getType().getName());
                    String sprite = pokemon.getSprites().getFrontDefault();
                    int def = pokemon.getStats().get(2).getBaseStat(),
                            attack = pokemon.getStats().get(1).getBaseStat(),
                            speed = pokemon.getStats().get(5).getBaseStat(),
                            hp = pokemon.getStats().get(0).getBaseStat();
                    Pokemon cPokemon = new Pokemon(name, types, sprite, def, attack, speed, hp);
                    myUser.getMyPokemons().add(cPokemon.getName());
                    db.collection("pokemon").document(name).set(cPokemon);
                    db.collection("users").document(myUser.getId()).set(myUser);
                    runOnUiThread(() -> adapter.addPokemon(cPokemon));
                    runOnUiThread(() -> Toast.makeText(this, "¡Enhorabuena! Has atrapado a " + name, Toast.LENGTH_SHORT).show());
                } else
                    runOnUiThread(() -> Toast.makeText(this, "El pokemon que quieres atrapar no existe", Toast.LENGTH_LONG).show());
            }).start();
        }else{
            Toast.makeText(this, "No ingresaste ningún Pokemon :(", Toast.LENGTH_SHORT).show();
        }
    }
}