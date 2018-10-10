package com.github.musicscore.randomdungeon;

import com.github.musicscore.randomdungeon.dungeon.DungeonClass;
import com.github.musicscore.randomdungeon.dungeon.util.TileType;
import com.github.musicscore.randomdungeon.render.GameEngine;

public class RandomDungeon {

    public static void main(String[] args) {
        // TODO[#0001]
        // Write the actual program.
        DungeonClass dungeon01 = new DungeonClass(50, 25, 0.3);

        // Debug method, remove later
        visualizeGridInConsole(dungeon01);
        GameEngine newGame = new GameEngine(dungeon01);
    }

    // Debug method, remove later
    private static void visualizeGridInConsole(DungeonClass dungeon) {
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
