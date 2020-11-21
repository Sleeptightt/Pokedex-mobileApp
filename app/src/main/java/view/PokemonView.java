package view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reto2.R;

public class PokemonView extends RecyclerView.ViewHolder {

    private ConstraintLayout root;
    private ImageView pokemonSprite;
    private TextView pokemonName;

    public PokemonView(ConstraintLayout root) {
        super(root);
        this.root = root;
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
}
