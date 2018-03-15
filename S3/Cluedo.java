package S3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Cluedo {

	private static final int MAX_NUM_PLAYERS = 6;
	private int TOTAL_PLAYERS;

	private final Notes notes = new Notes();
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
		for(Card card : cards)
		{
			if(i==number) murder.murderToken = card;
			
			i++;
		}
		System.out.println(murder.murderToken.getCardName());
				cards.cards.remove(number);
	}
	public void randomWeapon()
	{
		int number;
		Random rand = new Random();
		number = rand.nextInt(6) + 15;
		
		int i=0;
		for(Card card : cards)
		{
			if(i==number) murder.murderWeapon = card;
			
			i++;
		}
		System.out.println(murder.murderWeapon.getCardName());
		cards.cards.remove(number);
	}
	public void randomRoom()
	{
		int number;
		Random rand = new Random();
		number = rand.nextInt(9) + 6;
		
		int i=0;
		for(Card card : cards)
		{
			if(i==number) murder.murderRoom = card;
			
			i++;
		}
		cards.cards.remove(number);
System.out.println(murder.murderRoom.getCardName());
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
			if(dice.getTotal() > highestRoll)
			{
				highestPlayer[i] = player.getName();
				highestRoll = dice.getTotal();
			}
			else if(dice.getTotal() == highestRoll)
			{
				i++;
				highestPlayer[i] = player.getName();
			}
		}
		while(highestPlayer[1] != null)
		{
			highestRoll = 0;
			String[] highestPlayerRnd2 = new String[TOTAL_PLAYERS];
			i = 0;
			int j = 0;
			try {
			
				while(highestPlayer[i] != null && i<TOTAL_PLAYERS)
				{
					dice.roll();
					ui.displayDice(players.getPlayer(highestPlayer[i]), dice);
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
		int i=0;
		i=0;
		for(Card c : cards)
		{
			System.out.println(i+": "+c.getCardName() + ", " + c.getCardType());
			i++;
		}
		randomSuspect();
		randomWeapon();
		randomRoom();
		i=0;
		for(Card c : cards)
		{
			System.out.println(i+": "+c.getCardName() + ", " + c.getCardType());
			i++;
		}
		System.out.println();
		cards.shuffleCards();
	}
		
	private void inputPlayerNames() {
		int numPlayersSoFar = 0;
		do {
			ui.inputName(players);
			if (!ui.inputIsDone()) {
				ui.inputToken(tokens);
				Token token = tokens.get(ui.getTokenName());
				players.add(new Player(ui.getPlayerName(),token, notes));
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
							
						}
						case "cheat": {
							
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
		game.takeTurns();
		System.exit(0);
	}
}
