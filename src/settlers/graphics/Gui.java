package settlers.graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import settlers.Path;
import settlers.graphics.maps.Map;

public class Gui extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image imageBackground; // background image of Gui
	private List<ResourceTile> resourceTiles;
	
	public Gui() {
		// background
		URL urlBackground = getClass().getResource(Path.IMAGE_DIR + "water.png");
		this.imageBackground = new ImageIcon(urlBackground).getImage();
		
		// Create map (board)
		Map map = new Map(600, 200);
		
		// resource tiles
		this.resourceTiles = map.getResourceTiles();
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		graphics.drawImage(this.imageBackground, 0, 0, null);
		for (ResourceTile resourceTile : this.resourceTiles) {
			graphics.drawImage(resourceTile.getImage(), resourceTile.getX(), resourceTile.getY(), null);
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
