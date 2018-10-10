package com.mysteryclive.gmail.dungeon;

import com.mysteryclive.gmail.dungeon.util.TilePropType;

public class TileProp {

    private TilePropType type;

    public TileProp(TilePropType propType) {
        type = propType;
    }

    public TilePropType getType() {
        return type;
    }

}
