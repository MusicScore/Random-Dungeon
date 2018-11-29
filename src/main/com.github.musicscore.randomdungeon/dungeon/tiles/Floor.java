package com.github.musicscore.randomdungeon.dungeon.tiles;

import com.github.musicscore.randomdungeon.dungeon.Tile;

public class Floor implements Tile {

    /**
     * Returns whether the Floor is passable.
     * @return Always returns true.
     */
    public boolean isPassable() {
        return true;
    }

}
