import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;

public class ThreeLPiece extends Piece
{
	public ThreeLPiece(Location loc, Color col)
	{
		super();
		setNumSquares(3);
		setColor(col);
		
		Location one = loc.getAdjacentLocation(Location.SOUTH);
		Location two = one.getAdjacentLocation(Location.EAST);
		
		add(loc);
		add(one);
		add(two);
	}
}