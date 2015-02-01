/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sidescrollerplatexample;

import javax.swing.JFrame;

/**
 *
 * @author SydnaAgnehs
 */
public class SSPlatExample {
    public SSPlatExample() {
        JFrame frame=new JFrame();
        frame.add(new Board());
        frame.setTitle("Platform Engine Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new SSPlatExample();
    }
}
