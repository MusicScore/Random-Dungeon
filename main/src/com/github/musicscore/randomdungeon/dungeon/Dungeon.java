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
     * Resets the dungeon and fills every tile with a null.
     */
    public void generateBlankGrid() {
        tileSet.clear();
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                if (x == 0 || x == width - 1 || y == 0 || y == length - 1) {
                    tileSet.add(new Tile(TileType.WALL));
                    continue;
                }
                tileSet.add(null);
            }
        }
    }

    /**
     * Attempts to generate up to a certain amount of rooms. Walls are included as part of the room.
     * Gives up if a room fails to generate a certain amount of times.
     * @param maxRooms The maximum number of rooms that will be generated.
     * @param maxAttempts The maximum amount of attempts to generate each room before the method gives up.
     */
    public void generateRooms(int maxRooms, int maxAttempts) {
        generateRooms(maxRooms, maxAttempts, 2, Math.min(10, width / 10), 2, Math.min(10, length / 10));
    }

    /**
     * Attempts to generate up to a certain amount of rooms. Walls are included as part of the room.
     * Gives up if a room fails to generate a certain amount of times.
     * @param maxRooms The maximum number of rooms that will be generated.
     * @param maxAttempts The maximum amount of attempts to generate each room before the method gives up.
     * @param minRoomWidth The minimum room width.
     * @param maxRoomWidth The maximum room width.
     * @param minRoomLength The minimum room length.
     * @param maxRoomLength The maximum room length.
     */
    public void generateRooms(int maxRooms, int maxAttempts, int minRoomWidth, int maxRoomWidth, int minRoomLength, int maxRoomLength) {
        int roomsGenerated = 0, attemptsMade = 0;
        boolean shouldSkip = false;
        int startX, startY, extendX, extendY;
        HashMap<int[], int[]> listRooms = new HashMap<>();
        SecureRandom rnd = new SecureRandom();

        while (roomsGenerated < maxRooms && attemptsMade < maxAttempts) {
            extendX = rnd.nextInt(maxRoomWidth - minRoomWidth) + minRoomWidth;
            extendY = rnd.nextInt(maxRoomLength - minRoomLength) + minRoomLength;
            startX = rnd.nextInt(width - extendX);
            startY = rnd.nextInt(length - extendY);

            for (int[] checkRoom : listRooms.keySet()) {
                if (startX < listRooms.get(checkRoom)[0] && startY < listRooms.get(checkRoom)[1]
                        && startX + extendX > checkRoom[0] && startY + extendY > checkRoom[1]) {
                    shouldSkip = true;
                    break;
                }
            }

            if (shouldSkip) {
                attemptsMade++;
                shouldSkip = false;
                continue;
            }

            for (int y = 0; y < extendY; y++) {
                for (int x = 0; x < extendX; x++ ) {
                    setTile(startX + x, startY + y,
                            x == 0 || x == extendX - 1 || y == 0 || y == extendY - 1 ? new Tile(TileType.WALL) : new Tile(TileType.FLOOR));
                }
            }

            listRooms.put(new int[]{startX, startY}, new int[]{startX + extendX, startY + extendY});
            roomsGenerated++;
            attemptsMade = 0;
        }
    }

    /**
     * Attempts to generate a winding maze-like corridor, starting at a given tile.
     * @param x The x location to start generating the maze of corridors at.
     * @param y The y location to start generating the maze of corridors at.
     * @param directionalPreference The chance that a particular path will continue in the same direction. Ranges from 0 to 1 inclusively.
     */
    public void generateCorridors(int x, int y, double directionalPreference) {
        ArrayList<int[]> tileList = new ArrayList<>();
        ArrayList<Direction> validDir = new ArrayList<>();
        Direction lastDir = null;
        SecureRandom rnd = new SecureRandom();
        tileList.add(new int[]{x, y});

        while (!tileList.isEmpty()) {
            validDir.clear();
            for (Direction dir: Direction.values()) {
                if (canMakeFloor(tileList.get(tileList.size() - 1)[0] + dir.asXOffset(), tileList.get(tileList.size() - 1)[1] + dir.asYOffset())
                        && canSetCorridor(tileList.get(tileList.size() - 1)[0] + dir.asXOffset(), tileList.get(tileList.size() - 1)[1] + dir.asYOffset())) {
                    validDir.add(dir);
                }
            }
            if (validDir.isEmpty()) {
                setTile(x, y, new Tile(TileType.WALL));
                tileList.remove(tileList.size() - 1);
                lastDir = null;
                continue;
            }

            if (!validDir.contains(lastDir) || rnd.nextDouble() >= directionalPreference) {
                lastDir = validDir.get(rnd.nextInt(validDir.size()));
            }

            tileList.add(new int[]{tileList.get(tileList.size() - 1)[0] + lastDir.asXOffset(), tileList.get(tileList.size() - 1)[1] + lastDir.asYOffset()});
            setTile(tileList.get(tileList.size() - 1)[0], tileList.get(tileList.size() - 1)[1], new Tile(TileType.FLOOR));
        }
    }

    /**
     * Returns the width of the dungeon.
     * @return The width of the dungeon.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the length of the dungeon.
     * @return The length of the dungeon.
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns an ArrayList of all the Tiles in the dungeon.
     * @return All Tiles that compose the dungeon.
     */
    public ArrayList<Tile> getAllTiles() {
        return tileSet;
    }

    /**
     * Changes a Tile at a particular (x, y) coordinate on the dungeon grid.
     * @param x The x coordinate of the Tile.
     * @param y The y coordinate of the Tile.
     * @param tile A Tile object that replaces the old Tile object.
     */
    public void setTile(int x, int y, Tile tile) {
        tileSet.set(x + y * width, tile);
    }

    /**
     * Returns the Tile at the specified (x, y) coordinate.
     * @param x The x coordinate on the dungeon grid.
     * @param y The y coordinate on the dungeon grid.
     * @return The Tile at the specified (x, y) coordinate.
     */
    public Tile getTile(int x, int y) {
        return (x < width && x >= 0 && y < length && y >= 0) ? tileSet.get(x + y * width) : null;
    }

    /**
     * Returns an array of all adjacent Tiles (excluding diagonal Tiles) to the tile at the (x, y) coordinate.
     * @param x The x coordinate on the dungeon grid.
     * @param y The y coordinate on the dungeon grid.
     * @return All Tiles immediately adjacent (not diagonal) to the (x, y) coordinate.
     */
    public Tile[] getAdjacentTiles(int x, int y) {
        return new Tile[]{getTile(x, y + 1), getTile(x, y - 1), getTile(x + 1, y), getTile(x - 1, y)};
    }

    /**
     * Returns the Tile after moving one tile in the specified Direction from an (x, y) coordinate.
     * @param x The x coordinate of the initial Tile.
     * @param y The y coordinate of the initial Tile.
     * @param dir The Direction to move in.
     * @return The Tile one unit in a given Direction from the (x, y) coordinate.
     */
    public Tile tileInDirection(int x, int y, Direction dir) {
        return getTile(x + dir.asXOffset(), y + dir.asYOffset());
    }

    /**
     * Returns the Tile after moving one tile in each Direction from an (x, y) coordinate.
     * @param x The x coordinate of the initial Tile.
     * @param y The y coordinate of the initial Tile.
     * @param dir An array containing a set of Directions to move in.
     * @return The Tile after moving one unit in each Direction from the (x, y) coordinate.
     */
    public Tile tileInDirections(int x, int y, Direction[] dir) {
        int currentX = x, currentY = y;
        for (Direction val : dir) {
            currentX = val.asXOffset();
            currentY = val.asYOffset();
        }
        return getTile(currentX, currentY);
    }

    /**
     * Returns whether or not a single-tile-wide corridor can be placed at a given location.
     * @param x The x coordinate of the Tile.
     * @param y The y coordinate of the Tile.
     * @return Returns true if a single-tile-wide corridor Tile can be placed at the location.
     */
    public boolean canSetCorridor(int x, int y) {
        return resolveTileType(x, y) == null
                && resolveTileType(x - 1, y + 1) != TileType.FLOOR
                && resolveTileType(x + 1, y + 1) != TileType.FLOOR
                && resolveTileType(x - 1, y - 1) != TileType.FLOOR
                && resolveTileType(x + 1, y - 1) != TileType.FLOOR;
    }

    public boolean canMakeFloor(int x, int y) {
        return x > 0 && x < width - 1 && y > 0 && y < length - 1 && resolveTileType(x, y) == null;
    }

    /**
     * Safely returns a Tile's TileType versus using the Tile.getTileType() method. Returns null if the Tile does not exist.
     * @param x The x coordinate of the Tile.
     * @param y The y coordinate of the Tile.
     * @return Returns the TileType of the tile at the coordinates, or null if there is no tile.
     */
    public TileType resolveTileType(int x, int y) {
        return getTile(x, y) != null ? getTile(x, y).getTileType() : null;
    }

    // TODO[#0002]
    // Create enough utilities for proper generation.

    // TODO[#0003]
    // Create a working generator that works with as much efficiency as possible.

}
