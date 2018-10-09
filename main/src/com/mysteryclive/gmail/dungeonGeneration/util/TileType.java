package com.mysteryclive.gmail.dungeonGeneration.util;

public enum TileType {
    VOID,
    WALL,
    FLOOR;

    public boolean isPassable() {
        return this == TileType.FLOOR;
    }

}