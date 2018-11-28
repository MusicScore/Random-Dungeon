package com.github.musicscore.randomdungeon.dungeon.util;

import java.util.Random;

public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    private static Random rnd = new Random();
    public static Direction getRandomDirection() {
        return Direction.values()[rnd.nextInt(4)];
    }

    public int asYOffset() {
        if (this == Direction.NORTH) {
            return 1;
        }
        else if (this == Direction.SOUTH) {
            return -1;
        }
        return 0;
    }

    public int asXOffset() {
        if (this == Direction.EAST) {
            return 1;
        }
        else if (this == Direction.WEST) {
            return -1;
        }
        return 0;
    }

}
