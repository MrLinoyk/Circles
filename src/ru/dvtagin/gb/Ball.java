package ru.dvtagin.gb;

import java.awt.*;

public class Ball extends Sprite {
    private float vx = 150 + (float) (Math.random() * 200f);
    private float vy = 150 + (float) (Math.random() * 200f);

    private final Color color = new Color((int)(Math.random()* 256f),
            (int)(Math.random()* 256f),
            (int)(Math.random()* 256f));

    Ball () {
        halfHeight = 20 + (float) (Math.random() * 50f );
        halfWidth = halfHeight;
    }
    Ball (int x, int y) {
        this ();
        this.x = x;
        this.y = y;
    }

    @Override
    void update(GameCanvas gameCanvas, float deltaTime) {
        x += vx * deltaTime;
        y += vy * deltaTime;

        if (getLeft() < gameCanvas.getLeft()) {
            setLeft((gameCanvas.getLeft()));
            vx = -vx;
        }
        if (getRight() > gameCanvas.getRight()) {
            setRight((gameCanvas.getRight()));
            vx = -vx;
        }
        if (getTop() < gameCanvas.getTop()) {
            setTop((gameCanvas.getTop()));
            vy = -vy;
        }

        if (getBottom() > gameCanvas.getBottom()) {
            setBottom((gameCanvas.getBottom()));
            vy = -vy;
        }
    }

    @Override
    void render(GameCanvas gameCanvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int)(getLeft()), (int)(getTop()), (int)(getWidth()), (int) (getHeight()));
    }
}
