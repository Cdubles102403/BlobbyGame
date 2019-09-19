package blobbygame;

import java.awt.Color;

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
 private int x,y,health,vx,vy;
 private Color color;
 private final int speed = 5;
 
     public Enemy(int cWidth, int cHeight){
        this.x = cWidth/2+ 20;
        this.y = cHeight/2 + 30;
        this.color = Color.LIGHT_GRAY;
        
    }
     public void move(){
         int ran = (int)(Math.random()*4);
        //left
      if(ran == 1){
          
      }
      if(ran == 2){
       //right  
      }
      if(ran == 3){
       //up
      }
      //down
      if(ran == 4){
          
      }
     }
     public void attack(){
         
     }
     public void update(){
            
     }
}
