package com.github.musicscore.randomdungeon.render;

import javax.swing.*;

public class Game extends JFrame {

    private Board board;

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
        setTitle("RandomDungeon Visualizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // TODO: Figure out why the JPanel doesn't fit the JFrame perfectly
        //setSize(board.getWidthWithPadding(), board.getHeightWithPadding());
        //setLocationRelativeTo(null);

        //setResizable(false);

        add(board);
    }
}
