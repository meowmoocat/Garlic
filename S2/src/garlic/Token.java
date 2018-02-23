package garlic;

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

	public void setTurn(int turn)
	{
		this.turn = turn;
	}

	public int moveBy(Coordinates move) {
		System.out.println("pos row: " + position.getRow() +", col: " +position.getCol());
		return position.add(move);
	}
	public void middleRoom(Coordinates move)
	{
		System.out.println("move row: " + move.getRow() +", col: " +move.getCol());
		System.out.println("pos row: " + position.getRow() +", col: " +position.getCol());
		position.moveToRoom(move);
	}

	public String getName() {
		return name;
	}

	public int getTurn()
	{
		return turn;
	}

	public Color getColor() {
		return color;
	}

	public Coordinates getPosition() {
		return position;
	}

	public boolean hasName(String name) {
		return this.name.toLowerCase().equals(name.toLowerCase().trim());
	}

	public void setPlayerName(String pName)
	{
		this.playerName = pName;
	}

	public String getPlayerName()
	{
		return playerName;
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