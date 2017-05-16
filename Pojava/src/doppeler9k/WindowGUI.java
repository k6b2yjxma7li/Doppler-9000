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
	public JPanel simPropertiesPanel = new JPanel();
	public JPanel objPropertiesPanel = new JPanel();
	public JPanel emitSignalPanel = new JPanel();
	public JPanel obsSignalPanel = new JPanel();
	//SOURCE PROPERTIES PANEL
	public JTextField freqField = new JTextField("440");
	public JTextField velocityField = new JTextField("0");
	public JTextField souVelocityField = new JTextField("0");
	public JTextField souXPosition = new JTextField("0");
	public JTextField souYPosition = new JTextField("0");
	public JTextField souDirection = new JTextField("0");
	public JButton freqGenerateButton = new JButton("Start");
	public JButton stopButton = new JButton("Stop");
	public JButton resetButton = new JButton("Reset");
	public JLabel freqLabel = new JLabel("Frequency[Hz]: ");
	public JLabel positionLabel = new JLabel("Source Position [x,y]: ");
	public JLabel directionSourceLabel = new JLabel("Source movement angle [deg]: ");
	public JLabel simPropertiesPanelLabel = new JLabel("Source Properties");
	public JLabel souVelocityLabel = new JLabel("Source Velocity [m/s]: ");
	//OBSERVER PROPERTIES PANEL
	public JCheckBox show = new JCheckBox("show");
	public JLabel obsVelocityLabel = new JLabel("Observer Velocity [m/s]: ");
	public JLabel obsPositionLabel = new JLabel("Observer Position [x,y]: ");
	public JLabel directionObserverLabel = new JLabel("Source movement angle [deg]: ");
	public JTextField obsVelocityField = new JTextField("0");
	public JTextField obsXPosition = new JTextField("0");
	public JTextField obsYPosition = new JTextField("0");
	public JTextField obsDirection = new JTextField("0");
	//OTHER
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
		lowerPanel.add(simPropertiesPanel,BorderLayout.WEST);
		lowerPanel.add(objPropertiesPanel,BorderLayout.CENTER);
		lowerPanel.add(emitSignalPanel,BorderLayout.EAST);
		upperPanel.add(obsSignalPanel,BorderLayout.EAST);
		//TOOLTIPS
		simMainPanel.setToolTipText("Main panel");
		objPropertiesPanel.setToolTipText("Object properties");
		emitSignalPanel.setToolTipText("Signal emitted");
		obsSignalPanel.setToolTipText("Observed signals");
		simPropertiesPanel.setToolTipText("Properties");
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
		// GROUP FOR SIMPROPPANEL
		GroupLayout simPropPanelLayout = new GroupLayout(simPropertiesPanel);
		simPropertiesPanel.setLayout(simPropPanelLayout);
		simPropPanelLayout.setAutoCreateGaps(true);
		simPropPanelLayout.setAutoCreateContainerGaps(true);
		//
		GroupLayout.Group column1 = simPropPanelLayout.createParallelGroup(Alignment.LEADING);
		GroupLayout.Group column2 = simPropPanelLayout.createParallelGroup();
		GroupLayout.Group column3 = simPropPanelLayout.createParallelGroup();
		GroupLayout.Group line1 = simPropPanelLayout.createParallelGroup();
		GroupLayout.Group line2 = simPropPanelLayout.createParallelGroup();
		GroupLayout.Group line3 = simPropPanelLayout.createParallelGroup();
		GroupLayout.Group line4 = simPropPanelLayout.createParallelGroup();
		GroupLayout.Group line5 = simPropPanelLayout.createParallelGroup();
		GroupLayout.Group line6 = simPropPanelLayout.createParallelGroup();
		//
		GroupLayout.SequentialGroup lines = simPropPanelLayout.createSequentialGroup();
		GroupLayout.SequentialGroup columns = simPropPanelLayout.createSequentialGroup();
		lines.addGroup(line1);
		lines.addGroup(line2);
		lines.addGroup(line3);
		lines.addGroup(line4);
		lines.addGroup(line5);
		lines.addGroup(line6);
		columns.addGroup(column1);
		columns.addGroup(column2);
		columns.addGroup(column3);
		//
		simPropPanelLayout.setHorizontalGroup(columns);
		simPropPanelLayout.setVerticalGroup(lines);
		//
		line1.addComponent(simPropertiesPanelLabel);
		column1.addComponent(simPropertiesPanelLabel);
		//
		line2.addComponent(freqLabel);
		column1.addComponent(freqLabel);
		//
		line2.addComponent(freqField);
		column2.addComponent(freqField);
		//
		line3.addComponent(souVelocityLabel);
		column1.addComponent(souVelocityLabel);
		//
		line3.addComponent(souVelocityField);
		column2.addComponent(souVelocityField);
		//
		line4.addComponent(positionLabel);
		column1.addComponent(positionLabel);
		//
		line4.addComponent(souXPosition);
		column2.addComponent(souXPosition);
		//
		line4.addComponent(souYPosition);
		column3.addComponent(souYPosition);
		//
		line5.addComponent(directionSourceLabel);
		column1.addComponent(directionSourceLabel);
		//
		line5.addComponent(souDirection);
		column2.addComponent(souDirection);
		//
		line6.addComponent(freqGenerateButton);
		column1.addComponent(freqGenerateButton);
		//
		line6.addComponent(stopButton);
		column2.addComponent(stopButton);
		//
		line6.addComponent(resetButton);
		column3.addComponent(resetButton);
		//
		//LAYOUT FOR OBSERVATOR'S PROPERTIES
		GroupLayout objPropertiesPanelLayout = new GroupLayout(objPropertiesPanel);
		objPropertiesPanel.setLayout(objPropertiesPanelLayout);
		objPropertiesPanelLayout.setAutoCreateGaps(true);
		objPropertiesPanelLayout.setAutoCreateContainerGaps(true);
		//
		GroupLayout.Group columnO1 = objPropertiesPanelLayout.createParallelGroup(Alignment.LEADING);
		GroupLayout.Group columnO2 = objPropertiesPanelLayout.createParallelGroup();
		GroupLayout.Group columnO3 = objPropertiesPanelLayout.createParallelGroup();
		GroupLayout.Group lineO1 = objPropertiesPanelLayout.createParallelGroup();
		GroupLayout.Group lineO2 = objPropertiesPanelLayout.createParallelGroup();
		GroupLayout.Group lineO3 = objPropertiesPanelLayout.createParallelGroup();
		GroupLayout.Group lineO4 = objPropertiesPanelLayout.createParallelGroup();
		//
		GroupLayout.SequentialGroup linesO = objPropertiesPanelLayout.createSequentialGroup();
		GroupLayout.SequentialGroup columnsO = objPropertiesPanelLayout.createSequentialGroup();
		linesO.addGroup(lineO1);
		linesO.addGroup(lineO2);
		linesO.addGroup(lineO3);
		linesO.addGroup(lineO4);
		columnsO.addGroup(columnO1);
		columnsO.addGroup(columnO2);
		columnsO.addGroup(columnO3);
		//
		objPropertiesPanelLayout.setHorizontalGroup(columnsO);
		objPropertiesPanelLayout.setVerticalGroup(linesO);
		//
		lineO1.addComponent(show);
		columnO1.addComponent(show);
		//
		lineO2.addComponent(directionObserverLabel);
		columnO1.addComponent(directionObserverLabel);
		//
		lineO2.addComponent(obsDirection);
		columnO2.addComponent(obsDirection);
		//
		lineO3.addComponent(obsVelocityLabel);
		columnO1.addComponent(obsVelocityLabel);
		//
		lineO3.addComponent(obsVelocityField);
		columnO2.addComponent(obsVelocityField);
		//
		lineO4.addComponent(obsPositionLabel);
		columnO1.addComponent(obsPositionLabel);
		//
		lineO4.addComponent(obsXPosition);
		columnO2.addComponent(obsXPosition);
		//
		lineO4.addComponent(obsYPosition);
		columnO3.addComponent(obsYPosition);
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
		obsYPosition.setMinimumSize(new Dimension(40, 30));
		obsYPosition.setMaximumSize(new Dimension(40, 30));
		obsVelocityField.setMinimumSize(new Dimension(40, 30));
		obsVelocityField.setMaximumSize(new Dimension(40, 30));
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
