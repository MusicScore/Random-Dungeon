package com.mysteryclive.gmail.entity.specialEntity;

import java.util.ArrayList;
import java.util.HashMap;

import com.mysteryclive.gmail.entity.Entity;
import com.mysteryclive.gmail.entity.EntityType;
import com.mysteryclive.gmail.itemHandler.ItemClass;

public class Player extends Entity {

    private ArrayList<ItemClass> inventoryContents = new ArrayList<>();
    private HashMap<String, ItemClass> equipmentContents = new HashMap<>();

    public Player(double maxHealth, double statATK, double statDEF, double statLUC, double statREFLECT,
                  double statDODGE, double statFIRE, double statICE, double statEARTH, double statLIGHT,
                  double statDARK) {
        super(EntityType.PLAYER, maxHealth, statATK, statDEF, statLUC, statDODGE, statREFLECT, statFIRE, statICE, statEARTH, statLIGHT, statDARK);
    }

}
