package com.mysteryclive.gmail.randomdungeon.dungeon;

import com.mysteryclive.gmail.randomdungeon.dungeon.util.TilePropType;

public class TileProp {

    private TilePropType type;

    public TileProp(TilePropType propType) {
        type = propType;
    }

    public TilePropType getType() {
        return type;
    }

}
