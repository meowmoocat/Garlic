package garlic;

/* created by
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import java.util.HashSet;
import java.util.Iterator;

public class Rooms implements Iterable<Room>, Iterator<Room>
{
	private Iterator<Room> iterator;
	private final HashSet<Room> room = new HashSet<>();
	//	weaponPosition, doors

	//creates instance of rooms with coordinates entered for doors, -10,-10 and 0,0 are put in for doors that don't exist
	Rooms()
	{
		room.add(new Room("Computer Science", new Coordinates(2,5), //coordinates weapons(for movement between rooms)
				new Coordinates(4,6), new Coordinates(-10,-10), //door1, door2
				new Coordinates(-10,-10), new Coordinates(-10,-10), //door3, door4
				new Coordinates(23,21), new Coordinates(4,7), //secretpassage, exit1
				new Coordinates(0,0), new Coordinates(0,0),		//exit2, //exit3 
				new Coordinates(0,0))); 						//exit4

		room.add(new Room("O'Reilly Hall", new Coordinates(11,3),
				new Coordinates(8,5), new Coordinates(9,7), 
				new Coordinates(14,7), new Coordinates(15,5), 
				new Coordinates(-10,-10), new Coordinates(7,5), //secretpassage, exit1
				new Coordinates(9,8), new Coordinates(14,8),		//exit2, //exit3 
				new Coordinates(16,5))); 

		room.add(new Room("Engineering", new Coordinates(20,4),
				new Coordinates(18,4), new Coordinates(-10,-10), 
				new Coordinates(-10,-10), new Coordinates(-10,-10), 
				new Coordinates(0,19), new Coordinates(18,5), //secretpassage, exit1
				new Coordinates(0,0), new Coordinates(0,0),		//exit2, //exit3 
				new Coordinates(0,0))); 

		room.add(new Room("Sutherland", new Coordinates(18,10),
				new Coordinates(18,9), new Coordinates(22,12), 
				new Coordinates(-10,-10), new Coordinates(-10,-10),
				new Coordinates(-10,-10), new Coordinates(17,9), //secretpassage, exit1
				new Coordinates(22,13), new Coordinates(0,0),		//exit2, //exit3 
				new Coordinates(0,0))); 

		room.add(new Room("Quinn", new Coordinates(22,16),
				new Coordinates(17,16), new Coordinates(20,14), 
				new Coordinates(-10,-10), new Coordinates(-10,-10), 
				new Coordinates(-10,-10), new Coordinates(16,16), //secretpassage, exit1
				new Coordinates(20,13), new Coordinates(0,0),		//exit2, //exit3 
				new Coordinates(0,0))); 

		room.add(new Room("Newman", new Coordinates(17,22),
				new Coordinates(17,21), new Coordinates(-10,-10), 
				new Coordinates(-10,-10), new Coordinates(-10,-10), 
				new Coordinates(5,1), new Coordinates(17,20), //secretpassage, exit1
				new Coordinates(0,0), new Coordinates(0,0),		//exit2, //exit3 
				new Coordinates(0,0))); 

		room.add(new Room("Library", new Coordinates(11,20),
				new Coordinates(11,18), new Coordinates(12,18), 
				new Coordinates(14,20), new Coordinates(-10,-10), 
				new Coordinates(-10,-10), new Coordinates(11,17), //secretpassage, exit1
				new Coordinates(12,17), new Coordinates(15,20),		//exit2, //exit3 
				new Coordinates(0,0))); 

		room.add(new Room("Ag Science", new Coordinates(0,21),
				new Coordinates(6,19),  new Coordinates(-10,-10), 
				new Coordinates(-10,-10), new Coordinates(-10,-10), 
				new Coordinates(22,5), new Coordinates(6,18), //secretpassage, exit1
				new Coordinates(0,0), new Coordinates(0,0),		//exit2, //exit3 
				new Coordinates(0,0))); 

		room.add(new Room("O'Brien", new Coordinates(2,9),
				new Coordinates(6,15), new Coordinates(7,12), 
				new Coordinates(-10,-10), new Coordinates(-10,-10), 
				new Coordinates(-10,-10), new Coordinates(6,16), //secretpassage, exit1
				new Coordinates(8,12), new Coordinates(0,0),		//exit2, //exit3 
				new Coordinates(0,0))); 
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public Room next() {
		return iterator.next();
	}

	@Override
	public Iterator<Room> iterator() {
		iterator = room.iterator();
		return iterator;
	}
}
