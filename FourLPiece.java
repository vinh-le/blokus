import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;

public class FourLPiece extends Piece
{
	public FourLPiece(Location loc, Color col)
	{
		super();
		setNumSquares(4);
		setColor(col);
		
		Location one = loc.getAdjacentLocation(Location.EAST);
		Location two = one.getAdjacentLocation(Location.EAST);
		Location three = two.getAdjacentLocation(Location.NORTH);
		
		add(loc);
		add(one);
		add(two);
		add(three);
	}
}