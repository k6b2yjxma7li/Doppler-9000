/**
 * @author Robert
 * @author Karol
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */

package doppeler9k;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;

public class Doppler9000 extends WindowGUI {
	int functionChoice;
	float soundVelocity = (float)343.8;
	public SimulationObject source = new SimulationObject();
	public SimulationObject observer = new SimulationObject();
	public AnimationPanel animation;
	//
	//SETS VALUES FOR ANIMATION
	public void setValuesAnim() {
		source.setAngle(Float.parseFloat(souPanel.souDirection.getText()));
		source.setV(Float.parseFloat(souPanel.souVelocityField.getText()));
		source.setX(1+Float.parseFloat(souPanel.souXPosition.getText()));
		source.setY(1+Float.parseFloat(souPanel.souYPosition.getText()));
		observer.setAngle(Float.parseFloat(obsPanel.obsDirection.getText()));
		observer.setV(Float.parseFloat(obsPanel.obsVelocityField.getText()));
		observer.setX(1+Float.parseFloat(obsPanel.obsXPosition.getText()));
		observer.setY(1+Float.parseFloat(obsPanel.obsYPosition.getText()));
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
	public Doppler9000() throws HeadlessException, LineUnavailableException, FileNotFoundException, IOException {
		//
		souPanel.stopButton.setEnabled(false);
		souPanel.resetButton.setEnabled(false);
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
				try {
					animation = new AnimationPanel();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				

				upperPanel.remove(animation);
				upperPanel.repaint();
				animation.tm.stop();
				animation.setSize(500, 500);
				upperPanel.add(animation);
				functionAnimation.setFreq(Math.log(Float.parseFloat(souPanel.freqField.getText())));
				setValuesAnim();
				functionAnimation.repaint();
				animation.tm.start();
				animation.repaint();
				souPanel.startButton.setEnabled(false);
				souPanel.resetButton.setEnabled(true);
				souPanel.stopButton.setEnabled(true);
				
			}
		});
		souPanel.stopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				upperPanel.remove(animation);
				upperPanel.removeAll();
				upperPanel.repaint();
				animation.tm.stop();
				animation.outFile.close();
				souPanel.stopButton.setEnabled(false);
				souPanel.stopButton.setEnabled(false);
				souPanel.startButton.setEnabled(true);
				//generator.dispose();
				//generator.soundTimer.stop();
			}
		});
		souPanel.resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				upperPanel.remove(animation);
				upperPanel.add(animation, BorderLayout.WEST);
				animation.tm.stop();
				animation.outFile.close();
				setValuesAnim();
				animation.tm.start();
			
				
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
		//SOUND GENERATING
		startGenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FunctionGenerator gen = new FunctionGenerator(Float.parseFloat(souPanel.freqField.getText()), 10, functionChoice);
				} catch (LineUnavailableException e1) {
					e1.printStackTrace();
				}catch (NumberFormatException e1) {
					e1.printStackTrace();
				}catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		/*stopGenButton.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				//end of generation
			}
		});*/
	}
	//MAIN F
	public static void main(String[] args) throws HeadlessException, LineUnavailableException, IOException {
		Doppler9000 mainWin = new Doppler9000();
		mainWin.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
