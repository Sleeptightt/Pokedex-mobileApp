package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Pokemon implements Serializable {

    private String name;
    private ArrayList<String> types;
    private String sprite;
    private int defense;
    private int attack;
    private int speed;
    private int hp;

    public Pokemon() {
    }

    public Pokemon(String name, ArrayList<String> types, String sprite, int defense, int attack, int speed, int hp) {
        this.name = name;
        this.types = types;
        this.sprite = sprite;
        this.defense = defense;
        this.attack = attack;
        this.speed = speed;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getType() {
        return types;
    }

    public void setType(ArrayList<String> types) {
        this.types = types;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}