/**
 * @author Robert
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */

package doppeler9k;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.LineUnavailableException;

public class Doppler9000 extends WindowGUI {
	int functionChoice = 0;
	float soundVelocity = (float)343.8;
	
	public Doppler9000() throws HeadlessException, LineUnavailableException {
		SimulationObject obserwator = new SimulationObject(); //dodane obiekty majace x,y,v,kat - moze to byc zarowno zrodlo jak i obserwator
		//
		sineButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				functionChoice = 0;
			}
		});
		squareButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				functionChoice = 1;
			}
		});
		expButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				functionChoice = 2;
			}
		});
		freqGenerateButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
					obserwator.setV(Float.parseFloat(velocityField.getText()));
					FunctionGenerator generator = new FunctionGenerator(
							(Float.parseFloat(freqField.getText())*((soundVelocity+obserwator.v)/soundVelocity)),
							volumeSlider.getValue(),
							functionChoice);
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				}
			}
		});
		velocityField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				obserwator.setV(Float.parseFloat(velocityField.getText()));
			}
		});
		airButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				soundVelocity = (float)343.8;
			}
		});
		waterButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				soundVelocity = (float)1500;
			}
		});
		heliumButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				soundVelocity = (float)965;
			}
		});
	}
	public static void main(String[] args) throws HeadlessException, LineUnavailableException {
		Doppler9000 Win = new Doppler9000();
	}
}
