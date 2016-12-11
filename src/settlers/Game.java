package settlers;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import settlers.graphics.DragAndDropListener;
import settlers.graphics.board.Board;

public class Game extends JPanel {

	// Member variables
	private static final long serialVersionUID = 1L;
	private Board board;
	private List<Player> players = new ArrayList<Player>();
	
	public Game(int numberOfPlayers) throws IOException {
		// Create map (game board)
		board = new Board("water", 0, 0);
		addPlayers(numberOfPlayers);
		// add mouse listeners to enable drag and drop
		//
		DragAndDropListener listener = new DragAndDropListener(this.board.getResourceTiles(), this);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
	}
	
	private void addPlayers(int numberOfPlayers) {
		for (int i = 0; i < numberOfPlayers; i++) {
			this.players.add(new Player(i));
		}
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		board.draw(graphics);
	}
	
	public void start() {
		
	}
}
