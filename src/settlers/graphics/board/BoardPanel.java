package settlers.graphics.board;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import settlers.Path;


/**
 Class description
 Creates a Board object which is used to create different Boards from:
 - resource tiles
 - number tiles
 - shipping ports
 OBS! Only Board specific graphical objects are created here! 
 * */

public class BoardPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Member variables
	private List<ResourceTile> resourceTiles;
	
	/*
	 TILE_ORDER
	 TILE_ORDER lists the order of the resource tiles from top left to bottom right 
	 corner of the Board
	 */
	private static final String[] TILE_ORDER = {
			"rock", "sheep", "wood",
			"hay", "clay", "sheep", "clay",
			"hay", "wood", "desert", "wood", "rock", 
			"wood", "rock", "hay", "sheep",
			"clay", "hay", "sheep"
	};
	
	private static final String[] NUMBER_TILE_ORDER = {
			"10", "2", "9", 
			"12", "6", "4", "10",
			"9", "11", "", "3", "8",
			"8", "3", "4", "5", 
			"5", "6", "11"	
	};
	/*
	TILES_PER_ROW
	 is used in conjunction with TILE_ORDER to for the layout of the Board;
	It is unnecessary to do it this way; tiles per row can be calculated from knowing the
	total number of tiles n according to: 
	1. numberOfEdges = 1/2+sqrt( (4*(n-1)+3)/12)
	2. numberOfRows = 1 + 2*(numberOfEdges-1)
	3. tilesPerRow = numberOfEdges, in the first row
	4. The middle row can be calculated by adding the cumulative sum from 1 to (numberOfRows-1)/2,
	   to numberOfEdges.
	5. The rest is easy to calculate with an index counter, which increase for indices lower than 
	   the middle row and decrease for indices higher than the middle index.
	   
	   For now a cheap/ugly solution is good enough. 
	 
	 */
	private static final int[] TILES_PER_ROW = {3, 4, 5, 4, 3};
	
	public BoardPanel(String background, int positionX, int positionY) throws IOException {
		this.image = ImageIO.read(BoardPanel.class.getResource(Path.IMAGES + background + ".png"));
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		this.resourceTiles = new ArrayList<ResourceTile>();
		populateResourcesTiles();
	}
	
	/*
	 populateResourcesTiles
	 fill the list ResourcesTiles with resourceTile objects
	  */
	private void populateResourcesTiles() throws IOException { 
		int iTileOrder = 0;
		// find middle index of TILES_PER_ROW
		int iMiddle = (int) (TILES_PER_ROW.length)/2;
		
		for (int iRow = 0; iRow < TILES_PER_ROW.length; iRow++) {
			/* 
			 Offset factor in x is calculated from the distance between the first 
			 resource tiles of the iRow'th and longest row (middle row). 
			 Division by 2 performed due to geometry of hexagon shape.
			 The offset in x changes along the row of resource tiles.
			 */
			double xOffsetFactor = (TILES_PER_ROW[iMiddle] - TILES_PER_ROW[iRow])/2.0;
			
			/*
			 Offset factor in y per tile height is 0.75 due to geometric reasoning.
			 The offset in y is constant for the entire row of resource tiles. 
			 */
			double yOffsetFactorPerTileHeight = 0.75;
			int yOffset = (int) (ResourceTile.DEFAULT_HEIGHT * yOffsetFactorPerTileHeight); 
			int y = yOffset * iRow;
			
			for (int iCol = 0; iCol < TILES_PER_ROW[iRow]; iCol++) {
				int x = (int) (ResourceTile.DEFAULT_WIDTH * (xOffsetFactor + iCol));
				resourceTiles.add(
						new ResourceTile(TILE_ORDER[iTileOrder], this.positionX + x, this.positionY + y, NUMBER_TILE_ORDER[iTileOrder])
						);
				iTileOrder++;
			}	
		}
	}

	public List<ResourceTile> getResourceTiles() {
		return resourceTiles;
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(this.image, this.positionX, this.positionY, null);
		for(ResourceTile resourceTile : this.resourceTiles) {
			resourceTile.draw(graphics);
		}
	}
	
}
