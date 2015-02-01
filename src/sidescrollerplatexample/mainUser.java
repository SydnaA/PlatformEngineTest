/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sidescrollerplatexample;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author SydnaAgnehs
 */
public class mainUser {
    int x, y, dx, dy;
    Image img;
    ImageIcon img1;
    boolean jumping, canJump;
    int jumpCount;
    int jumpLimit=50;
    final int JUMPPOWER=-1;
    
    
    public mainUser() {
        img1=new ImageIcon(this.getClass().getResource("sprite_still.png"));
        img=img1.getImage();
        x=80;
        y=200;
        jumping=false;
        canJump=true;
    }
    public void moveVer() {
        y=y+dy;
    }
    public void moveHor() {
        x=x+dx;
    }
    
    
    public void jumpMove() {
        y=y+dy;
    }
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Image getImage() {
        return img;
    }
    
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_RIGHT) {
            dx=1;
        }
        if(key==KeyEvent.VK_LEFT) {
            dx=-1;
        }
        if(key==KeyEvent.VK_UP) {
            if(!jumping&&canJump) {
                jumping=true;
                canJump=false;
                jumpCount=0;
            }
        }
    }
    public void keyReleased(KeyEvent e) {
          int key=e.getKeyCode();
        if(key==KeyEvent.VK_RIGHT) {
            dx=0;
        }
        if(key==KeyEvent.VK_LEFT) {
            dx=0;
        }
        if(key==KeyEvent.VK_UP) {
            //dy=0;
        }
    }
    
}
