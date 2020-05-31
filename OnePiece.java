import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;

public class OnePiece extends Piece
{
	public OnePiece(Location loc, Color col)
	{
		super();
		setNumSquares(1);
		setColor(col);
		
		add(loc);
	}
	
}