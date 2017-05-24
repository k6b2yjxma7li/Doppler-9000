package doppeler9k;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener {

	public SimulationObject source1 = new SimulationObject(30,40,210,30);
	public SimulationObject obserwator1 = new SimulationObject(90,30);
	
		
		Timer tm = new Timer(5,this);
		
		public void paintComponent (Graphics g)
		{
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.fillOval((int)source1.getX(),(int)source1.y, 10, 10);
			tm.start();
		}
		
		
	
	//czy w poni¿szej funkcji nie mozna by by³o daæ tak¿e odtwarzania dzwiêku? //K
	@Override
	public void actionPerformed(ActionEvent e) {
		source1.calculateCoords(5);
		repaint();
	}

	

}
