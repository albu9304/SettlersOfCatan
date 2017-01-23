package settlers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
// import java.lang.reflect.Field;
import java.io.IOException;

import settlers.graphics.card.ResourceCard;
import settlers.graphics.pieces.City;
import settlers.graphics.pieces.Road;

public class PlayerPanel {
	
	// Member variables
	private City city;
	private Road road;
	private ResourceCard[] resourceCards = new ResourceCard[5];
	
	// Constructor
	public PlayerPanel() throws IOException {
		city = new City("red", 50, 700);
		road = new Road("red", 50, 750);
		resourceCards[0] = new ResourceCard("clay", 100 + 0*90, 700);
		resourceCards[1] = new ResourceCard("wood", 100 + 1*90, 700);
		resourceCards[2] = new ResourceCard("hay", 100 + 2*90, 700);
		resourceCards[3] = new ResourceCard("sheep", 100 + 3*90, 700);
		resourceCards[4] = new ResourceCard("rock", 100 + 4*90, 700);
	}
	
	public void draw(Graphics graphics) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		int fontSize = 20;
		graphics.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		graphics.setColor(Color.red);
		graphics.drawString("www.java2s.com", 10, 20);
		city.draw(graphics);
		road.draw(graphics);
		for(ResourceCard resourceCard : resourceCards){
			resourceCard.draw(graphics);
		}
//		Field field = Color.class.getField("yellow");
//		Color color;
//	    color = (Color)field.get(null);
//		System.out.println(color.toString());
		
	}

}
