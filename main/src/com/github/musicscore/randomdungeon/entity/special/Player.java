package com.github.musicscore.randomdungeon.entity.special;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.musicscore.randomdungeon.entity.Entity;
import com.github.musicscore.randomdungeon.entity.EntityType;
import com.github.musicscore.randomdungeon.item.Item;

public class Player extends Entity {

    private ArrayList<Item> inventoryContents = new ArrayList<>();
    private HashMap<String, Item> equipmentContents = new HashMap<>();

    public Player(double maxHealth, double statATK, double statDEF, double statLUC, double statREFLECT,
                  double statDODGE, double statFIRE, double statICE, double statEARTH, double statLIGHT,
                  double statDARK) {
        super(EntityType.PLAYER, maxHealth, statATK, statDEF, statLUC, statDODGE, statREFLECT, statFIRE, statICE, statEARTH, statLIGHT, statDARK);
    }

}
