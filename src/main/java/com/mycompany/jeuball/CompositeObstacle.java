package com.mycompany.jeuball;


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class CompositeObstacle extends GameObject {
    private List<GameObject> obstacles = new ArrayList<>();

    public List<GameObject> getObstacles() {
        return obstacles;
    }
  
    
    public void add(GameObject obstacle) {
        obstacles.add(obstacle);
    }

    @Override
    public void draw(Graphics g) {
        for (GameObject obstacle : obstacles) {
            obstacle.draw(g);  // Dessine chaque obstacle ou groupe d'obstacles
        }
    }
}