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
	//KOMENTAZE WZGLEDEM ELEMOENTOW PO ANGIELSKU I WIELKIMI LITERAMI (lepiej wyglada przy oddawaniu)
	//komentarze wzgledem przyszlych poprawek moga byc normalne/R
	double getFactor(SimulationObject source, SimulationObject observer)// czestotliwosc wynikowa to f_zrodla*getFactor
	{
		double rx = observer.x-source.x;
		System.out.print("Rx: ");
		System.out.println(rx);
		double ry = observer.y-source.y;
		System.out.print("Ry: ");
		System.out.println(ry);
		double cosObs = 1;
		double cosSou = 1;
		if (source.v != 0 && observer.v != 0){//do poprawienia - przy wpisaniu v_observer i v_source = 10 wyrzuca cosinusy =600 /R
			cosObs = (rx*observer.vx()) + (ry*observer.vy()) / (Math.sqrt(rx*rx+ry*ry) * observer.v);
			System.out.print("Observer cos: ");
			System.out.println(cosObs);
			cosSou = (rx*source.vx()) + (ry*source.vy()) / (Math.sqrt(rx*rx+ry*ry) * source.v);
			System.out.print("Source cos: ");
			System.out.println(cosSou);
		}
		double factor = (soundVelocity + (observer.v * cosObs)) / (soundVelocity - (source.v * cosSou));
		System.out.print("Frequency factor: ");
		System.out.println(factor);
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
///// program wywala sie przy podaniu zbyt niepoprawnej czêstotliwoœci -- do naprawy
//co znaczy 'zbyt niepoprawna czestotliwosc'? /R
