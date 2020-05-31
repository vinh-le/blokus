import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class BlokusRunner 
{
	public static void main(String args[]) throws NumberFormatException
	{
		int numPlayers = -1;
		boolean done = false;
		do 
		{
			try
			{
			numPlayers = Integer.parseInt((JOptionPane.showInputDialog(null, "How many players? Enter either 2 or 4")));
			if(!(numPlayers == 2 || numPlayers == 4))
			{
				JOptionPane.showMessageDialog(null, "Please input an integer, either 2 or 4");
				done = false;
			}
			else
				done = true;
			}
			catch(NumberFormatException e)
			{ 
          		JOptionPane.showMessageDialog(null, "Please input an integer, either 2 or 4");
			}
			
		}
		while(!done);
		
		
		new Blokus(numPlayers);
	}
}