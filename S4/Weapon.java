package S4; 

public class Weapon {

	private final String name;
	private Coordinates position;
	private Room room;

	Weapon(String name, Room room) {
		this.name = name;
		position = room.addWeapon();
		this.room = room;
	}

	public String getName() {
		return name;
	}

	public Coordinates getPosition() {
		return position;
	}

	public void setPosition(Room room)
	{
		position = room.addWeapon();
	}

	public boolean hasName(String name) {
		return this.name.toLowerCase().contains(name.toLowerCase().trim());
	}

	public void enterRoom(Room room) {
		this.room = room;
		position = this.room.addWeapon();
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room)
	{
		this.room = room;
	}

}
