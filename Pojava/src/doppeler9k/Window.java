package doppeler9k;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	public Window() throws HeadlessException {
		JPanel mainPanel = new JPanel();
		
	}

	public Window(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		Window mainWin = new Window();
	}

}
