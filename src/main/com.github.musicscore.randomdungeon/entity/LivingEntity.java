package com.github.musicscore.randomdungeon.entity;

import java.util.HashSet;
import java.util.HashMap;

import com.github.musicscore.randomdungeon.item.Item;

public abstract class LivingEntity implements Entity {

    public enum Statistic {
        HP,
        ATK,
        DEF,
        LUC,
        DODGE,
        REFLECT,
        FIRE,
        ICE,
        EARTH,
        LIGHT,
        DARK
    }

    private HashSet<Item> dropList = new HashSet<>();
    private HashMap<Statistic, Double> statList = new HashMap<>();

    public LivingEntity(double maxHealth, double statATK, double statDEF, double statLUC, double statDODGE,
                        double statREFLECT, double statFIRE, double statICE, double statEARTH, double statLIGHT, double statDARK) {
        statList.put(Statistic.HP, maxHealth);
        statList.put(Statistic.ATK, maxHealth);
        statList.put(Statistic.DEF, maxHealth);
        statList.put(Statistic.LUC, maxHealth);
        statList.put(Statistic.DODGE, maxHealth);
        statList.put(Statistic.REFLECT, maxHealth);
        statList.put(Statistic.FIRE, maxHealth);
        statList.put(Statistic.ICE, maxHealth);
        statList.put(Statistic.EARTH, maxHealth);
        statList.put(Statistic.LIGHT, maxHealth);
        statList.put(Statistic.DARK, maxHealth);
    }

    public double getStat(Statistic stat) {
        return statList.get(stat);
    }

}
