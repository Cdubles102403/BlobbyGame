package blobbygame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
package blobbygame;



/**
 *
 * @author CSchafer
 */

public class Enemy {
 private int x,y,health,vx,vy, height, width, cHeight, cWidth, strength;
 private Color color;
 private final int speed = 5;
 private Rectangle bounds;
 private boolean alive;
 
 
     public Enemy(int cWidth, int cHeight){
         this.alive = true;
        this.x = (int)( Math.random()*cWidth)+1;
        this.y = (int)( Math.random()*cHeight)+1;
        this.width = 40;
        this.height = 40;
        this.color = Color.RED;
        this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
        this.cHeight = cHeight;
        this.cWidth = cWidth;
        
        
    }
     public void move(){
         int ran = (int)(Math.random()*4)+1;
        //left
      if(ran == 1 && x>=0){
        this.vx = -speed;
      }
      //right
     else if(ran == 2 && x<=cWidth){
        this.vx = speed;
      }
      //up
     else if(ran == 3 && y>=0){
        this.vy = speed;
      }
      //down
     else if(ran == 4 && y<=cHeight ){
        this.vy = -speed;
      }
     
     else{
         this.vy = 0;
         this.vx = 0;
     }
   }
     
     public void draw(Graphics g){
       g.setColor(this.color);
       Graphics2D g2d = (Graphics2D) g;
       g2d.fill(bounds);
       
   }
     
     public void update(){
       this.x +=vx;
       this.y +=vy;
       this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
   }
     
     void stop() {
       vx = 0;
       vy = 0;
    }

    public Rectangle getBounds() {
        return bounds;
    }
    public void die(){
        this.alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
