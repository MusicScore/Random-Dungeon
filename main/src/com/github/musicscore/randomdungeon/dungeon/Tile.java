package com.github.musicscore.randomdungeon.dungeon;

import com.github.musicscore.randomdungeon.dungeon.util.TileProp;
import com.github.musicscore.randomdungeon.dungeon.util.TileType;

// TODO[#0004]
// Refine the tile data processing. More methods/instancing fields as needed.

public class Tile {

    private TileType tileType;
    private TileProp tileProp;

    /**
     * Creates a new Tile object with a specific TileType.
     * @param type The TileType of the tile.
     */
    public Tile(TileType type) {
        tileType = type;
    }

    /**
     * Creates a new Tile object with a specific TileType.
     * @param type The TileType of the tile.
     */
    public Tile(TileType type, TileProp prop) {
        tileType = type;
        tileProp = prop;
    }

    /**
     * Sets the tile's TileType.
     * @param type The new TileType.
     */
    public void setTileType(TileType type) {
        tileType = type;
    }

    /**
     * Returns the TileType of the Tile object.
     * @return The TileType of the Tile object.
     */
    public TileType getTileType() {
        return tileType;
    }

    /**
     * Returns the TileProp object assigned to the tile.
     * @return The TileProp object assigned to the tile.
     */
    public TileProp getTileProp() {
        return tileProp;
    }

    /**
     * Assigns a TileProp object to the tile.
     * @param newProp The TileProp object to add to the tile.
     */
    public void setTileProp(TileProp newProp) {
        tileProp = newProp;
    }

}
