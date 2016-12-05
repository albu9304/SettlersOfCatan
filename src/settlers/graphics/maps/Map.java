package settlers.graphics.maps;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import settlers.graphics.ResourceTile;
import settlers.Path;
//import settlers.graphics.NumberTile;
//import settlers.graphics.PortTile;


/**
 Creates a Map object which is used to create different maps from:
 - resource tiles
 - number tiles
 - shipping ports
 OBS! Only map specific graphical objects are created here! 
 * */


public class Map {
	private int x; // x-position of map (left top corner) 
	private int y; // x-position of map (left top corner) 
	private List<ResourceTile> resourceTiles;
	
	/*
	 TILE_ORDER lists the order of the resource tiles from top left to bottom right 
	 corner of the map
	 */
	private static final String[] TILE_ORDER = {
			"rock", "sheep", "wood",
			"hay", "clay", "sheep", "clay",
			"hay", "wood", "desert", "wood", "rock", 
			"wood", "rock", "hay", "sheep",
			"clay", "hay", "sheep"
	};
	
	/*
	TILES_PER_ROW is used in conjunction with TILE_ORDER to for the layout of the map;
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
	
	//	private static final int[] TILES
	//	private List<NumberTile> numberTiles;
	//	private List<PortTile> portTiles;
	//	private List<List> mapList; 
	
	public Map(int x, int y) {
		this.x = x;
		this.y = y;
		this.resourceTiles = new ArrayList<ResourceTile>();
		populateResourcesTiles();
	}
	
	/*
	 Fill the list ResourcesTiles with resourceTile objects
	  */
	private void populateResourcesTiles() { 
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
				addResourceTile(TILE_ORDER[iTileOrder], this.x + x,this.y + y);
				iTileOrder++;
			}	
		}
	}
	
	/*
	 Create resourceTile and add it to resourceTiles
	 */
	private void addResourceTile(String filename, int x, int y) {
		
		URL urlImage = getClass().getResource(Path.IMAGE_DIR + filename + ".png");
		Image image = new ImageIcon(urlImage).getImage();
		ResourceTile resourceTile = new ResourceTile(image, x, y);
		this.resourceTiles.add(resourceTile);
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public List<ResourceTile> getResourceTiles() {
		return resourceTiles;
	}
	
}
