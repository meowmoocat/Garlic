package garlic;

/* created by
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import java.util.Random;

public class Moves 
{

	private final static Map map = new Map();
	private final static Tokens tokens = new Tokens();
	private final static Weapons weapons = new Weapons();
	final static UI ui = new UI(tokens,weapons);


	Moves()
	{
		inputNames();

		String command = "";
		do {
			int i = 1;
			for(Token token : tokens) //loops through turns for tokens
			{
				token = tokens.get(i); //gets the tokens that is currently playing

				try { //nullpointer for tokens not in the game
					
					ui.refreshInfoPanel();
					ui.displayString("\n" + token.getName());
					
					do {
						
						ui.displayString(token.getPlayerName() + " enter start to start your turn");
						command = ui.getCommand().toLowerCase().trim();

						if(command.equals("quit")) quit(token); //quit if player quits

					}while(!command.equals("start") && !command.equals("Start") && !command.equals("quit"));

					int diceNum = 0;
					if(!command.equals("quit"))
					{
						//alreadyInRoom 0 for normal move, 1 for moving from room to corridor and 2 if its the secret passage
						int alreadyInARoom = 0;
						alreadyInARoom = map.exitRoom(token, token.getPosition().getRow(), token.getPosition().getCol());
						if(alreadyInARoom != 2)
						{
							diceNum = dice() - alreadyInARoom;	//TODO: add condition here for if they want to stay in room, later in gameplay
						}
						moveToken(token, diceNum);
					}

					do { //ends turn
						
						ui.displayString(token.getPlayerName() + " enter end to end your turn");
						command = ui.getCommand().toLowerCase().trim();
						
						if(command.equals("quit")) quit(token);
						
					}while(!command.equals("end"));
				} catch (NullPointerException e) {
					//nothing to do if it's null!
				}

				i++;

			}
		} while (!command.equals("end game"));

	}

	private int quit(Token token) //quits player turn
	{
		token.setTurn(0);
		ui.displayString(token.getName() + " has quit!!!");
		return 0;
	}

	private int dice() //returns int number between 2-12
	{
		String startRoll = "";
		do {
			ui.displayString("Type roll to roll dice");
			startRoll = ui.getCommand().toLowerCase().trim();
		} while(!startRoll.equals("roll"));

		Random dice = new Random();
		int roll = dice.nextInt(11) + 2;
		String rollAsString = Integer.toString(roll);
		ui.displayString(rollAsString);

		return roll;
	}

	
	private int moveToken(Token moveToken, int diceMoves)		//recursive function for move it counts down dice number
	{
		ui.display();
		String command;
		int validMove = 1;

		if(diceMoves <= 0) //if no more moves left return 0 and exits method
		{
			return 0;
		}
		//else if, calls method and returns true if they are ready to move
//		else if(map.exitRoom(moveToken, moveToken.getPosition().getRow(), moveToken.getPosition().getCol()) && !alreadyInARoom)
//		{
//			
//			ui.display();
//			return moveToken(moveToken, diceMoves-validMove, alreadyInARoom);
//		}
		else
		{
			do
			{
				ui.displayString("Type u for up, d for down, r for right, l for left");
				ui.displayString("Moves remaining " + diceMoves);
				command = ui.getCommand().toLowerCase().trim();

				if(command.equals("d")) 
					validMove = moveToken.moveBy(new Coordinates(0,+1));
				if(command.equals("l")) 
					validMove = moveToken.moveBy(new Coordinates(-1,0));
				if(command.equals("r")) 
					validMove = moveToken.moveBy(new Coordinates(+1,0));
				if(command.equals("u")) 
					validMove = moveToken.moveBy(new Coordinates(0,-1));

				//returns dicemoves unchanged if token hasn't entered a room,
				//returns 0 if token has entered a room
				diceMoves = map.enterRoom(moveToken, moveToken.getPosition().getRow(), moveToken.getPosition().getCol(), diceMoves);

				ui.display();

				if(checkMoveInput(command) || validMove == 0)
					ui.displayString("Invalid move");
				if(command.equals("quit")) diceMoves = quit(moveToken);
			}while(checkMoveInput(command) || validMove == 0);

			return moveToken(moveToken, diceMoves-validMove);//recursive function, if it's a valid move removes 1 from diceMoves
		}
	}

	//boolean for checking movements
	private boolean checkMoveInput(String command)
	{
		return (!command.equals("quit")
				&& !command.equals("d") && !command.equals("l")
				&& !command.equals("r") && !command.equals("u"));
	}


	//sets up characters for gameplay
	private void inputNames()
	{

		String command;
		int numPlayers=0;


		do 
		{

			//code to make sure there isn't to few players

			//			"Not enough players!!"
			do { //picking characters loop
				ui.displayString("\nEnter the name of the character you would like to be?\nEnter finish when done.");
				displayCharactersLeft();
				command = ui.getCommand().toLowerCase().trim();
				ui.displayString(command);
				command = command.toLowerCase().trim();
				if(checkNameInput(command))
				{
					ui.displayString("Error entering character!!");
				}
			}while(checkNameInput(command));


			if(!command.equals("finish"))
			{

				ui.displayString("Enter your player name: ");		//input for player name
				String personName = ui.getCommand().toLowerCase().trim();
				numPlayers++;
				ui.displayString(personName);

				for(Token token : tokens)		//sets up characters for game play
				{
					token = tokens.getCharacterName(command);
					token.setPlayerName(personName);
					token.setTurn(numPlayers);
				}

			}

			if(numPlayers<2) ui.displayString("\nNot enough players!!");

			ui.display();
		} while ((!command.equals("finish") && numPlayers<6) || numPlayers < 2);

	}

	//loops through remaining characters to pick from
	private void displayCharactersLeft()
	{
		for(Token token : tokens) 
		{
			if(token.getTurn() == 0)
				ui.displayString(token.getName());
		}
	}

	//checks input for character name
	private boolean checkNameInput(String command)
	{
		boolean characterTaken = false;
		for(Token token : tokens)//checks if the character has already been taken
		{
			if((command.equals(token.getName())) && !token.getPlayerName().equals(""))
			{
				characterTaken = true;
			}
		}

		return ((!command.equals("white") && !command.equals("scarlett") && ! command.equals("plum") 
				&& !command.equals("peacock") && !command.equals("mustard") && !command.equals("green") 
				&& !command.equals("finish")) || characterTaken);
	}
}
