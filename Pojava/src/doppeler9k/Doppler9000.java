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
	double getFactor(SimulationObject source, SimulationObject observer)// OBSERVED FREQUENCY = FACTOR*EMITER_FREQ
	{
		double rx = observer.x-source.x;
		double ry = observer.y-source.y;
		double cosObs = 1;
		double cosSou = 1;
		if (source.v != 0 && observer.v != 0){
			cosObs = ((rx*observer.vx()) + (ry*observer.vy())) / ((Math.sqrt(rx*rx+ry*ry) * observer.v));
			cosSou = ((rx*source.vx()) + (ry*source.vy())) / ((Math.sqrt(rx*rx+ry*ry) * source.v));
		}
		double factor = (soundVelocity + (observer.v * cosObs)) / (soundVelocity - (source.v * cosSou));
		return factor;
	}
	//
	public Doppler9000() throws HeadlessException, LineUnavailableException {
		SimulationObject source = new SimulationObject(30,40);
		SimulationObject obserwator = new SimulationObject(90,30); //dodane obiekty majace x,y,v,kat - moze to byc zarowno zrodlo jak i obserwator
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
					source.setV(Float.parseFloat(souVelocityField.getText()));
					FunctionGenerator generator = new FunctionGenerator(
							(Float.parseFloat(freqField.getText())*(float)getFactor(source, obserwator)),
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
		souVelocityField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			source.setV(Float.parseFloat(souVelocityField.getText()));
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
//// chodzi o to ¿e jak ktoœ poda ujemn¹ czêstotliwoœæ lub czêstotliwoœæ przekracza maksymaln¹ czêstotliwoœæ generatora(mo¿e byæ spowodowane tak¿e przez sam efekt dopplera)
