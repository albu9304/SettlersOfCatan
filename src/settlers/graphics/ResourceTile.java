package settlers.graphics;

import java.awt.Image;

public class ResourceTile {
	
	
	private Image image;
	private int x;
	private int y;

	public ResourceTile(Image image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return image.getHeight(null);
	}

	public int getHeight() {
		return image.getHeight(null);
	}
	
}
