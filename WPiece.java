import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;

public class WPiece extends Piece
{
	public WPiece(Location loc, Color col)
	{
		super();
		setNumSquares(5);
		setColor(col);
		
		Location one = loc.getAdjacentLocation(Location.SOUTH);
		Location two = one.getAdjacentLocation(Location.EAST);
		Location three = two.getAdjacentLocation(Location.SOUTH);
		Location four = three.getAdjacentLocation(Location.EAST);
		
		add(loc);
		add(one);
		add(two);
		add(three);
		add(four);
		
		setFirstLoc(loc);
	}
	
}