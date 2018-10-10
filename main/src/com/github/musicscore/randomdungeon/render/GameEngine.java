package com.github.musicscore.randomdungeon.render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

import com.github.musicscore.randomdungeon.dungeon.Dungeon;


// This is a semi-direct copy-and-paste from an online tutorial. Needs retouching at some point.

// Note: FIND A TUTORIAL THAT DOESN'T USE ANCIENT RAYCASTING! A graphical library, for example
public class GameEngine extends JFrame implements Runnable {
    private static final long serialVersionUID = 1L;
    private Thread thread;
    private boolean running;
    private BufferedImage image;
    public int[] pixels;

    private Dungeon loadedDungeon;

    public GameEngine(Dungeon dungeon) {
        loadedDungeon = dungeon;
        thread = new Thread(this);
        image = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
        setSize(640, 480);
        setResizable(false);
        setTitle("Random Dungeon Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setVisible(true);
        start();
    }

    private synchronized void start() {
        running = true;
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void render() {
        BufferStrategy buffer = getBufferStrategy();
        if (buffer == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = buffer.getDrawGraphics();
        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
        buffer.show();
    }

    public void run() {
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / 60.0; //60 times per second
        double delta = 0;
        requestFocus();
        while (running) {
            long now = System.nanoTime();
            delta = delta + ((now-lastTime) / ns);
            lastTime = now;
            while (delta >= 1) { //Make sure update is only happening 60 times a second
                //handles all of the logic restricted time
                delta--;
            }
            render();//displays to the screen unrestricted time
        }
    }

}
