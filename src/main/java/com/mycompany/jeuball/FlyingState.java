package com.mycompany.jeuball;

import java.awt.Color;
import java.awt.Graphics;

/**
 * État "en vol" du ballon.
 * Définit le comportement et l'affichage du ballon lorsqu'il vole.
 * 
 * @author Nada Ebdelli
 */
public class FlyingState implements BalloonState {
     private Balloon balloon;

    public FlyingState(Balloon balloon) {
        this.balloon = balloon;
    }

    @Override
    public void move() {
        // Déplacement horizontal du ballon
        balloon.x += balloon.dx;

        // Empêcher le ballon de sortir des limites de l'écran
        if (balloon.x < 0) {
            balloon.x = 0;
        } else if (balloon.x > 770) { // 800 - largeur du ballon
            balloon.x = 770;
        }
    }

    @Override
    public void display(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval(balloon.x, balloon.y, balloon.width, balloon.height);
    }

    

}
