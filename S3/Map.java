/* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */
package S3;

import java.util.HashMap;

public class Map {

	private final static int NUM_ROOMS = Names.ROOM_NAMES.length;
	private final static int D = 100, C=101, X=102;  // D = Door threshold, C = Corridor, X = Room or Prohibited
	private final static int MAP[][] = {             // Note: array indices are [row][col]
			{X,X,X,X,X,X,X,X,X,C,X,X,X,X,C,X,X,X,X,X,X,X,X,X},
			{X,X,X,X,X,X,X,C,C,C,X,X,X,X,C,C,C,X,X,X,X,X,X,X},
			{X,X,X,X,X,X,C,C,X,X,X,X,X,X,X,X,C,C,X,X,X,X,X,X},
			{X,X,X,X,X,X,C,C,X,X,X,X,X,X,X,X,C,C,X,X,X,X,X,X},
			{X,X,X,X,X,X,C,C,X,X,X,X,X,X,X,X,C,C,2,X,X,X,X,X},
			{X,X,X,X,X,X,C,D,1,X,X,X,X,X,X,1,D,C,D,X,X,X,X,X},
			{X,X,X,X,0,X,C,C,X,X,X,X,X,X,X,X,C,C,C,C,C,C,C,C},
			{C,C,C,C,D,C,C,C,X,1,X,X,X,X,1,X,C,C,C,C,C,C,C,X},
			{X,C,C,C,C,C,C,C,C,D,C,C,C,C,D,C,C,C,X,X,X,X,X,X},
			{X,X,X,X,X,C,C,C,C,C,C,C,C,C,C,C,C,D,3,X,X,X,X,X},
			{X,X,X,X,X,X,X,X,C,C,X,X,X,X,X,C,C,C,X,X,X,X,X,X},
			{X,X,X,X,X,X,X,X,C,C,X,X,X,X,X,C,C,C,X,X,X,X,X,X},
			{X,X,X,X,X,X,X,8,D,C,X,X,X,X,X,C,C,C,X,X,X,X,X,X},
			{X,X,X,X,X,X,X,X,C,C,X,X,X,X,X,C,C,C,C,C,D,C,C,X},
			{X,X,X,X,X,X,X,X,C,C,X,X,X,X,X,C,C,C,X,X,4,X,X,X},
			{X,X,X,X,X,X,8,X,C,C,X,X,X,X,X,C,C,X,X,X,X,X,X,X},
			{X,C,C,C,C,C,D,C,C,C,X,X,9,X,X,C,D,4,X,X,X,X,X,X},
			{C,C,C,C,C,C,C,C,C,C,C,D,D,C,C,C,C,X,X,X,X,X,X,X},
			{X,C,C,C,C,C,D,C,C,X,X,6,6,X,X,C,C,C,X,X,X,X,X,X},
			{X,X,X,X,X,X,7,C,C,X,X,X,X,X,X,C,C,C,C,C,C,C,C,C},
			{X,X,X,X,X,X,X,C,C,X,X,X,X,X,6,D,C,D,C,C,C,C,C,X},
			{X,X,X,X,X,X,X,C,C,X,X,X,X,X,X,C,C,5,X,X,X,X,X,X},
			{X,X,X,X,X,X,X,C,C,X,X,X,X,X,X,C,C,X,X,X,X,X,X,X},
			{X,X,X,X,X,X,X,C,C,X,X,X,X,X,X,C,C,X,X,X,X,X,X,X},
			{X,X,X,X,X,X,X,C,X,X,X,X,X,X,X,X,C,X,X,X,X,X,X,X},
	};
	private final static int NUM_COLS = MAP[0].length, NUM_ROWS = MAP.length;
	private final Room[] rooms = new Room[NUM_ROOMS];
	private final static HashMap<String,Coordinates> keyToCoordinates = new HashMap<>();

