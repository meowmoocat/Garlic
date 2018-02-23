package garlic;

import java.util.ArrayList;
import java.util.Iterator;

public class Weapons implements Iterable<Weapon>, Iterator<Weapon> {

	private final ArrayList<Weapon> weapons = new ArrayList<>();
	private Iterator<Weapon> iterator;

	Weapons() {
		weapons.add(new Weapon("Book", new Coordinates(2,5)));
		weapons.add(new Weapon("Bored",new Coordinates(11,3)));
		weapons.add(new Weapon("Gradcap",new Coordinates(20,4)));
		weapons.add(new Weapon("Librocop",new Coordinates(11,20)));
		weapons.add(new Weapon("Microscope",new Coordinates(0,21)));
		weapons.add(new Weapon("Seagull",new Coordinates(2,9)));
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