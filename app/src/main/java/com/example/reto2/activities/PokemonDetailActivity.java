package com.example.reto2.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
import model.User;

public class PokemonDetailActivity extends AppCompatActivity implements View.OnClickListener{

    private Pokemon pokemon;
    private String userId;
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

        userId = getIntent().getExtras().getString("userId");

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.freeBtn:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setTitle("Liberar Pokemon");
                builder.setMessage("¿Estás seguro de que quieres liberar a este pokemon?");
                builder.setPositiveButton("Confirmar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Query q = db.collection("users").whereEqualTo("id", userId);
                                q.get().addOnCompleteListener(task -> {
                                    if(task.isSuccessful()){
                                        User user = null;
                                        for(QueryDocumentSnapshot document : task.getResult()){
                                            user = document.toObject(User.class);
                                            break;
                                        }
                                        user.getMyPokemons().remove(pokemon.getName());
                                        db.collection("users").document(user.getId()).set(user);
                                        finish();
                                    }
                                });
                            }
                        });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //nada
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
                break;
        }
    }
}