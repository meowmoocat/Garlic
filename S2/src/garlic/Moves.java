package garlic;

import java.util.Random;

public class Moves 
{

	private final static Tokens tokens = new Tokens();
	private final static Weapons weapons = new Weapons();
	final static UI ui = new UI(tokens,weapons);
	

	Moves()
	{
		inputNames();

		String command = "";
		do {
			int i = 1;
			for(Token token : tokens)
			{
				token = tokens.get(i);
				
				//there is a null pointer exception here, I think from characters not in the game
				try {
					ui.displayString("\n" + token.getName());
					do {
						ui.displayString(token.getPlayerName() + " enter start to start your turn");
						command = ui.getCommand();
					}while(!command.equals("start") && !command.equals("Start"));
					
					if(token.getTurn() > 0)
					{
						int diceNum = dice();						//TO DO: add condition here for if they want to stay in room
						moveToken(token, diceNum);
						
					}
					
					i++;
					
					
					do {
						ui.displayString(token.getPlayerName() + " enter end to end your turn");
						command = ui.getCommand();
					}while(!command.equals("end"));
					
					
				}catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} while (!command.equals("quit"));
		
	}

	private int dice()
	{
		String startRoll = "";
		do {
			ui.displayString("Type roll to roll dice");
			startRoll = ui.getCommand();
		} while(!startRoll.equals("roll"));
		
		Random dice = new Random();
		int roll = dice.nextInt(10) + 2;
		String rollAsString = Integer.toString(roll);
		ui.displayString(rollAsString);

		return roll;
	}
	
	private int moveToken(Token moveToken, int diceMoves)		//recursive function for move it counts down dice number
	{
		String command;
		
		if(diceMoves == 0)
		{
			return 0;
		}
		else
		{
			do
			{
				command = ui.getCommand();
				ui.displayString(command);
				if(command.equals("d")) moveToken.moveBy(new Coordinates(0,+1));
				if(command.equals("l")) moveToken.moveBy(new Coordinates(-1,0));
				if(command.equals("r")) moveToken.moveBy(new Coordinates(+1,0));
				if(command.equals("u")) moveToken.moveBy(new Coordinates(0,-1));

				ui.display();
			}while(checkMoveInput(command));

			return moveToken(moveToken, diceMoves-1);
		}
	}

	private boolean checkMoveInput(String command)
	{
		return (!command.equals("quit")
				&& !command.equals("d") && !command.equals("l")
				&& !command.equals("r") && !command.equals("u"));
	}


	
	//TO DO clean this up
	private void inputNames()
	{
		
		String command;
		int numPlayers=0;

		do {

			do {
				ui.displayString("Enter the name of the character you would like to be?"
						+ "\n(Example: White)"
						+ "\n(Enter finish into command if you are finished entering players!!)");
				command = ui.getCommand();
				ui.displayString(command);
				command = command.toLowerCase();
				if(checkNameInput(command))
				{
					ui.displayString("Error entering character!!"
							+ "\nEnter the name of the character you would like to be?(Example: White)");
				}
			}while(checkNameInput(command));
			

			if(!command.equals("finish")){
				
				ui.displayString("Enter your player name: ");
				String personName = ui.getCommand();
				numPlayers++;
				ui.displayString(personName);
				personName = personName.toLowerCase();

				for(Token token : tokens)
				{
					token = tokens.getName(command);
					token.setPlayerName(personName);
					token.setTurn(numPlayers);
				}
				
//				TO DO???
//				ui.displayString("Player White is: " + white.getPlayerName());

			}

		} while (!command.equals("finish") && numPlayers<6);

	}
	
	private boolean checkNameInput(String command)
	{
		return (!command.equals("white") && !command.equals("scarlett") && ! command.equals("plum") 
					&& !command.equals("peacock") && !command.equals("mustard") && !command.equals("green") 
					&& !command.equals("finish"));
	}
}
