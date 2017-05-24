/**
 * @author Karol
 * @author Robert
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */
package doppeler9k;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

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
	public JPanel upperPanel = new JPanel();
	public JPanel lowerPanel = new JPanel();
	public JPanel simMainPanel = new JPanel();
	public JPanel objPropertiesPanel = new JPanel();
	public JPanel emitSignalPanel = new JPanel();
	public JPanel obsSignalPanel = new JPanel();
	public AnimationPanel animacja = new AnimationPanel();
	public SourcePropertiesPanel souPanel = new SourcePropertiesPanel();
	public ObserversPropertiesPanel obsPanel = new ObserversPropertiesPanel();
	//OTHER SIMPLE PANELS
	Animatronix sineAnimation = new Animatronix();
	public JLabel emittedSignalLabel = new JLabel("Emitted Signal");
	public JLabel workInProgress1 = new JLabel("To Be Done");
	public JLabel workInProgress2 = new JLabel("To Be Done");
	public JLabel workInProgress3 = new JLabel("To Be Done");
	public JLabel incomingSignalLabel = new JLabel("Incoming Signal");
	public JLabel observer1Label = new JLabel("Observer 1");
	public JLabel observer2Label = new JLabel("Observer 2");
	public JLabel observer3Label = new JLabel("Observer 3");
	public JLabel observer4Label = new JLabel("Observer 4");
	public JLabel graphicalSimulationLabel = new JLabel("Graphical simulation                                                                                                                  ");
	public JSlider volumeSlider = new JSlider();
	
	//
	public WindowGUI() throws HeadlessException {
		// BORDER
		this.setLayout(new BorderLayout());
		this.add(lowerPanel,BorderLayout.SOUTH);
		this.add(upperPanel,BorderLayout.CENTER);
		upperPanel.add(simMainPanel, BorderLayout.CENTER);
		lowerPanel.add(souPanel,BorderLayout.WEST);
		lowerPanel.add(obsPanel,BorderLayout.CENTER);
		lowerPanel.add(emitSignalPanel,BorderLayout.EAST);
		upperPanel.add(obsSignalPanel,BorderLayout.EAST);
		//TOOLTIPS
		simMainPanel.setToolTipText("Main panel");
		objPropertiesPanel.setToolTipText("Object properties");
		emitSignalPanel.setToolTipText("Signal emitted");
		obsSignalPanel.setToolTipText("Observed signals");
		souPanel.setToolTipText("Properties");
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
		//LAYOUT FOR OBSERVERS' PROPERTIES
		
		//EMITTED SIGNAL
		GroupLayout emitSignalPanelLayout = new GroupLayout(emitSignalPanel);
		emitSignalPanel.setLayout(emitSignalPanelLayout);
		emitSignalPanelLayout.setAutoCreateGaps(true);
		emitSignalPanelLayout.setAutoCreateContainerGaps(true);
		//
		GroupLayout.Group columnE1 = emitSignalPanelLayout.createParallelGroup(Alignment.LEADING);
		GroupLayout.Group lineE1 = emitSignalPanelLayout.createParallelGroup();
		GroupLayout.Group lineE2 = emitSignalPanelLayout.createParallelGroup();
		//
		GroupLayout.SequentialGroup linesE = emitSignalPanelLayout.createSequentialGroup();
		GroupLayout.SequentialGroup columnsE = emitSignalPanelLayout.createSequentialGroup();
		linesE.addGroup(lineE1);
		linesE.addGroup(lineE2);
		columnsE.addGroup(columnE1);
		//
		emitSignalPanelLayout.setHorizontalGroup(columnsE);
		emitSignalPanelLayout.setVerticalGroup(linesE);
		//
		lineE1.addComponent(emittedSignalLabel);
		columnE1.addComponent(emittedSignalLabel);
		//
		lineE2.addComponent(sineAnimation);
		columnE1.addComponent(sineAnimation);
		//INCOMING SIGNAL
		obsSignalPanel.setLayout(new BoxLayout(obsSignalPanel,BoxLayout.Y_AXIS));
		obsSignalPanel.add(incomingSignalLabel);
		obsSignalPanel.add(observer1Label);
		obsSignalPanel.add(workInProgress2);
		obsSignalPanel.add(observer2Label);
		obsSignalPanel.add(workInProgress2);
		obsSignalPanel.add(observer3Label);
		obsSignalPanel.add(workInProgress2);
		obsSignalPanel.add(observer4Label);
		obsSignalPanel.add(workInProgress2);
		//GRAPHICAL SIMULATION
		simMainPanel.setLayout(new BoxLayout(simMainPanel,BoxLayout.Y_AXIS));
		simMainPanel.add(graphicalSimulationLabel);
		simMainPanel.add(workInProgress3);
		//COMPONENT SIZE
		sineAnimation.setMinimumSize(new Dimension(100,300));
		volumeSlider.setMinimum(0);
		volumeSlider.setMaximum(100);
		//	
		setJMenuBar(mainBar);
		//
		
		setMinimumSize(new Dimension(1000, 500));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
