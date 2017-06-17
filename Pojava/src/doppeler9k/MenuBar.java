package doppeler9k;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	//Submenus
	public JMenu mainMenu;
	public JMenu functionMenu;
	public JMenu soundMenu;
	//Main menu
	public JMenuItem exitButton;
	public JMenuItem airButton;
	public JMenuItem waterButton;
	public JMenuItem heliumButton;
	//Function
	public JMenuItem sineButton;
	public JMenuItem squareButton;
	public JMenuItem expButton;
	//Simulation
	public JMenuItem startGenButton;
	//
	public MenuBar(int lang) {//0 english// 1 - polski
		switch(lang) {
		case 0:
		{
			mainMenu = new JMenu("Menu");
			functionMenu = new JMenu("Function");
			soundMenu = new JMenu("Sound");
			//Main menu
			exitButton = new JMenuItem("Exit");
			airButton = new JMenuItem("Air [343.8m/s]");
			waterButton = new JMenuItem("Water [1500.0m/s]");
			heliumButton = new JMenuItem("Helium [965.0m/s]");
			//Function
			sineButton = new JMenuItem("Sine wave");
			squareButton = new JMenuItem("Square wave");
			expButton = new JMenuItem("sin(x)*exp(cos(x)) wave");
			//Simulation
			startGenButton = new JMenuItem("Generate");
			break;
		}
		case 1:
		{
			mainMenu = new JMenu("Menu");
			functionMenu = new JMenu("Funkcje");
			soundMenu = new JMenu("Dzwiêk");
			//Main menu
			exitButton = new JMenuItem("Wyjœcie");
			airButton = new JMenuItem("Powietrze [343.8m/s]");
			waterButton = new JMenuItem("Woda [1500.0m/s]");
			heliumButton = new JMenuItem("Hel [965.0m/s]");
			//Function
			sineButton = new JMenuItem("Funkcja sinus");
			squareButton = new JMenuItem("Funkcja prostok¹tna");
			expButton = new JMenuItem("Funkcja: sin(x)*exp(cos(x))");
			//Simulation
			startGenButton = new JMenuItem("Generate");
			break;
		}
		}
		add(mainMenu);
		add(functionMenu);
		add(soundMenu);
		//Main
		mainMenu.add(airButton);
		mainMenu.add(waterButton);
		mainMenu.add(heliumButton);
		mainMenu.add(exitButton);
		//Function
		functionMenu.add(sineButton);
		functionMenu.add(squareButton);
		functionMenu.add(expButton);
		//Simulation
		soundMenu.add(startGenButton);
	}
}
