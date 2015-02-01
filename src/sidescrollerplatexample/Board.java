/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sidescrollerplatexample;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author SydnaAgnehs
 */
public class Board extends JPanel implements ActionListener {
    mainUser user1;
    Timer time;
    Platform[] plat;
    
    
    public Board() {
        user1=new mainUser();
        plat=new Platform[4];
        this.setUpPlat();
        this.addKeyListener(new actL());
        this.setFocusable(true);
        
        time=new Timer(5, this);
        time.start();
        
    }
    
    public void falling() {
        if((plat[0].getX()+258>user1.getX())&&(plat[0].getX()-25<user1.getX())&&(user1.getY()==plat[0].getY()-31)) {
            user1.dy=0;
        }
        if((plat[1].getX()+258>user1.getX())&&(plat[1].getX()-25<user1.getX())&&(user1.getY()==plat[1].getY()-31)) {
            user1.dy=0;
        }
        if((plat[2].getX()+258>user1.getX())&&(plat[2].getX()-25<user1.getX())&&(user1.getY()==plat[2].getY()-31)) {
            user1.dy=0;
        }
        if((plat[3].getX()+258>user1.getX())&&(plat[3].getX()-25<user1.getX())&&(user1.getY()==plat[3].getY()-31)) {
            user1.dy=0;
        }
    }
    
    public void setUpPlat() {
        plat[0]=new Platform();
        plat[0].setX(50);
        plat[0].setY(300);
        
        plat[1]=new Platform();
        plat[1].setX(200);
        plat[1].setY(250);
        
        plat[2]=new Platform();
        plat[2].setX(400);
        plat[2].setY(300);
        
        plat[3]=new Platform();
        plat[3].setX(700);
        plat[3].setY(300);
    }
    public void actionPerformed(ActionEvent e) {
        if((plat[0].getX()+258>user1.getX())&&(plat[0].getX()-25<user1.getX())&&(user1.getY()==plat[0].getY()-31)
                ||(plat[1].getX()+258>user1.getX())&&(plat[1].getX()-25<user1.getX())&&(user1.getY()==plat[1].getY()-31)
                ||(plat[2].getX()+258>user1.getX())&&(plat[2].getX()-25<user1.getX())&&(user1.getY()==plat[2].getY()-31)
                ||(plat[3].getX()+258>user1.getX())&&(plat[3].getX()-25<user1.getX())&&(user1.getY()==plat[3].getY()-31)) {
            user1.canJump=true;
        } else {
            user1.canJump=false;
        }
        if(user1.jumping) {
            user1.dy=user1.JUMPPOWER;
            this.user1.jumpMove();
            if(user1.jumpCount>=user1.jumpLimit) {
                user1.jumping=false;
                user1.dy=1;
            }
            user1.jumpCount++;
        } else {
            user1.dy=1;
        }
        this.falling();
        this.platformMove();
        user1.moveVer();
        repaint();
        
    }
    
    public void platformMove() {
        if(user1.x<100&&user1.dx<=0||user1.x>500&&user1.dx>=0) {
            for(int x=0;x<plat.length;x++) {
                plat[x].move(user1.dx);
            }
        } else {
            user1.moveHor();
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d=(Graphics2D) g;
        g2d.drawImage(user1.getImage(), user1.getX(), user1.getY(), null);
        for(int x=0;x<plat.length;x++) {
        g2d.drawImage(plat[x].getImage(), plat[x].getX(), plat[x].getY(), null);
        
        String msg = "Platform Engine Testing ";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics met = this.getFontMetrics(small);
        g.setColor(Color.BLUE);
        g.setFont(small);
        g.drawString(msg, ((600 - met.stringWidth(msg))/2), (400/2)-80);
        
        
        
        }
        
    }
    
    private class actL extends KeyAdapter{
        public void keyReleased(KeyEvent e) {
            user1.keyReleased(e);
                   
            
        }
        public void keyPressed(KeyEvent e) {
            user1.keyPressed(e);
        }
    }

}
