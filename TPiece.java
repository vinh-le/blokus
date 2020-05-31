import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;

public class TPiece extends Piece
{
	public TPiece(Location loc, Color col)
	{
		super();
		setNumSquares(5);
		setColor(col);
		
		Location one = loc.getAdjacentLocation(Location.WEST);
		Location two = one.getAdjacentLocation(Location.WEST);
		Location three = two.getAdjacentLocation(Location.SOUTHEAST);
		Location four = three.getAdjacentLocation(Location.SOUTH);
		
		add(loc);
		add(one);
		add(two);
		add(three);
		add(four);
	}
}