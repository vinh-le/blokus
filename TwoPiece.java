import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;

public class TwoPiece extends Piece
{
	public TwoPiece(Location loc, Color col)
	{
		super();
		setNumSquares(2);
		setColor(col);
		
		Location one = loc.getAdjacentLocation(Location.SOUTH);
		
		add(loc);
		add(one);
	}
}