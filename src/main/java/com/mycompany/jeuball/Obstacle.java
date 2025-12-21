package com.mycompany.jeuball;


import java.awt.Color;
import java.awt.Graphics;

public class Obstacle extends GameObject {
    private int x, y, width, height;

    public Obstacle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}