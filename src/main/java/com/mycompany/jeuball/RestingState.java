package com.mycompany.jeuball;

import java.awt.Color;
import java.awt.Graphics;

/**
 * État "au repos" du ballon.
 * Le ballon ne se déplace pas lorsqu'il est dans cet état.
 * 
 * @author Nada Ebdelli
 */
public class RestingState implements BalloonState {
    private Balloon balloon;

    public RestingState(Balloon balloon) {
        this.balloon = balloon;
    }

    @Override
    public void move() {
        // Le ballon ne se déplace pas quand il est au repos
    }

    @Override
    public void display(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval(balloon.x, balloon.y, balloon.width, balloon.height);
    }

}
