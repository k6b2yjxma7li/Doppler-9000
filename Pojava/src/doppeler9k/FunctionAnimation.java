/**
 * @author Robert
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */
package doppeler9k;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class FunctionAnimation extends JPanel implements ActionListener {
	//
	public int functionChoiceVal;
	int delayTime = 20;
	double timeDiv = 44;
	double mathStep = (double)(Math.PI/timeDiv);
	double theta = (double)0;
	int yy[] = new int[200];
	Timer timeAnimata = new Timer(delayTime, this);
	//
	public void setFreq(double tD) {
		
		timeDiv = tD;
		mathStep = (double)(Math.PI/timeDiv);
	}
	//
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		for(int x=0; x<199; x++) {
			g.drawLine(x, yy[x], x+1, yy[x+1]);
		}
		timeAnimata.start();
	}
	//
	@Override
	public void actionPerformed(ActionEvent e) {
		theta +=mathStep;
		for(int x=0; x<200; x++) {
			yy[x] = 50;
		}
		switch(functionChoiceVal) {
		case 0:
			{
				for(int x = 0; x<200; x++) {
					yy[x] +=(int)(50*Math.sin(theta+mathStep*x));
				}
				break;
			}
		case 1:
			{
				for(int x = 0; x<200; x++) {
					if(Math.sin(theta+mathStep*x) > 0) {
						yy[x]+=45;
					}else{
						yy[x]-=45;
					}
				}
				break;
			}
		case 2:
			{
				for(int x = 0; x<200; x++) {
					yy[x] +=(int)(50*(Math.cos(theta+mathStep*x)*Math.exp(Math.sin(theta+mathStep*x))/1.46) );
				}
				break;
			}
		}
		repaint();
	}
}
