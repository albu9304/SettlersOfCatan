package settlers.graphics;

import java.awt.Graphics;
import java.awt.Image;

public abstract class GraphicalObject {
	
	protected Image image;
	protected int positionX;
	protected int positionY;
	protected int width;
	protected int height;

	public Image getImage() {
		return this.image;
	}
	
	public int getPositionX() {
		return this.positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return this.positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
	
	public abstract void draw(Graphics graphics);

}
