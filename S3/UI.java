package S3;

import javax.swing.*;

import garlic.Token;

import java.awt.*;

public class UI {

	private static final int FRAME_WIDTH = 1095;
	private static final int FRAME_HEIGHT = 700;

	private final BoardPanel boardPanel;
	private final InfoPanel infoPanel = new InfoPanel();
	private final CommandPanel commandPanel = new CommandPanel();
	private String input, playerName, tokenName, command, move;
	private int door;
	private boolean inputIsDone;

	UI(Tokens characters, Weapons weapons) {
		boardPanel = new BoardPanel(characters, weapons);
		JFrame frame = new JFrame();
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

	public void notes(Player player)
	{
		infoPanel.addText("Bleakley Plum: " + player.notes.getNoteBleakleyPlum());
		infoPanel.addText("Kelly White: " + player.notes.getNoteKellyWhite());
		infoPanel.addText("Caka Scarlett: " + player.notes.getNoteCakaScarlett());
		infoPanel.addText("Sweeney Green: " + player.notes.getNoteSweeneyGreen());
		infoPanel.addText("Kalra Mustard: " + player.notes.getNoteKalraMustard());
		infoPanel.addText("Delorey Peacock: " + player.notes.getNoteDeloreyPeacock());
		
		infoPanel.addText("\nComputer Science: " + player.notes.getNoteComputerScience());
		infoPanel.addText("O'Reilly Hall: " + player.notes.getNoteOReillyHall());
		infoPanel.addText("Engineering: " + player.notes.getNoteEngineering());
		infoPanel.addText("Sutherland: " + player.notes.getNoteSutherland());
		infoPanel.addText("Quinn: " + player.notes.getNoteQuinn());
		infoPanel.addText("Newman: " + player.notes.getNoteNewman());
		infoPanel.addText("Library: " + player.notes.getNoteLibrary());
		infoPanel.addText("Ag Science: " + player.notes.getNoteAgScience());
		infoPanel.addText("O'Brien: " + player.notes.getNoteOBrien());
		
		infoPanel.addText("\nBook: " + player.notes.getNoteBook());
		infoPanel.addText("Bored: " + player.notes.getNoteBored());
		infoPanel.addText("Gradcap: " + player.notes.getNoteGradcap());
		infoPanel.addText("Librocop: " + player.notes.getNoteLibrocop());
		infoPanel.addText("Microscope: " + player.notes.getNoteMicroscope());
		infoPanel.addText("Seagull: " + player.notes.getNoteSeagull());
	}
	
	public void display() {
		boardPanel.refresh();
	}

	public void displayString(String string) {
		infoPanel.addText(string);
	}

	public void displayDice(Player player, Dice dice) {
		displayString(player + " rolls " + dice + ".");
	}

	/* Display Error Messages */

	private void displayError(String message) {
		displayString("Error: " + message + ".");
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

	/* User Input Methods */

	private void inputString() {
		input = commandPanel.getCommand();
	}

	public void inputName(Players playersSoFar) {
		boolean valid = false;
		inputIsDone = false;
		do {
			if (playersSoFar.size() < 2) {
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
			} else if (playersSoFar.size() >= 2 && playerName.toLowerCase().equals("done")) {
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
			
			//display characters left to choose from
			for(S3.Token token : tokens)//checks if the character has already been taken
			{
				if(!token.isOwned())
				{
					displayString(token.getName());
				}
			}
			
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
			if (command.equals("quit") || command.equals("done") || command.equals("roll") || command.equals("passage")
					|| command.equals("help") || command.equals("cheat") || command.equals("notes")) {
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

	public int getDoor() {
		return door;
	}
	
	public void refreshInfoPanel() {
		infoPanel.refresh();
		
	}

}
