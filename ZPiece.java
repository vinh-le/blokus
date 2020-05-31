import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;

public class ZPiece extends Piece
{
	public ZPiece(Location loc, Color col)
	{
		super();
		setNumSquares(5);
		setColor(col);
		
		Location one = loc.getAdjacentLocation(Location.EAST);
		Location two = one.getAdjacentLocation(Location.SOUTH);
		Location three = two.getAdjacentLocation(Location.SOUTH);
		Location four = three.getAdjacentLocation(Location.EAST);
		
		add(loc);
		add(one);
		add(two);
		add(three);
		add(four);
	}
}