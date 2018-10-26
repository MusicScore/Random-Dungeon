package com.github.musicscore.randomdungeon.dungeon;

import com.github.musicscore.randomdungeon.dungeon.util.TileProperty;
import com.github.musicscore.randomdungeon.dungeon.util.TileType;

// TODO: Refine this class in general. It's a mess.

public class Tile {

    // TODO: Figure out how to include obstacles without bloating the Tile class
    private String specialProperty;
    private TileType type;
    private TileProperty property;
    // 0, 4, 8, 12 = direction (N S E W)
    // 0, 2 = breakable/unbreakable
    // 1, 3 = ???
    private byte walls = 0;

    //==============================================
    // Constructors
    //==============================================

    /**
     * Creates a new Tile object with a specific TileType.
     * @param type The TileType of the tile.
     */
    public Tile(TileType type) {
        this.type = type;
    }

    /**
     * Creates a new Tile object with a specific TileType.
     * @param type The TileType of the tile.
     */
    public Tile(TileType type, String specialProperty) {
        this.type = type;
        this.specialProperty = specialProperty;
    }


    //==============================================
    // Instance methods
    //==============================================

    /**
     * Sets the tile's TileType.
     * @param type The new TileType.
     */
    public void setTileType(TileType type) {
        this.type = type;
    }

    /**
     * Returns the TileType of the Tile object.
     * @return The TileType of the Tile object.
     */
    public TileType getTileType() {
        return type;
    }

    /**
     * Returns the TileProp object assigned to the tile.
     * @return The TileProp object assigned to the tile.
     */
    public TileProperty getTilePropType() {
        return property;
    }

    /**
     * Assigns a TileProp object to the tile.
     * @param newProp The TileProp object to add to the tile.
     */
    public void setTileProp(TileProperty newProp) {
        property = newProp;
    }

    public String getSpecialProperty() {
        return this.specialProperty;
    }

    public void setSpecialProperty(String property) {
        this.specialProperty = property;
    }

}
