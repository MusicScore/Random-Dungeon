package com.github.musicscore.randomdungeon.dungeon.tiles;

import com.github.musicscore.randomdungeon.dungeon.Tile;

public class Wall implements Tile {

    private boolean breakable;

    /**
     * Creates a new, unbreakable Wall.
     */
    public Wall() {
        this(false);
    }

    /**
     * Creates a new Wall.
     * @param breakable Sets if the Wall should be breakable.
     */
    public Wall(boolean breakable) {
        this.breakable = breakable;
    }

    /**
     * Returns whether the Wall is passable.
     * @return Always returns false.
     */
    public boolean isPassable() {
        return false;
    }

    /**
     * Returns whether the Wall is breakable.
     * @return <code>true</code> if the Wall is breakable, <code>false</code> if it is not.
     */
    public boolean isBreakable() {
        return breakable;
    }

    /**
     * Sets the breakable state of the Wall.
     * @param breakable Whether the Wall should be breakable.
     */
    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }

}
