package com.mysteryclive.gmail.dungeonGeneration;

import com.mysteryclive.gmail.dungeonGeneration.util.TilePropType;

public class TileProp {

    private TilePropType type;

    public TileProp(TilePropType propType) {
        type = propType;
    }

    public TilePropType getType() {
        return type;
    }

}
