
package com.mycompany.jeuball;

/**
 *
 * @author Asma Mestaysser
 */
// Classe principale du panneau de jeu
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class JeuBallPanel extends JPanel implements ActionListener, KeyListener {
    private Balloon balloon;
    private ArrayList<RectanglePlatform> platforms;
    private Timer timer;
    private boolean isGameOver;
    private int score;

    public JeuBallPanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.CYAN);

        balloon = new Balloon(400, 300); // Ballon fixe au centre de l'écran
        platforms = new ArrayList<>();
        generatePlatforms();
        timer = new Timer(30, this);
        isGameOver = false;
        score = 0;

        setFocusable(true);
        addKeyListener(this);
    }

    public void startGame() {
        timer.start();
    }

    public void restartGame() {
        balloon = new Balloon(400, 300);
        platforms.clear();
        generatePlatforms();
        isGameOver = false;
        score = 0;
        timer.start();
        repaint();
    }

    private void generatePlatforms() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int x = random.nextInt(700);
            int y = random.nextInt(600); // Position verticale initiale
            boolean isBroken = random.nextBoolean(); // Plateformes rouges ou vertes
            platforms.add(new RectanglePlatform(x, y, 100, 20, isBroken));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isGameOver) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("Game Over!", 300, 300);
            g.drawString("Score: " + score, 300, 350);
        } else {
            balloon.draw(g);

            for (RectanglePlatform platform : platforms) {
                platform.draw(g);
            }

            g.setColor(Color.BLACK);
            g.drawString("Score: " + score, 10, 20);
        }
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (!isGameOver) {
        // Déplacer les plateformes vers le bas
        for (RectanglePlatform platform : platforms) {
            platform.moveDown();

            // Réinitialiser les plateformes qui sortent de l'écran
            if (platform.getY() > 600) {
                platform.resetPosition();
                score++;
            }

            // Vérifier les collisions
            if (platform.isActive() && balloon.checkCollision(platform)) {
                if (platform.isBroken()) {
                    isGameOver = true;
                    timer.stop();
                } else {
                    isGameOver = true;
                    timer.stop();
                }
            }
        }

        // Déplacer le ballon horizontalement
        balloon.move();
    }

    repaint();
}

@Override
public void keyPressed(KeyEvent e) {
    if (!isGameOver) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            balloon.setDx(-5); // Déplacement à gauche
        } else if (key == KeyEvent.VK_RIGHT) {
            balloon.setDx(5); // Déplacement à droite
        }
    }
}

@Override
public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
        balloon.setDx(0); // Arrêt du mouvement horizontal
    }
}

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
