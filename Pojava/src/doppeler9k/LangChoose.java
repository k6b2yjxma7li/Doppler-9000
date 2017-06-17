package doppeler9k;

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
	
	public int language = 69; //0 - english// 1 - polski
	JPanel buttonsPanel = new JPanel();
	JButton pl = new JButton("POLSKI");
	JButton eng = new JButton("ENGLISH");
	public int getLanguage()	{return language;}
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
		this.add(buttonsPanel);
		buttonsPanel.setLayout((new BoxLayout(buttonsPanel,BoxLayout.X_AXIS)));
		buttonsPanel.add(pl);
		buttonsPanel.add(eng);
		pl.addActionListener(plListener);
		eng.addActionListener(engListener);
		setSize(320,240);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Wybierz jêzyk/Choose language");
		this.setVisible(true);
	}

	

}
