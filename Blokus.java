import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;
import java.awt.event.KeyEvent;
import java.io.*;

public class Blokus extends ActorWorld
{
	private Color whoseTurn;
	private int numPlayers;
	private boolean firstClick;
	private AnchorSquare anchor;
	private Location firstLoc;
	private Location secondLoc;
	private ArrayList<Player> players;
	private ArrayList<Player> withdrawnPlayers;
	private ArrayList<Location> original;
	
	private static final int EMPTY = 0;
	private static final int BLUE = 1;
	private static final int RED = 2;
	private static final int GREEN = 3;
	private static final int YELLOW = 4;
	private static final int BLACK = 5;
	private static final int GREY = 6;
	
	private static final int BLUE_ANCHOR = 7;
	private static final int RED_ANCHOR = 8;
	private static final int GREEN_ANCHOR = 9;
	private static final int YELLOW_ANCHOR = 10;
	public Blokus(int i)
	{
		super(new BoundedGrid<Actor>(10*i+2, 100));
	
		if(i == 4)
		{
			numPlayers = 4;
			whoseTurn = Color.BLUE;
			firstClick = true;
			withdrawnPlayers = new ArrayList<Player>();

		
			String nameOne = JOptionPane.showInputDialog("Enter name for Player 1 (BLUE)");
			if(nameOne.length() == 0)
				nameOne = "PLAYER 1";
			
			String nameTwo = JOptionPane.showInputDialog("Enter name for Player 2 (RED)");
			if(nameTwo.length() == 0)
				nameTwo = "PLAYER 2";
			
			String nameThree = JOptionPane.showInputDialog("Enter name for Player 3 (GREEN)");
			if(nameThree.length() == 0)
				nameThree = "PLAYER 3";
			
			String nameFour = JOptionPane.showInputDialog("Enter name for Player 4 (YELLOW)");
			if(nameFour.length() == 0)
				nameFour = "PLAYER 4";
			
			JOptionPane.showMessageDialog(null, "Welcome to Blokus! The goal of the game is simple: to place as many of your pieces on the board as possible, while 'blocking' other players from doing the same." +
												"\n\nYou will take turns placing pieces with the following conditions:" +
												"\n     - Each new piece must touch at least one other piece of the same color, but only through corner contact" +
												"\n     - No flat edges of same colored pieces can touch" +
												"\n\nBe sure to check the message dialogs in the yellow box or the online help for additional info. Good luck and have fun!");
			players = new ArrayList<Player>();
			players.add(new Player(nameOne, Color.BLUE));
			players.add(new Player(nameTwo, Color.RED));
			players.add(new Player(nameThree, Color.GREEN));
			players.add(new Player(nameFour, Color.YELLOW));
			show();
		
			setBorders(i);
				
			addPiece(new WPiece(new Location(2,23), Color.BLUE)); // BLUE pieces
			addPiece(new FPiece(new Location(2,28), Color.BLUE));
			addPiece(new IPiece(new Location(4,95), Color.BLUE));
			addPiece(new LPiece(new Location(3,34), Color.BLUE));
			addPiece(new NPiece(new Location(3,39), Color.BLUE));
			addPiece(new PPiece(new Location(2,44), Color.BLUE));
			addPiece(new TPiece(new Location(2,49), Color.BLUE));
			addPiece(new UPiece(new Location(2,53), Color.BLUE));
			addPiece(new VPiece(new Location(3,59), Color.BLUE));
			addPiece(new ZPiece(new Location(3,65), Color.BLUE));
			addPiece(new XPiece(new Location(3,69), Color.BLUE));
			addPiece(new YPiece(new Location(3,75), Color.BLUE));
			
			addPiece(new FourZPiece(new Location(4, 79), Color.BLUE));
			addPiece(new FourLPiece(new Location(3, 85), Color.BLUE));
			addPiece(new FourIPiece(new Location(9, 24), Color.BLUE));
			addPiece(new FourTPiece(new Location(12, 27), Color.BLUE));
			addPiece(new FourSquarePiece(new Location(7, 35), Color.BLUE));
			
			addPiece(new ThreeIPiece(new Location(7, 32), Color.BLUE));
			addPiece(new ThreeLPiece(new Location(6, 41), Color.BLUE));
			addPiece(new TwoPiece(new Location(7, 44), Color.BLUE));
			addPiece(new OnePiece(new Location(7, 48), Color.BLUE));
			
			addPiece(new WPiece(new Location(15,23), Color.RED)); // RED pieces
			addPiece(new FPiece(new Location(15,28), Color.RED));
			addPiece(new IPiece(new Location(17,95), Color.RED));
			addPiece(new LPiece(new Location(16,34), Color.RED));
			addPiece(new NPiece(new Location(16,39), Color.RED));
			addPiece(new PPiece(new Location(15,44), Color.RED));
			addPiece(new TPiece(new Location(15,49), Color.RED));
			addPiece(new UPiece(new Location(15,53), Color.RED));
			addPiece(new VPiece(new Location(16,59), Color.RED));
			addPiece(new ZPiece(new Location(16,65), Color.RED));
			addPiece(new XPiece(new Location(16,69), Color.RED));
			addPiece(new YPiece(new Location(16,75), Color.RED));
			
			addPiece(new FourZPiece(new Location(17, 79), Color.RED));
			addPiece(new FourLPiece(new Location(17, 85), Color.RED));
			addPiece(new FourIPiece(new Location(9, 72), Color.RED));
			addPiece(new FourTPiece(new Location(12, 75), Color.RED));
			addPiece(new FourSquarePiece(new Location(9, 78), Color.RED));
			
			addPiece(new ThreeIPiece(new Location(9, 83), Color.RED));
			addPiece(new ThreeLPiece(new Location(9, 87), Color.RED));
			addPiece(new TwoPiece(new Location(9, 91), Color.RED));
			addPiece(new OnePiece(new Location(9, 95), Color.RED));
			
			addPiece(new WPiece(new Location(22,23), Color.GREEN)); // GREEN pieces
			addPiece(new FPiece(new Location(22,28), Color.GREEN));
			addPiece(new IPiece(new Location(23,95), Color.GREEN));
			addPiece(new LPiece(new Location(23,34), Color.GREEN));
			addPiece(new NPiece(new Location(23,39), Color.GREEN));
			addPiece(new PPiece(new Location(22,44), Color.GREEN));
			addPiece(new TPiece(new Location(22,49), Color.GREEN));
			addPiece(new UPiece(new Location(22,53), Color.GREEN));
			addPiece(new VPiece(new Location(23,59), Color.GREEN));
			addPiece(new ZPiece(new Location(23,65), Color.GREEN));
			addPiece(new XPiece(new Location(23,69), Color.GREEN));
			addPiece(new YPiece(new Location(23,75), Color.GREEN));
			
			addPiece(new FourZPiece(new Location(24, 79), Color.GREEN));
			addPiece(new FourLPiece(new Location(23, 85), Color.GREEN));
			addPiece(new FourIPiece(new Location(29, 24), Color.GREEN));
			addPiece(new FourTPiece(new Location(32, 27), Color.GREEN));
			addPiece(new FourSquarePiece(new Location(27, 35), Color.GREEN));
			
			addPiece(new ThreeIPiece(new Location(27, 32), Color.GREEN));
			addPiece(new ThreeLPiece(new Location(26, 41), Color.GREEN));
			addPiece(new TwoPiece(new Location(27, 44), Color.GREEN));
			addPiece(new OnePiece(new Location(27, 48), Color.GREEN));
			
			addPiece(new WPiece(new Location(35,23), Color.YELLOW)); // RED pieces
			addPiece(new FPiece(new Location(35,28), Color.YELLOW));
			addPiece(new IPiece(new Location(36,95), Color.YELLOW));
			addPiece(new LPiece(new Location(36,34), Color.YELLOW));
			addPiece(new NPiece(new Location(36,39), Color.YELLOW));
			addPiece(new PPiece(new Location(35,44), Color.YELLOW));
			addPiece(new TPiece(new Location(35,49), Color.YELLOW));
			addPiece(new UPiece(new Location(35,53), Color.YELLOW));
			addPiece(new VPiece(new Location(36,59), Color.YELLOW));
			addPiece(new ZPiece(new Location(36,65), Color.YELLOW));
			addPiece(new XPiece(new Location(36,69), Color.YELLOW));
			addPiece(new YPiece(new Location(36,75), Color.YELLOW));
			
			addPiece(new FourZPiece(new Location(37, 79), Color.YELLOW));
			addPiece(new FourLPiece(new Location(37, 85), Color.YELLOW));
			addPiece(new FourIPiece(new Location(29, 72), Color.YELLOW));
			addPiece(new FourTPiece(new Location(32, 75), Color.YELLOW));
			addPiece(new FourSquarePiece(new Location(29, 78), Color.YELLOW));
			
			addPiece(new ThreeIPiece(new Location(29, 83), Color.YELLOW));
			addPiece(new ThreeLPiece(new Location(29, 87), Color.YELLOW));
			addPiece(new TwoPiece(new Location(29, 91), Color.YELLOW));
			addPiece(new OnePiece(new Location(29, 95), Color.YELLOW));
			
			add(new Location(25, 4), new ConcedeSquare(Color.BLUE));
			add(new Location(25, 16), new ConcedeSquare(Color.RED));
			add(new Location(36, 4), new ConcedeSquare(Color.GREEN));
			add(new Location(36, 16), new ConcedeSquare(Color.YELLOW));
			
			add(new Location(0,0), new StartingSquare());
			add(new Location(19,0), new StartingSquare());
			add(new Location(0,19), new StartingSquare());
			add(new Location(19,19), new StartingSquare());
		}
		else
		{
			numPlayers = 2;
			whoseTurn = Color.BLUE;
			firstClick = true;
			withdrawnPlayers = new ArrayList<Player>();
//			System.setProperty("info.gridworld.gui.tooltips", "hide"); 
			
			String nameOne = JOptionPane.showInputDialog("Enter name for Player 1 (BLUE)");
			if(nameOne.length() == 0)
				nameOne = "PLAYER 1";
			
			String nameTwo = JOptionPane.showInputDialog("Enter name for Player 2 (RED)");
			if(nameTwo.length() == 0)
				nameTwo = "PLAYER 2";
				
			players = new ArrayList<Player>();
			players.add(new Player(nameOne, Color.BLUE));
			players.add(new Player(nameTwo, Color.RED));
			
			setBorders(i);
			JOptionPane.showMessageDialog(null, "Welcome to Blokus! The goal of the game is simple: to place as many of your pieces on the board as possible, while 'blocking' other players from doing the same." +
												"\n\nYou will take turns placing pieces with the following conditions:" +
												"\n     - Each new piece must touch at least one other piece of the same color, but only through corner contact" +
												"\n     - No flat edges of same colored pieces can touch" +
												"\n\nBe sure to check the message dialogs in the yellow box or the online help for additional info. Good luck and have fun!");
			addPiece(new WPiece(new Location(2,23), Color.BLUE)); // BLUE pieces
			addPiece(new FPiece(new Location(2,28), Color.BLUE));
			addPiece(new IPiece(new Location(4,95), Color.BLUE));
			addPiece(new LPiece(new Location(3,34), Color.BLUE));
			addPiece(new NPiece(new Location(3,39), Color.BLUE));
			addPiece(new PPiece(new Location(2,44), Color.BLUE));
			addPiece(new TPiece(new Location(2,49), Color.BLUE));
			addPiece(new UPiece(new Location(2,53), Color.BLUE));
			addPiece(new VPiece(new Location(3,59), Color.BLUE));
			addPiece(new ZPiece(new Location(3,65), Color.BLUE));
			addPiece(new XPiece(new Location(3,69), Color.BLUE));
			addPiece(new YPiece(new Location(3,75), Color.BLUE));
			
			addPiece(new FourZPiece(new Location(4, 79), Color.BLUE));
			addPiece(new FourLPiece(new Location(3, 85), Color.BLUE));
			addPiece(new FourIPiece(new Location(9, 24), Color.BLUE));
			addPiece(new FourTPiece(new Location(12, 27), Color.BLUE));
			addPiece(new FourSquarePiece(new Location(7, 35), Color.BLUE));
			
			addPiece(new ThreeIPiece(new Location(7, 32), Color.BLUE));
			addPiece(new ThreeLPiece(new Location(6, 41), Color.BLUE));
			addPiece(new TwoPiece(new Location(7, 44), Color.BLUE));
			addPiece(new OnePiece(new Location(7, 48), Color.BLUE));
			
			addPiece(new WPiece(new Location(15,23), Color.RED)); // RED pieces
			addPiece(new FPiece(new Location(15,28), Color.RED));
			addPiece(new IPiece(new Location(17,95), Color.RED));
			addPiece(new LPiece(new Location(16,34), Color.RED));
			addPiece(new NPiece(new Location(16,39), Color.RED));
			addPiece(new PPiece(new Location(15,44), Color.RED));
			addPiece(new TPiece(new Location(15,49), Color.RED));
			addPiece(new UPiece(new Location(15,53), Color.RED));
			addPiece(new VPiece(new Location(16,59), Color.RED));
			addPiece(new ZPiece(new Location(16,65), Color.RED));
			addPiece(new XPiece(new Location(16,69), Color.RED));
			addPiece(new YPiece(new Location(16,75), Color.RED));
			
			addPiece(new FourZPiece(new Location(17, 79), Color.RED));
			addPiece(new FourLPiece(new Location(17, 85), Color.RED));
			addPiece(new FourIPiece(new Location(9, 72), Color.RED));
			addPiece(new FourTPiece(new Location(12, 75), Color.RED));
			addPiece(new FourSquarePiece(new Location(9, 78), Color.RED));
			
			addPiece(new ThreeIPiece(new Location(9, 83), Color.RED));
			addPiece(new ThreeLPiece(new Location(9, 87), Color.RED));
			addPiece(new TwoPiece(new Location(9, 91), Color.RED));
			addPiece(new OnePiece(new Location(9, 95), Color.RED));
			
			add(new Location(17, 4), new ConcedeSquare(Color.BLUE));
			add(new Location(17, 10), new ConcedeSquare(Color.RED));
			
			add(new Location(4,4), new StartingSquare());
			add(new Location(9,9), new StartingSquare());
			show();
		}	
			setFrame(numPlayers);
		setMessage("Welcome to Blokus! It is " + players.get(getIndex()).getName() + "'s turn. Select an anchor square (a " + players.get(getIndex()).getStringColor() + " square with a white square inside)");
	}
		
