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
	public SimulationObject source;
	public SimulationObject observer;
		
	Timer tm = new Timer(5,this);
	
	public void setSoundVel(float sv) {
		soundVelocity = sv;
	}
		
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval((int)source.getX(),(int)source.getY(), 10, 10);
		g.fillOval((int)observer.getX(), (int)observer.getY(), 10, 10);
		tm.start();
	}
		
	//czy w poni¿szej funkcji nie mozna by by³o daæ tak¿e odtwarzania dzwiêku? //K
	//nie wydaje mi sie, ale dodalem warunki brzegowe /R
	@Override
	public void actionPerformed(ActionEvent e) {
		source.calculateCoords(5);
		if((source.x>(this.getWidth()-10))||(source.getX()<0)) {
			source.setAngle(180-source.getAngle());
		}
		if((source.y>(this.getHeight()-10))||(source.getY()<0)) {
			source.setAngle((360-source.getAngle()));
		}
		repaint();
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
