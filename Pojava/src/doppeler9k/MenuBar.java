package doppeler9k;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	//MENUS
	public JMenu mainMenu;
	public JMenu soundMenu;
	public JMenu signalMenu;
	//Main menu
	public JMenuItem exitButton;
	public JMenuItem airButton;
	public JMenuItem waterButton;
	public JMenuItem heliumButton;
	//Simulation
	public JMenuItem startGenButton;
	//Signal
	public JMenuItem sinSigButton;
	public JMenuItem sqrSigButton;
	public JMenuItem secSigButton;
	public MenuBar(int lang) {//0 english// 1 - polski
		switch(lang) {
		case 0:
		{
			mainMenu = new JMenu("Menu");
			soundMenu = new JMenu("Sound");
			signalMenu = new JMenu("Signal");
			//Main menu
			exitButton = new JMenuItem("Exit");
			airButton = new JMenuItem("Air [343.8m/s]");
			waterButton = new JMenuItem("Water [1500.0m/s]");
			heliumButton = new JMenuItem("Helium [965.0m/s]");
			//Simulation
			startGenButton = new JMenuItem("Generate");
			//Signal
			sinSigButton = new JMenuItem("Sine");
			sqrSigButton = new JMenuItem("Square");
			secSigButton = new JMenuItem("sinx*exp(cosx)");
			break;
		}
		case 1:
		{
			mainMenu = new JMenu("Menu");
			soundMenu = new JMenu("Dzwiêk");
			signalMenu = new JMenu("Sygna³");
			//Main menu
			exitButton = new JMenuItem("Wyjœcie");
			airButton = new JMenuItem("Powietrze [343.8m/s]");
			waterButton = new JMenuItem("Woda [1500.0m/s]");
			heliumButton = new JMenuItem("Hel [965.0m/s]");
			//Simulation
			startGenButton = new JMenuItem("Generate");
			//Signal
			sinSigButton = new JMenuItem("Sinus");
			sqrSigButton = new JMenuItem("Kwadrat");
			secSigButton = new JMenuItem("sinx*exp(cosx)");
			break;
		}
		}
		add(mainMenu);
		add(soundMenu);
		add(signalMenu);
		//Main
		mainMenu.add(airButton);
		mainMenu.add(waterButton);
		mainMenu.add(heliumButton);
		mainMenu.add(exitButton);
		//Simulation
		soundMenu.add(startGenButton);
		//Signal
		signalMenu.add(sinSigButton);
		signalMenu.add(sqrSigButton);
		signalMenu.add(secSigButton);
	}
}
