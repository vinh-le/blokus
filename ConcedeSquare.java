import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class ConcedeSquare extends Actor
{
	private Color color;
	private String name;
	private Grid<Actor> grid;
    private Location location;
    
    public ConcedeSquare(Color c)
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