package bots;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import gameengine.*;

public class Bot3 implements BotAPI {


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
	private Boolean roomOut;
	private Boolean checkNotes = true;
	private Boolean murderWeapon, murderRoom, murderSuspect;
	private Token token;
	private String room;
	private String possWeapon, possRoom, possSuspect;
	private int checkCardsCounterPrev;
	private int checkCardsCounterCurr;
	private Queue<String> q = new LinkedList<String>();

	public Bot3 (Player player, PlayersInfo playersInfo, Map map, Dice dice, Log log, Deck deck) {
		this.player = player;
		this.playersInfo = playersInfo;
		this.map = map;
		this.dice = dice;
		this.log = log;
		this.deck = deck;
		moveOver = false;
		questionAsked = false;
		this.token = player.getToken();
		roomOut = false;
		murderWeapon = false;
		murderRoom = false;
		murderSuspect = false;
		checkCardsCounterPrev = 0;
		checkCardsCounterCurr = 0;
	}

	private void checkMurder()
	{
		int counter = 0;

		for(int i=0; i<Names.ROOM_CARD_NAMES.length; i++)
		{
			if(!player.hasCard(Names.ROOM_CARD_NAMES[i]) && !player.hasSeen(Names.ROOM_CARD_NAMES[i])) counter ++;
			else checkCardsCounterCurr ++;
		}
		if(counter == 1) murderRoom = true;

		counter = 0;
		for(int i=0; i<Names.SUSPECT_NAMES.length; i++)
		{
			if(!player.hasCard(Names.SUSPECT_NAMES[i]) && !player.hasSeen(Names.SUSPECT_NAMES[i])) counter ++;
			else checkCardsCounterCurr ++;
		}
		if(counter == 1) murderSuspect = true;

		counter = 0;
		for(int i=0; i<Names.WEAPON_NAMES.length; i++)
		{
			if(!player.hasCard(Names.WEAPON_NAMES[i]) && !player.hasSeen(Names.WEAPON_NAMES[i])) counter ++;
			else checkCardsCounterCurr ++;
		}
		if(counter == 1) murderWeapon = true;
	}

	public String getName() {
		return "Bot3"; // must match the class name
	}

	public String getCommand() {
		//if token is in corridor roll

		//System.out.println("\nBot3 "+token.getName());


		//		if(murderRoom) //System.out.println("murderRoom: true");
		//		if(murderSuspect) //System.out.println("murderSuspect: true");
		//		if(murderWeapon) //System.out.println("murderWeapon: true");

		if(checkNotes)
		{
			checkNotes = false;
			//System.out.println("notes");
			return "notes";
		}

		if(token.isInRoom())
		{
			room = token.getRoom().toString();
			possRoom = room;
		}
		else
		{
			room = "null";
		}


		if(token.isInRoom() && !questionAsked)
		{
			if(moveOver)
			{
				for(int i=0; i<Names.ROOM_NAMES.length; i++)
				{
					if(room.equalsIgnoreCase(Names.ROOM_CARD_NAMES[i])) {//needs to not work if already asked question
						questionAsked = true;
						//System.out.println("question");
						return "question";
					}
					if(murderWeapon && murderRoom && murderSuspect && room.equalsIgnoreCase("Cellar"))
					{
						//System.out.println("accuse");
						return "accuse";
					}
				}
			}
			//if entered room question
			//if in middle accuse
			//if start turn & in room -> roll || passage
		}
		if(map.isCorridor(token.getPosition()) && !moveOver)
		{
			//System.out.println("roll");
			return "roll";
		}
		if(token.isInRoom() && !moveOver)
		{

			if(room.equalsIgnoreCase("lounge") && !player.hasCard("conservatory") && !player.hasSeen("conservatory"))
			{
				questionAsked = false;
				moveOver = true;
				//System.out.println("passage: lounge to conservatory");
				return "passage";
			}
			else if(room.equalsIgnoreCase("study") && !player.hasCard("kitchen") && !player.hasSeen("kitchen"))
			{
				questionAsked = false;
				moveOver = true;
				//System.out.println("passage: study to kitchen");
				return "passage";
			}
			if(room.equalsIgnoreCase("conservatory") && !player.hasCard("lounge") && !player.hasSeen("lounge"))
			{
				questionAsked = false;
				moveOver = true;
				//System.out.println("passage: conservatory to lounge");
				return "passage";
			}
			else if(room.equalsIgnoreCase("kitchen") && !player.hasCard("study") && !player.hasSeen("study"))
			{
				questionAsked = false;
				moveOver = true;
				//System.out.println("passage: kitchen to study");
				return "passage";
			}
			else
			{
				//System.out.println("roll");
				roomOut = true;
				return "roll";
			}
		}
		else
		{
			checkMurder();
			//System.out.println("done");
			checkNotes = true;
			roomOut = false;
			questionAsked = true;
			moveOver = false;
			return "done";
		}
	}

