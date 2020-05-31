import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;

public class FourTPiece extends Piece
{
	public FourTPiece(Location loc, Color col)
	{
		super();
		setNumSquares(4);
		setColor(col);
		
		Location one = loc.getAdjacentLocation(Location.EAST);
		Location two = loc.getAdjacentLocation(Location.NORTH);
		Location three = loc.getAdjacentLocation(Location.WEST);
		
		add(loc);
		add(one);
		add(two);
		add(three);
	}
}