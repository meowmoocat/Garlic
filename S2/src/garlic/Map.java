package garlic;

/* created by
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

public class Map 
{
	private final static Rooms room = new Rooms();

	Map()
	{



	}

	public int enterRoom(Token token, int row, int col, int diceReturn) {

		for(Room room : room)
		{
			//checks if the token is in a door and moves to middle of room
			if((row == room.getDoor1().getRow() && col == room.getDoor1().getCol()) 
					|| (row == room.getDoor2().getRow() && col == room.getDoor2().getCol()) 
					|| (row == room.getDoor3().getRow() && col == room.getDoor3().getCol())
					|| (row == room.getDoor4().getRow() && col == room.getDoor4().getCol())
					|| (row == room.getSecretPassage().getRow() && col == room.getSecretPassage().getCol()))
			{
				if(room.getName().equals("Computer Science"))
				{
					token.middleRoom(token.getCompSciPosition()); //puts tokens in unique positions in rooms
				}
				if(room.getName().equals("O'Reilly Hall"))
				{
					token.middleRoom(token.getOReillyHallPosition());
				}
				if(room.getName().equals("Engineering"))
				{
					token.middleRoom(token.getEngineeringPosition());
				}	
				if(room.getName().equals("Sutherland"))
				{
					token.middleRoom(token.getSutherlandPosition());
				}
				if(room.getName().equals("Quinn"))
				{
					token.middleRoom(token.getQuinnPosition());
				}
				if(room.getName().equals("Newman"))
				{
					token.middleRoom(token.getNewmanPosition());
				}
				if(room.getName().equals("Library"))
				{
					token.middleRoom(token.getLibraryPosition());
				}
				if(room.getName().equals("Ag Science"))
				{
					token.middleRoom(token.getAgSciPosition());
				}
				if(room.getName().equals("O'Brien"))
				{
					token.middleRoom(token.getOBrienPosition());
				}
				return 0; //returns 0 to dice moves to end turn
			}
		}
		return diceReturn; //else returns diceMoves
	}

	//checks which room the tokens in
	//then moves token to choosen door
	public int exitRoom(Token token, int row, int col) {
		String command = "";

		//Comp Sci
		if(row == token.getCompSciPosition().getRow() && col == token.getCompSciPosition().getCol())
		{
			do {
				Moves.ui.displayString("Enter which door to exit, 1 for door, passage for the secret passage");
				command = Moves.ui.getCommand().toLowerCase().trim();
				for(Room room : room) {
					if(command.equals("1") && room.getName().equals("Computer Science")) {
						token.moveOutOfRoom(room.getDoor1Exit());
						return 1;
					}
					else if(command.equals("passage") && room.getName().equals("Computer Science"))
					{
						token.moveOutOfRoom(token.getNewmanPosition());
						return 2;
					}
				}
			}while(!command.equals("1") && !command.equals("passage"));
		}

		//engineering
		if(row == token.getEngineeringPosition().getRow() && col == token.getEngineeringPosition().getCol())
		{
			do {
				Moves.ui.displayString("Enter which door to exit, 1 for door, passage for the secret passage");
				command = Moves.ui.getCommand().toLowerCase().trim();
				for(Room room : room) {
					if(command.equals("1") && room.getName().equals("Engineering")) {
						token.moveOutOfRoom(room.getDoor1Exit());
						return 1;
					}
					else if(command.equals("passage") && room.getName().equals("Engineering"))
					{
						token.moveOutOfRoom(token.getAgSciPosition());
						return 2;
					}
				}
			}while(!command.equals("1") && !command.equals("passage"));
		}

		//library
		if(row == token.getLibraryPosition().getRow() && col == token.getLibraryPosition().getCol())
		{
			do {
				Moves.ui.displayString("Enter which door to exit, 1 for door on left, 2 middle, 3 right door");
				command = Moves.ui.getCommand().toLowerCase().trim();
				for(Room room : room) {
					if(command.equals("1") && room.getName().equals("Library")) {
						token.moveOutOfRoom(room.getDoor1Exit());
						return 1;
					}
					else if(command.equals("2") && room.getName().equals("Library")) {
						token.moveOutOfRoom(room.getDoor2Exit());
						return 1;
					}
					else if(command.equals("3") && room.getName().equals("Library"))
					{
						token.moveOutOfRoom(room.getDoor3Exit());
						return 1;
					}
				}
			}while(!command.equals("1") && !command.equals("2") && !command.equals("3"));
		}

		//ag sci
		if(row == token.getAgSciPosition().getRow() && col == token.getAgSciPosition().getCol())
		{
			do {
				Moves.ui.displayString("Enter which door to exit, 1 for door, passage for the secret passage");
				command = Moves.ui.getCommand().toLowerCase().trim();
				for(Room room : room) {
					if(command.equals("1") && room.getName().equals("Ag Science")) {

						token.moveOutOfRoom(room.getDoor1Exit());
						return 1;
					}
					else if(command.equals("passage") && room.getName().equals("Ag Science"))
					{
						token.moveOutOfRoom(token.getEngineeringPosition());
						return 2;
					}
				}
			}while(!command.equals("1") && !command.equals("passage"));
		}

		//newman
		if(row == token.getNewmanPosition().getRow() && col == token.getNewmanPosition().getCol())
		{
			do {
				Moves.ui.displayString("Enter which door to exit, 1 for door, passage for the secret passage");
				command = Moves.ui.getCommand().toLowerCase().trim();
				for(Room room : room) {
					if(command.equals("1") && room.getName().equals("Newman")) {
						token.moveOutOfRoom(room.getDoor1Exit());
						return 1;
					}
					else if(command.equals("passage") && room.getName().equals("Newman"))
					{
						token.moveOutOfRoom(token.getCompSciPosition());
						return 2;
					}
				}
			}while(!command.equals("1") && !command.equals("passage"));
		}

		//OBrien
		if(row == token.getOBrienPosition().getRow() && col == token.getOBrienPosition().getCol())
		{
			do {
				Moves.ui.displayString("Enter which door to exit, 1 south door, 2 for east door");
				command = Moves.ui.getCommand().toLowerCase().trim();
				for(Room room : room) {
					if(command.equals("1") && room.getName().equals("O'Brien")) {
						token.moveOutOfRoom(room.getDoor1Exit());
						return 1;
					}
					else if(command.equals("2") && room.getName().equals("O'Brien")) {
						token.moveOutOfRoom(room.getDoor2Exit());
						return 1;
					}
				}
			}while(!command.equals("1") && !command.equals("2"));
		}
		//		OReilly
		if(row == token.getOReillyHallPosition().getRow() && col == token.getOReillyHallPosition().getCol())
		{
			do {
				Moves.ui.displayString("Enter which door to exit, 1 for door on left, 2 middle left, 3 for middle right, 4 for right");
				command = Moves.ui.getCommand().toLowerCase().trim();
				for(Room room : room) {
					if(command.equals("1") && room.getName().equals("O'Reilly Hall")) {
						token.moveOutOfRoom(room.getDoor1Exit());
						return 1;
					}
					else if(command.equals("2") && room.getName().equals("O'Reilly Hall")) {
						token.moveOutOfRoom(room.getDoor2Exit());
						return 1;
					}
					else if(command.equals("3") && room.getName().equals("O'Reilly Hall")) {
						token.moveOutOfRoom(room.getDoor3Exit());
						return 1;
					}
					else if(command.equals("4") && room.getName().equals("O'Reilly Hall")) {
						token.moveOutOfRoom(room.getDoor4Exit());
						return 1;
					}
				}
			}while(!command.equals("1") && !command.equals("2") && !command.equals("3") && !command.equals("4"));
		}

		//quinn
		if(row == token.getQuinnPosition().getRow() && col == token.getQuinnPosition().getCol())
		{
			do {
				Moves.ui.displayString("Enter which door to exit, 1 for door on left, 2 for right door");
				command = Moves.ui.getCommand().toLowerCase().trim();
				for(Room room : room) {
					if(command.equals("1") && room.getName().equals("Quinn")) {
						token.moveOutOfRoom(room.getDoor1Exit());
						return 1;
					}
					else if(command.equals("2") && room.getName().equals("Quinn")) {
						token.moveOutOfRoom(room.getDoor2Exit());
						return 1;
					}
				}
			}while(!command.equals("1") && !command.equals("2"));
		}

		//sutherland
		if(row == token.getSutherlandPosition().getRow() && col == token.getSutherlandPosition().getCol())
		{
			do {
				Moves.ui.displayString("Enter which door to exit, 1 for door on left, 2 for right door");
				command = Moves.ui.getCommand().toLowerCase().trim();
				for(Room room : room) {
					if(command.equals("1") && room.getName().equals("Sutherland")) {
						token.moveOutOfRoom(room.getDoor1Exit());
						return 1;
					}
					else if(command.equals("2") && room.getName().equals("Sutherland")) {
						token.moveOutOfRoom(room.getDoor2Exit());
						return 1;
					}
				}
			}while(!command.equals("1") && !command.equals("2"));
		}
		return 0;
	}
}
