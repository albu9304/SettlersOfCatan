package settlers.graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class DragAndDropListener implements MouseListener, MouseMotionListener {

	private List<ResourceTile> resourceTiles;
	private Game game;
	
	private ResourceTile dragResourceTile;
	private int dragOffsetX;
	private int dragOffsetY;
	
	public DragAndDropListener(List<ResourceTile> resourceTiles, Game game) {
		this.resourceTiles = resourceTiles;
		this.game = game;
	}
	
	private boolean mouseOverObject(ResourceTile resourceTile, int x, int y) {
		return resourceTile.getPositionX() <= x
			&& resourceTile.getPositionX() + resourceTile.getWidth() >= x
			&& resourceTile.getPositionY() <= y
			&& resourceTile.getPositionY() + resourceTile.getWidth() >= y; 
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		
		if (this.dragResourceTile != null) {
			this.dragResourceTile.setPositionX(event.getPoint().x - this.dragOffsetX);
			this.dragResourceTile.setPositionY(event.getPoint().y - this.dragOffsetY);
			this.game.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		int x = event.getPoint().x;
		int y = event.getPoint().y;
		
		for (int i = this.resourceTiles.size() - 1; i >= 0; i--) {
			ResourceTile resourceTile= this.resourceTiles.get(i);
			
			if (mouseOverObject(resourceTile, x, y)) {
				// calculate offset, because we do not want the drag resourceTile
				// to jump with it's upper left corner to the current mouse
				// position
				//
				this.dragOffsetX = x - resourceTile.getPositionX();
				this.dragOffsetY = y - resourceTile.getPositionY();
				this.dragResourceTile = resourceTile;
				break;
			}
		}
		
		// Move drag piece to the top of the list
		if (this.dragResourceTile != null) {
			this.resourceTiles.remove(this.dragResourceTile);
			this.resourceTiles.add(this.dragResourceTile);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		this.dragResourceTile = null;
	}

}
