package settlers.graphics;

import java.awt.Graphics;
import java.io.IOException;

import javax.imageio.ImageIO;

import settlers.Path;

public class ResourceTile extends graphicalObject {
	
	// Constants
	public static final int DEFAULT_WIDTH = 128;
	public static final int DEFAULT_HEIGHT = 128;
	
	// Instance variables
	private String resourceType;
	private NumberTile numberTile;
	
	public ResourceTile(String resourceType, int positionX, int positionY, String tileNumber) throws IOException {
		
		// Inherited member variables
		this.image = ImageIO.read(ResourceTile.class.getResource(Path.RESOURCE_TILES_IMAGES + resourceType + ".png"));
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		
		// Member variables
		this.resourceType = resourceType;
		
		if (!tileNumber.equals("")) {
			this.numberTile = new NumberTile(tileNumber, this.positionX, this.positionY, this.width, this.height);	
		}
		
	}
	
	public String getResourceType() {
		return this.resourceType;
	}
	
	public NumberTile getNumberTile() {
		return this.numberTile;
	}
	
	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(this.image, this.positionX, this.positionY, null);
		if (this.numberTile instanceof NumberTile) {
			numberTile.draw(graphics);
		}
	}


	
}
