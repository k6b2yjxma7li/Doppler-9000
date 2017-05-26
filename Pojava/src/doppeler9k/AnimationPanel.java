package doppeler9k;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener {
	float soundVelocity;
	public double factor = 1;
	public SimulationObject source;
	public SimulationObject observer;
	
	//
	public void setSoundVel(float sv) {
		soundVelocity = sv;
	}
	//
	Timer tm = new Timer(5,this);
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
	//
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval((int)source.getX(),(int)source.getY(), 10, 10);
		g.fillOval((int)observer.getX(), (int)observer.getY(), 10, 10);
		tm.start();
	}
	//
	@Override
	public void actionPerformed(ActionEvent e) {
		source.calculateCoords(5);
		observer.calculateCoords(5);
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
	}
}
