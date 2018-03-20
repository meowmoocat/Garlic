/* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */
package S3;

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
		return this.name.toLowerCase().equals(name.toLowerCase().trim());
	}

}
