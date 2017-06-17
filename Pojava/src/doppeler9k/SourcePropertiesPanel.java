/**
 * @author Karol
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */
package doppeler9k;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

public class SourcePropertiesPanel extends JPanel {

	public JTextField freqField = new JTextField("440");
	public JTextField velocityField = new JTextField("0");
	public JTextField souVelocityField = new JTextField("0");
	public JTextField souXPosition = new JTextField("0");
	public JTextField souYPosition = new JTextField("0");
	public JTextField souDirection = new JTextField("0");
	public JButton startButton = new JButton("Start");
	public JButton stopButton = new JButton("Stop");
	public JButton resetButton = new JButton("Reset");
	public JLabel freqLabel = new JLabel("Frequency[Hz]: ");
	public JLabel positionLabel = new JLabel("Source Position [x,y]: ");
	public JLabel directionSourceLabel = new JLabel("Source movement angle [deg]: ");
	public JLabel thisLabel = new JLabel("Source Properties");
	public JLabel souVelocityLabel = new JLabel("Source Velocity [m/s]: ");
			
	
	
	
	public SourcePropertiesPanel() {
		
		// GROUP FOR SIMPROPPANEL
		GroupLayout simPropPanelLayout = new GroupLayout(this);
		this.setLayout(simPropPanelLayout);
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
		line1.addComponent(thisLabel);
		column1.addComponent(thisLabel);
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
		line6.addComponent(startButton);
		column1.addComponent(startButton);
		//
		line6.addComponent(stopButton);
		column2.addComponent(stopButton);
		//
		line6.addComponent(resetButton);
		column3.addComponent(resetButton);
		//
		stopButton.setEnabled(false);
		resetButton.setEnabled(false);
		souXPosition.setMinimumSize(new Dimension(60, 30));
		souXPosition.setMaximumSize(new Dimension(60, 30));
		souDirection.setMinimumSize(new Dimension(60, 30));
		souDirection.setMaximumSize(new Dimension(60, 30));
		souYPosition.setMinimumSize(new Dimension(60, 30));
		souYPosition.setMaximumSize(new Dimension(60, 30));
		velocityField.setMinimumSize(new Dimension(60, 30));
		velocityField.setMaximumSize(new Dimension(60, 30));
		souVelocityField.setMinimumSize(new Dimension(60, 30));
		souVelocityField.setMaximumSize(new Dimension(60, 30));
		freqField.setMinimumSize(new Dimension(60, 30));
		freqField.setMaximumSize(new Dimension(60, 30));
		velocityField.setPreferredSize(new Dimension(60, 30));
		freqField.setPreferredSize(new Dimension(50, 30));
		startButton.setMinimumSize(new Dimension(60, 30));
		startButton.setPreferredSize(new Dimension(60, 30));
		
	
	}
}