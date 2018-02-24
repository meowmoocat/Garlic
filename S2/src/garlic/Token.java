package garlic;

/* created by
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import java.awt.*;

public class Token {

	private final String name;
	private final Color color;
	private final Coordinates position;
	private int turn;
	private String playerName="";
	private final Coordinates compSciPosition;
	private final Coordinates oReillyHallPosition;
	private final Coordinates engineeringPosition;
	private final Coordinates sutherlandPosition;
	private final Coordinates quinnPosition;
	private final Coordinates newmanPosition;
	private final Coordinates libraryPosition;
	private final Coordinates agSciPosition;
	private final Coordinates oBrienPosition;

	//creates instance of token with coordinates for position and room positions
	Token(String name, Color color, Coordinates position, 
			Coordinates compSciPosition, Coordinates oReillyHallPosition, Coordinates engineeringPosition, 
			Coordinates sutherlandPosition, Coordinates quinnPosition, Coordinates newmanPosition, 
			Coordinates libraryPosition, Coordinates agSciPosition, Coordinates oBrienPosition) {
		this.name = name;
		this.color = color;
		this.position = position;
		this.compSciPosition = compSciPosition;
		this.oReillyHallPosition = oReillyHallPosition;
		this.engineeringPosition = engineeringPosition;
		this.sutherlandPosition = sutherlandPosition;
		this.quinnPosition = quinnPosition;
		this.newmanPosition = newmanPosition;
		this.libraryPosition = libraryPosition;
		this.agSciPosition = agSciPosition;
		this.oBrienPosition = oBrienPosition;
	}

	//sets the turn for that token based on when that character was chosen
	public void setTurn(int turn)
	{
		this.turn = turn;
	}

	//moves token by chosen coordinates
	public int moveBy(Coordinates move) {
		return position.add(move);
	}

	//moves token to middle of room
	public void middleRoom(Coordinates move)
	{
		position.moveToRoom(move);
	}

	//moves token to position to move out of the room
	public void moveOutOfRoom(Coordinates move)
	{
		position.moveToExit(move);
	}

	//returns the character name
	public String getName() {
		return name;
	}

	//returns the turn value
	public int getTurn()
	{
		return turn;
	}

	//returns color set to token
	public Color getColor() {
		return color;
	}

	//returns tokens current position
	public Coordinates getPosition() {
		return position;
	}

	//checks if string is equal to characters name
	public boolean hasName(String name) {
		return this.name.toLowerCase().equals(name.toLowerCase().trim());
	}

	//sets players name e.g. john
	public void setPlayerName(String pName)
	{
		this.playerName = pName;
	}

	//returns players name
	public String getPlayerName()
	{
		return playerName;
	}

	//returns tokens column position
	public int getTokenCol() {
		return position.getCol();
	}

	//returns tokens row position
	public int getTokenRow() {
		return position.getRow();
	}

	public Coordinates getCompSciPosition() {
		return compSciPosition;
	}

	public Coordinates getOReillyHallPosition() {
		return oReillyHallPosition;
	}

	public Coordinates getEngineeringPosition() {
		return engineeringPosition;
	}

	public Coordinates getSutherlandPosition() {
		return sutherlandPosition;
	}

	public Coordinates getQuinnPosition() {
		return quinnPosition;
	}

	public Coordinates getNewmanPosition() {
		return newmanPosition;
	}

	public Coordinates getLibraryPosition() {
		return libraryPosition;
	}

	public Coordinates getAgSciPosition() {
		return agSciPosition;
	}

	public Coordinates getOBrienPosition() {
		return oBrienPosition;
	}

}
