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

public class Food {
private final int x,y,width,height;
private static boolean eaten;
private Color color;
private Rectangle bounds;

public Food(int cWidth, int cHeight){
   
    this.eaten = false;
    this.x = (int)( Math.random()*cWidth)+1;
    this.y = (int)( Math.random()*cHeight)+1;
    this.color = Color.PINK;
    this.width = 10;
    this.height = 10;
    this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
    }
public void eaten(){
    this.eaten = true;
    }

public static boolean isEaten(){
    return eaten;
}

public void draw(Graphics g){
       g.setColor(this.color);
       Graphics2D g2d = (Graphics2D) g;
       g2d.fill(bounds);  
   }
public void update(){
       this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
   }
public Rectangle getBounds() {
        return bounds;
    }
}
