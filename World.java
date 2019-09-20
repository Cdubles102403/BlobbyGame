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
    public World() {
        super();
        player = new Player(800,600);
        enemy = new Enemy(800,600);
        enemy2 = new Enemy(800,600);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/40);
    }

    @Override
    public void paintComponent(Graphics g) {
//        int counter = 0;
//        
        super.paintComponent(g);
        this.setBackground(Color.cyan);
        if(player.isAlive()) {player.draw(g);}
        if(enemy.isAlive()) enemy.draw(g);
        
        if(enemy2.isAlive()){
            enemy2.setColor(Color.MAGENTA);
            enemy2.draw(g);
        }
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            player.update();
            checkCollisions();
            //enemy.move();
            enemy.update();
            enemy2.update();
            repaint();
        }

       
    }
         private void checkCollisions() {
            if(player.getBounds().intersects(enemy.getBounds()) && player.isAlive()){
                if(player.getVy()> 0){
                    System.out.println("kill enemy");
                    enemy.die();
            }
                else{
                   System.out.println("player dead");
                   player.die();
                    
                }
                
            }
            else{
                
            }
       }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            enemy.move();
            enemy2.move();
            player.move("right");
         
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            enemy.move();
            enemy2.move();
            player.move("left");
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            enemy.move();
            enemy2.move();
            player.move("up"); 
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            enemy.move();
            enemy2.move();
            player.move("down");
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.stop();
            enemy.stop();
            enemy2.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.stop();
            enemy.stop();
            enemy2.stop();


        }
            
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.stop();
            enemy.stop();
            enemy2.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.stop();
            enemy.stop();
            enemy2.stop();
        }
            
    }
}
