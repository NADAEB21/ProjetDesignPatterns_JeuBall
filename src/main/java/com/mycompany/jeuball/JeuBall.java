/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jeuball;

/**
 *
 * @author Asus
 */

import javax.swing.*;
import java.awt.*;

public class JeuBall {

    public static void main(String[] args) {
        // Création de la fenêtre principale
        JFrame frame = new JFrame("Jeu Montgolfière");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout()); // Utilisation de BorderLayout pour positionner les composants

        // Création du panneau principal
        JeuBallPanel gamePanel = new JeuBallPanel();
        frame.add(gamePanel, BorderLayout.CENTER); // Ajout du panneau de jeu au centre

        // Ajout d'un bouton pour redémarrer le jeu
        JButton restartButton = new JButton("Redémarrer");
        restartButton.addActionListener(e -> {
            gamePanel.restartGame(); // Réinitialiser le jeu
            gamePanel.requestFocusInWindow(); // Assurer que le panneau a le focus pour capturer les événements clavier
        });

        // Ajout du bouton en bas de la fenêtre
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(restartButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Configuration de la fenêtre
        frame.setVisible(true);

        // Assurer que le panneau de jeu a le focus initial
        gamePanel.requestFocusInWindow();

        // Lancement du jeu
        gamePanel.startGame();
    }
}