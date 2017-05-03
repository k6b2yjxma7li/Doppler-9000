package doppeler9k;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Window extends JFrame {

	public Window() throws HeadlessException {
		JPanel mainPanel = new JPanel();
		//Menu bar
		JMenuBar mainBar = new JMenuBar();
		JMenu mainMenu = new JMenu("Menu");
		JMenu functionMenu = new JMenu("Function");
		JMenu simulationMenu = new JMenu("Simulation");
		//Main
		JMenuItem exitButton = new JMenuItem("Exit");
		JMenuItem frequencyButton = new JMenuItem("Frequency");
		//Function
		JMenuItem sineButton = new JMenuItem("Sine wave");
		JMenuItem squareButton = new JMenuItem("Square wave");
		JMenuItem expButton = new JMenuItem("Cosine-exponens-sine wave");
		//Simulation
		JMenuItem startSimButton = new JMenuItem("Start simulation");
		JMenuItem stopSimButton = new JMenuItem("Stop simulation");
		JMenuItem saveSimButton = new JMenuItem("Save simulation");
		JMenuItem openSimButton = new JMenuItem("Open existing save");
		//
		mainBar.add(mainMenu);
		mainBar.add(functionMenu);
		mainBar.add(simulationMenu);
		//Main
		mainMenu.add(exitButton);
		mainMenu.add(frequencyButton);
		//Function
		functionMenu.add(sineButton);
		functionMenu.add(squareButton);
		functionMenu.add(expButton);
		//Simulation
		simulationMenu.add(startSimButton);
		simulationMenu.add(stopSimButton);
		simulationMenu.add(saveSimButton);
		simulationMenu.add(openSimButton);
		//
		setJMenuBar(mainBar);
		//
		setSize(640,320);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public Window(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		Window mainWin = new Window();
	}

}
