package com.github.musicscore.randomdungeon.dungeon.tiles;

import com.github.musicscore.randomdungeon.dungeon.Tile;
import com.github.musicscore.randomdungeon.dungeon.prop.Prop;

public class Floor implements Tile {

    private Prop prop;

    /**
     * Returns whether the Floor is passable.
     * @return Always returns true.
     */
    public boolean isPassable() {
        return true;
    }

    public Prop getProp() {
        return prop;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }

}
