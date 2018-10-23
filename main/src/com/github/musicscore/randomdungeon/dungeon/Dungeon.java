package com.github.musicscore.randomdungeon.dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.github.musicscore.randomdungeon.dungeon.util.Direction;
import com.github.musicscore.randomdungeon.dungeon.util.TileProperty;
import com.github.musicscore.randomdungeon.dungeon.util.TileType;

public class Dungeon {

    private int width, length;
    private int[] tileSet;
    private ArrayList<Tile> tileIDList = new ArrayList<>();
    private Random rnd = new Random();

    //==============================================
    // Constructor and methods containing
    //   dungeon generation logic
    //==============================================

    /**
     * Generates a new rectangular Dungeon using a specified width and length.
     * @param width The width of the dungeon.
     * @param length The length of the dungeon.
     */
    public Dungeon(int width, int length) {
        this.width = width;
        this.length = length;
        tileSet = new int[width * length];

        tileIDList.add(null);
        tileIDList.add(new Tile(TileType.WALL, TileProperty.WALL_UNBREAKABLE, "blank"));
        tileIDList.add(new Tile(TileType.FLOOR, null, "blank"));
        generateBlankGrid();
    }

    /**
     * Resets the dungeon and fills every tile with a null.
     */
    public void generateBlankGrid() {
        for (int x = 0; x < width; x++) {
            tileSet[x] = 1;
            tileSet[x + (length - 1) * width] = 1;
        }
        for (int y = 0; y < length; y++) {
            tileSet[width - 1 + y * width] = 1;
            tileSet[y * width] = 1;
        }
    }

    /**
     * Attempts to generate up to a certain amount of rooms. Walls are included as part of the room.
     * Gives up if a room fails to generate a certain amount of times.
     * @param maxRooms The maximum number of rooms that will be generated.
     * @param maxAttempts The maximum amount of attempts to generate each room before the method gives up.
     */
    public void generateRooms(int maxRooms, int maxAttempts) {
        generateRooms(maxRooms, maxAttempts, 4, Math.min(5, width / 10), 4, Math.min(5, length / 10));
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
                            x == 0 || x == extendX - 1 || y == 0 || y == extendY - 1 ? 1 : 2);
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

        setTile(x, y, 2);
        tileList.add(new int[]{x, y});
        int lastX, lastY;

        while (!tileList.isEmpty()) {
            lastX = tileList.get(tileList.size() - 1)[0];
            lastY = tileList.get(tileList.size() - 1)[1];

            validDir.clear();
            for (Direction dir: Direction.values()) {
                if (lastX + dir.asXOffset() * 3 > 0 && lastX + dir.asXOffset() * 3 < width
                        && lastY + dir.asYOffset() * 3 > 0 && lastY + dir.asYOffset() * 3 < length
                        && canSetCorridorInDirection(tileList.get(tileList.size() - 1)[0], tileList.get(tileList.size() - 1)[1], dir)) {
                    validDir.add(dir);
                }
            }

            if (validDir.isEmpty()) {
                tileList.remove(tileList.size() - 1);
                lastDir = null;
                continue;
            }

            if (!validDir.contains(lastDir) || rnd.nextDouble() >= directionalPreference) {
                lastDir = validDir.get(rnd.nextInt(validDir.size()));
            }

            setTile(lastX + lastDir.asXOffset(), lastY + lastDir.asYOffset(), 2);
            setTile(lastX + lastDir.asXOffset() * 2, lastY + lastDir.asYOffset() * 2, 2);
            tileList.add(new int[]{lastX + lastDir.asXOffset(), lastY + lastDir.asYOffset()});
            tileList.add(new int[]{lastX + lastDir.asXOffset() * 2, lastY + lastDir.asYOffset() * 2});
        }
    }


    //==============================================
    // Dungeon management/debug methods
    //==============================================

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
     * Changes a Tile at a particular (x, y) coordinate on the dungeon grid.
     * @param x The x coordinate of the Tile.
     * @param y The y coordinate of the Tile.
     * @param tileID The ID of the Tile to place here.
     */
    public void setTile(int x, int y, int tileID) {
        tileSet[x + y * width] = tileID;
    }

    /**
     * Returns the Tile at the specified (x, y) coordinate.
     * @param x The x coordinate on the dungeon grid.
     * @param y The y coordinate on the dungeon grid.
     * @return The Tile at the specified (x, y) coordinate.
     */
    public Tile getTile(int x, int y) {
        try {
            return tileIDList.get(tileSet[x + y * width]);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public int getTileID(Tile tile) {
        return tileIDList.indexOf(tile);
    }

    public void addNewTile(Tile tile) {
        tileIDList.add(tile);
    }

    public void removeTile(int index) {
        tileIDList.remove(index);
    }


    //==============================================
    // Tile-related methods
    //==============================================

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
        int totalOffsetX = 0, totalOffsetY = 0;
        for (Direction val : dir) {
            totalOffsetX += val.asXOffset();
            totalOffsetY += val.asYOffset();
        }
        return getTile(x + totalOffsetX, y + totalOffsetY);
    }

    /**
     * Returns whether or not a single-tile-wide corridor can be placed at a given location.
     * @param x The x coordinate of the Tile.
     * @param y The y coordinate of the Tile.
     * @return Returns true if a single-tile-wide corridor Tile can be placed at the location.
     */
    public boolean canSetCorridorInDirection(int x, int y, Direction dir) {
        int newX = x + dir.asXOffset() * 2, newY = y + dir.asYOffset() * 2;
        return resolveTileType(newX, newY) == null
                && resolveTileType(newX - 1, newY + 1) != TileType.FLOOR
                && resolveTileType(newX + 1, newY + 1) != TileType.FLOOR
                && resolveTileType(newX - 1, newY - 1) != TileType.FLOOR
                && resolveTileType(newX + 1, newY - 1) != TileType.FLOOR;
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

}
