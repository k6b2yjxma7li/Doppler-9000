/**
 * @author Karol
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */
package doppeler9k;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LangChoose extends JFrame {
	
	static public int language = 69; //0 - english// 1 - polski
	JPanel buttonsPanel = new JPanel();
	
	JButton pl = new JButton("POLSKI");
	JButton eng = new JButton("ENGLISH");
	public static int getLanguage()	{return language;}
	public void setLanguage(int lang) {language = lang;}
	

	public ActionListener plListener = new ActionListener()  {
    	public void actionPerformed(ActionEvent e) {
    		setLanguage(1);
    		setVisible(false);
    		
    		
    }
	};
	public ActionListener engListener = new ActionListener()  {
    	public void actionPerformed(ActionEvent e) {
    		setLanguage(0);
    		setVisible(false);
    		
    }
	};
	

	public LangChoose() throws HeadlessException {
		language = 69;
		setSize(320,240);
		this.add(buttonsPanel,BorderLayout.SOUTH);
		buttonsPanel.setLayout((new BoxLayout(buttonsPanel,BoxLayout.X_AXIS)));
		buttonsPanel.add(pl);
		buttonsPanel.add(eng);
		//
		pl.setMinimumSize(new Dimension(this.getWidth()/2, this.getHeight()/2));
		eng.setMinimumSize(new Dimension(this.getWidth()/2, this.getHeight()/2));
		pl.setMaximumSize(new Dimension(this.getWidth()/2, this.getHeight()/2));
		eng.setMaximumSize(new Dimension(this.getWidth()/2, this.getHeight()/2));//alert!
		//
		pl.addActionListener(plListener);
		eng.addActionListener(engListener);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Wybierz jêzyk/Choose language");
		this.setVisible(true);
	}

	

}
