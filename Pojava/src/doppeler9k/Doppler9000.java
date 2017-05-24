/**
 * @author Robert
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */

package doppeler9k;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;

public class Doppler9000 extends WindowGUI {
	int functionChoice = 0;
	float soundVelocity = (float)343.8;
	public SimulationObject source = new SimulationObject(30,40);
	public SimulationObject obserwator = new SimulationObject(90,30);

	public Doppler9000() throws HeadlessException, LineUnavailableException {
				//
		sineButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				functionChoice = 0;
				Animatronix sineAnimation = new Animatronix();
				emitSignalPanel.add(sineAnimation);
				sineAnimation.setSize(300, 300);
				sineAnimation.functionChoiceVal = 0;
			}
		});
		squareButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				functionChoice = 1;
				Animatronix squareAnimation = new Animatronix();
				emitSignalPanel.add(squareAnimation);
				squareAnimation.setSize(215, 150);
				squareAnimation.functionChoiceVal = 1;
			}
		});
		expButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				functionChoice = 2;
				Animatronix expAnimation = new Animatronix();
				emitSignalPanel.add(expAnimation);
				expAnimation.setSize(215, 150);
				expAnimation.functionChoiceVal = 2;
			}
		});
		souPanel.freqGenerateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
					obserwator.setV(Float.parseFloat(obsPanel.obsVelocityField.getText()));
					source.setV(Float.parseFloat(souPanel.souVelocityField.getText()));
					FunctionGenerator generator = new FunctionGenerator(
							(Float.parseFloat(souPanel.freqField.getText())*(float)getFactor(source, obserwator)),
							volumeSlider.getValue(),
							functionChoice);
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				}
			}
		});
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		souPanel.velocityField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				obserwator.setV(Float.parseFloat(souPanel.velocityField.getText()));
			}
		});
		souPanel.souVelocityField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			source.setV(Float.parseFloat(souPanel.souVelocityField.getText()));
			}
		});
		obsPanel.obsVelocityField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			obserwator.setV(Float.parseFloat(obsPanel.obsVelocityField.getText()));
			}
		});
		airButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				soundVelocity = (float)343.8;
			}
		});
		waterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				soundVelocity = (float)1500;
			}
		});
		heliumButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				soundVelocity = (float)965;
			}
		});
	}
	//
	//OBSERVED FREQUENCY = FACTOR*EMITER_FREQ
	double getFactor(SimulationObject source, SimulationObject observer) {
		double rx = observer.x-source.x;
		double ry = observer.y-source.y;
		double cosObs = 1;
		double cosSou = 1;
		if (source.v != 0 && observer.v != 0) {
			cosObs = ((rx*observer.vx()) + (ry*observer.vy())) / ((Math.sqrt(rx*rx+ry*ry) * observer.v));
			cosSou = ((rx*source.vx()) + (ry*source.vy())) / ((Math.sqrt(rx*rx+ry*ry) * source.v));
		}
		double factor = (soundVelocity + (observer.v * cosObs)) / (soundVelocity - (source.v * cosSou));
		return factor;
	}
	//
	//MAIN
	public static void main(String[] args) throws HeadlessException, LineUnavailableException {
		Doppler9000 mainWin = new Doppler9000();
		AnimationPanel panel = new AnimationPanel();
		JFrame win = new JFrame();
		win.setSize(1000, 1000);
		win.setVisible(true);
		win.add(panel);
		win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
}
