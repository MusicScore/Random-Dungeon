package com.github.musicscore.randomdungeon;

import com.github.musicscore.randomdungeon.render.Game;

import java.awt.*;

public class RandomDungeon {

    public static Game game;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            game = new Game();
            game.setVisible(true);
        });
    }
}
