/**
 * @author Robert
 * @author Karol
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */

package doppeler9k;

import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;

public class Doppler9000 extends WindowGUI {
	int functionChoice;
	float soundVelocity = (float)343.8;
	public SimulationObject source = new SimulationObject();
	public SimulationObject observer = new SimulationObject();
	public JFrame win = new JFrame();
	public AnimationPanel animation;
	//public SoundOperator generator = new SoundOperator();
	//
	//SETS VALUES FOR ANIMATION
	public void setValuesAnim() {
		source.setAngle(Float.parseFloat(souPanel.souDirection.getText()));
		source.setV(Float.parseFloat(souPanel.souVelocityField.getText()));
		source.setX(Float.parseFloat(souPanel.souXPosition.getText()));
		source.setY(Float.parseFloat(souPanel.souYPosition.getText()));
		observer.setAngle(Float.parseFloat(obsPanel.obsDirection.getText()));
		observer.setV(Float.parseFloat(obsPanel.obsVelocityField.getText()));
		observer.setX(Float.parseFloat(obsPanel.obsXPosition.getText()));
		observer.setY(Float.parseFloat(obsPanel.obsYPosition.getText()));
		animation.setSoundVel(soundVelocity);
		animation.observer=observer;
		animation.source=source;
		animation.counter = 0;
		if(source.v > soundVelocity) {
			System.out.println("Source velocity too high! Set to max");
			source.setV(soundVelocity);
		}
		if(observer.v > soundVelocity) {
			System.out.println("Observer velocity too high! Set to max");
			observer.setV(soundVelocity);
		}
	}
	//MAIN C
	public Doppler9000() throws HeadlessException, LineUnavailableException, FileNotFoundException {
		//MENU 
		sineButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				functionChoice = 0;
				functionAnimation.functionChoiceVal = 0;
				emitSignalPanel.add(functionAnimation);
			}
		});
		squareButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				functionChoice = 1;
				functionAnimation.functionChoiceVal = 1;
				emitSignalPanel.add(functionAnimation);
			}
		});
		expButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				functionChoice = 2;
				functionAnimation.functionChoiceVal = 2;
				emitSignalPanel.add(functionAnimation);
			}
		});
		//
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		souPanel.startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				win.dispose();
				try {
					animation = new AnimationPanel();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				functionAnimation.setFreq(Math.log(Float.parseFloat(souPanel.freqField.getText())));
				setValuesAnim();
				functionAnimation.repaint();
				//animation.setFrequency(Double.parseDouble(souPanel.freqField.getText()));
				animation.tm.start();
				animation.repaint();
				//generator.soundTimer.start();
				win.setSize(500, 500);
				win.setVisible(true);
				win.add(animation);
				win.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				win.setLocation(new Point(0,0));
				win.setTitle("To close this window press 'Stop' in main window");
				
			}
		});
		souPanel.stopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.dispose();
				animation.tm.stop();
				animation.outFile.close();
				//generator.dispose();
				//generator.soundTimer.stop();
			}
		});
		souPanel.resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setValuesAnim();
				animation.repaint();
				//setValuesGen();
			}			
		});
		//MATERIAL
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
	//MAIN F
	public static void main(String[] args) throws HeadlessException, LineUnavailableException, FileNotFoundException {
		Doppler9000 mainWin = new Doppler9000();
		mainWin.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
