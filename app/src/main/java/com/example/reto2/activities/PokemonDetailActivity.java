package com.example.reto2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reto2.R;

public class PokemonDetailActivity extends AppCompatActivity {

    private Button freeBtn;
    private ImageView pokemonThumbnailIV;
    private TextView pokemonNameTypeTV;
    private TextView defenseTitleTV;
    private TextView defenseValueTV;
    private TextView attackValueTV;
    private TextView speedTitleTV;
    private TextView speedValueTV;
    private TextView healthTitleTV;
    private TextView healthValueTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        freeBtn = findViewById(R.id.freeBtn);
        pokemonThumbnailIV = findViewById(R.id.pokemonThumbnailIV);
        pokemonNameTypeTV = findViewById(R.id.pokemonNameTypeTV);
        defenseTitleTV = findViewById(R.id.defenseTitleTV);
        defenseValueTV = findViewById(R.id.defenseValueTV);
        attackValueTV = findViewById(R.id.attackValueTV);
        speedTitleTV = findViewById(R.id.speedTitleTV);
        speedValueTV = findViewById(R.id.speedValueTV);
        healthTitleTV = findViewById(R.id.healthTitleTV);
        healthValueTV = findViewById(R.id.healthValueTV);
    }
}