package settlers;

import java.io.IOException;

import javax.swing.JFrame;

import settlers.graphics.Game;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// create Game
		Game game = new Game();
		
		// create application frame and set visible
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.setResizable(false);
		frame.setSize(1920, 1080);
	}
}
