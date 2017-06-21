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
	int limitVel;
	float soundVelocity = (float)343.8;
	public SimulationObject source = new SimulationObject();
	public SimulationObject observer = new SimulationObject();
	public AnimationPanel animation;
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
		if(limitVel == 0) {
			if(source.v > soundVelocity) {
				System.out.println("Source velocity too high! Set to max");
				source.setV(soundVelocity);
			}
			if(observer.v > soundVelocity) {
				System.out.println("Observer velocity too high! Set to max");
				observer.setV(soundVelocity);
			}
		}
	}
	//MAIN C
	public Doppler9000() throws HeadlessException, LineUnavailableException, FileNotFoundException, IOException {
		//MENU 
		mainBar.sineButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				functionChoice = 0;
				emittedSignalAnimation.functionChoiceVal = 0;
				signalAnimationPanel.add(emittedSignalAnimation);
			}
		});
		mainBar.squareButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				functionChoice = 1;
				emittedSignalAnimation.functionChoiceVal = 1;
				signalAnimationPanel.add(emittedSignalAnimation);
			}
		});
		mainBar.expButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				functionChoice = 2;
				emittedSignalAnimation.functionChoiceVal = 2;
				signalAnimationPanel.add(emittedSignalAnimation);
			}
		});
		//
		mainBar.exitButton.addActionListener(new ActionListener() {
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
				animation.setSize(upperPanel.getWidth(),upperPanel.getHeight());
				upperPanel.add(animation);
				emittedSignalAnimation.setFreq(Math.log(Float.parseFloat(souPanel.freqField.getText())));
				setValuesAnim();
				emittedSignalAnimation.repaint();
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
				emittedSignalAnimation.setFreq(Math.log(Float.parseFloat(souPanel.freqField.getText())));
				animation.tm.stop();
				animation.outFile.close();
				souPanel.stopButton.setEnabled(false);
				souPanel.startButton.setEnabled(true);
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
				souPanel.stopButton.setEnabled(true);
				souPanel.startButton.setEnabled(false);
			}			
		});
		//MATERIAL
		mainBar.airButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				soundVelocity = (float)343.8;
			}
		});
		mainBar.waterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				soundVelocity = (float)1500;
			}
		});
		mainBar.heliumButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				soundVelocity = (float)965;
			}
		});
		//SOUND GENERATING
		mainBar.startGenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FunctionGenerator gen = new FunctionGenerator(Float.parseFloat(souPanel.freqField.getText()), 10, functionChoice);
				} catch (NumberFormatException | LineUnavailableException | IOException e1) {
					e1.printStackTrace();
				}
			
			}
		});
		obsPanel.vLimit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(obsPanel.vLimit.isSelected()) {
					limitVel = 0;
				}else {
					limitVel = 1;
				}
			}
		});
		obsPanel.vLimitPL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(obsPanel.vLimitPL.isSelected()) {
					limitVel = 0;
				}else {
					limitVel = 1;
				}
			}
		});
	}
	//MAIN F
	public static void main(String[] args) throws HeadlessException, LineUnavailableException, IOException {
		LangChoose win = new LangChoose();
		while(win.getLanguage() == 69)
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		Doppler9000 mainWin = new Doppler9000();
		mainWin.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
