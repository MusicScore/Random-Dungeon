package com.github.musicscore.randomdungeon.dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.security.SecureRandom;

import com.github.musicscore.randomdungeon.dungeon.util.Direction;
import com.github.musicscore.randomdungeon.dungeon.util.TileType;

public class Dungeon {

    private int width, length;
    private ArrayList<Tile> tileSet = new ArrayList<>();

    /**
     * Generates a new rectangular Dungeon using a specified width and length.
     * @param gridWidth The width of the dungeon.
     * @param gridLength The length of the dungeon.
     */
    public Dungeon(int gridWidth, int gridLength) {
        this.width = gridWidth;
        this.length = gridLength;
        this.generateBlankGrid();
    }

    /**
     * Resets the dungeon and fills every tile with a VOID type tile.
     */
    public void generateBlankGrid() {
        tileSet.clear();
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                tileSet.add(new Tile(new int[]{x, y}));
            }
        }
    }

    /**
     * Attempts to generate up to a certain amount of rooms. Gives up if a room fails to generate a certain amount of times.
     * @param maxRooms The maximum number of rooms that will be generated.
     * @param maxAttempts The maximum amount of attempts to generate each room before the method gives up.
     */
    public void generateRooms(int maxRooms, int maxAttempts) {
        generateRooms(maxRooms, maxAttempts, 2, Math.min(10, width / 10), 2, Math.min(10, length / 10));
    }

    /**
     * Attempts to generate up to a certain amount of rooms. Gives up if a room fails to generate a certain amount of times.
     * @param maxRooms The maximum number of rooms that will be generated.
     * @param maxAttempts The maximum amount of attempts to generate each room before the method gives up.
     * @param minRoomWidth The minimum room width.
     * @param maxRoomWidth The maximum room width.
     * @param minRoomLength The minimum room length.
     * @param maxRoomLength The maximum room length.
     */
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

    /**
     * Attempts to generate a winding maze-like corridor, starting at a given tile.
     * @param startingTile The Tile at which to start attempting to generate the winding corridors.
     * @param directionalPreference The chance that . Ranges from 0 to 1 inclusively.
     */
    public void generateCorridors(Tile startingTile, double directionalPreference) {
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
