package com.mysteryclive.gmail.dungeonGeneration;

import java.util.ArrayList;

import com.mysteryclive.gmail.dungeonGeneration.util.Direction;
import com.mysteryclive.gmail.dungeonGeneration.util.TileData;
import com.mysteryclive.gmail.dungeonGeneration.util.TileType;

public class DungeonClass {

    private int width, length;
    private double dirPrefFactor;
    private ArrayList<TileData> tileSet = new ArrayList<>();

    public DungeonClass(int gridWidth, int gridLength) {
        this(gridWidth, gridLength, Math.random());
    }

    public DungeonClass(int gridWidth, int gridLength, double preferenceFactor) {
        this.width = gridWidth;
        this.length = gridLength;
        this.dirPrefFactor = preferenceFactor;
        this.generateBlankGrid();
    }

    public void generateBlankGrid() {
        tileSet.clear();
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                tileSet.add(new TileData(new int[]{x, y}));
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public ArrayList<TileData> getAllTiles() {
        return tileSet;
    }

    public void setTile(int x, int y, TileData tile) {
        tileSet.set(x + y * width, tile);
    }

    public TileData getTile(int x, int y) {
        return (x < width && x >= 0 && y < length && y >= 0) ? tileSet.get(x + y * width) : null;
    }

    public TileData tileInDirection(int x, int y, Direction dir) {
        return getTile(x + dir.asXOffset(), y + dir.asYOffset());
    }

    public TileData tileInDirections(int x, int y, Direction[] dir) {
        TileData currentTile = getTile(x, y);
        TileData newCell = null;
        for (Direction val : dir) {
            newCell = tileInDirection(currentTile.getTileX(), currentTile.getTileY(), val);
            currentTile = newCell;
        }
        return newCell;
    }

    public boolean canMakeCorridor(TileData tile) {
        return tile.isEmpty() && tile.getTileID() != null
                && tileInDirections(tile.getTileX(), tile.getTileY(), new Direction[]{Direction.NORTH, Direction.EAST}).getTileType() != TileType.FLOOR
                && tileInDirections(tile.getTileX(), tile.getTileY(), new Direction[]{Direction.NORTH, Direction.WEST}).getTileType() != TileType.FLOOR
                && tileInDirections(tile.getTileX(), tile.getTileY(), new Direction[]{Direction.SOUTH, Direction.EAST}).getTileType() != TileType.FLOOR
                && tileInDirections(tile.getTileX(), tile.getTileY(), new Direction[]{Direction.SOUTH, Direction.WEST}).getTileType() != TileType.FLOOR;
    }

    // TODO[#0002]
    // Create enough utilities for proper generation.

    // TODO[#0003]
    // Create a working generator that works with as much efficiency as possible.

}
