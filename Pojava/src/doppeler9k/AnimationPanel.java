package doppeler9k;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener {
	public double factor = 1;
	double soundVelocity;
	double freq = 1;
	int step = 1;
	int counter = 0;
	double waveLife = 5000;
	double waveLength = 10000/freq;
	int waveNumber = (int)(waveLife/waveLength) + 1;
	public SimulationObject source;
	public SimulationObject observer;
	WaveObject[] wave = new WaveObject[waveNumber];
	//
	Timer tm = new Timer(step,this);
	//
	public void setSoundVel(float sv) {
		soundVelocity = sv;
	}
	public void setFrequency(double f) {
		freq = f;
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
	//
	public void propCalc() {
		source.calculateCoords(step);
		observer.calculateCoords(step);
		if((source.getX()>(this.getWidth())-5)||(source.getX()<0)) {
			source.setAngle(180-source.getAngle());
		}
		if((source.getY()>(this.getHeight())-5)||(source.getY()<0)) {
			source.setAngle((360-source.getAngle()));
		}
		if((observer.getX()>(this.getWidth())-5)||(observer.getX()<0)) {
			observer.setAngle(180-observer.getAngle());
		}
		if((observer.getY()>(this.getHeight())-5)||(observer.getY()<0)) {
			observer.setAngle((360-observer.getAngle()));
		}
	}
	//
	public void drawSoundWaves(Graphics g, double x, double y) {
		for(int n=0; n<waveNumber; n++) {
			wave[n].setV(soundVelocity);
			wave[n].setXY(source.calcInitX(counter+waveLength*n, waveLife), source.calcInitY(counter+waveLength*n, waveLife));
		}
		for(int n = 0; n<waveNumber; n++) {
			g.drawOval((int)(wave[n].getX()-(wave[n].calculateRad(counter+waveLength*n, waveLife)/2)+5),
				(int)(wave[n].getY()-(wave[n].calculateRad(counter+waveLength*n, waveLife)/2)+5), 
				(int)(wave[n].calculateRad(counter+waveLength*n, waveLife)),
				(int)(wave[n].calculateRad(counter+waveLength*n, waveLife)));
		}
	}
	//
	public void paintComponent (Graphics g) {
		for(int n = 0; n < waveNumber; n++) {
			wave[n] = new WaveObject(0,0,0,0);
		}
		//System.out.println(this.getSize());
		//System.out.println(counter);
		//System.out.println(freq);
		System.out.print(waveLength);
		System.out.print('\t');
		System.out.print(waveNumber);
		System.out.print('\n');
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval((int)source.getX(),(int)source.getY(), 5, 5);
		g.fillOval((int)observer.getX(), (int)observer.getY(), 5, 5);
		drawSoundWaves(g, source.getX(), source.getY());
		tm.start();
	}
	//
	@Override
	public void actionPerformed(ActionEvent e) {
		propCalc();
		repaint();
		counter++;
	}
}
