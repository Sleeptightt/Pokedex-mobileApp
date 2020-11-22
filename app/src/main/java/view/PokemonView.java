package view;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reto2.R;
import com.example.reto2.activities.PokemonDetailActivity;

public class PokemonView extends RecyclerView.ViewHolder implements View.OnClickListener{

    private ConstraintLayout root;
    private ImageView pokemonSprite;
    private TextView pokemonName;

    public PokemonView(ConstraintLayout root) {
        super(root);
        this.root = root;
        this.root.setOnClickListener(this);
        pokemonSprite = root.findViewById(R.id.pokemonSprite);
        pokemonName = root.findViewById(R.id.pokemonName);
    }

    public ConstraintLayout getRoot() {
        return root;
    }

    public ImageView getPokemonSprite() {
        return pokemonSprite;
    }

    public TextView getPokemonName() {
        return pokemonName;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.root:
                Intent i = new Intent(root.getContext(), PokemonDetailActivity.class);
                i.putExtra("pokemon", pokemonName.getText().toString());
                root.getContext().startActivity(i);
                break;
        }
    }
}
