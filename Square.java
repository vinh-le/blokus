import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class Square extends Actor
{
	private Color color;
	private String name;
	private Grid<Actor> grid;
    private Location location;
	
	private static final Color RED = Color.red;
	private static final Color BLUE = Color.blue;
	private static final Color GREEN = Color.green;
	private static final Color YELLOW = Color.yellow;
	
	public Square(Color c)
	{
		color = c;
		name = "square";
		grid = null;
		location = null;
	}
	
	public String getName()
	{
		return name;
	}
	
	// needed for GridWorld to display the Piece properly
   	public String getText() 
   	{ 
      return getName(); 
   	} 
   	
	public Color getColor()
	{
		return color;
	}
	
	public String toString()
	{
		return getName() + " " + getColor();
	}
}