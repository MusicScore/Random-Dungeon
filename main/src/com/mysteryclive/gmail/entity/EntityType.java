package com.mysteryclive.gmail.entity;

public enum EntityType {
    PLAYER,
    NORMAL,
    BOSS;

    public boolean hasDropTable() {
        return this != PLAYER;
    }

}
