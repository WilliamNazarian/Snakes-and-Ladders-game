/**
 *Name(s) and ID(s) (Ahmad Elmahallawy - 40193418 , William Nazarian - 40213100)
 *COMP249
 *Assignment # (1)
 *Due Date (7/2/2022)
 */

import java.util.*;
public class PlayLadderAndSnake {
	
	/**
	 * this class is has the main method (the driver class)
	 * first users will enter the number of players
	 * then players will roll to determine who goes first
	 * if there is a tie, tied players will roll again
	 * if tie breaks, the game proceeds until someone wins by reaching exactly 100
	 */

	
	public static void main(String[] args) {
		
		//creating scanner object
		Scanner scanner = new Scanner(System.in);
		
		//variable declaration
		int numberOfPlayers,count=0,position=0,temp=0,dice=0;
		String name,roll;
		boolean flag=false;
		
		//declaring player object
		Player player;
		
		//declaring arrays
		Player[] players;
		int[] scores;
		//LadderAndSnake object
		LadderAndSnake ladderAndSnake;
		
		//Welcome message
		System.out.println("******************************************************************");
		System.out.println("          Welcome to Ladder and Snake game");
		System.out.println("******************************************************************\n");
		
		//asking the user to enter the number of players
		System.out.print("Enter the # of players for your game – Number must be between 2 and 4 inclusively: ");
		numberOfPlayers = scanner.nextInt();
		
		//If user does not enter number of players between 2 and 4 inclusive, Iterate over
		while(numberOfPlayers<2 || numberOfPlayers>4) {
			count++; 
			if(count<4) {
			System.out.println("Bad Attempt " + count + " - Invalid # of players. Please enter a # between 2 and 4 inclusively:");
			numberOfPlayers = scanner.nextInt();
			}
			//terminate the game
			if(count==4) {
				System.out.println("Bad Attempt " + count + "! You have exhausted all your chances. Program will terminate!");
				System.exit(0);
			}
		}
		//determining the size of the array
		players = new Player[numberOfPlayers];
		

		//letting users enter their names and creating player objects
		System.out.println();
		for(int i=0;i<numberOfPlayers;i++) {
			System.out.print("Please enter the initials of player " + (i+1)+": ");
			name = scanner.next();
			player = new Player(name,dice, position);
			players[i] = player;	
		}
		
		//initializing LadderAndSnake object
		ladderAndSnake = new LadderAndSnake(players,numberOfPlayers);
		
		
		System.out.println("The game is played by " + players.length + " players:" );
		
		//printing the players' names
		for(int i=0;i<numberOfPlayers;i++) {
			System.out.println(players[i].getName());
		}
		
		
		System.out.println("\nNow you will all roll the dice, whoever has the highest number will start!\n");
		
		//variable declarations
		String pressF;
		Player temp2;
		int amountDoWhile = 0; //the amount of times the do-while loop has excuted
		String exit = "yes"; //if exit=yes , do-while loop is exited
		int start = 0; /*after sorting, players that are tied are next to eachother inside the players array.
		The start value is the index in the array of the first player that is tied
		*/
		int end = 0; //the end value is the index of the last player that is tied
		int finalEnd = 0; //if 3 players are tied and out of those players, 2 of them tied, final end will remain the index of the original end value
		int trackingEnd = 0; //holds the end value 
		
		//do-while loop to determine players' order
		do
		{	
			if(amountDoWhile >= 1)
			{
				System.out.print("There was a tie between ");
			
				for(int i = start; i<=end; i++)
				{
					if(i == end-1)
						System.out.print(players[i].getName()+ " and ");
					else if(i==end)
						System.out.println(players[i].getName()+ "\n");
					else
						System.out.print(players[i].getName()+ ", ");
				}
			}
			
			if (amountDoWhile == 0)
			{
				end = players.length-1;
			}
			
			for (int i = start; i<=end; i++)
			{
				//making the players roll the dice
				
			
				System.out.println(players[i].getName() + " rolled a " + players[i].flipDice() + "\n");
			}
			
			//sorting players
			for(int i = start; i <= end  ; i++) 
			{
				for(int j = i+1; j <=  end ; j++) 
				{
					if(players[i].getDiceNumber() < players[j].getDiceNumber()&&i!=j) 
					{    
		                   temp2 = players[i];    
		                   players[i] = players[j];    
		                   players[j] = temp2;  
					
					}
				}
			}
			
			if (amountDoWhile == 0)
			{
				end = 0;
			}
			
			if(end > finalEnd && (start!=0 && end!=4))
				finalEnd = end;
			
			trackingEnd = end;	
			
			//finding the new stat and end value
			for(int i = start; i<players.length-1; i++)
			{
				if(i==trackingEnd && amountDoWhile!=0 && trackingEnd != players.length-1)
					i=finalEnd+1;
				if(i!=players.length-1 && players[i].getDiceNumber() == players[i+1].getDiceNumber())
				{
					exit = "no";
					start = i;
					end = i+1;
					i++;
					
					while(i!=players.length-1 && players[i].getDiceNumber() == players[i+1].getDiceNumber()&& i!=trackingEnd)
					{
						end++;
						i++;
					}
					
					break;
				}
				
				else
					exit = "yes";
			}
		
				
			//System.out.println(start + " " + end);
			
			amountDoWhile++;
			
		}while(exit.equals("no"));
		
		
		
		//Telling the players their order
		for(int i = 0 ; i < players.length ; i++)
		{
			System.out.println(players[i].getName() + ", you are player number " + (i+1) ) ;
		}
		
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		
		//Gameplay loop
		do
		{
			for(int i=0;i<players.length;i++) 
			{
				
				players[i].flipDice(); 
				System.out.println("\n" + players[i].getName()+" you rolled a " + players[i].getDiceNumber());
				players[i].updatePosition(players[i].getDiceNumber());
				ladderAndSnake.board();
				
				System.out.println("\n");
				
				ladderAndSnake.play(i);
				
				System.out.println("you have now moved to position " + players[i].getPosition());
				
				
				if(ladderAndSnake.checkWin(i)==true) 
				{
					//terminating the game
					flag=true;
					break;
				}
				
			}
		} while(flag==false);
			
	}

}