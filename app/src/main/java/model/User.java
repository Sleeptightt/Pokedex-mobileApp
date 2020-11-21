package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class User implements Serializable {
    private String id;
    private String username;
    private List<String> myPokemons;

    public User() {
    }

    public User(String id, String username) {
        this.myPokemons = new ArrayList<>();
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getMyPokemons() {
        return myPokemons;
    }

    public void setMyPokemons(List<String> myPokemons) {
        this.myPokemons = myPokemons;
    }
}