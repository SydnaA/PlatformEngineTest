/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sidescrollerplatexample;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author SydnaAgnehs
 */
public class Platform {
    int x, y, dx, dy;
    Image img;
    ImageIcon img1;
    
    public Platform() {
        img1=new ImageIcon(this.getClass().getResource("platform.png"));
        img=img1.getImage();
    }
     public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
     public void setX(int x) {
        this.x=x;
    }
    public void setY(int y) {
        this.y=y;
    }
    public Image getImage() {
        return img;
    }
    public void move(int speed) {
        x=x-speed;
    }
}
