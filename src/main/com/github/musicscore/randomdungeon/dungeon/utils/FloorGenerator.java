package com.github.musicscore.randomdungeon.dungeon.utils;

import com.github.musicscore.randomdungeon.dungeon.Room;
import com.github.musicscore.randomdungeon.render.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FloorGenerator {

    private Random rnd = new Random();

    private Board board = null;
    private List<Room> roomList = new ArrayList<>();

    public FloorGenerator() {
        this(new Board(0, 0));
    }

    public FloorGenerator(Board board) {
        this.board = board;
    }

    /**
     * Attempts to create rooms on a Board.
     * @param minWidth The minimum width of a room. Cannot be less than 2.
     * @param maxWidth The maximum width of a room. Cannot be less than the minimum width.
     * @param minHeight The minimum height of a room. Cannot be less than 2.
     * @param maxHeight The maximum height of a room. Cannot be less than the minimum height.
     * @param numOfRooms The maximum number of rooms that can be generated.
     * @param maxAttempts The maximum number of times the generator will try to place rooms.
     * @return The number of rooms that were successfully generated.
     */
    public int generateRooms(int minWidth, int maxWidth, int minHeight, int maxHeight, int numOfRooms, int maxAttempts) {
        int attempts = 0;
        int roomsCreated = 0;

        while (roomsCreated != numOfRooms && attempts < maxAttempts) {
            int startX = rnd.nextInt(board.getWidth());
            int startY = rnd.nextInt(board.getHeight());
            int endX = Math.min(rnd.nextInt(maxWidth - minWidth) + minWidth + startX, board.getWidth());
            int endY = Math.min(rnd.nextInt(maxHeight - minHeight) + minHeight + startY, board.getHeight());

            Room room = new Room(startX, startY, endX, endY);
        }

        return roomsCreated;
    }

    private boolean roomsIntersect(Room room1, Room room2) {
        return room1.getMaxX() < room2.getMinX() || room1.getMaxY() < room2.getMinY() || room1.getMinX() > room2.getMaxX() || room1.getMinY() > room2.getMaxY();
    }
}
