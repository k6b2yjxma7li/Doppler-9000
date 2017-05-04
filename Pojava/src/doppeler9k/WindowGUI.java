/**
 * @author Karol
 * @author Robert
 * @version 03.05.2017
 */
package doppeler9k;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowGUI extends JFrame {
	//Menu bar
	public JMenuBar mainBar = new JMenuBar();
	public JMenu mainMenu = new JMenu("Menu");
	public JMenu functionMenu = new JMenu("Function");
	public JMenu simulationMenu = new JMenu("Simulation");
	//Main
	public JMenuItem exitButton = new JMenuItem("Exit");
	public JMenuItem airButton = new JMenuItem("Air [343.8m/s]");
	public JMenuItem waterButton = new JMenuItem("Water [1500.0m/s]");
	public JMenuItem heliumButton = new JMenuItem("Helium [965.0m/s]");
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
	public JPanel simMainPanel = new JPanel();
	public JPanel simPropertiesPanel = new JPanel();
	public JPanel objPropertiesPanel = new JPanel();
	public JPanel emitSignalPanel = new JPanel();
	public JPanel obsPropertiesPanel = new JPanel();
	//
	public JTextField freqField = new JTextField("440");
	public JButton freqGenerateButton = new JButton("Generate");
	public JTextField velocityField = new JTextField("0");
	//
	public JLabel freqLabel = new JLabel("Frequency [Hz]: ");
	public JLabel velocityLabel = new JLabel("Velocity [m/s]: ");
	//
	public WindowGUI() throws HeadlessException {
		//
		this.setLayout(new GridLayout(3, 3));
		this.add(simMainPanel);
		this.add(simPropertiesPanel);
		this.add(objPropertiesPanel);
		this.add(emitSignalPanel);
		this.add(obsPropertiesPanel);
		//
		simMainPanel.setToolTipText("Main panel");
		objPropertiesPanel.setToolTipText("Object properties");
		emitSignalPanel.setToolTipText("Signal emitted");
		obsPropertiesPanel.setToolTipText("Observed signals");
		simPropertiesPanel.setToolTipText("Properties");
		//
		//Menu bar
		mainBar.add(mainMenu);
		mainBar.add(functionMenu);
		mainBar.add(simulationMenu);
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
		simulationMenu.add(startSimButton);
		simulationMenu.add(stopSimButton);
		simulationMenu.add(saveSimButton);
		simulationMenu.add(openSimButton);
		//
		//simPropertiesPanel.setLayout(new GridLayout(2,3));
		simPropertiesPanel.add(freqLabel);
		simPropertiesPanel.add(freqField);
		simPropertiesPanel.add(freqGenerateButton);
		simPropertiesPanel.add(velocityLabel);
		simPropertiesPanel.add(velocityField);
		//
		setJMenuBar(mainBar);
		//
		setSize(640,320);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		//
		exitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}

	public static void main(String arg0) {
		WindowGUI mainWin = new WindowGUI();
	}

}
