package ru.dvtagin.gb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {
    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    private Sprite [] sprites = new Sprite[1];
    private int spritesCount;

    MainWindow () {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(POS_X, POS_Y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setTitle("Circles");
        GameCanvas gameCanvas = new GameCanvas(this);
        gameCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1)
                    addSprite(new Ball(e.getX(), e.getY()));
                else if (e.getButton() == MouseEvent.BUTTON3)
                    removeSprite ();
            }
        });
        add(gameCanvas);
        initGame();
        setVisible(true);
    }


    private void addSprite (Sprite sprite) {
        if (spritesCount == sprites.length) {
            Sprite[] newSprites = new Sprite[sprites.length * 2];
            System.arraycopy(sprites, 0, newSprites, 0 ,sprites.length);
            sprites = newSprites;
        }
        sprites [spritesCount] = sprite;
        spritesCount++;
    }

    private void removeSprite () {
        if (spritesCount > 1)
            spritesCount--;
    }

    private void initGame () {
       addSprite(new Background());
       addSprite(new Ball());
    }


    void onDrawFrame (GameCanvas gameCanvas, Graphics g, float deltaTime) {
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }

    private void update (GameCanvas gameCanvas, float deltaTime) {
        for (int i = 0; i < spritesCount; i++) {
            sprites[i].update(gameCanvas, deltaTime);
        }

    }

    private void render (GameCanvas gameCanvas, Graphics g) {
        for (int i = 0; i < spritesCount; i++) {
            sprites[i].render(gameCanvas, g);
        }
    }
}
