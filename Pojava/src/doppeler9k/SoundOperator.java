package doppeler9k;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;
import javax.swing.Timer;


public class SoundOperator extends JFrame implements ActionListener{
	public float f;
	public float vol;
	public int fTyp;
	
	public Timer soundTimer = new Timer((int)(1000/f),this);
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			FunctionGenerator gener = new FunctionGenerator(f, vol, fTyp);
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
		System.out.println((int)(1000/f));
		soundTimer.start();
	}
	
}
