package com.example.reto2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.reto2.R;

public class MyPokemonActivity extends AppCompatActivity {

    private EditText catchPokemonET;
    private Button catchBtn;
    private TextView myPokemonTV;
    private ConstraintLayout pokemonSearchCL;
    private Button searchBtn;
    private EditText searchET;
    private RecyclerView pokemonList;

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
    }
}