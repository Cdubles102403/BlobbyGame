/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blobbygame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author CSchafer
 */
public class World extends JPanel {
    
    private Timer timer;
    private Player player;
    private Enemy enemy;
    private Enemy enemy2;
    private Enemy enemy3;
    private Food food;
    private Food food2;
    public World() {
        super();
        player = new Player(800,600);
        enemy = new Enemy(800,600);
        enemy2 = new Enemy(800,600);
        enemy3 = new Enemy(800,600);
        food = new Food(800,600);
        food2 = new Food(800,600);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/120);
    }

    @Override
    public void paintComponent(Graphics g) {   
        super.paintComponent(g);
        this.setBackground(Color.black);
        if(player.isAlive()) player.draw(g);
        if(enemy.isAlive()) enemy.draw(g);
        if(enemy3.isAlive()){
            enemy3.setColor(Color.WHITE);
            enemy.draw(g);
        }
        if(enemy2.isAlive()){
            enemy2.setColor(Color.MAGENTA);
            enemy2.draw(g);
        }
        if(!food.isEaten()){
            food.draw(g);
        }
        if(!food2.isEaten()){
            food2.draw(g);
        }
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            player.update();
            //enemy.move();
            enemy.update();
            enemy2.update();
            enemy3.update();
            food.update();
            food2.update();
            foodCollision();
            checkCollisions();
            repaint();
        }

       
    }
         private void checkCollisions() {
            if(player.getBounds().intersects(enemy.getBounds()) && enemy.isAlive()){
                if(player.getVy()> 0){
                    System.out.println("kill enemy");
                    player.increasePoints();
                    enemy.die();
                    System.out.println(player.getScore());
            }
                else{
                   System.out.println("player dead");
                   player.die();
                    
                }
            }
            
            if(player.getBounds().intersects(enemy2.getBounds()) && enemy2.isAlive()){
                if(player.getVy()> 0){
                    System.out.println("kill enemy2");
                    player.increasePoints();
                    enemy2.die();
                    System.out.println(player.getScore());
            }
                else{
                   System.out.println("player dead by enemy 2");
                   player.die();
            }
        }
            
        if(player.getBounds().intersects(enemy3.getBounds()) && enemy3.isAlive()){
                if(player.getVy()> 0){
                    System.out.println("kill enemy3");
                    player.increasePoints();
                    enemy3.die();
                    System.out.println(player.getScore());
            }
                else{
                   System.out.println("player dead by enemy 3");
                   player.die();
            }
        }
    }    
         
      public void foodCollision(){
          if(player.getBounds().intersects(food.getBounds()) && !food.isEaten()){
             player.eat();
             food.eaten();
             System.out.println("food was eaten");
            }
          if(player.getBounds().intersects(food2.getBounds()) && !food2.isEaten()){
             player.eat();
             food2.eaten();
             System.out.println("food2 was eaten");
            }
        }
         
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            enemy.move();
            enemy2.move();
            enemy3.move();
            player.move("right");
         
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            enemy.move();
            enemy2.move();
            enemy3.move();
            player.move("left");
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            enemy.move();
            enemy2.move();
            enemy3.move();
            player.move("up"); 
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            enemy.move();
            enemy2.move();
            enemy3.move();
            player.move("down");
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.stop();
            enemy.stop();
            enemy2.stop();
            enemy3.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.stop();
            enemy.stop();
            enemy2.stop();
            enemy3.stop();

        }
            
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.stop();
            enemy.stop();
            enemy2.stop();
            enemy3.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.stop();
            enemy.stop();
            enemy2.stop();
            enemy3.stop();
        }    
    }
}
