package com.github.musicscore.randomdungeon.dungeon.tileprop;

import com.github.musicscore.randomdungeon.dungeon.util.TileProp;
import com.github.musicscore.randomdungeon.dungeon.util.TilePropType;


public class Exit implements TileProp {

    private TilePropType tilePropType;

    public Exit(TilePropType exitType) {
        tilePropType = exitType;
    }

    public TilePropType getPropType() {
        return tilePropType;
    }
}
