import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;

public class FourSquarePiece extends Piece
{
	public FourSquarePiece(Location loc, Color col)
	{
		super();
		setNumSquares(4);
		setColor(col);
		
		Location one = loc.getAdjacentLocation(Location.EAST);
		Location two = one.getAdjacentLocation(Location.SOUTH);
		Location three = two.getAdjacentLocation(Location.WEST);
		
		add(loc);
		add(one);
		add(two);
		add(three);
	}
}