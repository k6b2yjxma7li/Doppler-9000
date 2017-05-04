/**
 * @author Robert
 * @version 03.05.2017
 */

package doppeler9k;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class Doppler9000 extends WindowGUI {
	int functionChoice = 0;
	
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
		exitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		//
		frequencyButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) { //POWSTANIE NOWEGO OKIENKA - ROZWIAZANIE TYMCZASOWE
				JFrame ramka = new JFrame();
				JSlider freqSlider = new JSlider();
				JButton freqG = new JButton("Generate");
				JButton freq2 = new JButton("200Hz");
				JTextField v_obs = new JTextField("0",10); // domyslnie wpisane jest zero zeby nie bylo problemu jak ktos od razu kliknie generate
				//
				ramka.setLayout(new GridLayout(3, 0));
				//
				freqG.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent ae) {
						try {
							obserwator.setV(Float.parseFloat(v_obs.getText()));
							FunctionGenerator generator = new FunctionGenerator((int)(Math.round(freqSlider.getValue()*10)*((340+obserwator.v)/340)), functionChoice);//dodany doppler zaokr¹gli³em oraz zcastowa³em do inta
						} catch (LineUnavailableException e) {
							e.printStackTrace();
						}
					}
				});
				//
				freq2.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent ae){
						try {
							FunctionGenerator gener200 = new FunctionGenerator(200, functionChoice);
						} catch (LineUnavailableException e) {
							e.printStackTrace();
						}
					}
				});
				//
				v_obs.addActionListener(new ActionListener() { //
					@Override
					public void actionPerformed(ActionEvent e) {
						obserwator.setV(Float.parseFloat(v_obs.getText()));
					}
				});
				//
				ramka.add(freqSlider);
				ramka.add(freqG);
				ramka.add(freq2);
				ramka.add(v_obs);
				ramka.setVisible(true);
				ramka.setSize(200,100);
				ramka.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
	}
	public static void main(String[] args) throws HeadlessException, LineUnavailableException {
		Doppler9000 Win = new Doppler9000();
	}
}
