package settlers.graphics;

import java.awt.Graphics;
import java.awt.Image;

public abstract class graphicalObject {
	
	protected Image image;
	protected int positionX;
	protected int positionY;
	protected int width;
	protected int height;

	public Image getImage() {
		return image;
	}
	
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public abstract void draw(Graphics graphics);

}