	public boolean locationClicked(Location loc)
	{
		if(firstClick)
		{	
			firstLoc = loc;
			firstClick();		
		}
		else
		{
			secondLoc = loc;
			secondClick();
		}
		return true;		
	}
	
	public boolean keyPressed(String description, Location l)
	{
		if(!firstClick)
		{
			if(description.equals("SPACE"))
			{
				for(Location loc: anchor.getPiece().getLocs())
					((Actor)getGrid().get(loc)).removeSelfFromGrid();
				anchor.getPiece().turn();
				addPiece(anchor.getPiece());
				anchor = (AnchorSquare) getGrid().get(firstLoc);
				for(int i = 0; i < original.size(); i++)
					original.set(i, anchor.getPiece().getLocs().get(i));
			}
//			else if(description.equals("W"))
//			{
//				for(Location loc: anchor.getPiece().getLocs())
//					((Actor)getGrid().get(loc)).removeSelfFromGrid();
//				anchor.getPiece().flip();
//				addPiece(anchor.getPiece());
//				anchor = (AnchorSquare) getGrid().get(firstLoc);
//				for(int i = 0; i < original.size(); i++)
//					original.set(i, anchor.getPiece().getLocs().get(i));
//			}
		}
		return true;
	}
		
	public boolean notValidPiece() // Checks if the selected piece on first click is an anchor piece of the correct color
	{
		return	!(getGrid().get(firstLoc) instanceof AnchorSquare) || getGrid().get(firstLoc).getColor() != whoseTurn ;
	}
	
