package S4; 

/* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Weapons implements Iterable<Weapon>, Iterator<Weapon> {

	private final ArrayList<Weapon> weapons = new ArrayList<>();
	private Iterator<Weapon> iterator;
	
	Weapons (Map map) {
		weapons.add(new Weapon(Names.WEAPON_NAMES[0],map.getRoom(Names.ROOM_NAMES[0])));//book, computer science
		weapons.add(new Weapon(Names.WEAPON_NAMES[1],map.getRoom(Names.ROOM_NAMES[1])));//bored, O'reilly hall
		weapons.add(new Weapon(Names.WEAPON_NAMES[2],map.getRoom(Names.ROOM_NAMES[2])));//gradcap, engineering
		weapons.add(new Weapon(Names.WEAPON_NAMES[3],map.getRoom(Names.ROOM_NAMES[3])));//librocop, sutherland
		weapons.add(new Weapon(Names.WEAPON_NAMES[4],map.getRoom(Names.ROOM_NAMES[4])));//microscope, quinn
		weapons.add(new Weapon(Names.WEAPON_NAMES[5],map.getRoom(Names.ROOM_NAMES[5])));//seagull, newman
	}

	public boolean contains(String name)
	{
		for(Weapon weapon : weapons)
		{
			if(weapon.hasName(name))
			{
				return true;
			}
		}
		return false;
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
		return iterator.hasNext ();
	}

	public Weapon next() {
		return iterator.next ();
	}

	public Iterator<Weapon> iterator() {
		iterator = weapons.iterator ();
		return iterator;
	}

}
