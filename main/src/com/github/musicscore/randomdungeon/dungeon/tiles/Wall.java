package com.github.musicscore.randomdungeon.dungeon.tiles;

import com.github.musicscore.randomdungeon.dungeon.Tile;

public class Wall implements Tile {

    private boolean breakable;

    public Wall(boolean breakable) {
        this.breakable = breakable;
    }

    public boolean isPassable() {
        return false;
    }

    public boolean isBreakable() {
        return breakable;
    }

    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }

}
