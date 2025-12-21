package com.mycompany.jeuball;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Balloon {

    int x;
    int y;
    int width;
     int height, dx;
    public static final int SPEED = 5; // Vitesse de déplacement

    private BalloonState currentState;  // Attribut pour l'état actuel

    public Balloon(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 30;
        this.height = 40;
        this.dx = 0;  // Pas de déplacement horizontal initial
        this.currentState = new FlyingState(this);  // Par défaut, l'état est en vol
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Méthode pour changer l'état du ballon
    public void setState(BalloonState state) {
        this.currentState = state;
    }

    // Appel de la méthode move() de l'état actuel
    public void move() {
        currentState.move();
    }

    // Appel de la méthode display() de l'état actuel
    public void draw(Graphics g) {
        currentState.display(g);
    }

    public boolean checkCollision(RectanglePlatform platform) {
        Rectangle balloonBounds = new Rectangle(x, y, width, height);
        Rectangle platformBounds = new Rectangle(platform.getX(), platform.getY(), platform.getWidth(), platform.getHeight());
        return balloonBounds.intersects(platformBounds);
    }

    // Setters pour le déplacement horizontal
    public void setDx(int dx) {
        this.dx = dx;
    }
}