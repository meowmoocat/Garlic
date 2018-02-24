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


		if(row == token.getCompSciPosition().getRow() && row == token.getCompSciPosition().getCol())
		{
			return true;
		}
		if(row == token.getEngineeringPosition().getRow() && row == token.getEngineeringPosition().getCol())
		{
			return true;
		}
		if(row == token.getLibraryPosition().getRow() && row == token.getLibraryPosition().getCol())
		{
			return true;
		}
		if(row == token.getAgSciPosition().getRow() && row == token.getAgSciPosition().getCol())
		{
			return true;
		}
		if(row == token.getNewmanPosition().getRow() && row == token.getNewmanPosition().getCol())
		{
			return true;
		}
		if(row == token.getOBrienPosition().getRow() && row == token.getOBrienPosition().getCol())
		{
			return true;
		}
		if(row == token.getOReillyHallPosition().getRow() && row == token.getOReillyHallPosition().getCol())
		{
			return true;
		}
		if(row == token.getQuinnPosition().getRow() && row == token.getQuinnPosition().getCol())
		{
			return true;
		}
		if(row == token.getSutherlandPosition().getRow() && row == token.getSutherlandPosition().getCol())
		{
			return true;
		}
		return false;
	}

}