	Map() {

		//"Computer Science", first coordinates room position for weapons, then tokens, then doors
		rooms[0] = new Room(Names.ROOM_NAMES[0],new Coordinates(2,5),new Coordinates(1,1),new Coordinates[]{new Coordinates(4,6)});

		//"O'Reilly Hall"
		rooms[1] = new Room(Names.ROOM_NAMES[1],new Coordinates(11,3),new Coordinates(10,6),new Coordinates[]{new Coordinates(8,5), new Coordinates(9,7), new Coordinates(14,7), new Coordinates(15,5)});

		//"Engineering"
		rooms[2] = new Room(Names.ROOM_NAMES[2],new Coordinates(20,4),new Coordinates(20,2),new Coordinates[]{new Coordinates(18,4)});

		//"Sutherland"
		rooms[3] = new Room(Names.ROOM_NAMES[3],new Coordinates(18,10),new Coordinates(20,10),new Coordinates[]{new Coordinates(18,9),new Coordinates(22,12)});

		//"Quinn"
		rooms[4] = new Room(Names.ROOM_NAMES[4],new Coordinates(22,16),new Coordinates(18,15),new Coordinates[]{new Coordinates(17,16), new Coordinates(20,14)});

		//"Newman"
		rooms[5] = new Room(Names.ROOM_NAMES[5],new Coordinates(17,22),new Coordinates(19,21),new Coordinates[]{new Coordinates(17,21)});

		//"Library"
		rooms[6] = new Room(Names.ROOM_NAMES[6],new Coordinates(11,20),new Coordinates(10,19),new Coordinates[]{new Coordinates(11,18), new Coordinates(12,18), new Coordinates(14,20)});

		//"Ag Science"
		rooms[7] = new Room(Names.ROOM_NAMES[7],new Coordinates(0,21),new Coordinates(2,19),new Coordinates[]{new Coordinates(6,19)});

		//"O'Brien"
		rooms[8] = new Room(Names.ROOM_NAMES[8],new Coordinates(2,9),new Coordinates(2,11),new Coordinates[]{new Coordinates(6,15),new Coordinates(7,12)});

		//"Lake"
		rooms[9] = new Room(Names.ROOM_NAMES[9],new Coordinates(12,11),new Coordinates(11,14),new Coordinates[]{new Coordinates(12,17)});

		//creates passages for each of the corner rooms
		rooms[0].addPassage(rooms[5]);
		rooms[5].addPassage(rooms[0]);
		rooms[2].addPassage(rooms[7]);
		rooms[7].addPassage(rooms[2]);

		//sets the values for each of the inputs used to move a token
		keyToCoordinates.put("u", new Coordinates(0, -1));
		keyToCoordinates.put("d", new Coordinates(0, +1));
		keyToCoordinates.put("l", new Coordinates(-1, 0));
		keyToCoordinates.put("r", new Coordinates(+1, 0));
	}

	//test whether its a corridor or not
	private boolean isCorridor(Coordinates position) {
		return position.getCol() >= 0 && position.getCol() < NUM_COLS && position.getRow() >= 0 && position.getRow() < NUM_ROWS &&
				(MAP[position.getRow()][position.getCol()] == C || MAP[position.getRow()][position.getCol()] == D);
	}
	//test whether its a door or not
	public boolean isDoor(Coordinates currentPosition, Coordinates nextPosition) {
		return currentPosition.getCol() >= 0 && currentPosition.getCol() < NUM_COLS &&
				currentPosition.getRow() >= 0 && currentPosition.getRow() < NUM_ROWS &&
				nextPosition.getCol() >= 0 && nextPosition.getCol() < NUM_COLS &&
				nextPosition.getRow() >= 0 && nextPosition.getRow() < NUM_ROWS &&
				MAP[currentPosition.getRow()][currentPosition.getCol()] == D &&
				MAP[nextPosition.getRow()][nextPosition.getCol()] < NUM_ROOMS;
	}

	//returns the value of the room coordinates
	public Room getRoom(Coordinates position) {
		return rooms[MAP[position.getRow()][position.getCol()]];
	}


	public Room getRoom(String name) {
		for (Room room : rooms) {
			if (room.hasName(name)) {
				return room;
			}
		}
		return null;
	}
	//checks if the player is making a valid move
	public boolean isValidMove(Coordinates startingPosition, String key) {
		Coordinates newPosition = new Coordinates(startingPosition);
		newPosition.add(keyToCoordinates.get(key));
		return(isCorridor(newPosition) || isDoor(startingPosition, newPosition));
	}
	//returns the new coordinates when a player moves
	public Coordinates getNewPosition(Coordinates startingPosition, String key) {
		Coordinates newPosition = new Coordinates(startingPosition);
		newPosition.add(keyToCoordinates.get(key));
		return newPosition;
	}

}
