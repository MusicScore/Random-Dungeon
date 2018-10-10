package com.mysteryclive.gmail.randomdungeon.entity;

public enum EntityType {
    PLAYER,
    NORMAL,
    BOSS;

    public boolean hasDropTable() {
        return this != PLAYER;
    }

}
