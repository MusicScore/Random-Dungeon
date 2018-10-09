package com.mysteryclive.gmail.player;

import java.util.ArrayList;

import com.mysteryclive.gmail.itemHandler.ItemClass;

public class Player {

    private ArrayList<ItemClass> inventoryContents = new ArrayList<>();
    private double health;

    public Player(double maxHealth) {
        health = maxHealth;
    }

}
