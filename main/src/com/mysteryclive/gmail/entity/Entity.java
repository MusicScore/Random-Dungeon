package com.mysteryclive.gmail.entity;

import java.util.HashSet;

import com.mysteryclive.gmail.entity.EntityType;
import com.mysteryclive.gmail.itemHandler.ItemClass;

public class Entity {

    public HashSet<ItemClass> dropList = new HashSet<>();
    public EntityType entityType;
    public double health, atk, def, luck, reflect, dodge, fire_affinity, ice_affinity,
            earth_affinity, light_affinity, dark_affinity;

    public Entity() {
    }

    public Entity(EntityType type, double maxHealth, double statATK, double statDEF, double statLUC, double statREFLECT,
                  double statDODGE, double statFIRE, double statICE, double statEARTH, double statLIGHT,
                  double statDARK) {
        entityType = type;
        health = maxHealth;
        atk = statATK;
        def = statDEF;
        luck = statLUC;
        reflect = statREFLECT;
        dodge = statDODGE;
        fire_affinity = statFIRE;
        ice_affinity = statICE;
        earth_affinity = statEARTH;
        light_affinity = statLIGHT;
        dark_affinity = statDARK;
    }

    public Entity(EntityType type, double maxHealth, double statATK, double statDEF, double statLUC, double statREFLECT,
                  double statDODGE, double statFIRE, double statICE, double statEARTH, double statLIGHT,
                  double statDARK, HashSet<ItemClass> drops) {
        this(type, maxHealth, statATK, statDEF, statLUC, statREFLECT, statDODGE, statFIRE, statICE, statEARTH, statLIGHT, statDARK);
        dropList = drops;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double newHP) {
        health = newHP;
    }

}
