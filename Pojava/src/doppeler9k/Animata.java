/**
 *@author Robert
 */

package doppeler9k;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JApplet;

public class Animata extends JApplet implements Runnable {
	Thread animation;
	//
	int delayTime = 5;
	float mathStep = (float)(Math.PI/10);
	float theta = (float)0;
	int n= 100;
	int yy[] = new int[n];
	//
	public void start() {
		if(animation == null) {
			animation = new Thread(this);
			animation.start();
		}
	}
	//
	@SuppressWarnings("deprecation")
	public void stop() {
		if(animation != null) {
			animation.stop();
			animation = null;
		}
	}
    //
    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(int x = 0; x<99; x++) {
        	g2d.drawLine(x, yy[x], 1+x, yy[x+1]);
        }
    }
    //
    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
	public void run() {
		while(true) {
			for(int x=0; x<100; x++) {
				yy[x] = 50;
			}
			for(int x = 0; x<100; x++) {
				yy[x] +=(int)(50*Math.sin(theta+mathStep*x));
			}
			theta +=mathStep;
			/*for(int x = 0; x<4; x++) {
				System.out.print(5*Math.sin(theta+mathStep*x));
				System.out.print('\t');
			}*/
			System.out.println();
			repaint();
			try { 
				Thread.sleep(delayTime);
			}catch (InterruptedException e) {
			}
		}
	}
}