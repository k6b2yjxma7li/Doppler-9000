/**
 * @author Karol
 * @author Robert
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */
package doppeler9k;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.GroupLayout.Alignment;

public class WindowGUI extends JFrame {
	//Menu bar
	public MenuBar mainBar = new MenuBar(LangChoose.getLanguage());
	//
	public JPanel upperPanel = new JPanel();
	public JPanel lowerPanel = new JPanel();
	public JPanel objPropertiesPanel = new JPanel();
	public JPanel signalAnimationPanel = new JPanel();
	public JPanel obsSignalPanel = new JPanel();
	public SourcePropertiesPanel souPanel = new SourcePropertiesPanel(LangChoose.getLanguage());
	public ObserversPropertiesPanel obsPanel = new ObserversPropertiesPanel(LangChoose.getLanguage());
	//OTHER SIMPLE PANELS
	public FunctionAnimation emittedSignalAnimation = new FunctionAnimation();
	public FunctionAnimation incomingSignalAnimation = new FunctionAnimation();
	public JLabel emittedSignalLabel = new JLabel("Emitted Signal");
	public JLabel emittedSignalLabelPL = new JLabel("Sygna³ Wychodz¹cy");
	public JLabel incomingSignalLabelPL = new JLabel("Sygna³ Odbierany");
	public JLabel incomingSignalLabel = new JLabel("Incoming Signal");
	public JLabel graphicalSimulationLabel = new JLabel("Graphical simulation                                                                                                                  ");
	public JSlider volumeSlider = new JSlider();
	//
	public WindowGUI() throws HeadlessException {
		upperPanel.setBackground(Color.BLUE);
		lowerPanel.setBackground(Color.CYAN);
		objPropertiesPanel.setBackground(Color.GRAY);
		signalAnimationPanel.setBackground(Color.GREEN);
		obsSignalPanel.setBackground(Color.LIGHT_GRAY);
		// BORDER
		this.setLayout(new BorderLayout());
		this.add(lowerPanel,BorderLayout.SOUTH);
		this.add(upperPanel,BorderLayout.CENTER);
		upperPanel.setLayout(new BoxLayout(upperPanel,BoxLayout.X_AXIS));
		lowerPanel.add(signalAnimationPanel,BorderLayout.EAST);
		lowerPanel.add(souPanel,BorderLayout.WEST);
		lowerPanel.add(obsPanel,BorderLayout.CENTER);
		//TOOLTIPS
		upperPanel.setToolTipText("Main panel");
		objPropertiesPanel.setToolTipText("Object properties");
		signalAnimationPanel.setToolTipText("Signal emitted");
		obsSignalPanel.setToolTipText("Observed signals");
		souPanel.setToolTipText("Properties");
		//EMITTED SIGNAL
		GroupLayout emitSignalPanelLayout = new GroupLayout(signalAnimationPanel);
		signalAnimationPanel.setLayout(emitSignalPanelLayout);
		emitSignalPanelLayout.setAutoCreateGaps(true);
		emitSignalPanelLayout.setAutoCreateContainerGaps(true);
		
		GroupLayout.Group columnE1 = emitSignalPanelLayout.createParallelGroup(Alignment.LEADING);
		GroupLayout.Group lineE1 = emitSignalPanelLayout.createParallelGroup();
		GroupLayout.Group lineE2 = emitSignalPanelLayout.createParallelGroup();
		GroupLayout.Group lineE3 = emitSignalPanelLayout.createParallelGroup();
		GroupLayout.Group lineE4 = emitSignalPanelLayout.createParallelGroup();
		
		GroupLayout.SequentialGroup linesE = emitSignalPanelLayout.createSequentialGroup();
		GroupLayout.SequentialGroup columnsE = emitSignalPanelLayout.createSequentialGroup();
		linesE.addGroup(lineE1);
		linesE.addGroup(lineE2);
		linesE.addGroup(lineE3);
		linesE.addGroup(lineE4);
		columnsE.addGroup(columnE1);
		//
		emitSignalPanelLayout.setHorizontalGroup(columnsE);
		emitSignalPanelLayout.setVerticalGroup(linesE);
		//
		switch(LangChoose.getLanguage()) {
		case 0:
			lineE1.addComponent(emittedSignalLabel);
			columnE1.addComponent(emittedSignalLabel);
			break;
		case 1:
			lineE1.addComponent(emittedSignalLabelPL);
			columnE1.addComponent(emittedSignalLabelPL);
			break;
		}
		//
		lineE2.addComponent(emittedSignalAnimation);
		columnE1.addComponent(emittedSignalAnimation);
		//
		switch(LangChoose.getLanguage()) {
		case 0:
			lineE3.addComponent(incomingSignalLabel);
			columnE1.addComponent(incomingSignalLabel);
			break;
		case 1:
			lineE3.addComponent(incomingSignalLabelPL);
			columnE1.addComponent(incomingSignalLabelPL);
			break;
		}
		//
		lineE4.addComponent(incomingSignalAnimation);
		columnE1.addComponent(incomingSignalAnimation);
		//COMPONENT SIZE
		emittedSignalAnimation.setMinimumSize(new Dimension(100,100));
		incomingSignalAnimation.setMinimumSize(new Dimension(100,100));
		//	
		setJMenuBar(mainBar);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1000,700));
		setLocation(new Point(0, 0));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
