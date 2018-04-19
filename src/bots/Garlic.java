package bots;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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
	private Boolean questionAsked;
	private Token token;
	private Queue<String> q = new LinkedList<String>();

	public Garlic (Player player, PlayersInfo playersInfo, Map map, Dice dice, Log log, Deck deck) {
		this.player = player;
		this.playersInfo = playersInfo;
		this.map = map;
		this.dice = dice;
		this.log = log;
		this.deck = deck;
		moveOver = false;
		questionAsked = false;
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

	public String getName() {
		return "Garlic"; // must match the class name
	}

	public String getCommand() {
		//if token is in corridor roll

		if(questionAsked) System.out.println("asked true");
		else System.out.println("asked false");

		if(map.isCorridor(player.getToken().getPosition()) && !moveOver)
		{
			return "roll";
		}
		if(player.getToken().isInRoom() && !questionAsked)
		{
			System.out.println("fuck");
			if(moveOver)
			{
				for(int i=0; i<Names.ROOM_NAMES.length; i++)
				{
					if(token.getRoom().hasName(Names.ROOM_CARD_NAMES[i])) {//needs to not work if already asked question
						System.out.println("here? "+Names.ROOM_CARD_NAMES[i]);
						questionAsked = true;
						return "question";
					}
					else if(token.getRoom().hasName(Names.ROOM_NAMES[9])) {
						return "accuse";
					}
				}
			}
			//if entered room question
			//if in middle accuse
			//if start turn & in room -> roll || passage
		}
		//if turn over done
		else
		{
			questionAsked = true;
			moveOver = false;
			return "done";
		}
		return "notes";
	}

	public String getMove() {
		/*changeNum();
		for(int i=0; i<Names.ROOM_NAMES.length;i++)
		{
			System.out.println(Names.ROOM_NAMES[i]+" "+RoomValues.get(Names.ROOM_NAMES[i]));
		}
		System.out.println("\n");
		moveOver = true;
		if(player.getToken().getName().equalsIgnoreCase("scarlett")) return "u";
		if(player.getToken().getName().equalsIgnoreCase("white") || player.getToken().getName().equalsIgnoreCase("green")) return "d";
		if(player.getToken().getName().equalsIgnoreCase("mustard")) return "r";*/

		//white start
		if(player.getToken().getPosition().getRow()==0 && player.getToken().getPosition().getCol()==9 && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 8 ; i++) {
				if(i==0) j="d";
				if(i==1) j="l";
				if(i==2) j="l";
				if(i==3) j="d";
				if(i==4) j="d";
				if(i==5) j="d";
				if(i==6) j="d";
				if(i==7) j="r";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==0 && player.getToken().getPosition().getCol()==9 && !player.hasCard("kitchen") && !player.hasSeen("kitchen")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 13 ; i++) {
				if(i==0) j="d";
				if(i==1) j="l";
				if(i==2) j="l";
				if(i==3) j="d";
				if(i==4) j="d";
				if(i==5) j="d";
				if(i==6) j="d";
				if(i==7) j="d";
				if(i==8) j="d";
				if(i==9) j="l";
				if(i==10) j="l";
				if(i==11) j="l";
				if(i==12) j="u";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==0 && player.getToken().getPosition().getCol()==9 && !player.hasCard("dining room") && !player.hasSeen("dining room")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 16 ; i++) {
				if(i==0) j="d";
				if(i==1) j="l";
				if(i==2) j="l";
				if(i==3) j="d";
				if(i==4) j="d";
				if(i==5) j="d";
				if(i==6) j="d";
				if(i==7) j="d";
				if(i==8) j="d";
				if(i==9) j="d";
				if(i==10) j="d";
				if(i==11) j="r";
				if(i==12) j="d";
				if(i==13) j="d";
				if(i==14) j="d";
				if(i==15) j="l";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==0 && player.getToken().getPosition().getCol()==9 && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 22 ; i++) {
				if(i==0) j="d";
				if(i==1) j="l";
				if(i==2) j="l";
				if(i==3) j="d";
				if(i==4) j="d";
				if(i==5) j="d";
				if(i==6) j="d";
				if(i==7) j="d";
				if(i==8) j="d";
				if(i==9) j="d";
				if(i==10) j="d";
				if(i==11) j="r";
				if(i==12) j="r";
				if(i==13) j="r";
				if(i==14) j="r";
				if(i==15) j="r";
				if(i==16) j="r";
				if(i==17) j="r";
				if(i==18) j="r";
				if(i==19) j="r";
				if(i==20) j="r";
				if(i==21) j="r";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==0 && player.getToken().getPosition().getCol()==9 && !player.hasCard("lounge") && !player.hasSeen("lounge")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 24 ; i++) {
				if(i==0) j="d";
				if(i==1) j="l";
				if(i==2) j="l";
				if(i==3) j="d";
				if(i==4) j="d";
				if(i==5) j="d";
				if(i==6) j="d";
				if(i==7) j="d";
				if(i==8) j="d";
				if(i==9) j="d";
				if(i==10) j="d";
				if(i==11) j="r";
				if(i==12) j="d";
				if(i==13) j="d";
				if(i==14) j="d";
				if(i==15) j="d";
				if(i==16) j="d";
				if(i==17) j="d";
				if(i==18) j="d";
				if(i==19) j="d";
				if(i==20) j="d";
				if(i==21) j="l";
				if(i==22) j="l";
				if(i==23) j="d";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==0 && player.getToken().getPosition().getCol()==14 && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {
			//green start
			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 8 ; i++) {
				if(i==0) j="d";
				if(i==1) j="r";
				if(i==2) j="r";
				if(i==3) j="d";
				if(i==4) j="d";
				if(i==5) j="d";
				if(i==6) j="d";
				if(i==7) j="l";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==0 && player.getToken().getPosition().getCol()==14 && !player.hasCard("conservatory") && !player.hasSeen("conservatory")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 10 ; i++) {
				if(i==0) j="d";
				if(i==1) j="r";
				if(i==2) j="r";
				if(i==3) j="d";
				if(i==4) j="d";
				if(i==5) j="d";
				if(i==6) j="d";
				if(i==7) j="r";
				if(i==8) j="r";
				if(i==9) j="u";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==0 && player.getToken().getPosition().getCol()==14 && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 13 ; i++) {
				if(i==0) j="d";
				if(i==1) j="r";
				if(i==2) j="r";
				if(i==3) j="d";
				if(i==4) j="d";
				if(i==5) j="d";
				if(i==6) j="d";
				if(i==7) j="d";
				if(i==8) j="d";
				if(i==9) j="d";
				if(i==10) j="d";
				if(i==11) j="r";
				if(i==12) j="r";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==0 && player.getToken().getPosition().getCol()==14 && !player.hasCard("library") && !player.hasSeen("library")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 19 ; i++) {
				if(i==0) j="d";
				if(i==1) j="r";
				if(i==2) j="r";
				if(i==3) j="d";
				if(i==4) j="d";
				if(i==5) j="d";
				if(i==6) j="d";
				if(i==7) j="d";
				if(i==8) j="d";
				if(i==9) j="d";
				if(i==10) j="d";
				if(i==11) j="d";
				if(i==12) j="d";
				if(i==13) j="d";
				if(i==14) j="d";
				if(i==15) j="d";
				if(i==16) j="d";
				if(i==17) j="d";
				if(i==18) j="r";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==0 && player.getToken().getPosition().getCol()==14 && !player.hasCard("dining room") && !player.hasSeen("dining room")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 23 ; i++) {
				if(i==0) j="d";
				if(i==1) j="r";
				if(i==2) j="r";
				if(i==3) j="d";
				if(i==4) j="d";
				if(i==5) j="d";
				if(i==6) j="d";
				if(i==7) j="d";
				if(i==8) j="d";
				if(i==9) j="d";
				if(i==10) j="l";
				if(i==11) j="l";
				if(i==12) j="l";
				if(i==13) j="l";
				if(i==14) j="l";
				if(i==15) j="l";
				if(i==16) j="l";
				if(i==17) j="l";
				if(i==18) j="d";
				if(i==19) j="d";
				if(i==20) j="d";
				if(i==21) j="d";
				if(i==22) j="l";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==6 && player.getToken().getPosition().getCol()==23 && !player.hasCard("conservatory") && !player.hasSeen("conservatory")) {
			//peacock start
			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 7 ; i++) {
				if(i==0) j="l";
				if(i==1) j="l";
				if(i==2) j="l";
				if(i==3) j="l";
				if(i==4) j="l";
				if(i==5) j="u";
				if(i==6) j="u";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==6 && player.getToken().getPosition().getCol()==23 && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 9 ; i++) {
				if(i==0) j="l";
				if(i==1) j="l";
				if(i==2) j="l";
				if(i==3) j="l";
				if(i==4) j="l";
				if(i==5) j="l";
				if(i==6) j="l";
				if(i==7) j="u";
				if(i==8) j="l";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==6 && player.getToken().getPosition().getCol()==23 && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 10 ; i++) {
				if(i==0) j="l";
				if(i==1) j="l";
				if(i==2) j="l";
				if(i==3) j="l";
				if(i==4) j="l";
				if(i==5) j="l";
				if(i==6) j="d";
				if(i==7) j="d";
				if(i==8) j="d";
				if(i==9) j="r";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==6 && player.getToken().getPosition().getCol()==23 && !player.hasCard("library") && !player.hasSeen("library")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 18 ; i++) {
				if(i==0) j="l";
				if(i==1) j="l";
				if(i==2) j="l";
				if(i==3) j="l";
				if(i==4) j="l";
				if(i==5) j="l";
				if(i==6) j="l";
				if(i==7) j="d";
				if(i==8) j="d";
				if(i==9) j="d";
				if(i==10) j="d";
				if(i==11) j="d";
				if(i==12) j="d";
				if(i==13) j="d";
				if(i==14) j="d";
				if(i==15) j="d";
				if(i==16) j="d";
				if(i==17) j="r";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==6 && player.getToken().getPosition().getCol()==23 && !player.hasCard("study") && !player.hasSeen("study")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 23 ; i++) {
				if(i==0) j="l";
				if(i==1) j="l";
				if(i==2) j="l";
				if(i==3) j="l";
				if(i==4) j="l";
				if(i==5) j="l";
				if(i==6) j="l";
				if(i==7) j="d";
				if(i==8) j="d";
				if(i==9) j="d";
				if(i==10) j="d";
				if(i==11) j="d";
				if(i==12) j="d";
				if(i==13) j="d";
				if(i==14) j="d";
				if(i==15) j="d";
				if(i==16) j="d";
				if(i==17) j="d";
				if(i==18) j="d";
				if(i==19) j="d";
				if(i==20) j="d";
				if(i==21) j="r";
				if(i==22) j="d";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==19 && player.getToken().getPosition().getCol()==23 && !player.hasCard("study") && !player.hasSeen("study")) {
			//plum start
			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 8 ; i++) {
				if(i==0) j="l";
				if(i==1) j="l";
				if(i==2) j="l";
				if(i==3) j="l";
				if(i==4) j="l";
				if(i==5) j="l";
				if(i==6) j="d";
				if(i==7) j="d";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==19 && player.getToken().getPosition().getCol()==23 && !player.hasCard("hall") && !player.hasSeen("hall")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 10 ; i++) {
				if(i==0) j="l";
				if(i==1) j="l";
				if(i==2) j="l";
				if(i==3) j="l";
				if(i==4) j="l";
				if(i==5) j="l";
				if(i==6) j="l";
				if(i==7) j="l";
				if(i==8) j="d";
				if(i==9) j="l";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==19 && player.getToken().getPosition().getCol()==23 && !player.hasCard("library") && !player.hasSeen("library")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 11 ; i++) {
				if(i==0) j="l";
				if(i==1) j="l";
				if(i==2) j="l";
				if(i==3) j="l";
				if(i==4) j="l";
				if(i==5) j="l";
				if(i==6) j="l";
				if(i==7) j="u";
				if(i==8) j="u";
				if(i==9) j="u";
				if(i==10) j="r";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==19 && player.getToken().getPosition().getCol()==23 && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 19 ; i++) {
				if(i==0) j="l";
				if(i==1) j="l";
				if(i==2) j="l";
				if(i==3) j="l";
				if(i==4) j="l";
				if(i==5) j="l";
				if(i==6) j="l";
				if(i==7) j="u";
				if(i==8) j="u";
				if(i==9) j="u";
				if(i==10) j="u";
				if(i==11) j="u";
				if(i==12) j="u";
				if(i==13) j="u";
				if(i==14) j="u";
				if(i==15) j="u";
				if(i==16) j="u";
				if(i==17) j="r";
				if(i==18) j="r";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==19 && player.getToken().getPosition().getCol()==23 && !player.hasCard("lounge") && !player.hasSeen("lounge")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 21 ; i++) {
				if(i==0) j="l";
				if(i==1) j="l";
				if(i==2) j="l";
				if(i==3) j="l";
				if(i==4) j="l";
				if(i==5) j="l";
				if(i==6) j="l";
				if(i==7) j="l";
				if(i==8) j="u";
				if(i==9) j="u";
				if(i==10) j="l";
				if(i==11) j="l";
				if(i==12) j="l";
				if(i==13) j="l";
				if(i==14) j="l";
				if(i==15) j="l";
				if(i==16) j="l";
				if(i==17) j="l";
				if(i==18) j="l";
				if(i==19) j="d";
				if(i==20) j="d";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==24 && player.getToken().getPosition().getCol()==7 && !player.hasCard("lounge") && !player.hasSeen("lounge")) {
			//scarlett start
			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 8 ; i++) {
				if(i==0) j="u";
				if(i==1) j="u";
				if(i==2) j="u";
				if(i==3) j="u";
				if(i==4) j="u";
				if(i==5) j="u";
				if(i==6) j="l";
				if(i==7) j="d";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==24 && player.getToken().getPosition().getCol()==7 && !player.hasCard("dining room") && !player.hasSeen("dining room")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 10 ; i++) {
				if(i==0) j="u";
				if(i==1) j="u";
				if(i==2) j="u";
				if(i==3) j="u";
				if(i==4) j="u";
				if(i==5) j="u";
				if(i==6) j="u";
				if(i==7) j="u";
				if(i==8) j="l";
				if(i==9) j="u";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==24 && player.getToken().getPosition().getCol()==7 && !player.hasCard("hall") && !player.hasSeen("hall")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 12 ; i++) {
				if(i==0) j="u";
				if(i==1) j="u";
				if(i==2) j="u";
				if(i==3) j="u";
				if(i==4) j="u";
				if(i==5) j="u";
				if(i==6) j="u";
				if(i==7) j="r";
				if(i==8) j="r";
				if(i==9) j="r";
				if(i==10) j="r";
				if(i==11) j="d";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==24 && player.getToken().getPosition().getCol()==7 && !player.hasCard("library") && !player.hasSeen("library")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 18 ; i++) {
				if(i==0) j="u";
				if(i==1) j="u";
				if(i==2) j="u";
				if(i==3) j="u";
				if(i==4) j="u";
				if(i==5) j="u";
				if(i==6) j="u";
				if(i==7) j="r";
				if(i==8) j="r";
				if(i==9) j="r";
				if(i==10) j="r";
				if(i==11) j="r";
				if(i==12) j="r";
				if(i==13) j="r";
				if(i==14) j="r";
				if(i==15) j="r";
				if(i==16) j="u";
				if(i==17) j="r";
				q.add(j);
			}
		}else if(player.getToken().getPosition().getRow()==24 && player.getToken().getPosition().getCol()==7 && !player.hasCard("study") && !player.hasSeen("study")) {

			if(!q.isEmpty()) {
				q.clear();
			}

			String j=null;
			for(int i=0; i < 21 ; i++) {
				if(i==0) j="u";
				if(i==1) j="u";
				if(i==2) j="u";
				if(i==3) j="u";
				if(i==4) j="u";
				if(i==5) j="u";
				if(i==6) j="u";
				if(i==7) j="r";
				if(i==8) j="r";
				if(i==9) j="r";
				if(i==10) j="r";
				if(i==11) j="r";
				if(i==12) j="r";
				if(i==13) j="r";
				if(i==14) j="r";
				if(i==15) j="r";
				if(i==16) j="d";
				if(i==17) j="d";
				if(i==18) j="d";
				if(i==19) j="r";
				if(i==20) j="d";
				q.add(j);
			}
		}



		if(!q.isEmpty()) {
			String local = q.remove();
			return local;
		}
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

	public String getRoom() {//TODO: is hasSeen correct here?
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
		return matchingCards.get().toString();
	}

	private static ArrayList<Coordinates> possibleMoves(Coordinates current_tile) {
		ArrayList<Coordinates> moves = new ArrayList<Coordinates>();
		int x = current_tile.getRow(), y = current_tile.getCol();
		int current_type = Map.MAP[x][y];
		if (! ((x - 1) < 0) && !(current_type == Map.C && Map.MAP[x-1][y] == Map.X)) {
			// can't move up
			moves.add(new Coordinates(y, x-1));
		}
		if (! ((x + 1) > Map.NUM_ROWS) && !(current_type == Map.C && Map.MAP[x+1][y] == Map.X)) {
			// can't move up
			moves.add(new Coordinates(y, x+1));
		}
		if (! ((y - 1) < 0) && !(current_type == Map.C && Map.MAP[x][y-1] == Map.X)) {
			// can't move up
			moves.add(new Coordinates(y-1, x));
		}
		if (! ((y + 1) < Map.NUM_COLS) && !(current_type == Map.C && Map.MAP[x][y+1] == Map.X)) {
			// can't move up
			moves.add(new Coordinates(y+1, x));
		}

		return moves;
	}

	public void notifyResponse(Log response) {
		// Add your code here
	}



}
