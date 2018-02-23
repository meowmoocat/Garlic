package garlic;

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
			for(Token token : tokens)
			{
				if(token.getTurn() > 0)
				{
					token = tokens.get(i);

					//there is a null pointer exception here, I think from characters not in the game
					try {
						ui.refreshInfoPanel();
						ui.displayString("\n" + token.getName() + " " + token.getTurn());
						do {
							ui.displayString(token.getPlayerName() + " enter start to start your turn");
							command = ui.getCommand().toLowerCase().trim();
							if(command.equals("quit")) quit(token);
						}while(!command.equals("start") && !command.equals("Start") && !command.equals("quit"));


						int diceNum = dice();					//TODO: add condition here for if they want to stay in room
						moveToken(token, diceNum);


						do {
							ui.displayString(token.getPlayerName() + " enter end to end your turn");
							command = ui.getCommand().toLowerCase().trim();
							if(command.equals("quit")) quit(token);
						}while(!command.equals("end"));


					}catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					i++;
				}
			}
		} while (!command.equals("end game"));

	}

	private int quit(Token token)
	{
		token.setTurn(0);
		ui.displayString(token.getName() + " has quit!!!");
		return 0;
	}

	private int dice()
	{
		String startRoll = "";
		do {
			ui.displayString("Type roll to roll dice");
			startRoll = ui.getCommand().toLowerCase().trim();
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
		int validMove = 1;

		if(diceMoves == 0)
		{
			return 0;
		}

		int col=moveToken.getTokenCol();
		int row=moveToken.getTokenRow();

		//Comp Sci
		if(col==1 && row==1 || col==2 && row==1 || col==3 && row==1|| col==1 && row==2 || col==2 && row==2 || col==3 && row==2) {//Entering room comp Sci building
			validMove= moveToken.moveBy(new Coordinates(0,+2));
			return 0;// will make the amount of turns a player has to 0
		}
		//O'Reilly Hall
		if(col==10 && row==6 || col==11 && row==6 || col==12 && row==6|| col==10 && row==7 || col==11 && row==7 || col==12 && row==7) {//Entering room comp Sci building
			validMove= moveToken.moveBy(new Coordinates(0,-2));
			return 0;// will make the amount of turns a player has to 0
		}
		//Engineering
		if(col==20 && row==3 || col==21 && row==3 || col==22 && row==3|| col==20 && row==4 || col==21 && row==4 || col==22 && row==4) {//Entering room comp Sci building
			validMove= moveToken.moveBy(new Coordinates(0,+2));
			return 0;// will make the amount of turns a player has to 0
		}
		//Sutherland
		if(col==20 && row==10 || col==21 && row==10 || col==22 && row==10|| col==20 && row==11 || col==21 && row==11 || col==22 && row==11) {//Entering room comp Sci building
			validMove= moveToken.moveBy(new Coordinates(0,+2));
			return 0;// will make the amount of turns a player has to 0
		}
		//Quinn
		if(col==18 && row==15 || col==19 && row==15 || col==18 && row==16|| col==19 && row==16 || col==18 && row==17 || col==19 && row==17) {//Entering room comp Sci building
			validMove= moveToken.moveBy(new Coordinates(+2,0));
			return 0;// will make the amount of turns a player has to 0
		}
		//Newman
		if(col==10 && row==21 || col==11 && row==21 || col==12 && row==21|| col==10 && row==22 || col==11 && row==22 || col==12 && row==22) {//Entering room comp Sci building
			validMove= moveToken.moveBy(new Coordinates(0,+2));
			return 0;// will make the amount of turns a player has to 0
		}
		//Library
		if(col==9 && row==19 || col==10 && row==19 || col==11 && row==19|| col==12 && row==19 || col==13 && row==19 || col==14 && row==19) {//Entering room comp Sci building
			validMove= moveToken.moveBy(new Coordinates(0,+2));
			return 0;// will make the amount of turns a player has to 0
		}
		//Ag Science
		if(col==2 && row==19 || col==3 && row==19 || col==4 && row==19|| col==2 && row==20 || col==3 && row==20 || col==4 && row==20) {//Entering room comp Sci building
			validMove= moveToken.moveBy(new Coordinates(0,+2));
			return 0;// will make the amount of turns a player has to 0
		}
		//O'brien
		if(col==2 && row==11 || col==3 && row==11 || col==4 && row==11|| col==2 && row==12 || col==3 && row==12 || col==4 && row==12) {//Entering room comp Sci building
			validMove= moveToken.moveBy(new Coordinates(0,+2));
			return 0;// will make the amount of turns a player has to 0
		}

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

				map.enterRoom(moveToken, moveToken.getPosition().getRow(), moveToken.getPosition().getCol());

				ui.display();

				if(checkMoveInput(command) || validMove == 0)
					ui.displayString("Invalid move");
				if(command.equals("quit")) diceMoves = quit(moveToken);
			}while(checkMoveInput(command) || validMove == 0);

			return moveToken(moveToken, diceMoves-validMove);
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


		do 
		{

			//code to make sure there isn't to few players
			//TODO needs fixing doesn't work if enter finish twice in a row and too few players

			//			"Not enough players!!"
			do { 
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

				ui.displayString("Enter your player name: ");
				String personName = ui.getCommand().toLowerCase().trim();
				numPlayers++;
				ui.displayString(personName);

				for(Token token : tokens)
				{
					token = tokens.getCharacterName(command);
					token.setPlayerName(personName);
					token.setTurn(numPlayers);
				}

				//				TODO ???
				//				ui.displayString("Player White is: " + white.getPlayerName());

			}

			if(numPlayers<2) ui.displayString("Not enough players!!");

		} while ((!command.equals("finish") && numPlayers<6) || numPlayers < 2);

	}

	private void displayCharactersLeft()
	{
		for(Token token : tokens)
		{
			if(token.getTurn() == 0)
				ui.displayString(token.getName());
		}
	}

	private boolean checkNameInput(String command)
	{
		boolean characterTaken = false;
		for(Token token : tokens)
		{
			if((command.equals(token.getName().toLowerCase().trim())) && !token.getPlayerName().equals(""))
			{
				characterTaken = true;
			}
		}

		return ((!command.equals("white") && !command.equals("scarlett") && ! command.equals("plum") 
				&& !command.equals("peacock") && !command.equals("mustard") && !command.equals("green") 
				&& !command.equals("finish")) || characterTaken);
	}
}
