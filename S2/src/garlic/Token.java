package garlic;

import java.awt.*;

public class Token {

	private final String name;
	private final Color color;
	private final Coordinates position;
	private final int turn;
	private String playerName="";

	Token(String name, int turn , Color color, Coordinates position) {
		this.name = name;
		this.color = color;
		this.position = position;
		this.turn = turn;
	}

	public void moveBy(Coordinates move) {
		position.add(move);
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

}