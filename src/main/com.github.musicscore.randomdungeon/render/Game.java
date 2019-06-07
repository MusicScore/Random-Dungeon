package com.github.musicscore.randomdungeon.render;

import javax.swing.*;

public class Game extends JFrame {

    private Board board = null;

    public Game() {
        this(new Board(100, 100));
    }

    public Game(Board board) {
        this.board = board;
        initUI();
    }

    public Board getBoard() {
        return board;
    }

    private void initUI() {
        add(board);

        setSize(board.getPixelWidth(), board.getPixelHeight());

        setResizable(false);

        setTitle("RandomDungeon Visualizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
