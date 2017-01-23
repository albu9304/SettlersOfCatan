package settlers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.lang.reflect.Field;

import settlers.graphics.pieces.City;

public class PlayerPanel {
	
	City city;
	
	public PlayerPanel() {
		city = new City("red", 500, 500);
	}
	
	public void draw(Graphics graphics) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		int fontSize = 20;
		graphics.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		graphics.setColor(Color.red);
		graphics.drawString("www.java2s.com", 10, 20);
		city.draw(graphics);
//		Field field = Color.class.getField("yellow");
//		Color color;
//	    color = (Color)field.get(null);
//		System.out.println(color.toString());
		
	}

}
