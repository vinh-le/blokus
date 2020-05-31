import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;

public class FourIPiece extends Piece
{
	public FourIPiece(Location loc, Color col)
	{
		super();
		setNumSquares(4);
		setColor(col);
		
		Location one = loc.getAdjacentLocation(Location.SOUTH);
		Location two = one.getAdjacentLocation(Location.SOUTH);
		Location three = two.getAdjacentLocation(Location.SOUTH);
		
		add(loc);
		add(one);
		add(two);
		add(three);
	}
}