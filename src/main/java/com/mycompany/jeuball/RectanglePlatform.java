package com.mycompany.jeuball;

import java.awt.*;
import java.util.Random;

public class RectanglePlatform {
    private int x, y, width, height;
    private boolean isActive;
    private boolean isBroken;

    public RectanglePlatform(int x, int y, int width, int height, boolean isBroken) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isActive = true;
        this.isBroken = isBroken;
    }

    public void draw(Graphics g) {
        if (isActive) {
            g.setColor(isBroken ? Color.RED : Color.GREEN);
            g.fillRect(x, y, width, height);
        }
    }

    public void moveDown() {
        y += 5; // Déplacement constant vers le bas
    }

    public void resetPosition() {
        Random random = new Random();
        this.y = -20; // Réapparaît en haut de l'écran
        this.x = random.nextInt(700); // Nouvelle position horizontale aléatoire
        this.isBroken = random.nextBoolean(); // Réinitialisation rouge/verte
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}