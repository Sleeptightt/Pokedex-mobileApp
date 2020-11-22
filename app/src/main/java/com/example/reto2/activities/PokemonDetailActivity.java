package com.example.reto2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.reto2.R;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import model.Pokemon;

public class PokemonDetailActivity extends AppCompatActivity implements View.OnClickListener{

    private Pokemon pokemon;
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
    private FirebaseFirestore db;

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

        db = FirebaseFirestore.getInstance();

        String name = getIntent().getExtras().getString("pokemon");
        Query query = db.collection("pokemon").whereEqualTo("name", name);
        query.get().addOnCompleteListener(task -> {
           if(task.isSuccessful()){
               for(QueryDocumentSnapshot document : task.getResult()){
                   pokemon = document.toObject(Pokemon.class);
                   break;
               }
               freeBtn.setOnClickListener(this);
               String url = pokemon.getSprite();
               Glide.with(this).load(url).fitCenter().into(pokemonThumbnailIV);
               pokemonNameTypeTV.setText(pokemon.getName()+"\n("+pokemon.getType().toString().replace("[", "").replace("]","")+")");
               defenseValueTV.setText(pokemon.getDefense()+"");
               attackValueTV.setText(pokemon.getAttack()+"");
               speedValueTV.setText(pokemon.getSpeed()+"");
               healthValueTV.setText(pokemon.getHp()+"");
           }
        });

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.catchBtn:

                break;
        }
    }
}