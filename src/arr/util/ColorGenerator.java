package arr.util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class ColorGenerator {

	// The output that will be used by other members
	static ArrayList<Color> colors;
	
	// Generate random N colors, where N is the input.
	// The general idea is to mix the colors with a shade of white, making them appear to have a "nicer and cleaner" look;
	public static void generateRandomColors(int n)
	{
		colors = new ArrayList<Color>();
		// Set the base color to be white, so I can generate good pastel colors;
		Color mix = new Color(255,255,255);
		
		for(int i = 0; i < n; i++)
		{
		    Random random = new Random();
		    int red = random.nextInt(256);
		    int green = random.nextInt(256);
		    int blue = random.nextInt(256);
	
		    // mix the color
		    if (mix != null) {
		        red = (red + mix.getRed()) / 2;
		        green = (green + mix.getGreen()) / 2;
		        blue = (blue + mix.getBlue()) / 2;
		    }
		    colors.add(new Color(red, green, blue));
		}
	}
	
	public static Color getColor(int id)
	{
		if(id <= colors.size())
		{
			return colors.get(id);
		}
		return new Color(150,150,150);
	}
}
