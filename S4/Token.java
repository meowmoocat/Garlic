package S4; 

/* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import java.awt.*;

public class Token {

	private final String name;
	private final Color color;
	private Coordinates position;
	private boolean isInRoom = false, isOwned = false;//is owned is set to true if a person chooses to play as that character
	private Room room;

	Token(String name, Color color, Coordinates position) {
		this.name = name;
		this.color = color;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public boolean hasName(String name) {
		return this.name.toLowerCase().contains(name.toLowerCase().trim());
	}

	public Color getColor() {
		return color;
	}

	public void setPosition(Coordinates position) {
		this.position = position;
	}

	public Coordinates getPosition() {
		return position;
	}

	//adds token to room
	public void enterRoom(Room room) {
		this.room = room;
		position = this.room.addToken();
		isInRoom = true;
	}

	//moves token to door to leave if the player has to choose a door
	public void leaveRoom(int doorIndex) {
		room.removeItem(position);
		position = room.getDoorCoordinates(doorIndex);
		isInRoom = false;
	}

	//moves token to door to leave
	public void leaveRoom() {
		room.removeItem(position);
		position = room.getDoorCoordinates(0);
		isInRoom = false;
	}

	public Room getRoom() {
		return room;
	}

	public boolean isInRoom() {
		return isInRoom;
	}

	public void setOwned() {
		isOwned = true;
	}

	public boolean isOwned() {
		return isOwned;
	}
}
