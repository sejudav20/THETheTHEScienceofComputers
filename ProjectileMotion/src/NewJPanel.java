


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author sejudav20
 */
public class NewJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public static final double Acceleration = -9.8;
    public static double velocity;
    static double xLocation = 10;
    static double yLocation = 390;
    static double totalTime;
    static final double steps = 30;
    static double timeIntreval, timeLeft, timePassed, angle, xVelocity, yVelocity, xIncrement, yIncremant;

    public NewJPanel() {
        initComponents();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Velocity: ");
        velocity = sc.nextDouble();
        System.out.println("Enter angle: ");
        angle = sc.nextDouble();
        xVelocity = velocity * Math.cos(Math.toRadians(angle));
        yVelocity = velocity * Math.sin(Math.toRadians(angle));
        totalTime = -4.0 *yVelocity / Acceleration;
        timeLeft = totalTime;

        timeIntreval = totalTime / steps;

        xIncrement = xVelocity * timeIntreval;
        sc.close();
        super.repaint();

    }

    @Override

    public void paintComponent(Graphics g) {

        super.paintComponent(g); // let the drawing panel draw itself first
        drawCircle(g, (int)xLocation, (int)yLocation);
         g.setColor(Color.cyan);
        g.fillRect(0, 400, 50000, 50000);
        g.setColor(Color.BLACK);
        g.drawString("Ice", 250, 420);
        

    }

    public static void drawCircle(Graphics g, int x, int y) {
       

        g.setColor(Color.BLACK);

        g.fillOval(x, y, 10, 10);

    }

    public void changeLocation(double height) {
        this.repaint();
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(NewJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            timeLeft -= timeIntreval;
            timePassed = totalTime - timeLeft;
            xLocation += xIncrement;
            yIncremant = (yVelocity * timePassed) + (0.5 * (Acceleration * timePassed*timePassed));
            yLocation -= yIncremant;

            if (timeLeft <= 0 || yLocation > 390) {
                yLocation = 390;
                this.repaint();
                break;
            }
            this.repaint();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    // End of variables declaration                   
}










