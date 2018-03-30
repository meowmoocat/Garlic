package S4; 

public class Weapon {

	private final String name;
	private final Coordinates position;

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
	
	public boolean hasName(String name) {
		return this.name.toLowerCase().contains(name.toLowerCase().trim());
	}
}
