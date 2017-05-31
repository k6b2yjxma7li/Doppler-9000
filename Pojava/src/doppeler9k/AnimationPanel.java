package doppeler9k;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener {
	double soundVelocity = 100;
	double freq;
	int step = 1;
	int counter = 0;
	int ncounter = 0;
	double waveLife = 2000;
	double waveLength = (double)(20);
	int waveNumber = (int)(waveLife/waveLength);
	public SimulationObject source;
	public SimulationObject observer;
	WaveObject[] wave = new WaveObject[waveNumber];
	//
	public void setSoundVel(float sv) {
		soundVelocity = sv;
	}
	//
	public void setFrequency(double f) {
		freq = f;
	}
	//
	public AnimationPanel() {
		for(int n =0; n < waveNumber; n++) {
			wave[n] = new WaveObject(0,0,0,0);
		}
	}
	//
	Timer tm = new Timer(step,this);
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
	public void drawSoundWaves(Graphics g) {
		double[] r = new double[waveNumber];
		//
		for(int n = 0; n < waveNumber; n++) {
			if((counter+waveLength*n)%waveLife==0) {
				wave[n].setXY(source.getX(), source.getY());
			}
		}
		for(int n = 0; n < waveNumber; n++) {
			wave[n].setV(soundVelocity);
			r[n] = wave[n].calculateRad(counter+waveLength*n, waveLife);
			g.drawOval((int)(wave[n].getX() - r[n]/2 + 2.5),
					(int)(wave[n].getY() - r[n]/2 + 2.5),
					(int)(r[n]),
					(int)(r[n]));
		}
	}
	//
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillOval((int)source.getX(), (int)source.getY(), 5, 5);
		g.fillOval((int)observer.getX(), (int)observer.getY(), 5, 5);
		drawSoundWaves(g);
		tm.start();
	}
	//
	public double getFactor() {
		double value;
		double rx = observer.getX()-source.getX();
		double ry = observer.getY()-source.getY();
		double cosObs = 1;
		double cosSou = 1;
		if (source.getV() != 0) {
			cosSou = ((rx*source.vx()) + (ry*source.vy())) / ((Math.sqrt(rx*rx+ry*ry) * source.getV()));
		}
		if(observer.getV() != 0) {
			cosObs = ((rx*observer.vx()) + (ry*observer.vy())) / ((Math.sqrt(rx*rx+ry*ry) * observer.getV()));
		}
		value = (soundVelocity + (observer.getV()* cosObs)) / (soundVelocity - (source.getV() * cosSou));
		return value;
	}
	/*public void printer(double x, double y, double z) {
		System.out.print(x);
		System.out.print('\t');
		System.out.print(y);
		System.out.print('\t');
		System.out.print(z);
		System.out.print('\n');
		
	}*/
	//
	@Override
	public void actionPerformed(ActionEvent e) {
		propCalc();
		repaint();
		counter++;
	}
}
