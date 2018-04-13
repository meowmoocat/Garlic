package bots;

import gameengine.*;

public class Garlic implements BotAPI {

	// The public API of Bot must not change
	// This is ONLY class that you can edit in the program
	// Rename Bot to the name of your team. Use camel case.
	// Bot may not alter the state of the board or the player objects
	// It may only inspect the state of the board and the player objects

	private Player player;
	private PlayersInfo playersInfo;
	private Map map;
	private Dice dice;
	private Log log;
	private Deck deck;
	private Boolean moveOver;

	public Garlic (Player player, PlayersInfo playersInfo, Map map, Dice dice, Log log, Deck deck) {
		this.player = player;
		this.playersInfo = playersInfo;
		this.map = map;
		this.dice = dice;
		this.log = log;
		this.deck = deck;
		moveOver = false;
	}

	public String getName() {
		return "Garlic"; // must match the class name
	}

	public String getCommand() {
		//if token is in corridor roll
		if(map.isCorridor(player.getToken().getPosition()) && !moveOver)
		{
			return "roll";
		}
		if(player.getToken().isInRoom())
		{
			if(!moveOver)
			{
				
			}
			//if entered room question
			//if in middle accuse
			//if start turn & in room -> roll || passage
		}
		//if turn over done
		else
		{
			moveOver = false;
			return "done";
		}
		return "notes";
	}

	public String getMove() {
		// Add your code here
		moveOver = true;
		if(player.getToken().getName().equalsIgnoreCase("scarlett")) return "u";
		if(player.getToken().getName().equalsIgnoreCase("white") || player.getToken().getName().equalsIgnoreCase("green")) return "d";
		if(player.getToken().getName().equalsIgnoreCase("mustard")) return "r";
		return "l";
	}

	public String getSuspect() {
		// Add your code here
		return Names.SUSPECT_NAMES[0];
	}

	public String getWeapon() {
		// Add your code here
		return Names.WEAPON_NAMES[0];
	}

	public String getRoom() {
		// Add your code here
		return Names.ROOM_NAMES[0];
	}

	public String getDoor() {
		// Add your code here
		return "1";
	}

	public String getCard(Cards matchingCards) {
		// Add your code here
		return matchingCards.get().toString();
	}

	public void notifyResponse(Log response) {
		// Add your code here
	}

}
