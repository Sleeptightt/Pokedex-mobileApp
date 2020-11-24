package view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.reto2.R;

import java.util.ArrayList;

import model.Pokemon;
import model.User;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonView> {

    private ArrayList<Pokemon> pokemons;
    private String user;

    public PokemonAdapter(){
        this.pokemons = new ArrayList<>();
    }

    public void addPokemons(ArrayList<Pokemon> pokemons){
        this.pokemons.addAll(pokemons);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.pokemonrow,null);
        ConstraintLayout rowroot = (ConstraintLayout) row;
        PokemonView pokemonView = new PokemonView(rowroot);
        return pokemonView;
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonView holder, int position) {
        holder.getPokemonName().setText(pokemons.get(position).getName());
        Glide.with(holder.getRoot()).load(pokemons.get(position).getSprite()).into(holder.getPokemonSprite());
        holder.setUser(this.user);
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }


    public void clear() {
        this.pokemons.clear();
        this.notifyDataSetChanged();
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        this.notifyDataSetChanged();
    }

    public void setUser(String myUser) {
        this.user = myUser;
    }
}
