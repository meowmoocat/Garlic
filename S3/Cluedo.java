package S3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Cluedo {

	private static final int MAX_NUM_PLAYERS = 6;
	private int TOTAL_PLAYERS;

	
	private final MurderEnvelope murder = new MurderEnvelope();
	private final Cards cards = new Cards();
	private final Tokens tokens = new Tokens();
	private final Players players = new Players();
	private final Dice dice = new Dice();
	private final Map map = new Map();
	private final Weapons weapons = new Weapons(map);
	private final UI ui = new UI(tokens,weapons);
	
	public void randomSuspect()
	{
		int number;
		Random rand = new Random();
		number = rand.nextInt(6);
		int i=0;
//		System.out.println("number: "+number);
		for(Card card : cards)
		{
			if(i==number) murder.murderToken = card;
			
			i++;
		}
//		System.out.println(murder.murderToken.getCardName());
				cards.cards.remove(number);
	}
	public void randomWeapon()
	{
		int number;
		Random rand = new Random();
		number = rand.nextInt(6) + 14;
//		System.out.println("number: "+number);
		int i=0;
		for(Card card : cards)
		{
			if(i==number) murder.murderWeapon = card;
			
			i++;
		}
//		System.out.println(murder.murderWeapon.getCardName());
		cards.cards.remove(number);
	}
	public void randomRoom()
	{
		int number;
		Random rand = new Random();
		number = rand.nextInt(9) + 5;
//		System.out.println("number: "+number);
		int i=0;
		for(Card card : cards)
		{
			if(i==number) murder.murderRoom = card;
			
			i++;
		}
		cards.cards.remove(number);
//System.out.println(murder.murderRoom.getCardName());
	}
	
	private void playerOrder()
	{
		String[] highestPlayer = new String[TOTAL_PLAYERS];//stores the highest scoring in an array
		int highestRoll = 0;
		int i=0;
		
		for(Player player : players)
		{
			dice.roll();
			ui.displayDice(player, dice);
			if(i>=1 && dice.getTotal() > highestRoll)	//if theres a new highest roll while there's more than one entry in the array
			{
				for( ;i>0;i--)
				{
					highestPlayer[i]=null;
				}
				i=0;
			}
			if(dice.getTotal() > highestRoll)
			{
				highestPlayer[i] = player.getName();
				highestRoll =12; //dice.getTotal();
			}
			else if(dice.getTotal() == highestRoll)
			{
				i++;
				highestPlayer[i] = player.getName();
			}
		}
		
		
		while(highestPlayer[1] != null)	//second round if two or more are equal
		{
			ui.displayString("");
			highestRoll = 0;
			String[] highestPlayerRnd2 = new String[TOTAL_PLAYERS];
			i = 0;
			int j = 0;
			try {
			
				while(i<TOTAL_PLAYERS && highestPlayer[i] != null)
				{
					dice.roll();
					ui.displayDice(players.getPlayer(highestPlayer[i]), dice);
					if(j>=1 && dice.getTotal() > highestRoll)	//if theres a new highest roll while there's more than one entry in the array
					{
						for( ;j>0;j--)
						{
							highestPlayerRnd2[j]=null;
						}
						j=0;
					}
					if(dice.getTotal() > highestRoll)
					{
						highestPlayerRnd2[j] = highestPlayer[i];
						highestRoll = dice.getTotal();
					}
					else if(dice.getTotal() == highestRoll)
					{
						j++;
						highestPlayerRnd2[j] = highestPlayer[i];
					}
					i++;
				}
			
			} catch (NullPointerException e) {
				//nothing to do if it's null!
			}
			for(int k=0; k<TOTAL_PLAYERS; k++)
			{
				highestPlayer[k] = highestPlayerRnd2[k];
				highestPlayerRnd2[k] = null;
			}
		}

		try {
			int t=1;
			for(Player player : players)
			{
				if(!player.getName().equals(highestPlayer[0]))
				{
					highestPlayer[t] = player.getName();
					t++;
				}
			}
		} catch (NullPointerException e) {
			
		}
		int p=0;
		for(p=0; p < highestPlayer.length; p++)
		{
			players.getPlayer(highestPlayer[p]).setTurn(p+1);
		}
	}
	
	private void createCards()
	{
//		int i=0;
//		i=0;
//		for(Card c : cards)
//		{
//			System.out.println(i+": "+c.getCardName() + ", " + c.getCardType());
//			i++;
//		}
//		System.out.println();
		randomSuspect();
//		i=0;
//		for(Card c : cards)
//		{
//			System.out.println(i+": "+c.getCardName() + ", " + c.getCardType());
//			i++;
//		}
//		System.out.println();
		randomWeapon();
//		i=0;
//		for(Card c : cards)
//		{
//			System.out.println(i+": "+c.getCardName() + ", " + c.getCardType());
//			i++;
//		}
//		System.out.println();
		randomRoom();
//		i=0;
//		for(Card c : cards)
//		{
//			System.out.println(i+": "+c.getCardName() + ", " + c.getCardType());
//			i++;
//		}
//		System.out.println();
		cards.shuffleCards();
	}
	
	private void assignCards()
	{
		Card temp1 = new Card(null, null);
		Card temp2 = new Card(null, null);
		Card temp3 = new Card(null, null);
		int ifStatement =0;
		if(18 % TOTAL_PLAYERS == 2)
		{
			temp1 = cards.cards.remove(0);
			temp2 = cards.cards.remove(0);
			temp1.setPlayer("A");
			temp2.setPlayer("A");
			ifStatement = 2;
		}
		else if(18 % TOTAL_PLAYERS == 3)
		{
			temp1 = cards.cards.remove(0);
			temp2 = cards.cards.remove(0);
			temp3 = cards.cards.remove(0);
			temp1.setPlayer("A");
			temp2.setPlayer("A");
			temp3.setPlayer("A");
			ifStatement = 3;
		}
		int i=0;
		for(Card card : cards)
		{
			card.setPlayer(players.get(i).getName());
			i++;
			if(i==TOTAL_PLAYERS) i=0;
		}
		
		if(ifStatement == 2 || ifStatement ==3)
		{
			cards.cards.add(temp1);
			cards.cards.add(temp2);
		}
		if(ifStatement == 3)
		{
			cards.cards.add(temp3);
		}
		
//		i=0;
//		for(Card card : cards)
//		{
//			System.out.println(i+": "+card.getCardName()+" : "+card.getPlayer());
//			i++;
//		}
		
		//temp Card variables take out all cards, divide rest and add back?
	}
	
	private void makeNotes()
	{
		Player player;
		for(int i=1; i<=TOTAL_PLAYERS; i++)
		{
			player = players.getPlayerTurn(i);
//			try
//			{
				for(Card card : cards)
				{
					if(card.getPlayer().equals(player.getName()))
					{

						if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[0]))
						{// Computer Science
							player.notes.setNoteComputerScience("X");
						}
						else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[1]))
						{// O'Reilly Hall
							player.notes.setNoteOReillyHall("X");
						}
						else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[2]))
						{// Engineering
							player.notes.setNoteEngineering("X");
						}
						else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[3]))
						{// Sutherland
							player.notes.setNoteSutherland("X");
						}
						else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[4]))
						{// Quinn
							player.notes.setNoteQuinn("X");
						}
						else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[5]))
						{// Newman
							player.notes.setNoteNewman("X");
						}
						else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[6]))
						{// Library
							player.notes.setNoteLibrary("X");
						}
						else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[7]))
						{// Ag Science
							player.notes.setNoteAgScience("X");
						}
						else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[8]))
						{// O'Brien
							player.notes.setNoteOBrien("X");
						}
						else if(card.getCardName().equalsIgnoreCase(Names.SUSPECT_NAMES[0]))
						{// Bleakley Plum

						}
						else if(card.getCardName().equalsIgnoreCase(Names.SUSPECT_NAMES[1]))
						{// Kelly White

						}
						else if(card.getCardName().equalsIgnoreCase(Names.SUSPECT_NAMES[2]))
						{// Caka Scarlett

						}
						else if(card.getCardName().equalsIgnoreCase(Names.SUSPECT_NAMES[3]))
						{// Sweeney Green

						}
						else if(card.getCardName().equalsIgnoreCase(Names.SUSPECT_NAMES[4]))
						{// Kalra Mustard

						}
						else if(card.getCardName().equalsIgnoreCase(Names.SUSPECT_NAMES[5]))
						{// Delorey Peacock

						}
						else if(card.getCardName().equalsIgnoreCase(Names.WEAPON_NAMES[0]))
						{// Book

						}
						else if(card.getCardName().equalsIgnoreCase(Names.WEAPON_NAMES[1]))
						{// Bored

						}
						else if(card.getCardName().equalsIgnoreCase(Names.WEAPON_NAMES[2]))
						{// Gradcap

						}
						else if(card.getCardName().equalsIgnoreCase(Names.WEAPON_NAMES[3]))
						{// Librocop

						}
						else if(card.getCardName().equalsIgnoreCase(Names.WEAPON_NAMES[4]))
						{// Microscope

						}
						else if(card.getCardName().equalsIgnoreCase(Names.WEAPON_NAMES[5]))
						{// Seagull

						}
					}
				}
