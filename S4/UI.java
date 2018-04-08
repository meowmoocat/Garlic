package S4; 

/* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI {

	private static final int FRAME_WIDTH = 1095;
	private static final int FRAME_HEIGHT = 700;

	private final BoardPanel boardPanel;
	private final InfoPanel infoPanel;
	private final CommandPanel commandPanel;
	private String input, playerName, tokenName, command, move;
	private int door;
	private boolean inputIsDone;
	private final ArrayList<String> log = new ArrayList<>();

	UI(Tokens characters, Weapons weapons) {
		JFrame frame = new JFrame();
		infoPanel = new InfoPanel();
		commandPanel = new CommandPanel();
		boardPanel = new BoardPanel(characters, weapons);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("UCD Cluedo");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(boardPanel, BorderLayout.LINE_START);
		frame.add(infoPanel, BorderLayout.LINE_END);
		frame.add(commandPanel,BorderLayout.PAGE_END);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	/* Display Methods */

	public void display() {
		boardPanel.refresh();
	}

	private void displayString(String string) {
		infoPanel.addText(string);
	}

	//string displayed when questioned player has all three cards asked
	public void displayViewChoice3(Player player, String name1, String name2, String name3)
	{
		displayString("Choose to show "+player.getName()+" the "+name1+", "+name2+" or "+name3+" card.");
	}

	//string displayed when questioned player has two of the cards asked
	public void displayViewChoice2(Player player, String name1, String name2)
	{
		displayString("Choose to show "+player.getName()+" the "+name1+" or "+name2+" card.");
	}

	//string displayed when questioned player has one of the cards asked
	public void displayViewed(Player player, String cardName)
	{
		displayString(player.getName()+ " has viewed your card for " + cardName);
	}

	//displays guess
	public void displayAccused(String token, String weapon, String room)
	{
		displayString("Suspect token: " + token);
		displayString("Suspect weapon: " + weapon);
		displayString("Suspect room: " + room);
	}

	public void displayMurderAnnouncement() {
		displayString("WELCOME TO CLUEDO");
		displayString("A murder has been committed.");
		displayString("You must solve the case.");
		displayString("Mouse click image to remove intro screen.");
	}

	public void displayCardsDealt() {
		displayString("The cards have been dealt.");
	}

	public void displayDice(Player player, Dice dice) {
		displayString(player + " rolls " + dice + ".");
	}

	public void displayRollDraw() {
		displayString("Draw.");
	}

	public void displayRollWinner(Player player) {
		displayString(player + " wins the roll.");
	}

	private void displayNote(Player player, Deck deck, String cardName) {
		String displayName = String.format("%-18s",cardName);
		if (player.hasCard(cardName)) {
			displayString(displayName + "X");
		} else if (deck.isSharedCard(cardName)) {
			displayString(displayName + "A");
		} else if (player.isViewedCard(cardName)) {
			displayString(displayName + "V");
		}else {
			displayString(displayName + ".");
		}
	}

	public void displayNotes(Player player, Deck deck) {
		displayString("\n\t*****Detective Notes*****");
		displayString("\nSUSPECTS");
		for (String cardName : Names.SUSPECT_NAMES) {
			displayNote(player, deck, cardName);
		}
		displayString("\nWEAPONS");
		for (String cardName : Names.WEAPON_NAMES) {
			displayNote(player, deck, cardName);
		}
		displayString("\nROOMS");
		for (String cardName : Names.ROOM_CARD_NAMES) {
			displayNote(player, deck, cardName);
		}
	}

	//displays cheat string
	public void displaySolution(Cards cards) {
		displayString("The solutions is: " + cards);
	}

	public void displayHelp(Player currentPlayer, Token currentToken, boolean moveOver, boolean enteredRoom) {
		displayString("Available Commands:");
		//if in corridor - roll, cheat, done, exit, notes
		if(!currentToken.isInRoom())
		{
			displayString("Possible inputs:\n'roll' - rolls dice to move"
					+ "\n'cheat' - views cards in murder envelope\n'done' - ends turn"
					+ "\n'quit' - ends game\n'notes' - view notes\n'log' - view log");
		}
		//if entered room - done, exit, notes, (accuse)
		else if(currentToken.isInRoom() && moveOver == true)
		{
			displayString("Possible inputs:\n'cheat' - views cards in murder envelope"
					+ "\n'done' - ends turn\n'quit' - ends game\n'notes' - view notes\n'log' - view log");

			if(enteredRoom == true && !currentToken.getRoom().getName().equalsIgnoreCase(Names.ROOM_NAMES[9]))
			{
				displayString("'question' - posing a question to the players");
			}
			if(currentToken.getRoom().getName().equalsIgnoreCase(Names.ROOM_NAMES[9]))
			{
				displayString("'accuse' - checking the murder envelope");
			}
		}
		//if start turn room - notes, roll, done, exit, (passage)
		else if(currentToken.isInRoom() && moveOver == false)
		{
			displayString("Possible inputs:\n'roll' - rolls dice to move"
					+ "\n'cheat' - views cards in murder envelope\n'done' - ends turn"
					+ "\n'quit' - ends game\n'notes' - view notes\n'log' - view log");
			if(currentToken.getRoom().hasPassage())
			{
				displayString("'passage' - move through secret passage");
			}
		}
		if(currentPlayer.getCalledInToRoom())//player pulled to a room by question is allowed to stay in that room and ask a question
		{
			displayString("'question' - posing a question to the players");
		}

	}

	/* Display Error Messages */

	private void displayError(String message) {
		displayString("Error: " + message + ".");
	}

	public void displayErrorNoCardsToView()
	{
		displayError("No cards to show");
	}

	public void displayErrorNotADoor() {
		displayError("Not a door");
	}

	public void displayErrorInvalidMove() {
		displayError("Invalid move");
	}

	public void displayErrorAlreadyMoved() {
		displayError("Already moved this turn");
	}

	public void displayErrorNoPassage() {
		displayError("Not in a room with a passage");
	}

	public void displayErrorQuestion() {
		displayError("Can't ask Question at this time");
	}

	public void displayErrorNotLake() {
		displayError("Go to the lake if you want to accuse");
	}

	private void inputString() {
		input = commandPanel.getCommand();
	}

	public void inputName(Players playersSoFar) {
		boolean valid = false;
		inputIsDone = false;
		do {
			if (playersSoFar.getNumberOfPlayers() < 2) {
				displayString("Enter new player name:");
			} else {
				displayString("Enter new player name or done:");
			}
			inputString();
			displayString("> " + input);
			playerName = input.trim();
			if (playerName.isEmpty()) {
				displayError("Name is blank");
			} else if (playersSoFar.contains(playerName)) {
				displayError("Same name used twice");
			} else if (playersSoFar.getNumberOfPlayers() >= 2 && playerName.toLowerCase().equals("done")) {
				valid = true;
				inputIsDone = true;
			} else {
				valid = true;
			}
		} while (!valid);
	}

	public String getPlayerName() {
		return playerName;
	}

	public void inputToken(Tokens tokens) {
		boolean valid = false;
		do {
			displayString("Enter your character name:");
			inputString();
			displayString("> " + input);
			tokenName = input.trim().toLowerCase();
			if (tokens.contains(tokenName)) {
				if (!tokens.get(tokenName).isOwned()) {
					valid = true;
				} else {
					displayError("Character name already in use");
				}
			} else {
				displayError("Not a valid character name");
			}
		} while (!valid);
	}

	public String getTokenName() {
		return tokenName;
	}

	public boolean inputIsDone() {
		return inputIsDone;
	}

	public void inputCommand(Player player) {
		boolean valid = false;
		do {
			displayString(player + " type your command:");
			inputString();
			displayString("> " + input);
			command = input.trim().toLowerCase().replaceAll("( )+", " ");
			if (command.matches("quit|done|roll|passage|notes|cheat|help|question|accuse|log")) {
				valid = true;
			} else {
				displayError("No such command");
			}
		} while (!valid);
	}

	public String getCommand() {
		return command;
	}

	public void inputMove(Player player, int moveNumber, int movesAvailable) {
		boolean valid = false;
		do {
			displayString(player + " enter move " + moveNumber + " of " + movesAvailable + ":");
			inputString();
			displayString("> " + input);
			move = input.trim().toLowerCase();
			if (move.matches("[udlr]")) {
				valid = true;
			} else {
				displayError("Move must be u, d, l or r");
			}
		} while (!valid);
	}

	public String getMove() {
		return move;
	}

	public void inputDoor(Player player) {
		boolean valid = false;
		do {
			displayString(player + " enter door number:");
			inputString();
			displayString("> " + input);
			input = input.trim();
			if (input.matches("[1234]")) {
				door = Integer.valueOf(input);
				valid = true;
			} else {
				displayError("Input must be a number");
			}
		} while (!valid);
	}

	public String inputTokenGuess(Player player, Tokens token) {
		boolean valid = false;
		do {
			displayString("Enter the suspect token: ");
			inputString();
			displayString("> " + input);
			input = input.trim();
			if(token.contains(input))
			{
				valid = true;
				input = token.get(input).getName();
			}
			else
			{
				displayError("Not a valid character name");
			}
		} while(!valid);
		return input;
	}

	public String inputWeaponGuess(Player player, Weapons weapons) {
		boolean valid = false;
		do {
			displayString("Enter the murder weapon: ");
			inputString();
			displayString("> " + input);
			input = input.trim();
			if(weapons.contains(input))
			{
				valid = true;
				input = weapons.get(input).getName();
			}
			else
			{
				displayError("Not a valid weapon name");
			}
		} while(!valid);
		return input;
	}

	public String inputRoomGuess(Player player) {
		boolean valid = false;
		do {
			displayString("Enter the murder room: ");
			inputString();
			displayString("> " + input);
			input = input.trim();
			int counter = 0;
			for(int i=0; i<Names.ROOM_CARD_NAMES.length; i++)
			{
				if(input.equalsIgnoreCase(Names.ROOM_CARD_NAMES[i]))
				{
					valid = true;
					input = Names.ROOM_CARD_NAMES[i];
				}
				else if(counter==Names.ROOM_CARD_NAMES.length-1)
				{
					displayError("Not a valid room name");
				}
				else
				{
					counter++;
				}
			}
		} while(!valid);
		return input;
	}

	public String inputCardChoice(String suspect, String weapon, String room)
	{
		boolean valid = false;
		do {
			displayString("Enter the card name: ");
			inputString();
			displayString("> " + input);
			input = input.trim().toLowerCase();
			for(int i=0; i<Names.ALL_NAMES.length; i++)
			{
				if(input.equalsIgnoreCase(Names.ALL_NAMES[i]))
				{
					if(!input.equalsIgnoreCase(room) || 
							!input.equalsIgnoreCase(suspect) || 
							!input.equalsIgnoreCase(weapon))
					{
						valid = true;
						input = Names.ALL_NAMES[i];
					}
					else
					{
						displayError("Not a valid card name");
					}
				}

			}
		} while(!valid);
		return input;
	}

	public void inputConfirm(Player player) {
		do
		{
			displayString(player+ ": Enter confirm to confirm changeover: ");
			inputString();
			displayString("> " + input);
			input = input.trim();
		} while(!input.equals("confirm"));
	}

	public int getDoor() {
		return door;
	}

	public void refreshInfoPanel() {
		infoPanel.refresh();

	}

	public void setLog(String string)
	{
		log.add(string);
	}

	public void getLog()
	{

		StringBuilder sb = new StringBuilder();
		for(String s : log)
		{
			sb.append(s);
			sb.append("\n");
		}
		displayString(sb.toString());
	}

	public void youLost(Player currentPlayer)
	{
		displayString("\n"+currentPlayer.getName()+" you guessed wrong!!!\nYou're out of the game, go home!!");
	}

	public void youWon(Player currentPlayer) {
		displayString("\n\n\n\n\n\n\n\t\t"+currentPlayer.getName()+" won the game!!!!!\n\t\tFinally!!!!!!");
	}

	public void inputDone(Player player) {
		do
		{
			displayString(player+ ": Enter done to confirm changeover: ");
			inputString();
			displayString("> " + input);
			input = input.trim();
		} while(!input.equals("done"));

	}

}
