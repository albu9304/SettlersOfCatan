package settlers.graphics.card;

import java.awt.Graphics;
import java.io.IOException;

import javax.imageio.ImageIO;

import settlers.Path;
import settlers.graphics.GraphicalObject;
public class ResourceCard extends GraphicalObject{

	// Constants
	public static final int DEFAULT_WIDTH = 80;
	public static final int DEFAULT_HEIGHT = 128;	
	
	// Member variables
	private String resourceType;
	
	public ResourceCard(String resourceType, int positionX, int positionY) throws IOException {
		
		// Inherited member variables
		this.image = ImageIO.read(ResourceCard.class.getResource(Path.RESOURCE_CARDS_IMAGES + resourceType + ".png"));
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		
		// Member variables
		this.resourceType = resourceType;
	}
	
	public String getResourceType() {
		return this.resourceType;
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(this.image, this.positionX, this.positionY, null);
	}
	
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

}
