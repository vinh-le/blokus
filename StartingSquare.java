import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class StartingSquare extends Actor
{
	private String name;
	private Grid<Actor> grid;
    private Location location;
    private Color color;
    
    public StartingSquare()
    {
    	name = "Starting Square";
    	grid = null;
    	location = null;
    }
    
    public String getName()
    {
    	return name;
    }
    
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