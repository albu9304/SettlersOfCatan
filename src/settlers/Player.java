package settlers;

import java.awt.Image;

import settlers.graphics.card.ChooseTwoResourcesCard;
import settlers.graphics.card.CostsCard;
import settlers.graphics.card.MonopolyCard;
import settlers.graphics.card.ResourceCard;
import settlers.graphics.pieces.City;
import settlers.graphics.pieces.Road;
import settlers.graphics.pieces.Robber;
import settlers.graphics.pieces.Settlement;

public class Player {
	
	// Member variables
	// Pieces
	private City[] cities;
	private Road[] roads;
	private Robber robber;
	private Settlement[] settlements;
	
	// Cards
	private ChooseTwoResourcesCard[] chooseTwoResourcesCards;
	private CostsCard costCard;
	private MonopolyCard[] monopolyCards;
	private ResourceCard[] resourceCards;
	
	// Special cards
	private boolean largestArmy;
	private boolean longestRoad;
	
	// Other
	private int points;
	private int numberOfBonusPoints;
	private int numberOfKnights;
	
	private boolean won;
	private boolean isConceding;
	
	private String Name;
	private String color;
	
	private Image profileImage;

	// Constructor
	public Player() {

	}
	
	
	
	
}
