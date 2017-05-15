/**
 * @author Karol
 * @author Robert
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */
package doppeler9k;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

//WINDOW GUI CLASS
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
	public JTextField souVelocityField = new JTextField("0");
	public JSlider volumeSlider = new JSlider();
	//
	public JLabel freqLabel = new JLabel("Frequency [Hz]: ");
	public JLabel velocityLabel = new JLabel("Observer Velocity [m/s]: ");
	public JLabel souVelocityLabel = new JLabel("Source Velocity [m/s]: ");
	//
	public WindowGUI() throws HeadlessException {
		//
		this.setLayout(new GridLayout(3,3));
		this.getContentPane().add(simMainPanel);
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
		GroupLayout simPropPanelLayout = new GroupLayout(simPropertiesPanel);
		simPropertiesPanel.setLayout(simPropPanelLayout);
		simPropPanelLayout.setAutoCreateGaps(true);
		simPropPanelLayout.setAutoCreateContainerGaps(true);
		//
		GroupLayout.Group line1 = simPropPanelLayout.createParallelGroup(Alignment.TRAILING);
		GroupLayout.Group line2 = simPropPanelLayout.createParallelGroup();
		GroupLayout.Group line3 = simPropPanelLayout.createParallelGroup();
		GroupLayout.Group column1 = simPropPanelLayout.createParallelGroup();
		GroupLayout.Group column2 = simPropPanelLayout.createParallelGroup();
		GroupLayout.Group column3 = simPropPanelLayout.createParallelGroup();
		//
		GroupLayout.SequentialGroup lines = simPropPanelLayout.createSequentialGroup();
		GroupLayout.SequentialGroup columns = simPropPanelLayout.createSequentialGroup();
		lines.addGroup(line1);
		lines.addGroup(line2);
		lines.addGroup(line3);
		columns.addGroup(column1);
		columns.addGroup(column2);
		columns.addGroup(column3);
		//
		simPropPanelLayout.setHorizontalGroup(columns);
		simPropPanelLayout.setVerticalGroup(lines);
		//a1
		line1.addComponent(freqLabel);
		column1.addComponent(freqLabel);
		//b1
		line1.addComponent(freqField);
		column2.addComponent(freqField);
		//c1
		line1.addComponent(freqGenerateButton);
		column3.addComponent(freqGenerateButton);
		//a2
		line2.addComponent(velocityLabel);
		column1.addComponent(velocityLabel);
		//b2
		line2.addComponent(velocityField);
		column2.addComponent(velocityField);
		//c2
		line2.addComponent(volumeSlider);
		column3.addComponent(volumeSlider);
		//
		line3.addComponent(souVelocityLabel);
		column1.addComponent(souVelocityLabel);
		//
		line3.addComponent(souVelocityField);
		column2.addComponent(souVelocityField);
		//
		velocityField.setMinimumSize(new Dimension(40, 30));
		velocityField.setMaximumSize(new Dimension(40, 30));
		souVelocityField.setMinimumSize(new Dimension(40, 30));
		souVelocityField.setMaximumSize(new Dimension(40, 30));
		freqField.setMinimumSize(new Dimension(40, 30));
		freqField.setMaximumSize(new Dimension(40, 30));
		velocityField.setPreferredSize(new Dimension(40, 30));
		freqField.setPreferredSize(new Dimension(40, 30));
		freqGenerateButton.setMinimumSize(new Dimension(40, 30));
		freqGenerateButton.setPreferredSize(new Dimension(40, 30));
		volumeSlider.setMinimum(0);
		volumeSlider.setMaximum(100);
		//
		setJMenuBar(mainBar);
		//
		setSize(640,320);
		setMinimumSize(new Dimension(800, 400));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		pack();
		//
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
