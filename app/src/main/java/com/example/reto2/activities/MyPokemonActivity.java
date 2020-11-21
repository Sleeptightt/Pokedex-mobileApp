package com.example.reto2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.reto2.R;
import com.google.firebase.firestore.FirebaseFirestore;

import model.User;
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
        pokemonList.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();

        catchBtn.setOnClickListener(this);
        searchBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.catchBtn:

                break;
            case R.id.searchBtn:

                break;
        }
    }
}