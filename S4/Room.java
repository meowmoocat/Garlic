package S4; 

/* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

public class Room {

	private final static int ITEM_AREA_WIDTH = 4;
	private final static int NUMBER_OF_ITEMS = 12;

	private final String name;
	private final Coordinates tokenArea;
	private final Coordinates weaponArea;
	private final Coordinates[] doors;
	private boolean hasPassage = false;
	private Room passageDestination;
	private final boolean[] squaresOccupied;

	Room(String name,Coordinates weaponArea, Coordinates tokenArea, Coordinates[] doors) {
		squaresOccupied = new boolean[NUMBER_OF_ITEMS];
		this.name = name;
		this.tokenArea = tokenArea;
		this.weaponArea = weaponArea;
		this.doors = doors;
		for (boolean squareOccupied : squaresOccupied) {
			squareOccupied = false;
		}
	}

	public String getName()
	{
		return this.name.toLowerCase().trim();
	}

	public boolean hasName(String name) {
		return this.name.toLowerCase().trim().equals(name.toLowerCase().trim());
	}

	public Coordinates getDoorCoordinates(int index) {
		return doors[index];
	}

	public int getNumberOfDoors() {
		return doors.length;
	}

	public void addPassage(Room room) {
		passageDestination = room;
		hasPassage = true;
	}

	public boolean hasPassage() {
		return hasPassage;
	}

	public Room getPassageDestination() {
		return passageDestination;
	}

	//adds token to a room
	public Coordinates addToken() {
		int squareNumber = 0;
		while (squaresOccupied[squareNumber]) {
			squareNumber++;
		}
		Coordinates position = new Coordinates(tokenArea);
		if (squareNumber <= ITEM_AREA_WIDTH) {
			position.add(new Coordinates(squareNumber , 0));
		} else if (squareNumber <= 2 * ITEM_AREA_WIDTH) {
			position.add(new Coordinates(squareNumber - ITEM_AREA_WIDTH, +1));
		} else {
			position.add(new Coordinates(squareNumber - 2*ITEM_AREA_WIDTH, +2));
		}
		squaresOccupied[squareNumber] = true;
		return position;
	}

	public void removeItem(Coordinates position) {
		int squareNumber =(position.getRow()-tokenArea.getRow())*ITEM_AREA_WIDTH+position.getCol()-tokenArea.getCol();
		squaresOccupied[squareNumber] = false;
	}

	public Coordinates addWeapon() {
		Coordinates position = new Coordinates(weaponArea);
		return position;
	}

	@Override
	public String toString() {
		return name;
	}
}
