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

        setPreferredSize(new Dimension(getPixelWidth(), getPixelHeight()));
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPixelWidth() {
        return width * factor;
    }

    public int getPixelHeight() {
        return height * factor;
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

        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();

        Rectangle2D tile = new Rectangle2D.Double(width, 0, factor, factor);
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.gray);
        g2d.setBackground(Color.red);

        g2d.draw(tile);
    }

    public boolean drawTile(int x, int y) {
        return false;
    }

    public boolean drawWall(int x, int y) {
        return false;
    }

}
