import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;

public class FPiece extends Piece
{
	public FPiece(Location loc, Color col)
	{
		super();
		setNumSquares(5);
		setColor(col);
		
		Location one = loc.getAdjacentLocation(Location.WEST);
		Location two = one.getAdjacentLocation(Location.SOUTH);
		Location three = two.getAdjacentLocation(Location.SOUTH);
		Location four = two.getAdjacentLocation(Location.WEST);
		
		add(loc);
		add(one);
		add(two);
		add(three);
		add(four);
	}
}