package com.github.musicscore.randomdungeon.dungeon.util;

public enum TileType {
    VOID,
    WALL,
    FLOOR;

    public boolean isPassable() {
        return this == TileType.FLOOR;
    }

}