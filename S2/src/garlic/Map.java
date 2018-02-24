package garlic;


public class Map 
{
	private final static Rooms room = new Rooms();

	Map()
	{



	}

	public int enterRoom(Token token, int row, int col, int diceReturn) {

		for(Room room : room)
		{
			if((row == room.getDoor1().getRow() && col == room.getDoor1().getCol()) 
					|| (row == room.getDoor2().getRow() && col == room.getDoor2().getCol()) 
					|| (row == room.getDoor3().getRow() && col == room.getDoor3().getCol())
					|| (row == room.getDoor4().getRow() && col == room.getDoor4().getCol())
					|| (row == room.getSecretPassage().getRow() && col == room.getSecretPassage().getCol()))
			{
				if(room.getName().equals("Computer Science"))
				{
					token.middleRoom(token.getCompSciPosition());
				}
				if(room.getName().equals("O'Reilly Hall"))
				{
					token.middleRoom(token.getOReillyHallPosition());
				}
				if(room.getName().equals("Engineering"))
				{
					token.middleRoom(token.getEngineeringPosition());
				}	
				if(room.getName().equals("Sutherland"))
				{
					token.middleRoom(token.getSutherlandPosition());
				}
				if(room.getName().equals("Quinn"))
				{
					token.middleRoom(token.getQuinnPosition());
				}
				if(room.getName().equals("Newman"))
				{
					token.middleRoom(token.getNewmanPosition());
				}
				if(room.getName().equals("Library"))
				{
					token.middleRoom(token.getLibraryPosition());
				}
				if(room.getName().equals("Ag Science"))
				{
					token.middleRoom(token.getAgSciPosition());
				}
				if(room.getName().equals("O'Brien"))
				{
					token.middleRoom(token.getOBrienPosition());
				}
				return 0;
			}
		}
		return diceReturn;
	}

	public boolean exitRoom(Token token, int row, int col, int diceReturn) {


		if(row == token.getCompSciPosition().getRow() && col == token.getCompSciPosition().getCol())
		{
			return true;
		}
		if(row == token.getEngineeringPosition().getRow() && col == token.getEngineeringPosition().getCol())
		{
			return true;
		}
		if(row == token.getLibraryPosition().getRow() && col == token.getLibraryPosition().getCol())
		{
			return true;
		}
		if(row == token.getAgSciPosition().getRow() && col == token.getAgSciPosition().getCol())
		{
			return true;
		}
		if(row == token.getNewmanPosition().getRow() && col == token.getNewmanPosition().getCol())
		{
			return true;
		}
		if(row == token.getOBrienPosition().getRow() && col == token.getOBrienPosition().getCol())
		{
			return true;
		}
		if(row == token.getOReillyHallPosition().getRow() && col == token.getOReillyHallPosition().getCol())
		{
			return true;
		}
		if(row == token.getQuinnPosition().getRow() && col == token.getQuinnPosition().getCol())
		{
			return true;
		}
		if(row == token.getSutherlandPosition().getRow() && col == token.getSutherlandPosition().getCol())
		{
			return true;
		}
		return false;
	}

}
