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
	public JLabel panelLabel = new JLabel("Observer properties ");
	public JLabel noLabel = new JLabel(" ");
	public JLabel noLabel2 = new JLabel(" ");
	public JLabel obsVelocityLabel = new JLabel("Observer Velocity [m/s]: ");
	public JLabel obsPositionLabel = new JLabel("Observer Position [x,y]: ");
	public JLabel directionObserverLabel = new JLabel("Observer movement angle [deg]: ");
	public JTextField obsVelocityField = new JTextField("0");
	public JTextField obsXPosition = new JTextField("0");
	public JTextField obsYPosition = new JTextField("0");
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
		GroupLayout.Group lineO5 = objPropertiesPanelLayout.createParallelGroup();
		GroupLayout.Group lineO6 = objPropertiesPanelLayout.createParallelGroup();
		//
		GroupLayout.SequentialGroup linesO = objPropertiesPanelLayout.createSequentialGroup();
		GroupLayout.SequentialGroup columnsO = objPropertiesPanelLayout.createSequentialGroup();
		linesO.addGroup(lineO1);
		linesO.addGroup(lineO2);
		linesO.addGroup(lineO3);
		linesO.addGroup(lineO4);
		linesO.addGroup(lineO5);
		linesO.addGroup(lineO6);
		columnsO.addGroup(columnO1);
		columnsO.addGroup(columnO2);
		columnsO.addGroup(columnO3);
		//
		objPropertiesPanelLayout.setHorizontalGroup(columnsO);
		objPropertiesPanelLayout.setVerticalGroup(linesO);
		//
		lineO1.addComponent(panelLabel);
		columnO1.addComponent(panelLabel);
		//
		lineO2.addComponent(noLabel);
		columnO1.addComponent(noLabel);
		//
		lineO6.addComponent(noLabel2);
		columnO1.addComponent(noLabel2);
		//
		lineO5.addComponent(directionObserverLabel);
		columnO1.addComponent(directionObserverLabel);
		//
		lineO5.addComponent(obsDirection);
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
		noLabel.setMinimumSize(new Dimension(60, 30));
		noLabel.setMaximumSize(new Dimension(60, 30));
		noLabel2.setMinimumSize(new Dimension(60, 30));
		noLabel2.setMaximumSize(new Dimension(60, 30));
		obsXPosition.setMinimumSize(new Dimension(60, 30));
		obsXPosition.setMaximumSize(new Dimension(60, 30));
		obsDirection.setMinimumSize(new Dimension(60, 30));
		obsDirection.setMaximumSize(new Dimension(60, 30));
		obsYPosition.setMinimumSize(new Dimension(60, 30));
		obsYPosition.setMaximumSize(new Dimension(60, 30));
		obsVelocityField.setMinimumSize(new Dimension(60, 30));
		obsVelocityField.setMaximumSize(new Dimension(60, 30));
		
	}

	
}
