package com.github.musicscore.randomdungeon.dungeon;

import com.github.musicscore.randomdungeon.dungeon.util.TileProp;
import com.github.musicscore.randomdungeon.dungeon.util.TileType;

// TODO[#0004]
// Refine the tile data processing. More methods/instancing fields as needed.

public class Tile {

    private int tileX, tileY;
    private TileType tileType;
    private TileProp tileProp;

    /**
     * Creates a new Tile object.
     * @param x The x coordinate of the tile.
     * @param y The y coordinate of the tile.
     */
    public Tile(int x, int y) {
        this(x, y, TileType.VOID);
    }


    /**
     * Creates a new Tile object with a specific TileType.
     * @param x The x coordinate of the tile.
     * @param y The y coordinate of the tile.
     * @param type The TileType of the tile.
     */
    public Tile(int x, int y, TileType type) {
        this.tileX = Math.max(x, -1);
        this.tileY = Math.max(y, -1);
        this.tileType = type;
    }

    /**
     * Returns the x coordinate of the tile.
     * @return The x coordinate of the tile.
     */
    public int getTileX() {
        return tileX >= 0 ? tileX : -1;
    }

    /**
     * Returns the y coordinate of the tile.
     * @return The y coordinate of the tile.
     */
    public int getTileY() {
        return tileY >= 0 ? tileY : -1;
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
