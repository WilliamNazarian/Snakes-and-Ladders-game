/**
 *Name(s) and ID(s) (Ahmad Elmahallawy - 40193418 , William Nazarian - 40213100)
 *COMP249
 *Assignment # (1)
 *Due Date (7/2/2022)
 */

public class Player {
	/**
	 * this is a class for the Player that has getters and setters, attributes as well as the flipDice() method.
	 */
	
	//Attributes
	private String playerName;
	private int diceNumber;
	private int playerPosition; 
	
	//default constructor
	public Player()  
	{
		
	}
		
	/**
	 * constructor with 3 parameters
	 * @Param 1 takes a string name
	 * @Param 2 takes an int dice
	 * @Param 3 takes an int position
	 */
	public Player(String name,int dice,int position)   
	{
		playerName = name;
		diceNumber = dice;
		playerPosition = position;
	}
	
	/**
	 * method for player to roll the dice and generate random value from 1-6
	 * @return dice value
	 */
	public int flipDice() 
	{
		int randomDice = (int)(Math.random()*6)+1;
		setDiceNumber(randomDice);
		return randomDice;
	}
	
	/**
	 * Getters and setters
	 * getters @return playerName,diceNumber
	 */
	public String getName() {
		return playerName;
	}
	
	public int getDiceNumber() {
		return diceNumber;
	}
	
	public void setDiceNumber(int dice) {
		diceNumber = dice;
	}
	
	/**
	 * updates player's position
	 * @param 1 takes the dice value
	 * @return updated position
	 */
	public int updatePosition(int diceNum)
	{
		setPosition(diceNum + getPosition());
		return getPosition();
	}
	
	/**
	 * getter
	 * @return player positiion
	 */
	public int getPosition() {
		return playerPosition;
	}
	/**
	 * setter that sets the positoion
	 * @param takes an int of the position
	 * @return the player's position
	 */
	public void setPosition(int position) {
		this.playerPosition = position;
	}


	//toString method
	public String toString() {
		return "your name is " + playerName + " your current position is " + playerPosition;
	}

	
}
