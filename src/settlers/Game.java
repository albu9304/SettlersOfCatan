package settlers;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import settlers.graphics.DragAndDropListener;
import settlers.graphics.board.Board;

public class Game extends JPanel {

	// Member variables
	private static final long serialVersionUID = 1L;
	private Board board;
	private PlayerPanel playerPanel;
	private List<Player> players = new ArrayList<Player>();
	private int currentPlayerId;
	private int numberOfPlayers;
	
	public Game(int numberOfPlayers) throws IOException {
		
		this.numberOfPlayers = numberOfPlayers; 
		
		// Create map (game board)
		board = new Board("water", 0, 0);
		JButton button_endTurn = new JButton("End turn");
		button_endTurn.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) { 
		        endTurn();
		    } 
		});
		this.add(button_endTurn);
		playerPanel = new PlayerPanel();
		addPlayers();
	
		// add mouse listeners to enable drag and drop
		//
		DragAndDropListener listener = new DragAndDropListener(this.board.getResourceTiles(), this);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
	}
	
	private void addPlayers() {
		for (int i = 0; i < this.numberOfPlayers; i++) {
			this.players.add(new Player(i));
		}
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	private void endTurn() {
		if (this.currentPlayerId + 1 < this.numberOfPlayers) {
			this.currentPlayerId = this.currentPlayerId + 1;
		} else{
			this.currentPlayerId = 0;
		}
		System.out.println("Current Player has id: " + currentPlayerId);
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		this.board.draw(graphics);
		try {
			this.playerPanel.draw(graphics);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void start() {
		Random random = new Random();
		int startingPlayer = random.nextInt(this.numberOfPlayers);
		System.out.println("Starting player: " + startingPlayer);
	}
}
