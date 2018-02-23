package garlic;

import java.util.HashSet;
import java.util.Iterator;

public class Rooms implements Iterable<Room>, Iterator<Room>
{
	private Iterator<Room> iterator;
	private final HashSet<Room> room = new HashSet<>();
//	weaponPosition, doors
	
	Rooms()
	{
		room.add(new Room("Computer Science", new Coordinates(4,4),
				new Coordinates(4,6), new Coordinates(-10,-10), new Coordinates(-10,-10), 
				new Coordinates(-10,-10), new Coordinates(5,1)));
		
		room.add(new Room("O'Reilly Hall", new Coordinates(11,1),
				 new Coordinates(8,5), new Coordinates(9,7), new Coordinates(14,7), 
				 new Coordinates(15,5), new Coordinates(-10,-10)));
		
		room.add(new Room("Engineering", new Coordinates(20,5),
				new Coordinates(18,4), new Coordinates(-10,-10), 
				new Coordinates(-10,-10), new Coordinates(-10,-10), new Coordinates(22,5)));
		
		room.add(new Room("Sutherland", new Coordinates(19,10),
				new Coordinates(18,9), new Coordinates(22,12), 
				new Coordinates(-10,-10), new Coordinates(-10,-10), new Coordinates(-10,-10)));
		
		room.add(new Room("Quinn", new Coordinates(22,16),
				new Coordinates(17,16), new Coordinates(20,14), 
				new Coordinates(-10,-10), new Coordinates(-10,-10), new Coordinates(-10,-10)));
		
		room.add(new Room("Newman", new Coordinates(17,22),
				new Coordinates(17,21), new Coordinates(-10,-10), 
				new Coordinates(-10,-10), new Coordinates(-10,-10), new Coordinates(23,21)));
		
		room.add(new Room("Library", new Coordinates(11,24),
				new Coordinates(11,18), new Coordinates(12,18), 
				new Coordinates(14,20), new Coordinates(-10,-10), new Coordinates(-10,-10)));
		
		room.add(new Room("Ag Science", new Coordinates(1,20),
				new Coordinates(6,19),  new Coordinates(-10,-10), 
				new Coordinates(-10,-10), new Coordinates(-10,-10), new Coordinates(0,19)));
		
		room.add(new Room("O'Brien", new Coordinates(3,13),
				new Coordinates(6,15), new Coordinates(7,12), 
				new Coordinates(-10,-10), new Coordinates(-10,-10), new Coordinates(-10,-10)));
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
