package com.github.musicscore.randomdungeon.dungeon;

import com.github.musicscore.randomdungeon.dungeon.util.TilePropType;

public class TileProp {

    private TilePropType type;

    public TileProp(TilePropType propType) {
        type = propType;
    }

    public TilePropType getType() {
        return type;
    }

}