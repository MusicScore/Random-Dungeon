package com.github.musicscore.randomdungeon.dungeon;

import com.github.musicscore.randomdungeon.dungeon.interfaces.TileGenerator;

/**
 * Represents a room in the generated dungeon.
 */
public class Room implements TileGenerator {

    private int x1, x2, y1, y2;

    /**
     * Constructs a Room given two coordinates, in the form of two pairs of coordinates.
     * @param x1 The X component of the first coordinate.
     * @param y1 The Y component of the first coordinate.
     * @param x2 The X component of the second coordinate.
     * @param y2 The Y component of the second coordinate.
     */
    public Room(int x1, int y1, int x2, int y2) {
        this.x1 = Math.min(x1, x2);
        this.x2 = Math.max(x1, x2);
        this.y1 = Math.min(y1, y2);
        this.y2 = Math.max(y1, y2);
    }

    /**
     * Returns the X component of the minimum coordinate.
     * @return The X component of the coordinate at the lower-left hand side of the room.
     */
    public int getMinX() {
        return x1;
    }

    /**
     * Returns the Y component of the minimum coordinate.
     * @return The Y component of the coordinate at the lower-left hand side of the room.
     */
    public int getMinY() {
        return y1;
    }

    /**
     * Returns the X component of the maximum coordinate.
     * @return The X component of the coordinate at the upper-right hand side of the room.
     */
    public int getMaxX() {
        return x2;
    }

    /**
     * Returns the Y component of the maximum coordinate.
     * @return The Y component of the coordinate at the upper-right hand side of the room.
     */
    public int getMaxY() {
        return y2;
    }

    public void populate() {
        // TODO: Populate the room with tiles
    }
}
