package S3;

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
	private boolean isInRoom = false, isOwned = false;
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

	public void enterRoom(Room room) {
		this.room = room;
		position = this.room.addItem();
		isInRoom = true;
	}

	public void leaveRoom(int doorIndex) {
		room.removeItem(position);
		position = room.getDoorCoordinates(doorIndex);
		isInRoom = false;
	}

	public void leaveRoom() {
		room.removeItem(position);
		position = room.getDoorCoordinates(0);
		isInRoom = false;
	}

	public Room getRoom() {
		return room;
	}

	//returns true if in room
	public boolean isInRoom() {
		return isInRoom;
	}

	//sets owned to true if a player is chosen
	public void setOwned() {
		isOwned = true;
	}

	//returns true if player was chosen
	public boolean isOwned() {
		return isOwned;
	}
}
