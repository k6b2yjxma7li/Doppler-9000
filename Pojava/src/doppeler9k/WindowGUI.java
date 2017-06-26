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
	public JPanel obsSignalPanel = new JPanel();
	public SourcePropertiesPanel souPanel = new SourcePropertiesPanel(LangChoose.getLanguage());
	public ObserversPropertiesPanel obsPanel = new ObserversPropertiesPanel(LangChoose.getLanguage());
	//
	public WindowGUI() throws HeadlessException {
		upperPanel.setBackground(Color.BLUE);
		lowerPanel.setBackground(Color.CYAN);
		objPropertiesPanel.setBackground(Color.GRAY);
		obsSignalPanel.setBackground(Color.LIGHT_GRAY);
		// BORDER
		this.setLayout(new BorderLayout());
		this.add(lowerPanel,BorderLayout.SOUTH);
		this.add(upperPanel,BorderLayout.CENTER);
		upperPanel.setLayout(new BoxLayout(upperPanel,BoxLayout.X_AXIS));
		lowerPanel.add(souPanel,BorderLayout.WEST);
		lowerPanel.add(obsPanel,BorderLayout.CENTER);
		//TOOLTIPS
		upperPanel.setToolTipText("Main panel");
		objPropertiesPanel.setToolTipText("Object properties");
		obsSignalPanel.setToolTipText("Observed signals");
		souPanel.setToolTipText("Properties");
		setJMenuBar(mainBar);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1000,700));
		setLocation(new Point(0, 0));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
