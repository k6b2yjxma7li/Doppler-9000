/**
 * @author Karol
 * @author Robert
 * @version 03.05.2017
 */
package doppeler9k;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class WindowGUI extends JFrame {
	//Menu bar
	public JMenuBar mainBar = new JMenuBar();
	public JMenu mainMenu = new JMenu("Menu");
	public JMenu functionMenu = new JMenu("Function");
	public JMenu simulationMenu = new JMenu("Simulation");
	//Main
	public JMenuItem exitButton = new JMenuItem("Exit");
	public JMenuItem frequencyButton = new JMenuItem("Frequency");
	//Function
	public JMenuItem sineButton = new JMenuItem("Sine wave");
	public JMenuItem squareButton = new JMenuItem("Square wave");
	public JMenuItem expButton = new JMenuItem("Cosine-exponens-sine wave");
	//Simulation
	public JMenuItem startSimButton = new JMenuItem("Start simulation");
	public JMenuItem stopSimButton = new JMenuItem("Stop simulation");
	public JMenuItem saveSimButton = new JMenuItem("Save simulation");
	public JMenuItem openSimButton = new JMenuItem("Open existing save");
	//
	public WindowGUI() throws HeadlessException {
		//Menu bar
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

	public static void main(String arg0) {
		WindowGUI mainWin = new WindowGUI();
	}

}
