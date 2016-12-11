package settlers;

import java.io.IOException;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// Create Game
		Game game = new Game();
		
		// Create application frame and set visible
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.setResizable(false);
		frame.setSize(1920, 1080);
		
		// Start Game
		game.start();
	}
}
