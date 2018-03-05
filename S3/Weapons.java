package S3;

import java.util.ArrayList;
import java.util.Iterator;

public class Weapons implements Iterable<Weapon>, Iterator<Weapon> {

	private final ArrayList<Weapon> weapons = new ArrayList<>();
	private Iterator<Weapon> iterator;

	Weapons(Map map) {
		weapons.add(new Weapon(Names.WEAPON_NAMES[0], map.getRoom(Names.ROOM_NAMES[0]))); //"Book"
		weapons.add(new Weapon(Names.WEAPON_NAMES[1], map.getRoom(Names.ROOM_NAMES[1]))); //"Bored"
		weapons.add(new Weapon(Names.WEAPON_NAMES[2], map.getRoom(Names.ROOM_NAMES[2]))); //"Gradcap"
		weapons.add(new Weapon(Names.WEAPON_NAMES[3], map.getRoom(Names.ROOM_NAMES[3]))); //"Librocop"
		weapons.add(new Weapon(Names.WEAPON_NAMES[4], map.getRoom(Names.ROOM_NAMES[4]))); //"Microscope"
		weapons.add(new Weapon(Names.WEAPON_NAMES[5], map.getRoom(Names.ROOM_NAMES[5]))); //"Seagull"
	}

	public Weapon get(String name) {
		for (Weapon weapon : weapons) {
			if (weapon.hasName(name)) {
				return weapon;
			}
		}
		return null;
	}

	public boolean hasNext() {
		return iterator.hasNext();
	}

	public Weapon next() {
		return iterator.next();
	}

	public Iterator<Weapon> iterator() {
		iterator = weapons.iterator();
		return iterator;
	}

}