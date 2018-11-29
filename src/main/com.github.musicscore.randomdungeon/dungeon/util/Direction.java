package com.github.musicscore.randomdungeon.dungeon.util;

import java.util.Random;

public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    private static Random rnd = new Random();

    public static Direction getRandomDirection() {
        return Direction.values()[rnd.nextInt(4)];
    }

    public int asYOffset() {
        switch (this) {
            case NORTH:
                return 1;
            case SOUTH:
                return -1;
            default:
                return 0;
        }
    }

    public int asXOffset() {
        switch (this) {
            case EAST:
                return 1;
            case WEST:
                return -1;
            default:
                return 0;
        }
    }

}
