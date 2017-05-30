/**
 * @author Robert
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */

package doppeler9k;

import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;

public class Doppler9000 extends WindowGUI {
	int functionChoice;
	float soundVelocity = (float)343.8;
	public SimulationObject source = new SimulationObject(100,100);
	public SimulationObject observer = new SimulationObject(100,100);
	public JFrame win = new JFrame();
	public AnimationPanel animation = new AnimationPanel();
	public SoundOperator generator = new SoundOperator();
	//
	public Doppler9000() throws HeadlessException, LineUnavailableException {
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
		//SOURCE PROP
		souPanel.souVelocityField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				source.setV(Double.parseDouble(souPanel.souVelocityField.getText()));
			}
		});
		souPanel.souDirection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				source.setAngle(Double.parseDouble(souPanel.souDirection.getText()));
			}
		});
		souPanel.souXPosition.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				source.setX(Integer.parseInt(souPanel.souXPosition.getText()));
			}			
		});
		souPanel.souYPosition.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				source.setY(Integer.parseInt(souPanel.souYPosition.getText()));
			}			
		});
		souPanel.startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				win.dispose();
				generator.dispose();
				setValuesAnim();
				//setValuesGen();
				animation.tm.start();
				generator.soundTimer.start();
				animation.observer=observer;
				animation.source=source;
				animation.setFrequency(Double.parseDouble(souPanel.freqField.getText()));
				win.setSize(500, 500);
				win.setVisible(true);
				win.add(animation);
				win.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				win.setLocation(new Point(0,0));
				win.setTitle("To close this window press 'Stop' in main window");
				functionAnimation.timeDiv = Math.log(Float.parseFloat(souPanel.freqField.getText()));
			}
		});
		souPanel.stopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.dispose();
				animation.tm.stop();
				generator.dispose();
				generator.soundTimer.stop();
			}
		});
		souPanel.resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setValuesAnim();
				//setValuesGen();
			}			
		});
		//OBSERVER PROP
		obsPanel.obsVelocityField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				observer.setV(Float.parseFloat(obsPanel.obsVelocityField.getText()));
			}
		});
		obsPanel.obsDirection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				observer.setAngle(Float.parseFloat(obsPanel.obsDirection.getText()));
			}
		});
		obsPanel.obsXPosition.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				observer.setX(Integer.parseInt(obsPanel.obsXPosition.getText()));
			}			
		});
		obsPanel.obsYPosition.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				observer.setY(Integer.parseInt(obsPanel.obsYPosition.getText()));
			}			
		});
		//resetButton.
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
		animation.soundVelocity = soundVelocity;
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
	//SETS VALUES FOR GENERATOR - DOES NOT WORK
	public void setValuesGen() {
		generator.f = (float) (Float.parseFloat(souPanel.freqField.getText())*animation.getFactor());
		generator.fTyp = functionChoice;
		generator.vol = 100;
	}
	//MAIN
	public static void main(String[] args) throws HeadlessException, LineUnavailableException {
		Doppler9000 mainWin = new Doppler9000();
		mainWin.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
