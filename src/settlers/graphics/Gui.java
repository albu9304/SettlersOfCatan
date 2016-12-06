package settlers.graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import settlers.Path;

public class Gui extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image imageBackground; // background image of Gui
	private List<ResourceTile> resourceTiles;
	private List<NumberTile> numberTiles;
	
	public Gui() {
		// background
		URL urlBackground = getClass().getResource(Path.IMAGE_DIR + "water.png");
		this.imageBackground = new ImageIcon(urlBackground).getImage();
		
		// Create map (board)
		Map map = new Map(600, 200);
		
		// resource tiles
		this.resourceTiles = map.getResourceTiles();
		
		// number tiles
		this.numberTiles = map.getNumberTiles();
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		graphics.drawImage(this.imageBackground, 0, 0, null);
		for (ResourceTile resourceTile : this.resourceTiles) {
			graphics.drawImage(resourceTile.getImage(), resourceTile.getX(), resourceTile.getY(), null);
		}
		for (NumberTile numberTile : this.numberTiles) {
			graphics.drawImage(numberTile.getImage(), numberTile.getX(), numberTile.getY(), null);
		}
		
	}
	
//	private void addResourceTile(Image image, int x, int y) {
//		
//	}
	
	public int getHeight() {
		return this.imageBackground.getHeight(null);
	}	
	
	public int getWidth() {
		return this.imageBackground.getWidth(null);
	}
	
}
