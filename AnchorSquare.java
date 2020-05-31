import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class AnchorSquare extends Actor
{
	private Color color;
	private String name;
	private Grid<Actor> grid;
    private Location location;
    private Piece piece;
	
	public AnchorSquare(Color c, Piece p)
	{
		color = c;
		name = "square";
		grid = null;
		location = null;
		piece = p;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Piece getPiece()
	{
		return piece;
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