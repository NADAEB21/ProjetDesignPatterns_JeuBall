package com.mycompany.jeuball;
import java.awt.Graphics;
/**
 * Interface représentant l'état d'un ballon dans le jeu.
* @author Nada Ebdelli
 */
public interface BalloonState {
    void move();  // Le mouvement du ballon dans cet état
    void display(Graphics g);  // Affichage du ballon dans cet état
}
