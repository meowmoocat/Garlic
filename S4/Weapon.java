package S4; 

public class Weapon {

	private final String name;
	private Coordinates position;
	private boolean isInRoom = false, isOwned = false;
	private Room room;

	Weapon(String name, Room room) {
		this.name = name;
		position = room.addWeapon();
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
		isInRoom = true;
	}
}
