/**
 * @author Robert
 * @version 16.04.2017
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
	public Doppler9000() throws HeadlessException, LineUnavailableException {
		SimulationObject obserwator = new SimulationObject(); //dodane obiekty majace x,y,v,kat - moze to byæ zarówno zrodlo jak i obserwator
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem exitBut = new JMenuItem("Exit");
		JMenuItem freq = new JMenuItem("Frequency");
		//
		exitBut.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		//
		freq.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
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
							FunctionGenerator generator = new FunctionGenerator((int)(Math.round(freqSlider.getValue()*10)*((340+obserwator.v)/340)), 0);//dodany doppler zaokr¹gli³em oraz zcastowa³em do inta
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
							FunctionGenerator gener200 = new FunctionGenerator(200, 0);
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
		menu.add(exitBut);
		menu.add(freq);
		menuBar.add(menu);
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
