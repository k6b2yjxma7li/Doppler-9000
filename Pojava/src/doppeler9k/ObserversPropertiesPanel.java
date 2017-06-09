/**
 * @author Karol
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */
package doppeler9k;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

public class ObserversPropertiesPanel extends JPanel {
	//OBSERVER PROPERTIES PANEL
	public JCheckBox show = new JCheckBox("show");
	public JLabel obsVelocityLabel = new JLabel("Observer Velocity [m/s]: ");
	public JLabel obsPositionLabel = new JLabel("Observer Position [x,y]: ");
	public JLabel directionObserverLabel = new JLabel("Observer movement angle [deg]: ");
	public JTextField obsVelocityField = new JTextField("0");
	public JTextField obsXPosition = new JTextField("10");
	public JTextField obsYPosition = new JTextField("10");
	public JTextField obsDirection = new JTextField("0");
	
	public ObserversPropertiesPanel() {
	
		GroupLayout objPropertiesPanelLayout = new GroupLayout(this);
		this.setLayout(objPropertiesPanelLayout);
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
		//
		//
		obsYPosition.setMinimumSize(new Dimension(40, 30));
		obsYPosition.setMaximumSize(new Dimension(40, 30));
		obsVelocityField.setMinimumSize(new Dimension(40, 30));
		obsVelocityField.setMaximumSize(new Dimension(40, 30));
		
	}

	
}