//			}catch(NullPointerException e)
//			{
//				//do nothing
//			}
		}
		
		for(Card card : cards)
		{
			for(int i=1; i<=TOTAL_PLAYERS; i++)
			{
				player = players.getPlayerTurn(i);
				
				if(card.getPlayer().equals("A"))
				{
					if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[0]))
					{// Computer Science
						player.notes.setNoteComputerScience("A");
					}
					else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[1]))
					{// O'Reilly Hall
						player.notes.setNoteOReillyHall("A");
					}
					else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[2]))
					{// Engineering
						player.notes.setNoteEngineering("A");
					}
					else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[3]))
					{// Sutherland
						player.notes.setNoteSutherland("A");
					}
					else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[4]))
					{// Quinn
						player.notes.setNoteQuinn("A");
					}
					else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[5]))
					{// Newman
						player.notes.setNoteNewman("A");
					}
					else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[6]))
					{// Library
						player.notes.setNoteLibrary("A");
					}
					else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[7]))
					{// Ag Science
						player.notes.setNoteAgScience("A");
					}
					else if(card.getCardName().equalsIgnoreCase(Names.ROOM_NAMES[8]))
					{// O'Brien
						player.notes.setNoteOBrien("A");
					}
					else if(card.getCardName().equalsIgnoreCase(Names.SUSPECT_NAMES[0]))
					{// Bleakley Plum

					}
					else if(card.getCardName().equalsIgnoreCase(Names.SUSPECT_NAMES[1]))
					{// Kelly White

					}
					else if(card.getCardName().equalsIgnoreCase(Names.SUSPECT_NAMES[2]))
					{// Caka Scarlett

					}
					else if(card.getCardName().equalsIgnoreCase(Names.SUSPECT_NAMES[3]))
					{// Sweeney Green

					}
					else if(card.getCardName().equalsIgnoreCase(Names.SUSPECT_NAMES[4]))
					{// Kalra Mustard

					}
					else if(card.getCardName().equalsIgnoreCase(Names.SUSPECT_NAMES[5]))
					{// Delorey Peacock

					}
					else if(card.getCardName().equalsIgnoreCase(Names.WEAPON_NAMES[0]))
					{// Book

					}
					else if(card.getCardName().equalsIgnoreCase(Names.WEAPON_NAMES[1]))
					{// Bored

					}
					else if(card.getCardName().equalsIgnoreCase(Names.WEAPON_NAMES[2]))
					{// Gradcap

					}
					else if(card.getCardName().equalsIgnoreCase(Names.WEAPON_NAMES[3]))
					{// Librocop

					}
					else if(card.getCardName().equalsIgnoreCase(Names.WEAPON_NAMES[4]))
					{// Microscope

					}
					else if(card.getCardName().equalsIgnoreCase(Names.WEAPON_NAMES[5]))
					{// Seagull

					}
				}
			}
		}
	}
		
	
	private void inputPlayerNames() {
		int numPlayersSoFar = 0;
		do {
			ui.inputName(players);
			if (!ui.inputIsDone()) {
				ui.inputToken(tokens);
				Token token = tokens.get(ui.getTokenName());
				players.add(new Player(ui.getPlayerName(),token));
				token.setOwned();
				numPlayersSoFar++;
			}
		} while (!ui.inputIsDone() && numPlayersSoFar<MAX_NUM_PLAYERS);
		ui.refreshInfoPanel();
		TOTAL_PLAYERS = numPlayersSoFar;
	}

	private void takeTurns() {
		boolean moveOver, turnOver, gameOver = false;
		int i = 1; //loops players
		do {
			turnOver = false;
			moveOver = false;
			
			do {
				Player currentPlayer = players.getPlayerTurn(i); 
				try {
				Token currentToken = currentPlayer.getToken();						
						ui.inputCommand(currentPlayer);
						switch (ui.getCommand()) {
						case "roll": {
							if (!moveOver) {
								dice.roll();
								ui.displayDice(currentPlayer, dice);
								int squaresMoved = 0;
								if (currentToken.isInRoom()) {
									if (currentToken.getRoom().getNumberOfDoors()>1) {
										boolean exitDone = false;
										do {
											ui.inputDoor(currentPlayer);
											if (ui.getDoor()>= 1 || ui.getDoor()<=currentToken.getRoom().getNumberOfDoors()) {
												currentToken.leaveRoom(ui.getDoor()-1);
												exitDone = true;
											} else {
												ui.displayErrorNotADoor();
											}
										} while (!exitDone);
									} else {
										currentToken.leaveRoom();
									}
									ui.display();
								}
								do {
									ui.inputMove(currentPlayer, squaresMoved+1, dice.getTotal());
									Coordinates currentPosition = currentToken.getPosition();
									Coordinates newPosition;
									if (map.isValidMove(currentPosition, ui.getMove())) {
										newPosition = map.getNewPosition(currentPosition, ui.getMove());
										if (map.isDoor(currentPosition, newPosition)) {
											Room room = map.getRoom(newPosition);
											currentToken.enterRoom(room);
										} else {
											currentToken.setPosition(newPosition);
										}
										squaresMoved++;
										if (squaresMoved==dice.getTotal() || currentPlayer.getToken().isInRoom()) {
											moveOver = true;
										}
										ui.display();
									} else {
										ui.displayErrorInvalidMove();
									}
								} while (!moveOver);
							} else {
								ui.displayErrorAlreadyMoved();
							}
							break;
						}
						case "passage": {
							if (!moveOver) {
								if (currentToken.isInRoom() && currentToken.getRoom().hasPassage()) {
									Room destination = currentToken.getRoom().getPassageDestination();
									currentToken.leaveRoom();
									currentToken.enterRoom(destination);
									moveOver = true;
									ui.display();
								} else {
									ui.displayErrorNoPassage();
								}
							} else {
								ui.displayErrorAlreadyMoved();
							}
							break;
						}
						case "done": {
							turnOver = true;
							ui.refreshInfoPanel();
							break;
						}
						case "quit": {
							turnOver = true;
							gameOver = true;
							break;
						}
						case "help": {
							//if in corridor - roll, cheat, done, exit, notes
							if(!currentToken.isInRoom())
							{
								ui.displayString("Possible inputs:\n'roll' - rolls dice to move"
										+ "\n'cheat' - views cards in murder envelope\n'done' - ends turn"
										+ "\n'quit' - ends game\n'notes' - view notes");
							}
							//if entered room - done, exit, notes, (accuse)
							else if(currentToken.isInRoom() && moveOver == true)
							{
								ui.displayString("Possible inputs:\n'cheat' - views cards in murder envelope"
										+ "\n'done' - ends turn\n'quit' - ends game\n'notes' - view notes");
								//TODO add accusations
							}
							//if start turn room - notes, roll, done, exit, (passage)
							else if(currentToken.isInRoom() && moveOver == false)
							{
								ui.displayString("Possible inputs:\n'roll' - rolls dice to move"
										+ "\n'cheat' - views cards in murder envelope\n'done' - ends turn"
										+ "\n'quit' - ends game\n'notes' - view notes");
								if(currentToken.getRoom().hasPassage())
								{
									ui.displayString("'passage' - move through secret passage");
								}
							}
							break;
						}
						case "cheat": {
							ui.displayString(murder.murderToken.getCardName());
							ui.displayString(murder.murderRoom.getCardName());
							ui.displayString(murder.murderWeapon.getCardName());
							break;
						}
						case "notes": {
							ui.notes(currentPlayer);
							break;
						}
						case "accusation": {
							//TODO for next sprint
						}
						}
					
				}catch (NullPointerException e) {
					//Nothing to do!
				}
					
			} while (!turnOver);
			i++;
			if(i>TOTAL_PLAYERS) i=1;
		} while (!gameOver);
	}

	public static void main(String[] args) {
		Cluedo game = new Cluedo();
		game.createCards();
		game.inputPlayerNames();
		game.playerOrder();
		game.assignCards();
		game.makeNotes();
		game.takeTurns();
		System.exit(0);
	}
}
