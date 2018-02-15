package ui;

import java.util.ArrayList;
import java.util.Iterator;

public class Weapons implements Iterable<Weapon>, Iterator<Weapon>
{
	private final ArrayList<Weapon> weapons = new ArrayList<>();
	private Iterator<Weapon> iterator;
	
	Weapons()
	{
		weapons.add(new Weapon("candlestick", new Coordinates(1,1)));
		weapons.add(new Weapon("dagger", new Coordinates(2,2)));
		weapons.add(new Weapon("pipe", new Coordinates(3,3)));
		weapons.add(new Weapon("revolver", new Coordinates(4,4)));
		weapons.add(new Weapon("spanner", new Coordinates(5,5)));
		weapons.add(new Weapon("rope", new Coordinates(6,6)));
	}

	public Weapon get(String name)
	{
		for(Weapon weapon : weapons)
		{
			if(weapon.hasName(name))
			{
				return weapon;
			}
		}
		return null;
	}
	
	@Override
	public boolean hasNext()
	{
		return iterator.hasNext();
	}

	@Override
	public Weapon next() 
	{
		return iterator.next();
	}

	@Override
	public Iterator<Weapon> iterator()
	{
		iterator = weapons.iterator();
		return iterator;
	}
	
}
