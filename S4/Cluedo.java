package S4;

import java.util.ArrayList;

/* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

public class Cluedo {

	private static final int MAX_NUM_PLAYERS = 6;

	private final Tokens tokens = new Tokens();
	private final Players players = new Players();
	private final Dice dice = new Dice();
	private final Map map = new Map();
	private final Weapons weapons = new Weapons(map);
	private final UI ui = new UI(tokens,weapons);
	private final Deck deck = new Deck();
	private boolean moveOver;
	private boolean enteredRoom;
	private boolean gameWon;
	private boolean enteredPassage;
	private Player currentPlayer;
	private Token currentToken;
	private Room passageDestination;
	private int counterForWin;
	private int numPlayers;


	private void announceTheGame() {
		ui.displayMurderAnnouncement();
	}

	private void inputPlayerNames() {
		//		int numPlayersSoFar = 0;
		numPlayers = 0;
		counterForWin = 0;
		do {
			ui.inputName(players);
			if (!ui.inputIsDone()) {
				ui.inputToken(tokens);
				Token token = tokens.get(ui.getTokenName());
				players.add(new Player(ui.getPlayerName(),token));
				token.setOwned();
				numPlayers++;
			}
		} while (!ui.inputIsDone() && numPlayers<MAX_NUM_PLAYERS);
		ui.refreshInfoPanel();
	}

	private void rollToStart() {
		Players playersToRoll = new Players(players), playersWithHighRoll = new Players();
		boolean tie = false;
		do {
			int highRoll = 0;
			for (Player player : playersToRoll) {
				dice.roll();
				ui.displayDice(player,dice);
				if (dice.getTotal() > highRoll) {
					tie = false;
					highRoll = dice.getTotal();
					playersWithHighRoll.clear();
					playersWithHighRoll.add(player);
				} else if (dice.getTotal() == highRoll) {
					tie = true;
					playersWithHighRoll.add(player);
				}
			}
			if (tie) {
				ui.displayRollDraw();
				playersToRoll = new Players(playersWithHighRoll);
				playersWithHighRoll.clear();
			}
		} while (tie);
		players.setCurrentPlayer(playersWithHighRoll.get(0).getName());
		ui.displayRollWinner(players.getCurrentPlayer());
		ui.display();
	}

	private void dealCards() {
		deck.selectMurderCards();
		deck.prepareToDeal(players.getNumberOfPlayers());
		for (Player player : players) {
			player.addCards(deck.dealCards());
		}
		ui.displayCardsDealt();
	}

	private void roll() {
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
						currentPlayer.setInRoom(newPosition);
						Room room = map.getRoom(newPosition);
						currentToken.enterRoom(room);
						if(!room.getName().equalsIgnoreCase("Lake")) enteredRoom = true;
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
	}

	private void passage() {
		if (!moveOver) {
			if (currentToken.isInRoom() && currentToken.getRoom().hasPassage()) {
				passageDestination = currentToken.getRoom().getPassageDestination();
				currentToken.leaveRoom();
				currentToken.enterRoom(passageDestination);
				moveOver = true;
				enteredRoom = true;
				enteredPassage = true;
				ui.display();
			} else {
				ui.displayErrorNoPassage();
			}
		} else {
			ui.displayErrorAlreadyMoved();
		}
	}

	private void question() {
		boolean questions = moveOver;
		String possSuspect;
		String possWeapon;
		String possRoom;

		Player questionedPlayer;

		Players playersQuestions =  new Players(players);

		if(enteredRoom)
		{
			ui.displayNotes(currentPlayer, deck);
			possSuspect=ui.inputTokenGuess(currentPlayer,tokens);
			possWeapon=ui.inputWeaponGuess(currentPlayer,weapons);
			possRoom=currentToken.getRoom().getName();
			// TODO move token and player

			ui.setLog("\n"+currentPlayer.getName() + " asked:");
			ui.setLog("Was it " + possSuspect);
			ui.setLog("With the "+possWeapon);
			ui.setLog("In "+possRoom);

			//moves suspect token to room
			Token moveToken = tokens.get(possSuspect);
			Weapon moveWeapon = weapons.get(possWeapon);

			if(!currentPlayer.getName().equalsIgnoreCase(possSuspect))
			{
				if(enteredPassage)
				{
					if(moveToken.isInRoom())
					{
						moveToken.leaveRoom();
					}
					moveToken.enterRoom(passageDestination);
				}
				else
				{
					if(moveToken.isInRoom())
					{
						moveToken.leaveRoom();
					}
					Coordinates destination = currentPlayer.getInRoom();
					Room room = map.getRoom(destination);
					moveToken.enterRoom(room);
				}
			}
			for(Weapon weapon : weapons)
			{
				if(weapon.getPosition().equals(currentToken.getRoom().addWeapon()))
				{


				}
			}
			ui.display();
			playersQuestions.setCurrentPlayer(currentPlayer.getName());
			playersQuestions.turnOver();

			do
			{
				questionedPlayer = playersQuestions.getCurrentPlayer();
				if (questionedPlayer != currentPlayer) {
					ui.refreshInfoPanel();
					ui.displayAccused(possSuspect, possWeapon, possRoom);
					ui.inputConfirm(questionedPlayer);
					//input confirm
					questions = checkDeck(questionedPlayer,possSuspect,possWeapon,possRoom);
					//input done
					ui.inputDone(questionedPlayer);
					playersQuestions.turnOver();
				}
			}while(questions && questionedPlayer != currentPlayer);
			ui.refreshInfoPanel();
			//make sure it's valid - only when entering a room

			//input suspect, weapon, and what room they're in

			//move suspect and weapon into room(swap weapon)

			//loops between other players
		}
		else
		{
			ui.displayErrorQuestion();
		}
	}

	private boolean checkDeck(Player questionedPlayer, String possSuspect, String possWeapon, String possRoom) {
		String choice;
		if(questionedPlayer.hasCard(possSuspect) || questionedPlayer.hasCard(possWeapon) || questionedPlayer.hasCard(possRoom))
		{
			if(questionedPlayer.hasCard(possSuspect) && questionedPlayer.hasCard(possWeapon) && questionedPlayer.hasCard(possRoom))
			{
				ui.displayViewChoice3(currentPlayer, possSuspect, possWeapon, possRoom);
				choice = ui.inputCardChoice(possSuspect, possWeapon, possRoom);
				currentPlayer.addViewedCards(deck.viewedCards(currentPlayer, questionedPlayer.getCard(choice)));
				//choose which to add to questioners notes
			}
			else if(questionedPlayer.hasCard(possSuspect) && questionedPlayer.hasCard(possWeapon))
			{
				ui.displayViewChoice2(currentPlayer, possSuspect, possWeapon);
				choice = ui.inputCardChoice(possSuspect, possWeapon, possRoom);
				currentPlayer.addViewedCards(deck.viewedCards(currentPlayer, questionedPlayer.getCard(choice)));
			}
			else if(questionedPlayer.hasCard(possSuspect) && questionedPlayer.hasCard(possRoom))
			{
				ui.displayViewChoice2(currentPlayer, possSuspect, possRoom);
				choice = ui.inputCardChoice(possSuspect, possWeapon, possRoom);
				currentPlayer.addViewedCards(deck.viewedCards(currentPlayer, questionedPlayer.getCard(choice)));
			}
			else if(questionedPlayer.hasCard(possWeapon) && questionedPlayer.hasCard(possRoom))
			{
				ui.displayViewChoice2(currentPlayer, possWeapon, possRoom);
				choice = ui.inputCardChoice(possSuspect, possWeapon, possRoom);
				currentPlayer.addViewedCards(deck.viewedCards(currentPlayer, questionedPlayer.getCard(choice)));
			}
			else if(questionedPlayer.hasCard(possSuspect))
			{
				ui.displayViewed(currentPlayer, possSuspect);
				currentPlayer.addViewedCards(deck.viewedCards(currentPlayer, questionedPlayer.getCard(possSuspect)));
			}
			else if(questionedPlayer.hasCard(possWeapon))
			{
				ui.displayViewed(currentPlayer, possWeapon);
				currentPlayer.addViewedCards(deck.viewedCards(currentPlayer, questionedPlayer.getCard(possWeapon)));
			} 
			else if(questionedPlayer.hasCard(possRoom))
			{
				ui.displayViewed(currentPlayer, possRoom);
				currentPlayer.addViewedCards(deck.viewedCards(currentPlayer, questionedPlayer.getCard(possRoom)));
			}

			ui.setLog(questionedPlayer.getName() + " answered.");
			return false;
		}
		ui.displayErrorNoCardsToView();
		//TODO: input line to sign off
		return true;
	}


	private boolean accuse() {
		String guessSuspect;
		String guessWeapon;
		String guessRoom;

		if(currentToken.getRoom().getName().equalsIgnoreCase(Names.ROOM_NAMES[9]))
		{
			ui.displayNotes(currentPlayer, deck);
			guessSuspect=ui.inputTokenGuess(currentPlayer,tokens);
			guessWeapon=ui.inputWeaponGuess(currentPlayer,weapons);
			guessRoom = ui.inputRoomGuess(currentPlayer);

			if(deck.getMurderCards().contains(guessSuspect)
					&& deck.getMurderCards().contains(guessWeapon)
					&& deck.getMurderCards().contains(guessRoom))
			{
				gameWon=true;
				ui.youWon(currentPlayer);
			}
			//else player is out of the game
			else
			{
				ui.youLost(currentPlayer);
				ui.inputDone(currentPlayer);
				//TODO add an input
				counterForWin++;
				currentPlayer.setAccuseGuessed(true);
				ui.refreshInfoPanel();
			}
			return true;

		}
		else
		{
			//ui.display(need to be in the lake to accuse)
			ui.displayErrorNotLake();
			return false;
		}
		//check murder cards if true that player wins
		// if wrong that player has no more turns

		//maybe return boolean turn over is false and player.turnOver()
	}

	private void takeTurns() {
		boolean turnOver, gameOver = false;
		do {
			turnOver = false;
			moveOver = false;
			enteredRoom = false;
			enteredPassage = false;
			do {
				currentPlayer = players.getCurrentPlayer();
				currentToken = currentPlayer.getToken();
				if(counterForWin==numPlayers-1 && !currentPlayer.getAccuseGuessed())
				{
					gameWon = true;
					turnOver = true;
					ui.youWon(currentPlayer);
				}
				else if(!currentPlayer.getAccuseGuessed())
				{
					ui.inputCommand(currentPlayer);
					switch (ui.getCommand()) {
					case "roll": {
						roll();
						break;
					}
					case "passage": {
						passage();
						break;
					}
					case "notes": {
						ui.displayNotes(currentPlayer, deck);
						break;
					}
					case "cheat" : {
						ui.displaySolution(deck.getMurderCards());
						break;
					}
					case "help" : {
						ui.displayHelp(currentToken, moveOver, enteredRoom);
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
					case "question": {
						question();
						enteredRoom = false;
						break;
					}
					case "accuse": {
						turnOver = accuse();
						break;
					}
					case "log": {
						ui.getLog();
						break;
					}
					}
				}
				else
				{
					turnOver = true;
				}
			} while (!turnOver);
			if (!gameOver && !gameWon) {
				players.turnOver();
			}
		} while (!gameOver && !gameWon);
	}

	public static void main(String[] args) {
		Cluedo game = new Cluedo();
		game.announceTheGame();
		game.inputPlayerNames();
		game.dealCards();
		game.rollToStart();
		game.takeTurns();
		//		System.exit(0);
	}
}
