/**
 * @author Robert
 * @version 16.04.2017
 * Glowna czesc 'oienek'
 * Tu bedzie wprowadzany kazdy element i wyswietlana symulacja
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

public class Doppler9000 extends JFrame {
	int functChoice = 0;
	
	public Doppler9000() throws HeadlessException, LineUnavailableException {
		SimulationObject obserwator = new SimulationObject(); //dodane obiekty majace x,y,v,kat - moze to byc zarowno zrodlo jak i obserwator
		JMenuBar menuBar = new JMenuBar();
		//
		JMenu menu = new JMenu("Menu");
		JMenuItem exitBut = new JMenuItem("Exit");
		JMenuItem freq = new JMenuItem("Frequency");
		//
		JMenu functionMenu = new JMenu("Function");
		JMenuItem sineButton = new JMenuItem("Sine");
		JMenuItem squareButton = new JMenuItem("Square");
		JMenuItem oddButton = new JMenuItem("Exponens of sine");
		//
		sineButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				functChoice = 0;
			}
		});
		squareButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				functChoice = 1;
			}
		});
		squareButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				functChoice = 2;
			}
		});
		exitBut.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		//
		freq.addActionListener(new ActionListener(){
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
							FunctionGenerator generator = new FunctionGenerator((int)(Math.round(freqSlider.getValue()*10)*((340+obserwator.v)/340)), functChoice);//dodany doppler zaokr¹gli³em oraz zcastowa³em do inta
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
							FunctionGenerator gener200 = new FunctionGenerator(200, functChoice);
						} catch (LineUnavailableException e) {
							e.printStackTrace();
						}
					}
				});
				//
				v_obs.addActionListener(new ActionListener() { //uzylem na razie pola tekstowego do wpisywania predkosci obserwatora
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
		//
		functionMenu.add(sineButton);
		functionMenu.add(squareButton);
		functionMenu.add(oddButton);
		//
		menu.add(exitBut);
		menu.add(freq);
		menuBar.add(menu);
		menuBar.add(functionMenu);
		setJMenuBar(menuBar);
		//
		setSize(640,320);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) throws HeadlessException, LineUnavailableException {
		Doppler9000 Win = new Doppler9000();
	}
}
