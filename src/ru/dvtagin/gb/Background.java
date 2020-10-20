package ru.dvtagin.gb;

import java.awt.*;

public class Background extends Sprite {

    private float time;
    private static final float APLITUDE = 255f / 2f;
    private Color color;

    @Override
    void update(GameCanvas gameCanvas, float deltaTime) {
        time += deltaTime;
        int R = Math.round(APLITUDE + APLITUDE * (float) Math.sin(time * 2f));
        int G = Math.round(APLITUDE + APLITUDE * (float) Math.sin(time * 3f));
        int B = Math.round(APLITUDE + APLITUDE * (float) Math.sin(time));
        color = new Color(R, G, B);
    }

    @Override
    void render(GameCanvas gameCanvas, Graphics g) {
        gameCanvas.setBackground(color);
    }
}

