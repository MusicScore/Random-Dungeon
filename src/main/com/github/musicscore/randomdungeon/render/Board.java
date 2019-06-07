package com.github.musicscore.randomdungeon.render;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Board extends JPanel {

    private int width, height, factor;

    public Board(int width, int height) {
        this(width, height, 10);
    }

    public Board(int width, int height, int scale) {
        this.width = width;
        this.height = height;
        this.factor = scale;
    }

    @Override
    public int getWidth() {
        return (width - 1) * factor;
    }

    @Override
    public int getHeight() {
        return (height - 1) * factor;
    }

    public int getTileScale() {
        return factor;
    }

    private int cartesianX(int x) {
        return x * factor;
    }

    private int cartesianY(int y) {
        return (height - y - 1) * factor;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        testDraw(g);
    }

    private void testDraw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Rectangle2D tile = new Rectangle2D.Double(cartesianX(i), cartesianY(j), factor, factor);

                g2d.setStroke(new BasicStroke(1));
                g2d.setColor(Color.GRAY);
                g2d.draw(tile);

                g2d.setColor((((j % 2) + (i % 2)) % 2 == 0) ? Color.BLUE : Color.ORANGE);
                g2d.fill(tile);
            }
        }
    }

    public boolean drawTile(int x, int y) {
        return false;
    }

    public boolean drawWall(int x, int y) {
        return false;
    }

}
