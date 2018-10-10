package com.mysteryclive.gmail.dungeonGeneration;

import java.util.ArrayList;
import java.util.HashMap;
import java.security.SecureRandom;

import com.mysteryclive.gmail.dungeonGeneration.util.Direction;
import com.mysteryclive.gmail.dungeonGeneration.util.Tile;
import com.mysteryclive.gmail.dungeonGeneration.util.TileType;

public class DungeonClass {

    private int width, length;
    private double dirPrefFactor;
    private ArrayList<Tile> tileSet = new ArrayList<>();

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
                tileSet.add(new Tile(new int[]{x, y}));
            }
        }
    }

    public void generateRooms(int maxRooms, int maxAttempts) {
        generateRooms(maxRooms, maxAttempts, 2, Math.min(10, width / 10), 2, Math.min(10, length / 10));
    }

    public void generateRooms(int maxRooms, int maxAttempts, int minRoomWidth, int maxRoomWidth, int minRoomLength, int maxRoomLength) {
        int roomsGenerated = 0, attemptsMade = 0;
        int startX, startY, extendX, extendY;
        HashMap<int[], int[]> listRooms = new HashMap<>();
        SecureRandom rnd = new SecureRandom();

        while (roomsGenerated <= maxRooms && attemptsMade <= maxAttempts) {
            extendX = rnd.nextInt(maxRoomWidth - minRoomWidth) + minRoomWidth;
            extendY = rnd.nextInt(maxRoomLength - minRoomLength) + minRoomLength;
            startX = rnd.nextInt(width - extendX);
            startY = rnd.nextInt(length - extendY);

            for (int[] checkRoom : listRooms.keySet()) {
                // TODO[#0007]
                // Finish room generation logic
            }
        }
    }

    public void generateCorridors() {
        // TODO[#0008]
        // Create corridor generation logic, or multiple methods for corridor generation if there are multiple methods
        // to implement that produce distinctly different mazes.
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public ArrayList<Tile> getAllTiles() {
        return tileSet;
    }

    public void setTile(int x, int y, Tile tile) {
        tileSet.set(x + y * width, tile);
    }

    public Tile getTile(int x, int y) {
        return (x < width && x >= 0 && y < length && y >= 0) ? tileSet.get(x + y * width) : null;
    }

    public Tile tileInDirection(int x, int y, Direction dir) {
        return getTile(x + dir.asXOffset(), y + dir.asYOffset());
    }

    public Tile tileInDirections(int x, int y, Direction[] dir) {
        Tile currentTile = getTile(x, y);
        Tile newCell = null;
        for (Direction val : dir) {
            newCell = tileInDirection(currentTile.getTileX(), currentTile.getTileY(), val);
            currentTile = newCell;
        }
        return newCell;
    }

    public boolean canSetCorridorFloor(Tile tile) {
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
