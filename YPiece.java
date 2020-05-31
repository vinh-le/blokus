import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;

public class YPiece extends Piece
{
	public YPiece(Location loc, Color col)
	{
		super();
		setNumSquares(5);
		setColor(col);
		
		Location one = loc.getAdjacentLocation(Location.SOUTH);
		Location two = one.getAdjacentLocation(Location.WEST);
		Location three = one.getAdjacentLocation(Location.SOUTH);
		Location four = three.getAdjacentLocation(Location.SOUTH);
		
		add(loc);
		add(one);
		add(two);
		add(three);
		add(four);
	}
}