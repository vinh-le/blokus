import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;

public class Piece
{
	private ArrayList<Location> locs;
	private int numSquares;
	private Color color;
	private Location firstLoc;
	
	private static int count = 0;
	public Piece()
	{
		locs = new ArrayList<Location>();
		numSquares = 0;
	}
	
	public Piece(ArrayList<Location> locations, Color c)
	{
		locs = locations;
		numSquares = locs.size();
		color = c;
		firstLoc = getLocs().get(0);
	}
	public void add(Location l)
	{
		locs.add(l);
		firstLoc = getLocs().get(0);
	}
	
	public void set(int n, Location l)
	{
		locs.set(n, l);
	}
	
	public int getNumSquares()
	{
		return numSquares;
	}
	
	public void setNumSquares(int n)
	{
		numSquares = n;
	}
	
	public ArrayList<Location> getLocs()
	{
		return locs;
	}
	
	public void setColor(Color col)
	{
		color = col;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void turn()
	{
		ArrayList<Location> temp = new ArrayList<Location>();
		for(Location loc: locs)
			temp.add(loc);
			
		for(int i = 1; i < locs.size(); i++)
		{
			int dir = locs.get(i).getDirectionToward(temp.get(i-1));
			set(i, locs.get(i-1).getAdjacentLocation(dir+270));
		}
		count++;
		
		firstLoc = getLocs().get(0);
	}
	
//	public void flip()
//	{
//		ArrayList<Location> temp = new ArrayList<Location>();
//		for(Location loc: locs)
//			temp.add(loc);
//			
//		for(int i = 1; i < locs.size(); i++)
//		{
//			int dir = locs.get(i).getDirectionToward(temp.get(i-1));
//			if(dir == 0 || dir == 180)
//				set(i, locs.get(i-1).getAdjacentLocation(dir+180));
//			else
//				set(i, locs.get(i-1).getAdjacentLocation(dir));
//		}
//		firstLoc = getLocs().get(0);
//	}

	public Location getFirstLoc()
	{
		return firstLoc;
	}
	
	public void setFirstLoc(Location loc)
	{
		firstLoc = loc;
	}
	
	public void update()
	{	
		int dy = firstLoc.getRow() - locs.get(0).getRow();
		int dx = firstLoc.getCol() - locs.get(0).getCol();
		
		for(int i = 1; i < locs.size(); i++)
		{
			set(i, new Location(locs.get(i).getRow()-dy, locs.get(i).getCol()-dx));
		}
		
	}
	
	public String toString()
	{
		String ret = "" + getNumSquares();
		
		for(Location loc: locs)
		{
			ret += " " + loc.getRow() + " " + loc.getCol();
		}
		return ret;
	}
}