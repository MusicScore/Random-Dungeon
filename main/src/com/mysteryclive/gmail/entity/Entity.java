package com.mysteryclive.gmail.entity;

import java.util.HashSet;
import java.util.HashMap;

import com.mysteryclive.gmail.item.ItemClass;

public class Entity {

    private HashSet<ItemClass> dropList = new HashSet<>();
    private EntityType entityType;
    private HashMap<EntityStatistic, Double> statList = new HashMap<>();

    public Entity() {
    }

    public Entity(EntityType type, double maxHealth, double statATK, double statDEF, double statLUC, double statDODGE,
                  double statREFLECT, double statFIRE, double statICE, double statEARTH, double statLIGHT, double statDARK) {
        entityType = type;
        statList.put(EntityStatistic.HP, maxHealth);
        statList.put(EntityStatistic.ATK, maxHealth);
        statList.put(EntityStatistic.DEF, maxHealth);
        statList.put(EntityStatistic.LUC, maxHealth);
        statList.put(EntityStatistic.DODGE, maxHealth);
        statList.put(EntityStatistic.REFLECT, maxHealth);
        statList.put(EntityStatistic.FIRE, maxHealth);
        statList.put(EntityStatistic.ICE, maxHealth);
        statList.put(EntityStatistic.EARTH, maxHealth);
        statList.put(EntityStatistic.LIGHT, maxHealth);
        statList.put(EntityStatistic.DARK, maxHealth);
    }

    public Entity(EntityType type, double maxHealth, double statATK, double statDEF, double statLUC, double statDODGE,
                  double statREFLECT,  double statFIRE, double statICE, double statEARTH, double statLIGHT, double statDARK,
                  HashSet<ItemClass> drops) {
        this(type, maxHealth, statATK, statDEF, statLUC, statDODGE, statREFLECT, statFIRE, statICE, statEARTH, statLIGHT, statDARK);
        dropList = drops;
    }

}
