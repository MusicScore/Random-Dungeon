package com.mysteryclive.gmail.dungeonGeneration.util;

import java.security.SecureRandom;

public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    public static Direction getRandomDirection() {
        SecureRandom rnd = new SecureRandom();
        return Direction.values()[rnd.nextInt(4)];
    }

    public int[] asOffset() {
        switch (this) {
            case NORTH:
                return new int[]{0,1};
            case SOUTH:
                return new int[]{0,-1};
            case EAST:
                return new int[]{1,0};
            case WEST:
                return new int[]{-1,0};
            default:
                return null;
        }
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
