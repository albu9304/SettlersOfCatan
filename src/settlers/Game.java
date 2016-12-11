package settlers;

import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JPanel;

import settlers.graphics.DragAndDropListener;
import settlers.graphics.board.Board;

public class Game extends JPanel {

	// Member variables
	private static final long serialVersionUID = 1L;
	private Board board;
	
	public Game() throws IOException {
		// Create map (game board)
		board = new Board("water", 0, 0);
		
		// add mouse listeners to enable drag and drop
		//
		DragAndDropListener listener = new DragAndDropListener(this.board.getResourceTiles(), this);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
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
