package settlers;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import settlers.graphics.card.ChooseTwoResourcesCard;
import settlers.graphics.card.CostsCard;
import settlers.graphics.card.MonopolyCard;
import settlers.graphics.card.ResourceCard;
import settlers.graphics.pieces.City;
import settlers.graphics.pieces.Road;
import settlers.graphics.pieces.Settlement;

public class Player {
	
	// Member variables
	// Pieces
	private List<City> cities = new ArrayList<City>();
	private List<Road> roads =  new ArrayList<Road>();
	private List<Settlement> settlements = new ArrayList<Settlement>();
	
	// Cards
	private List<ChooseTwoResourcesCard> chooseTwoResourcesCards = new ArrayList<ChooseTwoResourcesCard>();
	private CostsCard costCard;
	private List<MonopolyCard> monopolyCards = new ArrayList<MonopolyCard>();
	private ResourceCard[] resourceCards;
	
	// Special cards
	private boolean largestArmy = false;
	private boolean longestRoad = false;
	
	// Other
	private int id;
	private int points = 0;
	private int numberOfBonusPoints = 0;
	private int numberOfKnights = 0;
	
	private boolean Won = false;
	private boolean conceding = false;
	private boolean playersTurn = false;
	
	private String name;
	private String color;
	
	private Image image;

	// Constructors
	public Player(int id) {
		this.id = id;
	}
	
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void addCity(int positionX, int positionY) {
		this.cities.add(new City(this.color, positionX, positionY));
	}
	
	public int getId() {
		return this.id;
	}
	
//	public void removeCity() {
//		
//	}
	
	public void drawPieces(Graphics graphics) {
		for (City city : cities){
			city.draw(graphics);
		}
	}
	
	
	
}
