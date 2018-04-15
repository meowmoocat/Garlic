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
		if(!player.hasCard("plum") && !player.hasSeen("plum")) {
			return "plum";
		}
		if(!player.hasCard("white") && !player.hasSeen("white")) {
			return "white";
		}
		if(!player.hasCard("scarlett") && !player.hasSeen("scarlett")) {
			return "scarlett";
		}
		if(!player.hasCard("green") && !player.hasSeen("green")) {
			return "green";
		}
		if(!player.hasCard("mustard") && !player.hasSeen("mustard")) {
			return "plum";
		}
		if(!player.hasCard("peacock") && !player.hasSeen("peacock")) {
			return "peacock";
		}
		return Names.SUSPECT_NAMES[0];
	}

	public String getWeapon() {
		// Add your code here
		
		if(!player.hasCard("rope") && !player.hasSeen("rope")) {
			return "rope";
		}
		if(!player.hasCard("dagger") && !player.hasSeen("dagger")) {
			return "dagger";
		}
		if(!player.hasCard("wrench") && !player.hasSeen("wrench")) {
			return "wrench";
		}
		if(!player.hasCard("pistol") && !player.hasSeen("pistol")) {
			return "pistol";
		}
		if(!player.hasCard("candelstick") && !player.hasSeen("candelstick")) {
			return "candelstick";
		}
		if(!player.hasCard("lead pipe") && !player.hasSeen("lead pipe")) {
			return "lead pipe";
		}
		
		return Names.WEAPON_NAMES[0];
	}

	public String getRoom() {
		// Add your code here
		
		if(!player.hasCard("kitchen") && !player.hasSeen("kitchen")) {
			return "kitchen";
		}
		if(!player.hasCard("ballroom") && !player.hasSeen("ballroom")) {
			return "ballroom";
		}
		if(!player.hasCard("conservatory") && !player.hasSeen("conservatory")) {
			return "conservatory";
		}
		if(!player.hasCard("billiard room") && !player.hasSeen("billiard room")) {
			return "billiard room";
		}
		if(!player.hasCard("library") && !player.hasSeen("library")) {
			return "library";
		}
		if(!player.hasCard("study") && !player.hasSeen("study")) {
			return "study";
		}
		if(!player.hasCard("hall") && !player.hasSeen("hall")) {
			return "hall";
		}
		if(!player.hasCard("lounge") && !player.hasSeen("lounge")) {
			return "lounge";
		}
		if(!player.hasCard("dining room") && !player.hasSeen("dining room")) {
			return "dining room";
		}
		if(!player.hasCard("cellar") && !player.hasSeen("cellar")) {
			return "cellar";
		}
		
		return Names.ROOM_NAMES[0];
	}

	public String getDoor() {
		// Add your code here
		return "1";
	}

	public String getCard(Cards matchingCards) {
		// Add your code here
		
		if(player.hasCard("plum") && matchingCards.contains("plum")) {
			return "plum";
		}
		if(player.hasCard("white") && matchingCards.contains("white")) {
			return "white";
		}
		if(player.hasCard("scarlett") && matchingCards.contains("scarlett")) {
			return "scarlett";
		}
		if(player.hasCard("green") && matchingCards.contains("green")) {
			return "green";
		}
		if(player.hasCard("mustard") && matchingCards.contains("mustard")) {
			return "plum";
		}
		if(player.hasCard("peacock") && matchingCards.contains("peacock")) {
			return "peacock";
		}
		
		if(player.hasCard("rope") && matchingCards.contains("rope")) {
			return "rope";
		}
		if(player.hasCard("dagger") && matchingCards.contains("dagger")) {
			return "dagger";
		}
		if(player.hasCard("wrench") && matchingCards.contains("wrench")) {
			return "wrench";
		}
		if(player.hasCard("pistol") && matchingCards.contains("pistol")) {
			return "pistol";
		}
		if(player.hasCard("candelstick") && matchingCards.contains("candelstick")) {
			return "candelstick";
		}
		if(player.hasCard("lead pipe") && matchingCards.contains("lead pipe")) {
			return "lead pipe";
		}
		
		if(player.hasCard("kitchen") && matchingCards.contains("kitchen")) {
			return "kitchen";
		}
		if(player.hasCard("ballroom") && matchingCards.contains("ballroom")) {
			return "ballroom";
		}
		if(player.hasCard("conservatory") && matchingCards.contains("conservatory")) {
			return "conservatory";
		}
		if(player.hasCard("billiard room") && matchingCards.contains("billiard room")) {
			return "billiard room";
		}
		if(player.hasCard("library") && matchingCards.contains("library")) {
			return "library";
		}
		if(player.hasCard("study") && matchingCards.contains("study")) {
			return "study";
		}
		if(player.hasCard("hall") && matchingCards.contains("hall")) {
			return "hall";
		}
		if(player.hasCard("lounge") && matchingCards.contains("lounge")) {
			return "lounge";
		}
		if(player.hasCard("dining room") && matchingCards.contains("dining room")) {
			return "dining room";
		}
		if(player.hasCard("cellar") && matchingCards.contains("cellar")) {
			return "cellar";
		}
		
		return matchingCards.get().toString();
	}

	public void notifyResponse(Log response) {
		// Add your code here
	}

}
