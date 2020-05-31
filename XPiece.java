import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;

public class XPiece extends Piece
{
	public XPiece(Location loc, Color col)
	{
		super();
		setNumSquares(5);
		setColor(col);
		
		Location one = loc.getAdjacentLocation(Location.NORTH);
		Location two = loc.getAdjacentLocation(Location.EAST);
		Location three = loc.getAdjacentLocation(Location.SOUTH);
		Location four = loc.getAdjacentLocation(Location.WEST);
		
		add(loc);
		add(one);
		add(two);
		add(three);
		add(four);
	}
}