	public void firstClick() // Grabs information of selected anchor square once a valid square is chosen
	{
		Player player = players.get(getIndex());
		int index = getIndex();
		if(getGrid().get(firstLoc) instanceof ConcedeSquare && ((ConcedeSquare) getGrid().get(firstLoc)).getColor().equals(whoseTurn))
		{
			int concede = JOptionPane.showConfirmDialog(null, "You are about to withdraw from the game. You will no longer be able to play additional pieces and your score will be finalized at [" + player.getPoints() + " points]. Continue to withdraw?", "WARNING",JOptionPane.YES_NO_OPTION);
			if(concede == 0)
			{
				withdrawnPlayers.add(player);
				players.remove(player);
				index--;
				if(players.size() == 0)
				{
					ArrayList<Player> tied = new ArrayList<Player>();
					Player winner = withdrawnPlayers.get(0);
					for(Player p: withdrawnPlayers)
						if(p.getPoints() > winner.getPoints())
							winner = p;
					for(Player p: withdrawnPlayers)
						if(p.getPoints() == winner.getPoints())
							tied.add(p);
					if(tied.size() > 1)
					{	
						String firstTied = "";
						for(int i = 0; i < tied.size()-1; i++)
							firstTied += tied.get(i).getName() + ", ";
						JOptionPane.showMessageDialog(null, "All players have withdrawn from the game. " + firstTied + "and " + tied.get(tied.size()-1).getName() + " have tied with [" + winner.getPoints() + " points].");
					}
					else
						JOptionPane.showMessageDialog(null, "All players have withdrawn from the game. " + winner.getName() + " has won with " + winner.getPoints() + " points!");
					frame.dispose();
					int play = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "", JOptionPane.YES_NO_OPTION);
					if(play == 0)
					{
						int num = -1;
						boolean done = false;
						do 
						{
							try
							{
							num = Integer.parseInt((JOptionPane.showInputDialog(null, "How many players? Enter either 2 or 4")));
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
						
						new Blokus(num);
					}
				}
				else if(index == players.size()-1 || players.size()==1)
				{
					whoseTurn = players.get(0).getColor();
					setMessage("It is " + players.get(getIndex()).getName() + "'s turn. Select an anchor square (a " + players.get(getIndex()).getStringColor() + " square with a white square inside)");
				}
				else
				{
					whoseTurn = players.get(index+1).getColor();
					firstClick = true;
					setMessage("It is " + players.get(getIndex()).getName() + "'s turn. Select an anchor square (a " + players.get(getIndex()).getStringColor() + " square with a white square inside)");
				}
			}
		}
		else if(notValidPiece())
			setMessage(player.getName() + ", you must select the " + player.getStringColor() + " anchor square of the piece you wish to play");
		else
			{
				anchor  = (AnchorSquare) getGrid().get(firstLoc);
				original = (ArrayList<Location>) anchor.getPiece().getLocs().clone();
				firstClick = false;
				setMessage("Piece selected! Press SPACE to turn your piece and then choose a position to place the anchor square within the board marked by the black borders");
			}
	}
	
	public void secondClick()
	{	
		
		int index = getIndex();
		anchor.getPiece().set(0, secondLoc);
		anchor.getPiece().update();
		if(!(isInsideGrid(anchor.getPiece().getLocs())))
		{
			JOptionPane.showMessageDialog(null, "Invalid Move - Piece outside of grid");
			System.out.println(numPlayers);
			System.out.println(anchor.getPiece().getLocs() + " before update");
			for(int i = 0; i < original.size(); i++)
				anchor.getPiece().getLocs().set(i, original.get(i));
			System.out.println(anchor.getPiece().getLocs() + " after update");
			setMessage("Please select the anchor piece again or choose another piece and try a new location.");
			firstClick = true;
		}
		else if(players.get(index).getPoints() > 0 && !(isCornerContact(anchor.getPiece().getLocs())))
		{
			JOptionPane.showMessageDialog(null, "Invalid Move - Piece must have corner contact with alike colors");
			for(int i = 0; i < original.size(); i++)
				anchor.getPiece().getLocs().set(i, original.get(i));
			setMessage("Please select the anchor piece again or choose another piece and try a new location.");
			firstClick = true;
		}
		else if(players.get(index).getPoints() > 0 && (noEdge(anchor.getPiece().getLocs())))
		{
			JOptionPane.showMessageDialog(null, "Invalid Move - Piece cannot have edge-to-edge contact with alike colors");
			for(int i = 0; i < original.size(); i++)
				anchor.getPiece().getLocs().set(i, original.get(i));
			setMessage("Please select the anchor piece again or choose another piece and try a new location");
			firstClick = true;
		}
		else if(players.get(index).getPoints() > 0 && !(isEmpty(anchor.getPiece().getLocs())))
		{
			JOptionPane.showMessageDialog(null, "Invalid Move - Spaces already occupied");
			for(int i = 0; i < original.size(); i++)
				anchor.getPiece().getLocs().set(i, original.get(i));
			setMessage("Please select the anchor piece again or choose another piece and try a new location");
			firstClick = true;
		}
		else
		{
			if(players.get(index).getPoints() > 0)
			{
				setPiece();
				if(players.size() == 0)
				{
					ArrayList<Player> tied = new ArrayList<Player>();
					Player winner = withdrawnPlayers.get(0);
					for(Player p: withdrawnPlayers)
						if(p.getPoints() > winner.getPoints())
							winner = p;
					for(Player p: withdrawnPlayers)
						if(p.getPoints() == winner.getPoints())
							tied.add(p);
					if(tied.size() > 1)
					{	
						String firstTied = "";
						for(int i = 0; i < tied.size()-1; i++)
							firstTied += tied.get(i).getName() + ", ";
						JOptionPane.showMessageDialog(null, "All players have withdrawn from the game. " + firstTied + "and " + tied.get(tied.size()-1).getName() + " have tied with [" + winner.getPoints() + " points].");
					}
					else
						JOptionPane.showMessageDialog(null, "All players have withdrawn from the game. " + winner.getName() + " has won with " + winner.getPoints() + " points!");
					frame.dispose();
				}
				if(index == players.size()-1)
					whoseTurn = players.get(0).getColor();
				else
					whoseTurn = players.get(index+1).getColor();
				firstClick = true;
				setMessage("It is " + players.get(getIndex()).getName() + "'s turn. Select an anchor square (a " + players.get(getIndex()).getStringColor() + " square with a white square inside If you have no available moves, click the " + players.get(getIndex()).getStringColor() + " concede square in the bottom left.");
			}
			else if(players.get(index).getPoints() == 0 && firstMove(anchor.getPiece().getLocs()))
			{
				setPiece();
				if(index == players.size()-1 || players.size()==1)
					whoseTurn = players.get(0).getColor();
				else
					whoseTurn = players.get(index+1).getColor();
				firstClick = true;
				setMessage("It is " + players.get(getIndex()).getName() + "'s turn. Select an anchor square (a " + players.get(getIndex()).getStringColor() + " square with a white square inside. If you have no available moves, click the " + players.get(getIndex()).getStringColor() + " concede square in the bottom left.");
			}	
			else
			{
				if(numPlayers == 4)
					JOptionPane.showMessageDialog(null, "Your first move be made in a corner");
				else
					JOptionPane.showMessageDialog(null, "Your first move be made in one of the starting positions marked by a circle");
			}
		}
			
	}

	public boolean isInsideGrid(ArrayList<Location> locs)
	{
		int max;
		if(numPlayers == 4)
			max = 20;
		else
			max = 14;
			
		for(Location loc: locs)
			if(loc.getRow() <= -1 || loc.getCol() <= -1 || loc.getRow() >= max || loc.getCol() >= max)
				return false;
		return true;
	}
	
	public boolean isCornerContact(ArrayList<Location> locs)
	{
		boolean valid = true;
		int count = 0;
		for(Location loc: locs)
		{
			for(int i = 45; i <= 360; i+= 90)
			{
				Location cornerContact = loc.getAdjacentLocation(i);
				if(cornerContact.getRow() > -1 && cornerContact.getCol() > -1 && getGrid().get(cornerContact) != null && locs.indexOf(cornerContact) < 0 && ((Square)getGrid().get(cornerContact)).getColor().equals(whoseTurn))
					count++;
			}
		}
		return count > 0;
	}
	
	public boolean noEdge(ArrayList<Location> locs)
	{
		boolean valid = true;
		int count = 0;
		for(Location loc: locs)
		{
			for(int i = 0; i <= 360; i+= 90)
			{
				Location edgeContact = loc.getAdjacentLocation(i);
				if(edgeContact.getRow() > -1 && edgeContact.getCol() > -1 && getGrid().get(edgeContact) != null && locs.indexOf(edgeContact) < 0 && ((Square)getGrid().get(edgeContact)).getColor().equals(whoseTurn))
					count++;
			}
		}
		return count > 0;
	}
	
	public boolean isEmpty(ArrayList<Location> locs)
	{
		for(Location loc: locs)
			if(!(getGrid().get(loc) instanceof StartingSquare) && getGrid().get(loc) != null)
				return false;
		return true;	
	}
	
	public boolean firstMove(ArrayList<Location> locs)
	{
		if(numPlayers == 4)
		{
			for(Location loc: locs)
				if(loc.equals(new Location(0, 0)) || loc.equals(new Location(19,0)) || loc.equals(new Location(19,19)) || loc.equals(new Location(0, 19)))
					return true;
		}
		else
		{
			for(Location loc: locs)
				if(loc.equals(new Location(4,4)) || loc.equals(new Location(9,9)))
					return true;
		}
		return false;
	}
	public void setPiece()
	{
		for(Location locat: ((AnchorSquare) getGrid().get(firstLoc)).getPiece().getLocs())
			add(locat, new Square(Color.GRAY));
		
		playPiece(anchor.getPiece());
		players.get(getIndex()).addPoints(anchor.getPiece().getNumSquares());		
	}
	
	public void addPiece(Piece p)
	{
		add(p.getLocs().get(0), new AnchorSquare(p.getColor(), p));
		for(int i = 1; i < p.getLocs().size(); i++)
			add(p.getLocs().get(i), new Square(p.getColor()));
	}
	
	public void playPiece(Piece p)
	{
		for (Location location: original)
			add(location, new Square(Color.GRAY));
		for (int i = 0; i < p.getLocs().size(); i++)
			add(p.getLocs().get(i), new Square(p.getColor()));
	}
	
	public void setBorders(int playerCount)
	{
		if(playerCount == 4)
		{
			for(int i = 0; i < 20; i++)
				add(new Location(i, 20), new Square(Color.BLACK));
			for (int i = 0; i < 21; i++)
				add(new Location(20, i), new Square(Color.BLACK));	
		}
		else
		{
			for(int i = 0; i < 14; i++)
				add(new Location(i, 14), new Square(Color.BLACK));
			for(int i = 0; i < 15; i++)
				add(new Location(14, i), new Square(Color.BLACK));
		}
			
	}
	
	public int getIndex()
	{
		for(int i = 0; i < players.size(); i++)
			if(players.get(i).getColor() == whoseTurn)
				return i;
		return -1;
	}
	
	public Location getFirstLoc()
	{
		return firstLoc;
	}
	
	public void save()
	{
		try
		{
			PrintWriter write = new PrintWriter("savefile.txt");
			
			write.println(numPlayers); // two player or four player game
			write.println(players.size()); // Number of players and then each player's information
			for(Player p: players)
				write.println(p.getName() + " " + p.getIntColor() + " " + p.getPoints());
				
			write.println(withdrawnPlayers.size()); // Number of withdrawn players and each player's information
			if(withdrawnPlayers.size() > 0)
				for(Player p: withdrawnPlayers)
					write.println(p.getName() + " " + p.getIntColor() + " " + p.getPoints());
					
			write.println(getIndex());
			
			int max;
			if(numPlayers == 4)
				max = 20;
			else
				max = 14;	
			int[][] grid = new int[max][max];
			
			for(int r = 0; r < max; r++)
			{
				for(int c = 0; c < max; c++)
				{
					Object obj = getGrid().get(new Location(r, c));
					if(obj == null)
						grid[r][c] = EMPTY;
					else
					{
						if(obj instanceof Square)
						{
							Square temp = (Square) obj;
							if(temp.getColor().equals(Color.BLUE))
								grid[r][c] = BLUE;
							else if(temp.getColor().equals(Color.RED))
								grid[r][c] = RED;
							else if(temp.getColor().equals(Color.GREEN))
								grid[r][c] = GREEN;
							else if(temp.getColor().equals(Color.YELLOW))
								grid[r][c] = YELLOW;
						}

					}
				}
			}
			for(int r = 0; r < grid.length; r++)
			{
				write.println();
				for(int c = 0; c < grid[0].length; c++)
					write.print(grid[r][c] + " ");
			}
			
			
			write.println();
			write.println(getGreyCount());
			
			for(int r = 0; r < getGrid().getNumRows(); r++)
				for(int c = 0; c < getGrid().getNumCols(); c++)
				{
					Object obj = getGrid().get(new Location(r,c));
					if(obj instanceof Square && ((Square)obj).getColor().equals(Color.GRAY))
					{
						write.println(r + " " + c);
					}	
				}
			
			for(int r = 0; r < getGrid().getNumRows(); r++)
			{
				for(int c = 0; c < getGrid().getNumCols(); c++)
				{
					Object obj = getGrid().get(new Location(r, c));
					if(obj instanceof AnchorSquare)
					{
						AnchorSquare temp = (AnchorSquare) obj;
						if(temp.getColor().equals(Color.BLUE))
							write.println(BLUE + " " + temp.getPiece().toString());
						else if(temp.getColor().equals(Color.RED))
							write.println(RED + " " + temp.getPiece().toString());
						else if(temp.getColor().equals(Color.GREEN))
							write.println(GREEN + " " + temp.getPiece().toString());
						else if(temp.getColor().equals(Color.YELLOW))
							write.println(YELLOW + " " + temp.getPiece().toString());
						else
							write.println(GREY + " " + r + " " + c);
					}
					
				}
			}

			write.close();
			JOptionPane.showMessageDialog(null, "Game saved!");		
		}
		catch (Exception e)
			{JOptionPane.showMessageDialog(null, "The following error has occurred: " + e + "\nGame not saved");}
	}
	
	public void load()
	{
		try
		{
		clearBoard();
		Grid grid = getGrid();
		ArrayList<Player> tempPlayers = new ArrayList<Player>();
		ArrayList<Player> tempWithdrawn = new ArrayList<Player>();
		
		Scanner in = new Scanner(new File("savefile.txt"));
		int gameSize = in.nextInt();
		numPlayers = gameSize;
		in.nextLine();
		setFrame(gameSize);
		setGrid(new BoundedGrid<Actor>(10*gameSize+1, 100));
		
		setBorders(gameSize);
		int playerCount = in.nextInt();
		in.nextLine();
		
		for(int i = 0; i<playerCount; i++)
		{
			String playerInfo = in.nextLine();
			int index = playerInfo.lastIndexOf(" ");
			int points = Integer.parseInt(playerInfo.substring(index+1));
			playerInfo = playerInfo.substring(0, index);
			index = playerInfo.lastIndexOf(" ");
			int c = Integer.parseInt(playerInfo.substring(index+1));
			Color color;
			
			color = getColor(c);
				
			String name = playerInfo.substring(0, index);
			tempPlayers.add(new Player(name, color, points));
		}
		
		players = tempPlayers;
		
		int withdrawnCount = in.nextInt();
		in.nextLine();
		
		for(int i = 0; i < withdrawnCount; i++)
		{
			String playerInfo = in.nextLine();
			int index = playerInfo.lastIndexOf(" ");
			int points = Integer.parseInt(playerInfo.substring(index+1));
			playerInfo = playerInfo.substring(0, index);
			index = playerInfo.lastIndexOf(" ");
			int c = Integer.parseInt(playerInfo.substring(index+1));
			Color color;
			
			color = getColor(c);
				
			String name = playerInfo.substring(0, index);
			tempWithdrawn.add(new Player(name, color, points));
		}	
		
		withdrawnPlayers = tempWithdrawn;
		
		int t = in.nextInt();
		in.nextLine();
		
		Color turn = tempPlayers.get(t).getColor();
		whoseTurn = turn;
		
		int max;
		if(gameSize == 4)
			max = 20;
		else
			max = 14;
		for(int r = 0; r < max; r++)
		{
			in.nextLine();
			for(int c = 0; c < max; c++)
			{
				Location temp = new Location(r, c);
				int square = in.nextInt();
				
				if(square == BLUE)
					add(temp, new Square(Color.BLUE));
				else if(square == RED)
					add(temp, new Square(Color.RED));
				else if(square == GREEN)
					add(temp, new Square(Color.GREEN));
				else if(square == YELLOW)
					add(temp, new Square(Color.YELLOW));
			} 
		}
		int greyCount = in.nextInt();
		in.nextLine();
		
		for(int i = 0; i < greyCount; i++)
		{
			int r = in.nextInt();
			int c = in.nextInt();
			add(new Location(r, c), new Square(Color.GRAY));
		}
		while(in.hasNextLine())
		{
			ArrayList<Location> temp = new ArrayList<Location>(); 
			int c = in.nextInt();
			Color color = getColor(c);
			int numLocs = in.nextInt();
			for(int i = 0; i < numLocs; i++)
			{
				int row = in.nextInt();
				int col = in.nextInt();
				temp.add(new Location(row, col));
			}
			addPiece(new Piece(temp, color));
			in.nextLine();
		}
		if(gameSize == 4)
		{
			add(new Location(25, 4), new ConcedeSquare(Color.BLUE));
			add(new Location(25, 16), new ConcedeSquare(Color.RED));
			add(new Location(36, 4), new ConcedeSquare(Color.GREEN));
			add(new Location(36, 16), new ConcedeSquare(Color.YELLOW));
		}
		else
		{
			add(new Location(17, 4), new ConcedeSquare(Color.BLUE));
			add(new Location(17, 10), new ConcedeSquare(Color.RED));
		}
		
		setMessage("It is " + players.get(getIndex()).getName() + "'s turn. Select an anchor square (a " + players.get(getIndex()).getStringColor() + " square with a white square inside)");
		show();
		}
		catch (Exception e)
			{System.out.println("File not found");
			 System.out.println(e);}
		
		
	}
	
	public Color getColor(int c)
	{
		if(c == BLUE)
			return Color.BLUE;
		else if(c == RED)
			return Color.RED;
		else if(c == GREEN)
			return Color.GREEN;
		else
			return Color.YELLOW;		
	}
	public void clearBoard()
	{
		for(int r = 0; r < getGrid().getNumRows(); r++)
			for(int c = 0; c < getGrid().getNumCols(); c++)
				remove(new Location(r,c));
	}
	
	public int getGreyCount()
	{
		int count = 0;
		for(int r = 0; r < getGrid().getNumRows(); r++)
			for(int c = 0; c < getGrid().getNumCols(); c++)
			{
				Object obj = getGrid().get(new Location(r,c));
				if(obj instanceof Square && ((Square)obj).getColor().equals(Color.GRAY))
				{
					count++;
				}	
			}
		return count;
	}
	
	public void setFrame(int g)
	{
		if(g == 4)
			frame.setSize(1665, 822);
		else
			frame.setSize(1665, 502);
	}
}
