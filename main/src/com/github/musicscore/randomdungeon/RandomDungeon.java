package com.github.musicscore.randomdungeon;

import com.github.musicscore.randomdungeon.dungeon.Dungeon;
import com.github.musicscore.randomdungeon.dungeon.util.TileType;
import com.github.musicscore.randomdungeon.render.GameEngine;

public class RandomDungeon {

    // READ: https://i.imgur.com/sl7GqTu.png <------------------------
    public static void main(String[] args) {
        // TODO[#0001]
        // Write the actual program.
        Dungeon dungeon01 = new Dungeon(50, 25);

        // Debug method, remove later
        visualizeGridInConsole(dungeon01);
        GameEngine newGame = new GameEngine(dungeon01);
    }

    // Debug method, remove later
    private static void visualizeGridInConsole(Dungeon dungeon) {
        for (int y = dungeon.getLength() - 1; y >= 0; y--) {
            for (int x = 0; x < dungeon.getWidth(); x++) {
                if (dungeon.getTile(x, y).getTileType() == TileType.FLOOR) {
                    System.out.print(". ");
                }
                else if (dungeon.getTile(x, y).getTileType() == TileType.WALL) {
                    System.out.print("O ");
                }
                else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

}
