import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class Player
{
	private String name;
	private Color color;
	private int points;
	
	public Player(String n, Color c)
	{
		name = n;
		color = c;
		points = 0;
	}
	
	public Player(String n, Color c, int p)
	{
		name = n;
		color = c;
		points = p;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public String getStringColor()
	{
		if(color == Color.BLUE)
			return "BLUE";
		else if(color == Color.RED)
			return "RED";
		else if(color == Color.GREEN)
			return "GREEN";
		else
			return "YELLOW";
	}
	
	public int getIntColor()
	{
		if(color == Color.BLUE)
			return 1;
		else if(color == Color.RED)
			return 2;
		else if(color == Color.GREEN)
			return 3;
		else
			return 4;
	}
	
	public int getPoints()
	{
		return points;
	}
	
	public void addPoints(int n)
	{
		points += n;
	}
	
	public String toString()
	{
		return getName() + " " + getColor() + " " + getPoints();
	}
	
	//		boolean validPlayers = false;
//		int numPlayers;
//		do
//		{
//			numPlayers = Integer.parseInt(JOptionPane.showInputDialog("How many players? Enter '2' or '4'"));
//			if(numPlayers == 2 || numPlayers == 4)
//				validPlayers = true;
//			else
//				JOptionPane.showMessageDialog(null, "Please enter a valid number of players. Either 2 or 4.");
//		}
//		while(!validPlayers);
//		
//		String playerOne = JOptionPane.showInputDialog("Enter name for Player 1 (BLUE)");
//		String playerTwo = JOptionPane.showInputDialog("Enter name for Player 2 (RED)");
//		if(numPlayers == 4)
//		{
//			String playerThree = JOptionPane.showInputDialog("Enter name for Player 3 (GREEN)");
//			String playerFour = JOptionPane.showInputDialog("Enter name for Player 4 (YELLOW)");
//			JOptionPane.showConfirmDialog(frame, "Welcome " + playerOne + ", " + playerTwo + ", " + playerThree + ", and " + playerFour + ".\nReady to play?");
//			 
//		}
//		else
//		{
//			JOptionPane.showMessageDialog(null, "In a 2 player game, both players will have two colors. Player 1 controls BLUE and GREEN. Player 2 controls RED and YELLOW");
//			JOptionPane.showConfirmDialog(frame, "Welcome " + playerOne + " and " + playerTwo + ".\nReady to Play?");
//		}
//
}
