package com.github.musicscore.randomdungeon.dungeon;

public interface Tile {

    /**
     * Returns whether or not the Tile is passable.
     * @return True if the Tile can be walked on, false if it cannot be walked on.
     */
    boolean isPassable();

}
