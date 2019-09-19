/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blobbygame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author CSchafer
 */
public class Player {
   private int height, width, x, y, hp,score, xp, vx, vy;
   private Rectangle bounds;
   private Color color;
   private final int speed = 5;
   
   public Player(int cWidth, int cHeight){
       this.x = cWidth/2;
       this.y = cHeight /2;
       this.width = 50;
       this.height = 50;
       this.hp = 100;
       this.xp = 0;
       this.vx = 0;
       this.vy = 0;
       this.color = Color.YELLOW;
       this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
       
   }
   
   public void move(String direction){
       if(direction.equals("right")){
           this.vx += speed;
       }
      else if(direction.equals("left")){
           this.vx -= speed;
       }
      else if(direction.equals("up")){
           this.vy -= speed;
       }
      else if(direction.equals("down")){
           this.vy += speed;
       }
       
       
   }
   
   public void draw(Graphics g){
       g.setColor(this.color);
       Graphics2D g2d = (Graphics2D) g;
       g2d.fill(bounds);
       
   }
   
   public void attack(){
       
   }
   
   public void collect(){
       
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
    
    public int GetY(){
        return this.y;
    }
    public int GetX(){
        return this.x;
    }
}
