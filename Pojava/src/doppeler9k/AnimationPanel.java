package doppeler9k;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener {
	float soundVelocity = (float)343.8;
	float freq = 0;
	int funct = 0;
	float vol = 0;
	int step = 100;
	int counter = 0;
	public SimulationObject source;
	public SimulationObject observer;
		
	Timer tm = new Timer(step,this);
	
	public void setSoundVel(float sv) {
		soundVelocity = sv;
	}
	public void drawSoundWaves(Graphics g,int x,int y,int iteration)	//function that animates wave propagation
	{
		
		int r = (int)(20+soundVelocity*step*0.001*(counter-iteration));
		g.drawOval(x-(r/2), y-(r/2) ,r,r);
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval((int)source.getX(),(int)source.getY(), 10, 10);
		g.fillOval((int)observer.getX(), (int)observer.getY(), 10, 10);
		for (int i = 0; i< 30; i++)//fixed number of circles to 30 to save processing power, we shall decide our limit later//K
		{	//it means that the source emits sound for 100*30 miliseconds
		drawSoundWaves(g,(int)(source.getInitX()+i*source.vx()*step*0.001),(int)(source.getInitY()+i*source.vy()*step*0.001),i);
		}
		tm.start();
	}
	
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
		//uwazam ze warunki brzegowe powinny byæ takie, ¿e symulacja koñczy siê gdy zrod³o wychodzi za krawêdz okna//K
		repaint();
		counter++;
	}
	//ta funkcja zostanie przywolana gdy bedzie rozdzielenie watkow /R
	public void simGenerator() {
		double rx = observer.x-source.x;
		double ry = observer.y-source.y;
		double cosObs = 1;
		double cosSou = 1;
		if (source.v != 0 && observer.v != 0) {
			cosObs = ((rx*observer.vx()) + (ry*observer.vy())) / ((Math.sqrt(rx*rx+ry*ry) * observer.v));
			cosSou = ((rx*source.vx()) + (ry*source.vy())) / ((Math.sqrt(rx*rx+ry*ry) * source.v));
		}
		double factor = (soundVelocity + (observer.v * cosObs)) / (soundVelocity - (source.v * cosSou));
		try {
			new FunctionGenerator((int)(freq*factor), vol, funct);
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
	}
}
