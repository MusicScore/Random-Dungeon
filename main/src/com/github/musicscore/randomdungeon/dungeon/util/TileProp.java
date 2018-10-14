package com.github.musicscore.randomdungeon.dungeon.util;

public interface TileProp {

    // Using this interface primarily to mark which classes are TileProps.

    /**
     * Returns the TilePropType of the prop.
     * @return The TilePropType of the prop.
     */
    TilePropType getPropType();

}
