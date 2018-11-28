package com.github.musicscore.randomdungeon.entity;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.musicscore.randomdungeon.item.Item;

public class PlayerEntity extends LivingEntity {

    private ArrayList<Item> inventoryContents = new ArrayList<>();
    private HashMap<String, Item> equipmentContents = new HashMap<>();

    public PlayerEntity(double maxHealth, double statATK, double statDEF, double statLUC, double statREFLECT,
                        double statDODGE, double statFIRE, double statICE, double statEARTH, double statLIGHT,
                        double statDARK) {
        super(maxHealth, statATK, statDEF, statLUC, statDODGE, statREFLECT, statFIRE, statICE, statEARTH, statLIGHT, statDARK);
    }

    public double getHealth() {
        return 0;
    }

    public void setHealth() {
        // TODO: Fill this in
    }

    // TODO: Make a player.

}
