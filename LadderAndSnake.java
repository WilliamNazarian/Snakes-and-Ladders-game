/**
 *Name(s) and ID(s) (Ahmad Elmahallawy - 40193418 , William Nazarian - 40213100)
 *COMP249
 *Assignment # (1)
 *Due Date (7/2/2022)
 */


import java.util.*;
public class LadderAndSnake {
	
	/**
	 * This class contains the attributes and methods required for the game. 
	 * There is another class for Players with the required methods and attributes.
	 */
	
	/**
	 * attributes
	 */
	private Player[] players;
	private Player player;
	private int noOfPlayers;
	
	//2D Board array
	private static final int gameBoard[][] = 
		{
			{100,99,98,97,96,95,94,93,92,91},
			{81,82,83,84,85,86,87,88,89,90},
			{80,79,78,77,76,75,74,73,72,71},
			{61,62,63,64,65,66,67,68,69,70},
			{60,59,58,57,56,55,54,53,52,51},
			{41,42,43,44,45,46,47,48,49,50},
			{40,39,38,37,36,35,34,33,32,31},
			{21,22,23,24,25,26,27,28,29,30},
			{20,19,18,17,16,15,14,13,12,11},
			{1,2,3,4,5,6,7,8,9,10}
		};
	
	//default constructor
	public LadderAndSnake() 
	{
		
	}
	/**
	 * Constructor with 2 parameter
	 * @param 1 will take players array
	 * @param 2 will take number of players
	 */
	public LadderAndSnake(Player[] playerArr,int noOfPlayers) 
	{	
		this.noOfPlayers = noOfPlayers;
		players = playerArr;
	}
	 
	
	/**
	 * flipDice() method
	 * @return player.flipDice()
	 */
	public int flipDice() {
			
		return player.flipDice();
		}

	/**
	 * Display the board with players position
	 */
	public void board()
	{
		String s = "";
		for(int i = 0; i<gameBoard.length; i++)
		{
			System.out.println();
			
			for(int j = 0; j<gameBoard[i].length; j++)
			{
				s="";
				for (int k = 0; k<players.length; k++)
				{
					if(gameBoard[i][j] == players[k].getPosition())
						s = s + "," + players[k].getName();
				}		

				if(j==9)
					System.out.print(gameBoard[i][j]+ ((s.equals(""))? "": s));
				
				else if (i==0 && j==0)
					System.out.print(gameBoard[i][j]+ ((s.equals(""))? "": s) + "  |");
				
				else if (i==9 && j!=9)
					System.out.print(gameBoard[i][j]+ ((s.equals(""))? "": s) + "    |");
				
				else
					System.out.print(gameBoard[i][j]+ ((s.equals(""))? "": s) + "   |");			
			}
		}
					
	}
	

	
	/**
	 *  method that initiates the ladders in the game 
	 *  player score will change according to the ladder they fell on
	 *  @param firstValue takes the player index of the array
	 */
	public void checkLadder(int playerIndex)
	{
		switch(this.players[playerIndex].getPosition()) {
			
		case 1:
			this.players[playerIndex].setPosition(38);
			System.out.println("Nice " + this.players[playerIndex].getName() + "! you stepped on a ladder and your new score is " + this.players[playerIndex].getPosition());
			break;
		
		case 4:
			this.players[playerIndex].setPosition(14);
			System.out.println("Nice " + this.players[playerIndex].getName() + "! you stepped on a ladder and your new score is " + this.players[playerIndex].getPosition());
			break;
			
		case 9:
			this.players[playerIndex].setPosition(31);
			System.out.println("Nice " + this.players[playerIndex].getName() + "! you stepped on a ladder and your new score is " + this.players[playerIndex].getPosition());
			break;
			
		case 21:
			this.players[playerIndex].setPosition(42);
			System.out.println("Nice " + this.players[playerIndex].getName() + "! you stepped on a ladder and your new score is " + this.players[playerIndex].getPosition());
			break;
			
		case 28:
			this.players[playerIndex].setPosition(84);
			System.out.println("Nice " + this.players[playerIndex].getName() + "! you stepped on a ladder and your new score is " + this.players[playerIndex].getPosition());
			break;
			
		case 36:
			this.players[playerIndex].setPosition(44);
			System.out.println("Nice " + this.players[playerIndex].getName() + "! you stepped on a ladder and your new score is " + this.players[playerIndex].getPosition());
			break;
			
		case 51:
			this.players[playerIndex].setPosition(67);
			System.out.println("Nice " + this.players[playerIndex].getName() + "! you stepped on a ladder and your new score is " + this.players[playerIndex].getPosition());
			break;
			
		case 71:
			this.players[playerIndex].setPosition(91);
			System.out.println("Nice " + this.players[playerIndex].getName() + "! you stepped on a ladder and your new score is " + this.players[playerIndex].getPosition());
			break;
			
		case 80:
			this.players[playerIndex].setPosition(100);
			System.out.println("Nice " + this.players[playerIndex].getName() + "! you stepped on a ladder and your new score is " + this.players[playerIndex].getPosition());
			break;
		
		}
		
		
	}
	
