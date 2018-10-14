package com.github.musicscore.randomdungeon;

import com.github.musicscore.randomdungeon.dungeon.Dungeon;
import com.github.musicscore.randomdungeon.dungeon.util.TileType;
import com.github.musicscore.randomdungeon.render.GameEngine;

public class RandomDungeon {

    // READ: https://i.imgur.com/sl7GqTu.png <------------------------
    public static void main(String[] args) {
        // TODO[#0001]
        // Write the actual program.
        Dungeon dungeon01 = new Dungeon(53, 25);
        // Disable the room and master corridor generation to figure out what the hell is wrong with the corridor
        // generator.
        //dungeon01.generateRooms(6, 15, 4, 12, 4, 12);
        //for (int y = 1; y < dungeon01.getLength(); y += 2) {
        //    for (int x = 1; x < dungeon01.getWidth(); x += 2) {
        //        if (dungeon01.resolveTileType(x, y) == null) {
        //            dungeon01.generateCorridors(x, y, 0.3);
        //        }
        //    }
        //}
        dungeon01.generateCorridors(1, 1, 0.3);

        // Debug method, remove later
        visualizeGridInConsole(dungeon01);
        GameEngine newGame = new GameEngine(dungeon01);
    }

    // Debug method, remove later
    private static void visualizeGridInConsole(Dungeon dungeon) {
        for (int y = dungeon.getLength() - 1; y >= 0; y--) {
            for (int x = 0; x < dungeon.getWidth(); x++) {
                if (dungeon.resolveTileType(x, y) == TileType.FLOOR) {
                    System.out.print(". ");
                }
                else if (dungeon.resolveTileType(x, y) == TileType.WALL){
                    System.out.print("O ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

}
