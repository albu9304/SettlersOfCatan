package settlers.graphics;

import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JPanel;

public class Gui extends JPanel {

	// Member variables
	private static final long serialVersionUID = 1L;
	private Map map;
	
	public Gui() throws IOException {
		// Create map (game board)
		map = new Map("water", 0, 0);
		
		// add mouse listeners to enable drag and drop
		//
		DragAndDropListener listener = new DragAndDropListener(this.map.getResourceTiles(), this);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
	}
	
	public Map getMap() {
		return this.map;
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		map.draw(graphics);
	}
}