	/**
	 *  method that initiates the ladders in the game 
	 *	player score will change according to the ladder they fell on
	 * 	@param 1 takes the player index of the array
	 *  switch which takes the player's position and see if there is a snakes head at that position 
	 *  if there is a snake, new position will be set
	*/
	public void checkSnake(int playerIndex) {
		switch(this.players[playerIndex].getPosition()) {
		
		case 16:
			this.players[playerIndex].setPosition(6);
			System.out.println("Whoops! " + this.players[playerIndex].getName() + ", you stepped on a snake's head! Your new score is " + this.players[playerIndex].getPosition());
			break;
			
			
		case 48:
			this.players[playerIndex].setPosition(30);
			System.out.println("Whoops! " + this.players[playerIndex].getName() + ", you stepped on a snake's head! Your new score is " + this.players[playerIndex].getPosition());
			break;
			
		case 62:
			this.players[playerIndex].setPosition(19);
			System.out.println("Whoops! " + this.players[playerIndex].getName() + ", you stepped on a snake's head! Your new score is " + this.players[playerIndex].getPosition());
			break;
			
		case 64:
			this.players[playerIndex].setPosition(60);
			System.out.println("Whoops! " + this.players[playerIndex].getName() + ", you stepped on a snake's head! Your new score is " + this.players[playerIndex].getPosition());
			break;
			
		case 93:
			this.players[playerIndex].setPosition(68);
			System.out.println("Whoops! " + this.players[playerIndex].getName() + ", you stepped on a snake's head! Your new score is " + this.players[playerIndex].getPosition());
			break;
		
		case 95:
			this.players[playerIndex].setPosition(24);
			System.out.println("Whoops! " + this.players[playerIndex].getName() + ", you stepped on a snake's head! Your new score is " + this.players[playerIndex].getPosition());
			break;
			
		case 97:
			this.players[playerIndex].setPosition(76);
			System.out.println("Whoops! " + this.players[playerIndex].getName() + ", you stepped on a snake's head! Your new score is " + this.players[playerIndex].getPosition());
			break;
			
		case 98:
			this.players[playerIndex].setPosition(78);
			System.out.println("Whoops! " + this.players[playerIndex].getName() + ", you stepped on a snake's head! Your new score is " + this.players[playerIndex].getPosition());
			break;
		}
		
	}
	
	/**
	 * When a player lands on a number bigger than 100 they will go backward the extra distance
	 * @param 1 takes the player index of the array
	 * switch which takes the player's position and see if there is a ladder at that position
	 * if there is a ladder, new position will be set
	 */
	public void checkDifference(int index) {
		int difference=0,newScore=0;
		if(players[index].getPosition() > 100) {
			difference= players[index].getPosition()-100;
			newScore = 100 - difference;
			
			players[index].setPosition(newScore);
			System.out.println("You did not land EXACTLY on 100,  your score dropped to " + players[index].getPosition());
			
		}
		
	}
	
	/**
	 * Method that checks if a player landed exactly on 100 and won
	 * @param 1 takes the player index of the array
	 * @return boolean
	 */
	public boolean checkWin(int index) {
		if(this.players[index].getPosition()==100) {
			System.out.println("Congrats " + players[index].getName() + "! You won!");
			return true;
		}
		else
			return false;
	}
	
	/**
	 * play method which makes the game function
	 * @param index which takes player's takes
	 * 3 methods will be called, checkDifference,checkLadder and checkSnake
	 */
	public void play(int index) {
		checkDifference(index);
		checkLadder(index);
		checkSnake(index);	
			
	}
	
	
	

}