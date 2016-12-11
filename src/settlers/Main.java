package settlers;

import java.io.IOException;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// Create Game
		Game game = new Game(2);
//		Game game = new Game(2);
//		List<JFrame> jFrames = new ArrayList<jFrames>();
//		for (int i = 0; i < 2; i++) {
//			
//		}
		// Create application frame and set visible
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(game);
		frame.setResizable(false);
		frame.setSize(1920, 1080);
		
		Game game2 = new Game(2);
		JFrame frame2 = new JFrame();
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame2.add(game2);
		frame2.setResizable(false);
		frame2.setSize(1920, 1080);
		
		// Start Game
		game.start();
	}
}
