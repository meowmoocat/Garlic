package bots;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

import com.sun.javafx.scene.paint.GradientUtils.Point;


import gameengine.*;

public class Garlic implements BotAPI {


	private HashMap<String, Integer> RoomValues = new HashMap<>();


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
	private Token token;
	//	private Graph graph = new GraphImpl();
	private Boolean note = false;

	public Garlic (Player player, PlayersInfo playersInfo, Map map, Dice dice, Log log, Deck deck) {
		this.player = player;
		this.playersInfo = playersInfo;
		this.map = map;
		this.dice = dice;
		this.log = log;
		this.deck = deck;
		moveOver = false;
		this.token = player.getToken();

		RoomValues.put("Kitchen", 0);
		RoomValues.put("Ballroom", 0);
		RoomValues.put("Conservatory", 0);
		RoomValues.put("Billiard Room", 0);
		RoomValues.put("Library", 0);
		RoomValues.put("Study", 0);
		RoomValues.put("Hall", 0);
		RoomValues.put("Lounge", 0);
		RoomValues.put("Dining Room", 0);
		RoomValues.put("Cellar", 0);

	}

	private void changeNum()
	{
		for(int i=0; i<Names.ROOM_CARD_NAMES.length; i++)
		{
			if(!player.hasCard(Names.ROOM_CARD_NAMES[i]))
			{
				if(RoomValues.containsKey(Names.ROOM_NAMES[i]))
				{
					RoomValues.get(Names.ROOM_CARD_NAMES[i]);
					RoomValues.put(Names.ROOM_CARD_NAMES[i], 1);
				}
			}
		}
	}
	
//	private void visit(String []map, Point start)
//	{
//		int []x = {0,0,1,-1};
//		int []y = {1,-1,0,0};
//		
//		LinkedList<Point> q = new LinkedList();
//		q.add(start);
//		int n = map.length;
//		int m = map[0].length();
//		int[][]dist = new int[n][m];
//		
//		for(int []a : dist)
//		{
//			Arrays.fill(a, -1);
//		}
//		
//		dist[start.x][start.y] = 0;
//		while(!q.isEmpty())
//		{
//			Point p = q.removefirst();
//			for(int i=0;i<4; i++)
//			{
//				int a = p.x + x[i];
//				int b = p.y + y[i];
//				if(a>)
//			}
//		}
//	}

	public String getName() {
		return "Garlic"; // must match the class name
	}

	public String getCommand() {
		//if token is in corridor roll
		if(!note)
		{
			note = true;
			return "notes";
		}
		if(map.isCorridor(player.getToken().getPosition()) && !moveOver)
		{
			return "roll";
		}
		if(player.getToken().isInRoom())
		{
			if(!moveOver)
			{
				if((map.getRoom(player.getToken().getPosition()).toString())!=Names.ROOM_NAMES[9]) {//needs to not work if already asked question
					return "question";
				}
				if((map.getRoom(player.getToken().getPosition()).toString())==Names.ROOM_NAMES[9]) {//needs to not work if already accused
					return "accuse";
				}
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
		changeNum();
		for(int i=0; i<Names.ROOM_NAMES.length;i++)
		{
			System.out.println(Names.ROOM_NAMES[i]+" "+RoomValues.get(Names.ROOM_NAMES[i]));
		}
		System.out.println("\n");
		moveOver = true;
		if(player.getToken().getName().equalsIgnoreCase("scarlett")) return "u";
		if(player.getToken().getName().equalsIgnoreCase("white") || player.getToken().getName().equalsIgnoreCase("green")) return "d";
		if(player.getToken().getName().equalsIgnoreCase("mustard")) return "r";
		return "l";
	}

	public String getSuspect() {
		// Add your code here
		//TODO: check case
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
