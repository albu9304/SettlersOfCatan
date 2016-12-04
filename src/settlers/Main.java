package settlers;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		// create gui
		Gui gui = new Gui();
		
		// create application frame and set visible
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gui);
		frame.setResizable(true);
		frame.setSize(gui.getWidth(), gui.getHeight());
	}
}
