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
    public World() {
        super();
        player = new Player(800,600);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/12);
    }

    @Override
    public void paintComponent(Graphics g) {
//        int counter = 0;
//        
        super.paintComponent(g);
        this.setBackground(Color.cyan);
        player.draw(g);
        
        
        
//        g.setColor(Color.red);
//        
//        while(counter<32){
//            int ran1 = (int) (Math.random()*20);
//            int ran2 = (int) (Math.random()*20);
//            if(counter>15){
//                g.setColor(Color.red);
//            }
//            else{
//                g.setColor(Color.GREEN);
//            }
//            g.fillRect(28 * ran1, 28 * ran2, 8 *ran2, 8 *ran1);
//            System.out.println(ran1);
//            counter++;
//        }
       
       
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            player.update();
            repaint();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
          player.move("right");
         
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
           player.move("left");
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
           player.move("up"); 
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.move("down");
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.stop();
        }
            
    }
}
