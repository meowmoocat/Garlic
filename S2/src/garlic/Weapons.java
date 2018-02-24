package garlic;

/* created by
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Weapons implements Iterable<Weapon>, Iterator<Weapon> {

	private final ArrayList<Weapon> weapons = new ArrayList<>();
	private Iterator<Weapon> iterator;

	//creates weapons and adds them to the board
	Weapons() {
		weapons.add(new Weapon("Book", new Coordinates(2,5)));
		weapons.add(new Weapon("Bored",new Coordinates(11,3)));
		weapons.add(new Weapon("Gradcap",new Coordinates(20,4)));
		weapons.add(new Weapon("Librocop",new Coordinates(11,20)));
		weapons.add(new Weapon("Microscope",new Coordinates(0,21)));
		weapons.add(new Weapon("Seagull",new Coordinates(2,9)));
	}

	//loops through wepons and returns weapon
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
