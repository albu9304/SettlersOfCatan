package settlers;

import java.io.IOException;

import javax.swing.JFrame;

import settlers.graphics.Gui;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// create gui
		Gui gui = new Gui();
		
		// create application frame and set visible
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gui);
		frame.setResizable(false);
		frame.setSize(gui.getMap().getWidth(), gui.getMap().getHeight());
	}
}
