package garlic;


public class Map 
{
	private final static Rooms room = new Rooms();
	
	Map()
	{
		
		
		
	}

	public void enterRoom(Token token, int row, int col) {

		
		for(Room room : room)
		{
			System.out.println("door row: "+room.getDoor1().getRow());
			System.out.println("door col: "+room.getDoor1().getCol());
			if((row == room.getDoor1().getRow() && col == room.getDoor1().getCol()) 
					|| (row == room.getDoor2().getRow() && col == room.getDoor2().getCol()) 
					|| (row == room.getDoor3().getRow() && col == room.getDoor3().getCol())
					|| (row == room.getDoor4().getRow() && col == room.getDoor4().getCol()))
			{
//				for(Token token : token)
//				{
//					if(token.getPosition().getCol() == col && token.getPosition().getRow() == row)
//					{
						if(room.getName().equals("Computer Science"))
						{
							System.out.println(token.getCompSciPosition());
							token.middleRoom(token.getCompSciPosition());
						}
						if(room.getName().equals("O'Reilly Hall"))
						{
							System.out.println(token.getOReillyHallPosition());
							token.middleRoom(token.getOReillyHallPosition());
						}
						if(room.getName().equals("Engineering"))
						{
							System.out.println(token.getEngineeringPosition());
							token.middleRoom(token.getEngineeringPosition());
						}	
						if(room.getName().equals("Sutherland"))
						{
							System.out.println(token.getSutherlandPosition());
							token.middleRoom(token.getSutherlandPosition());
						}
						if(room.getName().equals("Quinn"))
						{
							System.out.println(token.getQuinnPosition());
							token.middleRoom(token.getQuinnPosition());
						}
						if(room.getName().equals("Newman"))
						{
							System.out.println(token.getNewmanPosition());
							token.middleRoom(token.getNewmanPosition());
						}
						if(room.getName().equals("Library"))
						{
							System.out.println(token.getLibraryPosition());
							token.middleRoom(token.getLibraryPosition());
						}
						if(room.getName().equals("Ag Science"))
						{
							System.out.println(token.getAgSciPosition());
							token.middleRoom(token.getAgSciPosition());
						}
						if(room.getName().equals("O'Brien"))
						{
							System.out.println(token.getOBrienPosition());
							token.middleRoom(token.getOBrienPosition());
						}
//					}
//				}
			}
		}
	}

//	public void checkBorders(int row, int col, int prevRow, int prevCol) {
//
//		if(prevCol==7 && prevRow==24 && col==7 && row==25 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==7 && prevRow==24 && col==6 && row==24 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==7 && prevRow==24 && col==8 && row==24 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//
//		if(prevCol==7 && prevRow==23 && col==6 && row==23 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==7 && prevRow==22 && col==6 && row==22 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==7 && prevRow==21 && col==6 && row==21 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==7 && prevRow==20 && col==6 && row==20 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==7 && prevRow==19 && col==6 && row==19 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==8 && prevRow==23 && col==9 && row==23 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==8 && prevRow==22 && col==9 && row==22 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==8 && prevRow==21 && col==9 && row==21 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==8 && prevRow==20 && col==9 && row==20 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==8 && prevRow==19 && col==9 && row==19 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==8 && prevRow==18 && col==9 && row==18 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==0 && prevRow==17 && col==0 && row==16 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==0 && prevRow==17 && col==0 && row==18 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==0 && prevRow==17 && col==-1 && row==17 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==1 && prevRow==18 && col==0 && row==18 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==1 && prevRow==18 && col==1 && row==19 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==2 && prevRow==18 && col==2 && row==19 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==3 && prevRow==18 && col==3 && row==19 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==4 && prevRow==18 && col==4 && row==19 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==5 && prevRow==18 && col==5 && row==19 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==1 && prevRow==16 && col==0 && row==16 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==1 && prevRow==16 && col==1 && row==15 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==2 && prevRow==16 && col==2 && row==15 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==3 && prevRow==16 && col==3 && row==15 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==4 && prevRow==16 && col==4 && row==15 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==5 && prevRow==16 && col==5 && row==15 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==7 && prevRow==16 && col==7 && row==15 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==8 && prevRow==15 && col==7 && row==15 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==8 && prevRow==14 && col==7 && row==14 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==8 && prevRow==13 && col==7 && row==13 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==8 && prevRow==11 && col==7 && row==11 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==8 && prevRow==10 && col==7 && row==10 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==7 && prevRow==9 && col==7 && row==10 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==6 && prevRow==9 && col==6 && row==10 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==5 && prevRow==9 && col==5 && row==10 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==5 && prevRow==9 && col==4 && row==9 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==8 && prevRow==23 && col==8 && row==24 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==4 && prevRow==8 && col==4 && row==9 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==3 && prevRow==8 && col==3 && row==9 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==2 && prevRow==8 && col==2 && row==9 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==1 && prevRow==8 && col==1 && row==9 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==1 && prevRow==8 && col==0 && row==8 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==0 && prevRow==7 && col==0 && row==6 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==0 && prevRow==7 && col==0 && row==8 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==0 && prevRow==7 && col==-1 && row==7 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==1 && prevRow==7 && col==1 && row==6 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==2 && prevRow==7 && col==2 && row==6 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==3 && prevRow==7 && col==3 && row==6 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==5 && prevRow==7 && col==5 && row==6 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==6 && prevRow==6 && col==5 && row==6 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==6 && prevRow==5 && col==5 && row==5 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==6 && prevRow==4 && col==5 && row==4 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==6 && prevRow==3 && col==5 && row==3 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==6 && prevRow==2 && col==5 && row==2 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==6 && prevRow==2 && col==6 && row==1 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==9 && prevRow==0 && col==9 && row==-1 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==9 && prevRow==0 && col==8 && row==0 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==9 && prevRow==0 && col==10 && row==0 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==9 && prevRow==1 && col==10 && row==1 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==9 && prevRow==1 && col==9 && row==2 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==8 && prevRow==1 && col==8 && row==0 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==8 && prevRow==1 && col==8 && row==2 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==7 && prevRow==1 && col==7 && row==0 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==7 && prevRow==1 && col==6 && row==1 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==7 && prevRow==2 && col==8 && row==2 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==7 && prevRow==3 && col==8 && row==3 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==7 && prevRow==4 && col==8 && row==4 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==7 && prevRow==6 && col==8 && row==6 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==7 && prevRow==7 && col==8 && row==7 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==8 && prevRow==8 && col==8 && row==7 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==10 && prevRow==8 && col==10 && row==7 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==11 && prevRow==8 && col==11 && row==7 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==12 && prevRow==8 && col==12 && row==7 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==13 && prevRow==8 && col==13 && row==7 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==8 && col==15 && row==7 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==16 && prevRow==7 && col==15 && row==7 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==16 && prevRow==6 && col==15 && row==6 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==16 && prevRow==4 && col==15 && row==4 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==16 && prevRow==3 && col==15 && row==3 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==16 && prevRow==2 && col==15 && row==2 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==14 && prevRow==0 && col==14 && row==-1 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==14 && prevRow==0 && col==13 && row==0 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==14 && prevRow==0 && col==15 && row==0 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==14 && prevRow==1 && col==13 && row==1 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==14 && prevRow==1 && col==14 && row==2 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==1 && col==15 && row==0 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==1 && col==15 && row==2 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==16 && prevRow==1 && col==16 && row==0 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==16 && prevRow==1 && col==17 && row==1 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==17 && prevRow==2 && col==17 && row==1 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==17 && prevRow==2 && col==18 && row==2 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==17 && prevRow==3 && col==18 && row==3 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==17 && prevRow==4 && col==18 && row==4 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==18 && prevRow==5 && col==19 && row==5 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==23 && prevRow==6 && col==23 && row==5 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==23 && prevRow==6 && col==24 && row==6 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==23 && prevRow==6 && col==23 && row==7 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==22 && prevRow==6 && col==22 && row==5 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==21 && prevRow==6 && col==21 && row==5 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==20 && prevRow==6 && col==20 && row==5 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==19 && prevRow==6 && col==19 && row==5 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==22 && prevRow==7 && col==23 && row==7 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==22 && prevRow==7 && col==22 && row==8 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==21 && prevRow==7 && col==21 && row==8 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==20 && prevRow==7 && col==20 && row==8 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==19 && prevRow==7 && col==19 && row==8 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==18 && prevRow==7 && col==18 && row==8 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==17 && prevRow==8 && col==18 && row==8 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==17 && prevRow==10 && col==18 && row==10 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==17 && prevRow==11 && col==18 && row==11 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==17 && prevRow==12 && col==18 && row==12 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==18 && prevRow==13 && col==18 && row==12 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==18 && prevRow==13 && col==18 && row==14 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==19 && prevRow==13 && col==19 && row==12 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==19 && prevRow==13 && col==19 && row==14 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==20 && prevRow==13 && col==20 && row==12 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==21 && prevRow==13 && col==21 && row==12 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==21 && prevRow==13 && col==21 && row==14 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==22 && prevRow==13 && col==22 && row==14 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==22 && prevRow==13 && col==23 && row==13 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==17 && prevRow==14 && col==18 && row==14 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==17 && prevRow==14 && col==17 && row==15 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==16 && prevRow==15 && col==17 && row==15 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==16 && prevRow==17 && col==17 && row==17 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==17 && prevRow==18 && col==17 && row==17 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==17 && prevRow==18 && col==18 && row==18 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==23 && prevRow==19 && col==23 && row==18 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==23 && prevRow==19 && col==24 && row==19 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==23 && prevRow==19 && col==23 && row==20 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==22 && prevRow==20 && col==23 && row==20 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==22 && prevRow==20 && col==22 && row==21 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==21 && prevRow==20 && col==21 && row==21 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==20 && prevRow==20 && col==20 && row==21 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==19 && prevRow==20 && col==19 && row==21 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==18 && prevRow==20 && col==18 && row==21 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==16 && prevRow==21 && col==17 && row==21 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==16 && prevRow==22 && col==17 && row==22 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==16 && prevRow==23 && col==17 && row==23 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==16 && prevRow==24 && col==17 && row==24 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==16 && prevRow==24 && col==16 && row==25 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==16 && prevRow==24 && col==15 && row==24 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==23 && col==15 && row==24 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==23 && col==14 && row==23 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==22 && col==14 && row==22 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==21 && col==14 && row==21 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==19 && col==14 && row==19 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==18 && col==14 && row==18 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==14 && prevRow==17 && col==14 && row==16 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==14 && prevRow==17 && col==14 && row==18 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==13 && prevRow==17 && col==13 && row==16 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==13 && prevRow==17 && col==13 && row==18 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==11 && prevRow==17 && col==11 && row==16 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==10 && prevRow==17 && col==10 && row==16 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==10 && prevRow==17 && col==10 && row==18 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==9 && prevRow==17 && col==9 && row==18 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==9 && prevRow==16 && col==10 && row==16 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==9 && prevRow==15 && col==10 && row==15 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==9 && prevRow==14 && col==10 && row==14 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==9 && prevRow==13 && col==10 && row==13 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==9 && prevRow==12 && col==10 && row==12 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==9 && prevRow==11 && col==10 && row==11 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==9 && prevRow==10 && col==10 && row==10 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==10 && prevRow==9 && col==10 && row==10 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==11 && prevRow==9 && col==11 && row==10 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==12 && prevRow==9 && col==12 && row==10 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==13 && prevRow==9 && col==13 && row==10 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==14 && prevRow==9 && col==14 && row==10 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==10 && col==14 && row==10 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==11 && col==14 && row==11 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==12 && col==14 && row==12 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==13 && col==14 && row==13 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==14 && col==14 && row==14 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==15 && col==14 && row==15 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//		if(prevCol==15 && prevRow==16 && col==14 && row==16 ) {
//			col=prevCol;
//			row=prevRow;
//		}
//
//	}

}
