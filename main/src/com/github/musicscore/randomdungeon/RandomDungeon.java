package com.github.musicscore.randomdungeon;

import com.github.musicscore.randomdungeon.dungeon.Dungeon;
import com.github.musicscore.randomdungeon.dungeon.util.TileType;

public class RandomDungeon {

    // READ: https://i.imgur.com/sl7GqTu.png <------------------------
    public static void main(String[] args) {
        // TODO: Write the actual program.
        Dungeon dungeon01 = new Dungeon(59, 29);

        dungeon01.generateRooms(20, 15, 4, 12, 4, 12);
        for (int y = 1; y < dungeon01.getLength(); y += 2) {
            for (int x = 1; x < dungeon01.getWidth(); x += 2) {
                if (dungeon01.getTile(x, y) == null) {
                    dungeon01.generateCorridors(x, y, 0.3);
                }
            }
        }

        // Debug method, remove later
        visualizeGridInConsole(dungeon01);
    }

    // Debug method, remove later
    private static void visualizeGridInConsole(Dungeon dungeon) {
        for (int y = dungeon.getLength() - 1; y >= 0; y--) {
            for (int x = 0; x < dungeon.getWidth(); x++) {
                if (dungeon.getTile(x, y) == null) {
                    System.out.print("  ");
                }
                else if (dungeon.getTile(x, y).getTileType() == TileType.FLOOR) {
                    System.out.print(". ");
                }
                else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

}
