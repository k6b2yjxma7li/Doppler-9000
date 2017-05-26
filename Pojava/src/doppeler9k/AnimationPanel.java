package doppeler9k;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener {
	public double factor = 1;
	float soundVelocity;
	float freq = 0;
	int funct = 0;
	float vol = 0;
	int step = 100;
	int counter = 0;
	public SimulationObject source;
	public SimulationObject observer;
	//
	Timer tm = new Timer(step,this);
	//
	public void setSoundVel(float sv) {
		soundVelocity = sv;
	}
	//
	public double getFactor() {
		double value;
		double rx = observer.getX()-source.getX();
		double ry = observer.getY()-source.getY();
		double cosObs = 1;
		double cosSou = 1;
		if (source.v != 0 && observer.v != 0) {
			cosObs = ((rx*observer.vx()) + (ry*observer.vy())) / ((Math.sqrt(rx*rx+ry*ry) * observer.v));
			cosSou = ((rx*source.vx()) + (ry*source.vy())) / ((Math.sqrt(rx*rx+ry*ry) * source.v));
		}
		return value = (soundVelocity + (observer.v * cosObs)) / (soundVelocity - (source.v * cosSou));
	}
	//	//function that animates wave propagation
	public void drawSoundWaves(Graphics g, int x, int y, int iteration) {
		int r = (int)(20+soundVelocity*step*0.001*(counter-iteration));
		g.drawOval(x-(r/2), y-(r/2) ,r,r);
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval((int)source.getX(),(int)source.getY(), 10, 10);
		g.fillOval((int)observer.getX(), (int)observer.getY(), 10, 10);
		//it means that the source emits sound for 100*30 miliseconds
		//fixed number of circles to 30 to save processing power, we shall decide our limit later//K
		for(int i = 0; i< 30; i++) {
			drawSoundWaves(g,
					(int)(source.getX()+i*source.vx()*step*0.001),
					(int)(source.getY()+i*source.vy()*step*0.001),
					i);
		}
		tm.start();
	}
	//
	@Override
	public void actionPerformed(ActionEvent e) {
		source.calculateCoords(step);
		observer.calculateCoords(step);
		if((source.getX()>(this.getWidth()-10))||(source.getX()<0)) {
			source.setAngle(180-source.getAngle());
		}
		if((source.getY()>(this.getHeight()-10))||(source.getY()<0)) {
			source.setAngle((360-source.getAngle()));
		}
		if((observer.getX()>(this.getWidth()-10))||(observer.getX()<0)) {
			observer.setAngle(180-observer.getAngle());
		}
		if((observer.getY()>(this.getHeight()-10))||(observer.getY()<0)) {
			observer.setAngle((360-observer.getAngle()));
		}
		repaint();
		counter++;
	}
}