	public String getMove() {

		moveOver = true;
		questionAsked = false;



		if(murderWeapon && murderRoom && murderSuspect)
		{
			//			//System.out.println("room: "+room);
			//			//System.out.println("????????????????????????????????????????????");
			if(room.equalsIgnoreCase("kitchen")) {
				if(!q.isEmpty()) {
					q.clear();
				}
				//System.out.println("kitchen to cellar");
				String j=null;
				for(int i=0; i < 20 ; i++) {
					if(i==0) j="d";
					if(i==1) j="d";
					if(i==2) j="r";
					if(i==3) j="r";
					if(i==4) j="r";
					if(i==5) j="r";
					if(i==6) j="r";
					if(i==7) j="d";
					if(i==8) j="d";
					if(i==9) j="d";
					if(i==10) j="d";
					if(i==11) j="d";
					if(i==12) j="d";
					if(i==13) j="d";
					if(i==14) j="d";
					if(i==15) j="d";
					if(i==16) j="r";
					if(i==17) j="r";
					if(i==18) j="r";
					if(i==19) j="u";
					q.add(j);
				}
			}if(room.equalsIgnoreCase("ballroom")) {
				if(!q.isEmpty()) {
					q.clear();
				}
				//				//System.out.println("ball");
				String j=null;
				for(int i=0; i < 14 ; i++) {
					if(i==0) j="d";
					if(i==1) j="d";
					if(i==2) j="d";
					if(i==3) j="d";
					if(i==4) j="d";
					if(i==5) j="d";
					if(i==6) j="d";
					if(i==7) j="d";
					if(i==8) j="d";
					if(i==9) j="d";
					if(i==10) j="r";
					if(i==11) j="r";
					if(i==12) j="r";
					if(i==13) j="u";
					q.add(j);
				}
			}if(room.equalsIgnoreCase("conservatory")) {
				if(!q.isEmpty()) {
					q.clear();
				}
				//System.out.println("conservatory to cellar");
				String j=null;
				for(int i=0; i < 20 ; i++) {
					if(i==0) j="d";
					if(i==1) j="d";
					if(i==2) j="d";
					if(i==3) j="l";
					if(i==4) j="l";
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
					if(i==15) j="l";
					if(i==16) j="l";
					if(i==17) j="l";
					if(i==18) j="l";
					if(i==19) j="u";
					q.add(j);
				}
			}if(room.equalsIgnoreCase("dining room")) {
				if(!q.isEmpty()) {
					q.clear();
				}
				//				//System.out.println("dining");
				String j=null;
				for(int i=0; i < 9 ; i++) {
					if(i==0) j="d";
					if(i==1) j="d";
					if(i==2) j="r";
					if(i==3) j="r";
					if(i==4) j="r";
					if(i==5) j="r";
					if(i==6) j="r";
					if(i==7) j="r";
					if(i==8) j="u";
					q.add(j);
				}
			}if(room.equalsIgnoreCase("billiard room")) {
				if(!q.isEmpty()) {
					q.clear();
				}
				//				//System.out.println("billiard");
				String j=null;
				for(int i=0; i < 15 ; i++) {
					if(i==0) j="l";
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
					if(i==11) j="l";
					if(i==12) j="l";
					if(i==13) j="l";
					if(i==14) j="u";
					q.add(j);
				}
			}if(room.equalsIgnoreCase("library")) {
				if(!q.isEmpty()) {
					q.clear();
				}
				//				//System.out.println("lib");
				String j=null;
				for(int i=0; i < 7 ; i++) {
					if(i==0) j="l";
					if(i==1) j="l";
					if(i==2) j="d";
					if(i==3) j="l";
					if(i==4) j="l";
					if(i==5) j="l";
					if(i==6) j="u";
					q.add(j);
				}
			}if(room.equalsIgnoreCase("lounge")) {
				if(!q.isEmpty()) {
					q.clear();
				}
				//System.out.println("lounge to cellar");
				String j=null;
				for(int i=0; i < 9 ; i++) {
					if(i==0) j="u";
					if(i==1) j="u";
					if(i==2) j="r";
					if(i==3) j="r";
					if(i==4) j="r";
					if(i==5) j="r";
					if(i==6) j="r";
					if(i==7) j="r";
					if(i==8) j="u";
					q.add(j);
				}
			}if(room.equalsIgnoreCase("hall")) {
				if(!q.isEmpty()) {
					q.clear();
				}
				//				//System.out.println("hall");
				String j=null;
				for(int i=0; i < 2 ; i++) {
					if(i==0) j="u";
					if(i==1) j="u";
					q.add(j);
				}
			}if(room.equalsIgnoreCase("study")) {
				if(!q.isEmpty()) {
					q.clear();
				}
				//System.out.println("study to cellar");
				String j=null;
				for(int i=0; i < 10 ; i++) {
					if(i==0) j="u";
					if(i==1) j="u";
					if(i==2) j="u";
					if(i==3) j="l";
					if(i==4) j="l";
					if(i==5) j="u";
					if(i==6) j="l";
					if(i==7) j="l";
					if(i==8) j="l";
					if(i==9) j="u";
					q.add(j);
				}
			}
		}
		else {
			if(token.getPosition().getRow()==0 && token.getPosition().getCol()==9 && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {
				//white start
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
			}else if(token.getPosition().getRow()==0 && token.getPosition().getCol()==9 && !player.hasCard("kitchen") && !player.hasSeen("kitchen")) {

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
			}else if(token.getPosition().getRow()==0 && token.getPosition().getCol()==9 && !player.hasCard("dining room") && !player.hasSeen("dining room")) {

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
			}else if(token.getPosition().getRow()==0 && token.getPosition().getCol()==9 && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {

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
			}else if(token.getPosition().getRow()==0 && token.getPosition().getCol()==9 && !player.hasCard("lounge") && !player.hasSeen("lounge")) {

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
			}else if(token.getPosition().getRow()==0 && token.getPosition().getCol()==14 && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {
				//green start

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
			}else if(token.getPosition().getRow()==0 && token.getPosition().getCol()==14 && !player.hasCard("conservatory") && !player.hasSeen("conservatory")) {

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
			}else if(token.getPosition().getRow()==0 && token.getPosition().getCol()==14 && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {

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
			}else if(token.getPosition().getRow()==0 && token.getPosition().getCol()==14 && !player.hasCard("library") && !player.hasSeen("library")) {

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
			}else if(token.getPosition().getRow()==0 && token.getPosition().getCol()==14 && !player.hasCard("dining room") && !player.hasSeen("dining room")) {

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
			}else if(token.getPosition().getRow()==6 && token.getPosition().getCol()==23 && !player.hasCard("conservatory") && !player.hasSeen("conservatory")) {
				//peacock start
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
			}else if(token.getPosition().getRow()==6 && token.getPosition().getCol()==23 && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {

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
			}else if(token.getPosition().getRow()==6 && token.getPosition().getCol()==23 && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {

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
			}else if(token.getPosition().getRow()==6 && token.getPosition().getCol()==23 && !player.hasCard("library") && !player.hasSeen("library")) {

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
			}else if(token.getPosition().getRow()==6 && token.getPosition().getCol()==23 && !player.hasCard("study") && !player.hasSeen("study")) {

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
			}else if(token.getPosition().getRow()==19 && token.getPosition().getCol()==23 && !player.hasCard("study") && !player.hasSeen("study")) {
				//plum start
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
			}else if(token.getPosition().getRow()==19 && token.getPosition().getCol()==23 && !player.hasCard("hall") && !player.hasSeen("hall")) {

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
			}else if(token.getPosition().getRow()==19 && token.getPosition().getCol()==23 && !player.hasCard("library") && !player.hasSeen("library")) {

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
			}else if(token.getPosition().getRow()==19 && token.getPosition().getCol()==23 && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {

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
			}else if(token.getPosition().getRow()==19 && token.getPosition().getCol()==23 && !player.hasCard("lounge") && !player.hasSeen("lounge")) {

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
			}else if(token.getPosition().getRow()==24 && token.getPosition().getCol()==7 && !player.hasCard("lounge") && !player.hasSeen("lounge")) {
				//scarlett start
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
			}else if(token.getPosition().getRow()==24 && token.getPosition().getCol()==7 && !player.hasCard("dining room") && !player.hasSeen("dining room")) {

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
			}else if(token.getPosition().getRow()==24 && token.getPosition().getCol()==7 && !player.hasCard("hall") && !player.hasSeen("hall")) {

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
			}else if(token.getPosition().getRow()==24 && token.getPosition().getCol()==7 && !player.hasCard("library") && !player.hasSeen("library")) {

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
			}else if(token.getPosition().getRow()==24 && token.getPosition().getCol()==7 && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {

				String j=null;
				for(int i=0; i < 19 ; i++) {
					if(i==0) j="u";
					if(i==1) j="u";
					if(i==2) j="u";
					if(i==3) j="u";
					if(i==4) j="u";
					if(i==5) j="u";
					if(i==6) j="u";
					if(i==7) j="u";
					if(i==8) j="r";
					if(i==9) j="r";
					if(i==10) j="u";
					if(i==11) j="u";
					if(i==12) j="u";
					if(i==13) j="u";
					if(i==14) j="u";
					if(i==15) j="u";
					if(i==16) j="u";
					if(i==17) j="u";
					if(i==18) j="u";
					q.add(j);
				}
			}else if(token.getPosition().getRow()==17 && token.getPosition().getCol()==0 && !player.hasCard("lounge") && !player.hasSeen("lounge")) {
				//mustard start
				String j=null;
				for(int i=0; i < 8 ; i++) {
					if(i==0) j="r";
					if(i==1) j="r";
					if(i==2) j="r";
					if(i==3) j="r";
					if(i==4) j="r";
					if(i==5) j="r";
					if(i==6) j="d";
					if(i==7) j="d";
					q.add(j);
				}
			}else if(token.getPosition().getRow()==17 && token.getPosition().getCol()==0 && !player.hasCard("dining room") && !player.hasSeen("dining room")) {

				String j=null;
				for(int i=0; i < 8 ; i++) {
					if(i==0) j="r";
					if(i==1) j="r";
					if(i==2) j="r";
					if(i==3) j="r";
					if(i==4) j="r";
					if(i==5) j="r";
					if(i==6) j="u";
					if(i==7) j="u";
					q.add(j);
				}
			}else if(token.getPosition().getRow()==17 && token.getPosition().getCol()==0 && !player.hasCard("hall") && !player.hasSeen("hall")) {

				String j=null;
				for(int i=0; i < 12 ; i++) {
					if(i==0) j="r";
					if(i==1) j="r";
					if(i==2) j="r";
					if(i==3) j="r";
					if(i==4) j="r";
					if(i==5) j="r";
					if(i==6) j="r";
					if(i==7) j="r";
					if(i==8) j="r";
					if(i==9) j="r";
					if(i==10) j="r";
					if(i==11) j="d";
					q.add(j);
				}
			}else if(token.getPosition().getRow()==17 && token.getPosition().getCol()==0 && !player.hasCard("library") && !player.hasSeen("library")) {

				String j=null;
				for(int i=0; i < 18 ; i++) {
					if(i==0) j="r";
					if(i==1) j="r";
					if(i==2) j="r";
					if(i==3) j="r";
					if(i==4) j="r";
					if(i==5) j="r";
					if(i==6) j="r";
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
			}else if(token.getPosition().getRow()==17 && token.getPosition().getCol()==0 && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {

				String j=null;
				for(int i=0; i < 19 ; i++) {
					if(i==0) j="r";
					if(i==1) j="r";
					if(i==2) j="r";
					if(i==3) j="r";
					if(i==4) j="r";
					if(i==5) j="r";
					if(i==6) j="r";
					if(i==7) j="r";
					if(i==8) j="r";
					if(i==9) j="u";
					if(i==10) j="u";
					if(i==11) j="u";
					if(i==12) j="u";
					if(i==13) j="u";
					if(i==14) j="u";
					if(i==15) j="u";
					if(i==16) j="u";
					if(i==17) j="u";
					if(i==18) j="u";
					q.add(j);
				}
			}


			//TODO
			if(roomOut && !room.equals("null"))
			{
				if(room.equalsIgnoreCase("kitchen") && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {
					//from kitchen to ballroom
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("kitchen to ballroom");
					String j=null;
					for(int i=0; i < 7 ; i++) {
						if(i==0) j="d";
						if(i==1) j="r";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="u";
						if(i==5) j="u";
						if(i==6) j="r";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("kitchen") && !player.hasCard("dining room") && !player.hasSeen("dining room")) {
					//from kitchen to dining room
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("kitchen to dining room");
					String j=null;
					for(int i=0; i < 11 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="r";
						if(i==6) j="d";
						if(i==7) j="d";
						if(i==8) j="d";
						if(i==9) j="d";
						if(i==10) j="l";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("kitchen") && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {
					//from kitchen to billiard room
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("kitchen to billiard room");
					String j=null;
					for(int i=0; i < 17 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="r";
						if(i==6) j="r";
						if(i==7) j="r";
						if(i==8) j="r";
						if(i==9) j="r";
						if(i==10) j="r";
						if(i==11) j="r";
						if(i==12) j="r";
						if(i==13) j="r";
						if(i==14) j="r";
						if(i==15) j="d";
						if(i==16) j="r";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("kitchen") && !player.hasCard("hall") && !player.hasSeen("hall")) {
					//from kitchen to hall
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("kitchen to hall");
					String j=null;
					for(int i=0; i < 19 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="r";
						if(i==6) j="r";
						if(i==7) j="d";
						if(i==8) j="d";
						if(i==9) j="d";
						if(i==10) j="d";
						if(i==11) j="d";
						if(i==12) j="d";
						if(i==13) j="d";
						if(i==14) j="d";
						if(i==15) j="d";
						if(i==16) j="r";
						if(i==17) j="r";
						if(i==18) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("kitchen") && !player.hasCard("lounge") && !player.hasSeen("lounge")) {
					//from kitchen to lounge
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("kitchen to lounge");
					String j=null;
					for(int i=0; i < 19 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="r";
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
						if(i==16) j="l";
						if(i==17) j="l";
						if(i==18) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("kitchen") && !player.hasCard("conservatory") && !player.hasSeen("conservatory")) {
					//from kitchen to conservatory
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("kitchen to conservatory");
					String j=null;
					for(int i=0; i < 20 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="r";
						if(i==6) j="r";
						if(i==7) j="r";
						if(i==8) j="r";
						if(i==9) j="r";
						if(i==10) j="r";
						if(i==11) j="r";
						if(i==12) j="r";
						if(i==13) j="r";
						if(i==14) j="r";
						if(i==15) j="u";
						if(i==16) j="u";
						if(i==17) j="u";
						if(i==18) j="r";
						if(i==19) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("kitchen") && !player.hasCard("library") && !player.hasSeen("library")) {
					//from kitchen to library
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("kitchen to library");
					String j=null;
					for(int i=0; i < 23 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="r";
						if(i==6) j="r";
						if(i==7) j="r";
						if(i==8) j="r";
						if(i==9) j="r";
						if(i==10) j="r";
						if(i==11) j="r";
						if(i==12) j="r";
						if(i==13) j="r";
						if(i==14) j="d";
						if(i==15) j="d";
						if(i==16) j="d";
						if(i==17) j="d";
						if(i==18) j="d";
						if(i==19) j="d";
						if(i==20) j="d";
						if(i==21) j="d";
						if(i==22) j="r";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("ballroom") && !player.hasCard("conservatory") && !player.hasSeen("conservatory")) {
					//from ballroom to conservatory
					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 4 ; i++) {
						if(i==0) j="r";
						if(i==1) j="r";
						if(i==2) j="r";
						if(i==3) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("ballroom") && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {
					//from ballroom to billiard room
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 6 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="r";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("ballroom") && !player.hasCard("kitchen") && !player.hasSeen("kitchen")) {
					//from ballroom to kitchen
					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 7 ; i++) {
						if(i==0) j="l";
						if(i==1) j="d";
						if(i==2) j="d";
						if(i==3) j="l";
						if(i==4) j="l";
						if(i==5) j="l";
						if(i==6) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("ballroom") && !player.hasCard("dining room") && !player.hasSeen("dining room")) {
					//from ballroom to dining room
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("ballroom to dining room");
					String j=null;
					for(int i=0; i < 7 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="d";
						if(i==3) j="d";
						if(i==4) j="d";
						if(i==5) j="l";
						if(i==6) j="l";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("ballroom") && !player.hasCard("library") && !player.hasSeen("library")) {
					//from ballroom to library
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("ballroom to library");
					String j=null;
					for(int i=0; i < 12 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="d";
						if(i==5) j="d";
						if(i==6) j="d";
						if(i==7) j="d";
						if(i==8) j="d";
						if(i==9) j="d";
						if(i==10) j="d";
						if(i==11) j="r";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("ballroom") && !player.hasCard("hall") && !player.hasSeen("hall")) {
					//from ballroom to hall
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("ballroom to hall");
					String j=null;
					for(int i=0; i < 13 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="d";
						if(i==3) j="d";
						if(i==4) j="d";
						if(i==5) j="d";
						if(i==6) j="d";
						if(i==7) j="d";
						if(i==8) j="d";
						if(i==9) j="d";
						if(i==10) j="r";
						if(i==11) j="r";
						if(i==12) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("ballroom") && !player.hasCard("lounge") && !player.hasSeen("lounge")) {
					//from ballroom to lounge
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("ballroom to lounge");
					String j=null;
					for(int i=0; i < 15 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="d";
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
						if(i==13) j="d";
						if(i==14) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("ballroom") && !player.hasCard("study") && !player.hasSeen("study")) {
					//from ballroom to study
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 17 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="r";
						if(i==3) j="r";
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
						if(i==15) j="r";
						if(i==16) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("conservatory") && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {
					//from conservatory to ballroom
					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 4 ; i++) {
						if(i==0) j="d";
						if(i==1) j="l";
						if(i==2) j="l";
						if(i==3) j="l";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("conservatory") && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {
					//from conservatory to billiard room
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("conservatory to billiard room");
					String j=null;
					for(int i=0; i < 7 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="d";
						if(i==3) j="l";
						if(i==4) j="d";
						if(i==5) j="d";
						if(i==6) j="r";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("conservatory") && !player.hasCard("library") && !player.hasSeen("library")) {
					//from conservatory to library
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("conservatory to library");
					String j=null;
					for(int i=0; i < 15 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="d";
						if(i==3) j="l";
						if(i==4) j="l";
						if(i==5) j="d";
						if(i==6) j="d";
						if(i==7) j="d";
						if(i==8) j="d";
						if(i==9) j="d";
						if(i==10) j="d";
						if(i==11) j="d";
						if(i==12) j="d";
						if(i==13) j="d";
						if(i==14) j="r";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("conservatory") && !player.hasCard("dining room") && !player.hasSeen("dining room")) {
					//from conservatory to dining room
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("conservatory to dining room");
					String j=null;
					for(int i=0; i < 19 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="d";
						if(i==3) j="l";
						if(i==4) j="l";
						if(i==5) j="d";
						if(i==6) j="d";
						if(i==7) j="l";
						if(i==8) j="l";
						if(i==9) j="l";
						if(i==10) j="l";
						if(i==11) j="l";
						if(i==12) j="l";
						if(i==13) j="l";
						if(i==14) j="l";
						if(i==15) j="d";
						if(i==16) j="d";
						if(i==17) j="d";
						if(i==18) j="l";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("conservatory") && !player.hasCard("kitchen") && !player.hasSeen("kitchen")) {
					//from conservatory to kitchen
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 20 ; i++) {
						if(i==0) j="d";
						if(i==1) j="l";
						if(i==2) j="d";
						if(i==3) j="d";
						if(i==4) j="d";
						if(i==5) j="l";
						if(i==6) j="l";
						if(i==7) j="l";
						if(i==8) j="l";
						if(i==9) j="l";
						if(i==10) j="l";
						if(i==11) j="l";
						if(i==12) j="l";
						if(i==13) j="l";
						if(i==14) j="l";
						if(i==15) j="l";
						if(i==16) j="l";
						if(i==17) j="l";
						if(i==18) j="u";
						if(i==19) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("conservatory") && !player.hasCard("study") && !player.hasSeen("study")) {
					//from conservatory to study
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("conservatory to study");
					String j=null;
					for(int i=0; i < 20 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="d";
						if(i==3) j="l";
						if(i==4) j="l";
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
						if(i==19) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("conservatory") && !player.hasCard("hall") && !player.hasSeen("hall")) {
					//from conservatory to hall
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("conservatory to hall");
					String j=null;
					for(int i=0; i < 20 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="d";
						if(i==3) j="l";
						if(i==4) j="l";
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
						if(i==15) j="l";
						if(i==16) j="l";
						if(i==17) j="l";
						if(i==18) j="l";
						if(i==19) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("billiard room") && !player.hasCard("library") && !player.hasSeen("library")) {
					//from billiard room to library
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 4 ; i++) {
						if(i==0) j="d";
						if(i==1) j="l";
						if(i==2) j="l";
						if(i==3) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("billiard room") && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {
					//from billiard room to ballroom
					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 6 ; i++) {
						if(i==0) j="l";
						if(i==1) j="l";
						if(i==2) j="l";
						if(i==3) j="l";
						if(i==4) j="u";
						if(i==5) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("billiard room") && !player.hasCard("conservatory") && !player.hasSeen("conservatory")) {
					//from billiard room to conservatory
					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 7 ; i++) {
						if(i==0) j="l";
						if(i==1) j="u";
						if(i==2) j="u";
						if(i==3) j="r";
						if(i==4) j="u";
						if(i==5) j="u";
						if(i==6) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("billiard room") && !player.hasCard("dining room") && !player.hasSeen("dining room")) {
					//from billiard room to dining room
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 14 ; i++) {
						if(i==0) j="l";
						if(i==1) j="l";
						if(i==2) j="l";
						if(i==3) j="l";
						if(i==4) j="l";
						if(i==5) j="l";
						if(i==6) j="l";
						if(i==7) j="l";
						if(i==8) j="l";
						if(i==9) j="l";
						if(i==10) j="d";
						if(i==11) j="d";
						if(i==12) j="d";
						if(i==13) j="l";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("billiard room") && !player.hasCard("study") && !player.hasSeen("study")) {
					//from billiard room to study
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 15 ; i++) {
						if(i==0) j="l";
						if(i==1) j="l";
						if(i==2) j="d";
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
						if(i==13) j="r";
						if(i==14) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("billiard room") && !player.hasCard("hall") && !player.hasSeen("hall")) {
					//from billiard room to hall
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 15 ; i++) {
						if(i==0) j="l";
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
						if(i==11) j="l";
						if(i==12) j="l";
						if(i==13) j="l";
						if(i==14) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("billiard room") && !player.hasCard("kitchen") && !player.hasSeen("kitchen")) {
					//from billiard room to kitchen
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 17 ; i++) {
						if(i==0) j="l";
						if(i==1) j="u";
						if(i==2) j="l";
						if(i==3) j="l";
						if(i==4) j="l";
						if(i==5) j="l";
						if(i==6) j="l";
						if(i==7) j="l";
						if(i==8) j="l";
						if(i==9) j="l";
						if(i==10) j="l";
						if(i==11) j="l";
						if(i==12) j="l";
						if(i==13) j="l";
						if(i==14) j="l";
						if(i==15) j="u";
						if(i==16) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("billiard room") && !player.hasCard("lounge") && !player.hasSeen("lounge")) {
					//from billiard room to lounge
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("billiard room to lounge");
					String j=null;
					for(int i=0; i < 22 ; i++) {
						if(i==0) j="l";
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
						if(i==11) j="l";
						if(i==12) j="l";
						if(i==13) j="l";
						if(i==14) j="l";
						if(i==15) j="l";
						if(i==16) j="l";
						if(i==17) j="l";
						if(i==18) j="l";
						if(i==19) j="l";
						if(i==20) j="d";
						if(i==21) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("library") && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {
					//from library to billiard room
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 4 ; i++) {
						if(i==0) j="u";
						if(i==1) j="r";
						if(i==2) j="r";
						if(i==3) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("library") && !player.hasCard("study") && !player.hasSeen("study")) {
					//from library to study
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 7 ; i++) {
						if(i==0) j="l";
						if(i==1) j="d";
						if(i==2) j="d";
						if(i==3) j="d";
						if(i==4) j="d";
						if(i==5) j="r";
						if(i==6) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("library") && !player.hasCard("hall") && !player.hasSeen("hall")) {
					//from library to hall
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 7 ; i++) {
						if(i==0) j="l";
						if(i==1) j="l";
						if(i==2) j="d";
						if(i==3) j="l";
						if(i==4) j="l";
						if(i==5) j="l";
						if(i==6) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("library") && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {
					//from library to ballroom
					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 12 ; i++) {
						if(i==0) j="l";
						if(i==1) j="u";
						if(i==2) j="u";
						if(i==3) j="u";
						if(i==4) j="u";
						if(i==5) j="u";
						if(i==6) j="u";
						if(i==7) j="u";
						if(i==8) j="l";
						if(i==9) j="l";
						if(i==10) j="u";
						if(i==11) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("library") && !player.hasCard("lounge") && !player.hasSeen("lounge")) {
					//from library to lounge
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 14 ; i++) {
						if(i==0) j="l";
						if(i==1) j="l";
						if(i==2) j="d";
						if(i==3) j="l";
						if(i==4) j="l";
						if(i==5) j="l";
						if(i==6) j="l";
						if(i==7) j="l";
						if(i==8) j="l";
						if(i==9) j="l";
						if(i==10) j="l";
						if(i==11) j="l";
						if(i==12) j="d";
						if(i==13) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("library") && !player.hasCard("dining room") && !player.hasSeen("dining room")) {
					//from library to dining room
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 14 ; i++) {
						if(i==0) j="l";
						if(i==1) j="l";
						if(i==2) j="d";
						if(i==3) j="l";
						if(i==4) j="l";
						if(i==5) j="l";
						if(i==6) j="l";
						if(i==7) j="l";
						if(i==8) j="l";
						if(i==9) j="l";
						if(i==10) j="l";
						if(i==11) j="l";
						if(i==12) j="u";
						if(i==13) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("library") && !player.hasCard("conservatory") && !player.hasSeen("conservatory")) {
					//from library to conservatory
					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 15 ; i++) {
						if(i==0) j="l";
						if(i==1) j="u";
						if(i==2) j="u";
						if(i==3) j="u";
						if(i==4) j="u";
						if(i==5) j="u";
						if(i==6) j="u";
						if(i==7) j="u";
						if(i==8) j="u";
						if(i==9) j="u";
						if(i==10) j="r";
						if(i==11) j="r";
						if(i==12) j="u";
						if(i==13) j="u";
						if(i==14) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("library") && !player.hasCard("kitchen") && !player.hasSeen("kitchen")) {
					//from library to kitchen
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 23 ; i++) {
						if(i==0) j="l";
						if(i==1) j="u";
						if(i==2) j="u";
						if(i==3) j="u";
						if(i==4) j="u";
						if(i==5) j="u";
						if(i==6) j="u";
						if(i==7) j="u";
						if(i==8) j="u";
						if(i==9) j="l";
						if(i==10) j="l";
						if(i==11) j="l";
						if(i==12) j="l";
						if(i==13) j="l";
						if(i==14) j="l";
						if(i==15) j="l";
						if(i==16) j="l";
						if(i==17) j="l";
						if(i==18) j="l";
						if(i==19) j="l";
						if(i==20) j="l";
						if(i==21) j="u";
						if(i==22) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("study") && !player.hasCard("hall") && !player.hasSeen("hall")) {
					//from study to hall
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("study to hall");
					String j=null;
					for(int i=0; i < 4 ; i++) {
						if(i==0) j="u";
						if(i==1) j="l";
						if(i==2) j="l";
						if(i==3) j="l";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("study") && !player.hasCard("library") && !player.hasSeen("library")) {
					//from study to library
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("study to library");
					String j=null;
					for(int i=0; i < 7 ; i++) {
						if(i==0) j="u";
						if(i==1) j="u";
						if(i==2) j="u";
						if(i==3) j="l";
						if(i==4) j="u";
						if(i==5) j="u";
						if(i==6) j="r";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("study") && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {
					//from study to billiard room
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("study to billiard room");
					String j=null;
					for(int i=0; i < 15 ; i++) {
						if(i==0) j="u";
						if(i==1) j="l";
						if(i==2) j="u";
						if(i==3) j="u";
						if(i==4) j="u";
						if(i==5) j="u";
						if(i==6) j="u";
						if(i==7) j="u";
						if(i==8) j="u";
						if(i==9) j="u";
						if(i==10) j="u";
						if(i==11) j="u";
						if(i==12) j="u";
						if(i==13) j="r";
						if(i==14) j="r";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("study") && !player.hasCard("lounge") && !player.hasSeen("lounge")) {
					//from study to lounge
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("study to lounge");
					String j=null;
					for(int i=0; i < 17 ; i++) {
						if(i==0) j="u";
						if(i==1) j="u";
						if(i==2) j="u";
						if(i==3) j="l";
						if(i==4) j="l";
						if(i==5) j="u";
						if(i==6) j="l";
						if(i==7) j="l";
						if(i==8) j="l";
						if(i==9) j="l";
						if(i==10) j="l";
						if(i==11) j="l";
						if(i==12) j="l";
						if(i==13) j="l";
						if(i==14) j="l";
						if(i==15) j="d";
						if(i==16) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("study") && !player.hasCard("dining room") && !player.hasSeen("dining room")) {
					//from study to dining room
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("study to dining room");
					String j=null;
					for(int i=0; i < 17 ; i++) {
						if(i==0) j="u";
						if(i==1) j="u";
						if(i==2) j="u";
						if(i==3) j="l";
						if(i==4) j="l";
						if(i==5) j="u";
						if(i==6) j="l";
						if(i==7) j="l";
						if(i==8) j="l";
						if(i==9) j="l";
						if(i==10) j="l";
						if(i==11) j="l";
						if(i==12) j="l";
						if(i==13) j="l";
						if(i==14) j="l";
						if(i==15) j="u";
						if(i==16) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("study") && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {
					//from study to ballroom
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("study to ballroom");
					String j=null;
					for(int i=0; i < 17 ; i++) {
						if(i==0) j="u";
						if(i==1) j="l";
						if(i==2) j="u";
						if(i==3) j="u";
						if(i==4) j="u";
						if(i==5) j="u";
						if(i==6) j="u";
						if(i==7) j="u";
						if(i==8) j="u";
						if(i==9) j="u";
						if(i==10) j="u";
						if(i==11) j="u";
						if(i==12) j="u";
						if(i==13) j="l";
						if(i==14) j="l";
						if(i==15) j="u";
						if(i==16) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("study") && !player.hasCard("conservatory") && !player.hasSeen("conservatory")) {
					//from study to conservatory
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("study to conservatory");
					String j=null;
					for(int i=0; i < 20 ; i++) {
						if(i==0) j="u";
						if(i==1) j="l";
						if(i==2) j="u";
						if(i==3) j="u";
						if(i==4) j="u";
						if(i==5) j="u";
						if(i==6) j="u";
						if(i==7) j="u";
						if(i==8) j="u";
						if(i==9) j="u";
						if(i==10) j="u";
						if(i==11) j="u";
						if(i==12) j="u";
						if(i==13) j="u";
						if(i==14) j="u";
						if(i==15) j="r";
						if(i==16) j="r";
						if(i==17) j="u";
						if(i==18) j="u";
						if(i==19) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("hall") && !player.hasCard("study") && !player.hasSeen("study")) {
					//from hall to study
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("hall to study");
					String j=null;
					for(int i=0; i < 4 ; i++) {
						if(i==0) j="r";
						if(i==1) j="r";
						if(i==2) j="r";
						if(i==3) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("hall") && !player.hasCard("library") && !player.hasSeen("library")) {
					//from hall to library
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("hall to library");
					String j=null;
					for(int i=0; i < 7 ; i++) {
						if(i==0) j="u";
						if(i==1) j="r";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="u";
						if(i==6) j="r";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("hall") && !player.hasCard("lounge") && !player.hasSeen("lounge")) {
					//from hall to lounge
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("hall to lounge");
					String j=null;
					for(int i=0; i < 8 ; i++) {
						if(i==0) j="u";
						if(i==1) j="l";
						if(i==2) j="l";
						if(i==3) j="l";
						if(i==4) j="l";
						if(i==5) j="l";
						if(i==6) j="d";
						if(i==7) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("hall") && !player.hasCard("dining room") && !player.hasSeen("dining room")) {
					//from hall to dining room
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("hall to dining room");
					String j=null;
					for(int i=0; i < 8 ; i++) {
						if(i==0) j="u";
						if(i==1) j="l";
						if(i==2) j="l";
						if(i==3) j="l";
						if(i==4) j="l";
						if(i==5) j="l";
						if(i==6) j="u";
						if(i==7) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("hall") && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {
					//from hall to ballroom
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("hall to ballroom");
					String j=null;
					for(int i=0; i < 13; i++) {
						if(i==0) j="u";
						if(i==1) j="l";
						if(i==2) j="l";
						if(i==3) j="u";
						if(i==4) j="u";
						if(i==5) j="u";
						if(i==6) j="u";
						if(i==7) j="u";
						if(i==8) j="u";
						if(i==9) j="u";
						if(i==10) j="u";
						if(i==11) j="u";
						if(i==12) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("hall") && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {
					//from hall to billiard room
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("hall to billiard room");
					String j=null;
					for(int i=0; i < 15 ; i++) {
						if(i==0) j="u";
						if(i==1) j="r";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="u";
						if(i==5) j="u";
						if(i==6) j="u";
						if(i==7) j="u";
						if(i==8) j="u";
						if(i==9) j="u";
						if(i==10) j="u";
						if(i==11) j="u";
						if(i==12) j="r";
						if(i==13) j="r";
						if(i==14) j="r";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("hall") && !player.hasCard("kitchen") && !player.hasSeen("kitchen")) {
					//from hall to kitchen
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("hall to kitchen");
					String j=null;
					for(int i=0; i < 19 ; i++) {
						if(i==0) j="u";
						if(i==1) j="l";
						if(i==2) j="l";
						if(i==3) j="u";
						if(i==4) j="u";
						if(i==5) j="u";
						if(i==6) j="u";
						if(i==7) j="u";
						if(i==8) j="u";
						if(i==9) j="u";
						if(i==10) j="u";
						if(i==11) j="u";
						if(i==12) j="l";
						if(i==13) j="l";
						if(i==14) j="l";
						if(i==15) j="l";
						if(i==16) j="l";
						if(i==17) j="u";
						if(i==18) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("hall") && !player.hasCard("conservatory") && !player.hasSeen("conservatory")) {
					//from hall to conservatory
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("hall to conservatory");
					String j=null;
					for(int i=0; i < 20 ; i++) {
						if(i==0) j="u";
						if(i==1) j="r";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="u";
						if(i==6) j="u";
						if(i==7) j="u";
						if(i==8) j="u";
						if(i==9) j="u";
						if(i==10) j="u";
						if(i==11) j="u";
						if(i==12) j="u";
						if(i==13) j="u";
						if(i==14) j="u";
						if(i==15) j="r";
						if(i==16) j="r";
						if(i==17) j="u";
						if(i==18) j="u";
						if(i==19) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("lounge") && !player.hasCard("dining room") && !player.hasSeen("dining room")) {
					//from lounge to dining room
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("lounge to dining room");
					String j=null;
					for(int i=0; i < 4 ; i++) {
						if(i==0) j="u";
						if(i==1) j="u";
						if(i==2) j="u";
						if(i==3) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("lounge") && !player.hasCard("hall") && !player.hasSeen("hall")) {
					//from lounge to hall
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("lounge to hall");
					String j=null;
					for(int i=0; i < 8; i++) {
						if(i==0) j="u";
						if(i==1) j="u";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="r";
						if(i==6) j="r";
						if(i==7) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("lounge") && !player.hasCard("library") && !player.hasSeen("library")) {
					//from lounge to library
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("lounge to library");
					String j=null;
					for(int i=0; i < 14 ; i++) {
						if(i==0) j="u";
						if(i==1) j="u";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="r";
						if(i==6) j="r";
						if(i==7) j="r";
						if(i==8) j="r";
						if(i==9) j="r";
						if(i==10) j="r";
						if(i==11) j="r";
						if(i==12) j="u";
						if(i==13) j="r";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("lounge") && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {
					//from lounge to ballroom
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("lounge to ballroom");
					String j=null;
					for(int i=0; i < 15 ; i++) {
						if(i==0) j="u";
						if(i==1) j="u";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="u";
						if(i==6) j="u";
						if(i==7) j="u";
						if(i==8) j="u";
						if(i==9) j="u";
						if(i==10) j="u";
						if(i==11) j="u";
						if(i==12) j="u";
						if(i==13) j="u";
						if(i==14) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("lounge") && !player.hasCard("study") && !player.hasSeen("study")) {
					//from lounge to study
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("lounge to study");
					String j=null;
					for(int i=0; i < 17; i++) {
						if(i==0) j="u";
						if(i==1) j="u";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="r";
						if(i==6) j="r";
						if(i==7) j="r";
						if(i==8) j="r";
						if(i==9) j="r";
						if(i==10) j="r";
						if(i==11) j="r";
						if(i==12) j="d";
						if(i==13) j="d";
						if(i==14) j="d";
						if(i==15) j="r";
						if(i==16) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("lounge") && !player.hasCard("kitchen") && !player.hasSeen("kitchen")) {
					//from lounge to kitchen
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("lounge to kitchen");
					String j=null;
					for(int i=0; i < 19 ; i++) {
						if(i==0) j="u";
						if(i==1) j="r";
						if(i==2) j="r";
						if(i==3) j="u";
						if(i==4) j="u";
						if(i==5) j="u";
						if(i==6) j="u";
						if(i==7) j="u";
						if(i==8) j="u";
						if(i==9) j="u";
						if(i==10) j="u";
						if(i==11) j="u";
						if(i==12) j="u";
						if(i==13) j="l";
						if(i==14) j="l";
						if(i==15) j="l";
						if(i==16) j="l";
						if(i==17) j="u";
						if(i==18) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("lounge") && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {
					//from lounge to billiard room
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("lounge to billiard room");
					String j=null;
					for(int i=0; i < 22 ; i++) {
						if(i==0) j="u";
						if(i==1) j="r";
						if(i==2) j="r";
						if(i==3) j="u";
						if(i==4) j="r";
						if(i==5) j="r";
						if(i==6) j="r";
						if(i==7) j="r";
						if(i==8) j="r";
						if(i==9) j="r";
						if(i==10) j="r";
						if(i==11) j="u";
						if(i==12) j="u";
						if(i==13) j="u";
						if(i==14) j="u";
						if(i==15) j="u";
						if(i==16) j="u";
						if(i==17) j="u";
						if(i==18) j="u";
						if(i==19) j="r";
						if(i==20) j="r";
						if(i==21) j="r";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("dining room") && !player.hasCard("lounge") && !player.hasSeen("lounge")) {
					//from dining room to lounge
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 4 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="d";
						if(i==3) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("dining room") && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) {
					//from dining room to ballroom
					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 7 ; i++) {
						if(i==0) j="r";
						if(i==1) j="r";
						if(i==2) j="u";
						if(i==3) j="u";
						if(i==4) j="u";
						if(i==5) j="u";
						if(i==6) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("dining room") && !player.hasCard("hall") && !player.hasSeen("hall")) {
					//from dining room to hall
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 8 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="r";
						if(i==6) j="r";
						if(i==7) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("dining room") && !player.hasCard("kitchen") && !player.hasSeen("kitchen")) {
					//from dining room to kitchen
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 11 ; i++) {
						if(i==0) j="r";
						if(i==1) j="u";
						if(i==2) j="u";
						if(i==3) j="u";
						if(i==4) j="u";
						if(i==5) j="l";
						if(i==6) j="l";
						if(i==7) j="l";
						if(i==8) j="l";
						if(i==9) j="u";
						if(i==10) j="u";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("dining room") && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) {
					//from dining room to billiard room
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("dining room to billiard room");
					String j=null;
					for(int i=0; i < 14; i++) {
						if(i==0) j="r";
						if(i==1) j="u";
						if(i==2) j="u";
						if(i==3) j="u";
						if(i==4) j="r";
						if(i==5) j="r";
						if(i==6) j="r";
						if(i==7) j="r";
						if(i==8) j="r";
						if(i==9) j="r";
						if(i==10) j="r";
						if(i==11) j="r";
						if(i==12) j="r";
						if(i==13) j="r";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("dining room") && !player.hasCard("library") && !player.hasSeen("library")) {
					//from dining room to 
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 14 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="r";
						if(i==6) j="r";
						if(i==7) j="r";
						if(i==8) j="r";
						if(i==9) j="r";
						if(i==10) j="r";
						if(i==11) j="r";
						if(i==12) j="u";
						if(i==13) j="r";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("dining room") && !player.hasCard("study") && !player.hasSeen("study")) {
					//from dining room to study
					if(!q.isEmpty()) {
						q.clear();
					}

					String j=null;
					for(int i=0; i < 17 ; i++) {
						if(i==0) j="d";
						if(i==1) j="d";
						if(i==2) j="r";
						if(i==3) j="r";
						if(i==4) j="r";
						if(i==5) j="r";
						if(i==6) j="r";
						if(i==7) j="r";
						if(i==8) j="r";
						if(i==9) j="r";
						if(i==10) j="r";
						if(i==11) j="r";
						if(i==12) j="d";
						if(i==13) j="d";
						if(i==14) j="d";
						if(i==15) j="r";
						if(i==16) j="d";
						q.add(j);
					}
				}else if(room.equalsIgnoreCase("dining room") && !player.hasCard("conservatory") && !player.hasSeen("conservatory")) {
					//from dining room to conservatory
					if(!q.isEmpty()) {
						q.clear();
					}
					//System.out.println("dining room to conservatory");
					String j=null;
					for(int i=0; i < 19 ; i++) {
						if(i==0) j="r";
						if(i==1) j="r";
						if(i==2) j="u";
						if(i==3) j="u";
						if(i==4) j="u";
						if(i==5) j="r";
						if(i==6) j="r";
						if(i==7) j="r";
						if(i==8) j="r";
						if(i==9) j="r";
						if(i==10) j="r";
						if(i==11) j="r";
						if(i==12) j="r";
						if(i==13) j="u";
						if(i==14) j="u";
						if(i==15) j="u";
						if(i==16) j="u";
						if(i==17) j="r";
						if(i==18) j="u";
						q.add(j);
					}
				}
				else if(room.equalsIgnoreCase("kitchen") && !player.hasCard("kitchen") && !player.hasSeen("kitchen")) {

					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 2; i++) {
						if(i==0) j="d";
						if(i==1) j="u";

						q.add(j);
					}
				}
				else if(room.equalsIgnoreCase("ballroom") && !player.hasCard("ballroom") && !player.hasSeen("ballroom")) 
				{

					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 2; i++) {
						if(i==0) j="l";
						if(i==1) j="r";
						q.add(j);
					}
				}
				else if(room.equalsIgnoreCase("conservatory") && !player.hasCard("conservatory") && !player.hasSeen("conservatory")) 
				{

					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 2; i++) {
						if(i==0) j="d";
						if(i==1) j="u";

						q.add(j);
					}
				}
				else if(room.equalsIgnoreCase("billiard room") && !player.hasCard("billiard room") && !player.hasSeen("billiard room")) 
				{

					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 2; i++) {
						if(i==0) j="l";
						if(i==1) j="r";

						q.add(j);
					}
				}
				else if(room.equalsIgnoreCase("library") && !player.hasCard("library") && !player.hasSeen("library")) 
				{

					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 2; i++) {
						if(i==0) j="l";
						if(i==1) j="r";

						q.add(j);
					}
				}
				else if(room.equalsIgnoreCase("study") && !player.hasCard("study") && !player.hasSeen("study")) 
				{

					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 2; i++) {
						if(i==0) j="u";
						if(i==1) j="d";

						q.add(j);
					}
				}
				else if(room.equalsIgnoreCase("hall") && !player.hasCard("hall") && !player.hasSeen("hall")) 
				{

					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 2; i++) {
						if(i==0) j="u";
						if(i==1) j="d";

						q.add(j);
					}
				}
				else if(room.equalsIgnoreCase("lounge") && !player.hasCard("lounge") && !player.hasSeen("lounge")) 
				{

					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 2; i++) {
						if(i==0) j="u";
						if(i==1) j="d";

						q.add(j);
					}
				}
				else if(room.equalsIgnoreCase("dining room") && !player.hasCard("dining room") && !player.hasSeen("dining room")) 
				{

					if(!q.isEmpty()) {
						q.clear();
					}
					String j=null;
					for(int i=0; i < 2; i++) {
						if(i==0) j="d";
						if(i==1) j="u";

						q.add(j);
					}
				}
			}
		}

		//System.out.println(q);
		room = "null";

		if(!q.isEmpty()) {
			String local = q.remove();
			return local;
		}


		return "l";
	}

	public String getSuspect() {
		// Add your code here
		//TODO: check case
		if(murderSuspect)
		{
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
				return "mustard";
			}
			if(!player.hasCard("peacock") && !player.hasSeen("peacock")) {
				return "peacock";
			}
		}
		else
		{
			Boolean found = false;
			while(!found)
			{
				int random = (int) (Math.random() * 6);

				if(!player.hasCard(Names.SUSPECT_NAMES[random]) && !player.hasSeen(Names.SUSPECT_NAMES[random])) {
					found = true;
					possSuspect = Names.SUSPECT_NAMES[random];
					return Names.SUSPECT_NAMES[random];
				}
			}
		}

		return Names.SUSPECT_NAMES[0];
	}

	public String getWeapon() {
		// Add your code here
		if(murderWeapon)
		{
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
			if(!player.hasCard("candlestick") && !player.hasSeen("candlestick")) {
				return "candlestick";
			}
			if(!player.hasCard("lead pipe") && !player.hasSeen("lead pipe")) {
				return "lead pipe";
			}
		}
		else
		{
			Boolean found = false;
			while(!found)
			{
				int random = (int) (Math.random() * 6);

				if(!player.hasCard(Names.WEAPON_NAMES[random]) && !player.hasSeen(Names.WEAPON_NAMES[random])) {
					found = true;
					possWeapon = Names.WEAPON_NAMES[random];
					return Names.WEAPON_NAMES[random];
				}
			}
		}
		return Names.WEAPON_NAMES[0];
	}

	public String getRoom() {//TODO: is hasSeen correct here?
		//		 Add your code here

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
		if(token.getRoom().hasName("ballroom") && murderRoom && murderSuspect && murderWeapon) { 
			//			//System.out.println("ballroom to cellar");
			return "2";
		}
		else if(token.getRoom().hasName("hall") && murderRoom && murderSuspect && murderWeapon) {
			//System.out.println("hall to cellar");
			return "2";
		}
		else if(token.getRoom().hasName("dining room") && murderRoom && murderSuspect && murderWeapon) {
			//System.out.println("dining to cellar");
			return "1";
		}
		else if(token.getRoom().hasName("library") && murderRoom && murderSuspect && murderWeapon){
			//			//System.out.println("lib to cellar");
			return "1";
		}
		else if(token.getRoom().hasName("billiard room") && murderRoom && murderSuspect && murderWeapon){
			//System.out.println("billiard to cellar");
			return "1";
		}
		else if(token.getRoom().hasName("ballroom") && !player.hasCard("conservatory") && !player.hasSeen("conservatory")) {
			//System.out.println("ballroom to conserv");
			return "4";
		}
		else if(token.getRoom().hasName("ballroom") && !player.hasCard("billiard room") && !player.hasSeen("billiard room")){
			//System.out.println("ballroom to billia");
			return "3";
		}
		else if(token.getRoom().hasName("ballroom") && !player.hasCard("kitchen") && !player.hasSeen("kitchen")){
			//System.out.println("ballroom to kitch");
			return "1";
		}
		else if(token.getRoom().hasName("ballroom") && !player.hasCard("dining room") && !player.hasSeen("dining room")){
			//System.out.println("ballroom to dining");
			return "2";
		}
		else if(token.getRoom().hasName("ballroom") && !player.hasCard("library") && !player.hasSeen("library")){
			//System.out.println("ballroom to lib");
			return "3";
		}
		else if(token.getRoom().hasName("ballroom") && !player.hasCard("hall") && !player.hasSeen("hall")){
			//System.out.println("ballroom to hall");
			return "2";
		}
		else if(token.getRoom().hasName("ballroom") && !player.hasCard("lounge") && !player.hasSeen("lounge")){
			//System.out.println("ballroom to lounge");
			return "2";
		}
		else if(token.getRoom().hasName("ballroom") && !player.hasCard("study") && !player.hasSeen("study")){
			//System.out.println("ballroom to study");
			return "3";
		}
		else if(token.getRoom().hasName("billiard room") && !player.hasCard("library") && !player.hasSeen("library")){
			//System.out.println("bill to lib");
			return "2";
		}
		else if(token.getRoom().hasName("billiard room")){
			//System.out.println("bill to ????");
			return "1";
		}
		else if(token.getRoom().hasName("library") && !player.hasCard("billiard room") && !player.hasSeen("billiard room")){
			//System.out.println("lib to bill");
			return "2";
		}
		else if(token.getRoom().hasName("library")){
			//System.out.println("lib to ???");
			return "1";
		}
		else if(token.getRoom().hasName("hall") && !player.hasCard("study") && !player.hasSeen("study")){
			//System.out.println("hall to study");
			return "3";
		}
		else if(token.getRoom().hasName("hall") && !player.hasCard("library") && !player.hasSeen("library")){
			//System.out.println("hall to lib");
			return "2";
		}
		else if(token.getRoom().hasName("hall") && !player.hasCard("lounge") && !player.hasSeen("lounge")){
			//System.out.println("hall to loung");
			return "1";
		}
		else if(token.getRoom().hasName("hall") && !player.hasCard("dining room") && !player.hasSeen("dining room")){
			//System.out.println("hall to dining");
			return "1";
		}
		else if(token.getRoom().hasName("hall") && !player.hasCard("ballroom") && !player.hasSeen("ballroom")){
			//System.out.println("hall to ball");
			return "1";
		}
		else if(token.getRoom().hasName("hall") && !player.hasCard("billiard room") && !player.hasSeen("billiard room")){
			//System.out.println("hall to bill");
			return "2";
		}
		else if(token.getRoom().hasName("hall") && !player.hasCard("kitchen") && !player.hasSeen("kitchen")){
			//System.out.println("hall to kitch");
			return "1";
		}
		else if(token.getRoom().hasName("hall") && !player.hasCard("conservatory") && !player.hasSeen("conservatory")){
			//System.out.println("hall to cons");
			return "2";
		}
		else if(token.getRoom().hasName("dining room") && !player.hasCard("lounge") && !player.hasSeen("lounge")){
			//System.out.println("dingn to loung");
			return "1";
		}
		else if(token.getRoom().hasName("dining room") && !player.hasCard("ballroom") && !player.hasSeen("ballroom")){
			//System.out.println("din to ball");
			return "2";
		}
		else if(token.getRoom().hasName("dining room") && !player.hasCard("hall") && !player.hasSeen("hall")){
			//System.out.println("din to hall");
			return "1";
		}
		else if(token.getRoom().hasName("dining room") && !player.hasCard("kitchen") && !player.hasSeen("kitchen")){
			//System.out.println("din to kitch");
			return "2";
		}
		else if(token.getRoom().hasName("dining room") && !player.hasCard("billiard room") && !player.hasSeen("billiard room")){
			//System.out.println("din to bill");
			return "2";
		}
		else if(token.getRoom().hasName("dining room") && !player.hasCard("library") && !player.hasSeen("library")){
			//System.out.println("din to lib");
			return "1";
		}
		else if(token.getRoom().hasName("dining room") && !player.hasCard("study") && !player.hasSeen("study")){
			//System.out.println("din to study");
			return "1";
		}
		else if(token.getRoom().hasName("Dining Room") && !player.hasCard("conservatory") && !player.hasSeen("conservatory")){
			//System.out.println("din to conservatory");
			return "2";
		}
		else //System.out.println(room+" to ?");

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
			return "mustard";
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
		if(player.hasCard("candlestick") && matchingCards.contains("candlestick")) {
			return "candlestick";
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

	public void notifyResponse(Log response) {
		// Add your code here
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void notifyPlayerName(String playerName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyTurnOver(String playerName, String position) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyQuery(String playerName, String query) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyReply(String playerName, boolean cardShown) {
		// TODO Auto-generated method stub

	}



}
