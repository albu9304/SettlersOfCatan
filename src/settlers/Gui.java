package settlers;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Gui extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final String IMAGE_DIR = "/images/"; // path for images directory
	private Image imageBackground; // background image of Gui
	private List<ResourceTile> resourceTiles = new ArrayList<ResourceTile>();
	
	public Gui() {
		// background
		URL urlBackground = getClass().getResource(IMAGE_DIR + "water.png");
		this.imageBackground = new ImageIcon(urlBackground).getImage();
		
		// resource tiles
		// hay
		URL urlImageHay = getClass().getResource(IMAGE_DIR + "hay.png");
		Image imageHay = new ImageIcon(urlImageHay).getImage();
		ResourceTile resourceTileHay = new ResourceTile(imageHay, 3*128 + 64, 3*128-32);
		this.resourceTiles.add(resourceTileHay);
		// rock
		URL urlImageRock = getClass().getResource(IMAGE_DIR + "rock.png");
		Image imageRock = new ImageIcon(urlImageRock).getImage();
		ResourceTile resourceTileRock = new ResourceTile(imageRock, 3*128, 2*128);
		this.resourceTiles.add(resourceTileRock);
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
