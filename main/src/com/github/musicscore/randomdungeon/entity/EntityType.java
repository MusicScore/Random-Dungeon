package com.github.musicscore.randomdungeon.entity;

public enum EntityType {
    PLAYER,
    NORMAL,
    BOSS;

    public boolean hasDropTable() {
        return this != PLAYER;
    }

}
