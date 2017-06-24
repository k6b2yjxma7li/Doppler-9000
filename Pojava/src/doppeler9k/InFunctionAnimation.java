package doppeler9k;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.Timer;

public class InFunctionAnimation extends JPanel implements ActionListener {
	public int functionChoiceVal;
	int delayTime = 15;
	double mathStep = 0;
	double theta = (double)0;
	int pointNr = 1000;
	int yy[] = new int[pointNr];
	Timer timer = new Timer(delayTime, this);
	//
	public double valueProvider() throws NumberFormatException, IOException {
		BufferedReader valuer = new BufferedReader(new FileReader("operatorfile.txt"));
		double tmp = 1;
		if(valuer != null) {
			tmp = Double.parseDouble(valuer.readLine());
		}
		return tmp;
	}
	public void setFreq(double tD) {
		mathStep = (double)((Math.PI/100)*tD);
	}
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.GREEN);
		for(int x=0; x<(pointNr-1); x++) {
			g.drawLine(x, yy[x], x+1, yy[x+1]);
		}
		timer.start();
	}
	//
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		try {
			theta +=mathStep*valueProvider();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		for(int x=0; x<pointNr; x++) {
			yy[x] = 50;
		}
		switch(functionChoiceVal) {
		case 0:
		{
			for(int x = 0; x<pointNr; x++) {
				yy[x] +=(int)(50*Math.sin(theta+mathStep*x));
			}
			break;
		}
		case 1:
		{
			for(int x = 0; x<pointNr; x++) {
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
			for(int x = 0; x<pointNr; x++) {
					yy[x] +=(int)(50*(Math.cos(theta+mathStep*x)*Math.exp(Math.sin(theta+mathStep*x))/1.46) );
			}
			break;
		}
		}
		repaint();
	}
}
