package garlic;

public class Coordinates {

	private int row, col;
	private int prevRow,prevCol;

	Coordinates(int col, int row) {
		this.col = col;
		this.row = row;
	}

	public void add(Coordinates coordinates) {

		prevCol=col;
		prevRow=row;

		System.out.println(prevCol);
		System.out.println(prevRow);

		col = col + coordinates.getCol();
		row = row + coordinates.getRow();

		System.out.println(col);
		System.out.println(row);

		checkBorders();

	}

	private void checkBorders() {

		if(prevCol==7 && prevRow==24 && col==7 && row==25 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==7 && prevRow==24 && col==6 && row==24 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==7 && prevRow==24 && col==8 && row==24 ) {
			col=prevCol;
			row=prevRow;
		}

		if(prevCol==7 && prevRow==23 && col==6 && row==23 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==7 && prevRow==22 && col==6 && row==22 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==7 && prevRow==21 && col==6 && row==21 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==7 && prevRow==20 && col==6 && row==20 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==7 && prevRow==19 && col==6 && row==19 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==8 && prevRow==23 && col==9 && row==23 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==8 && prevRow==22 && col==9 && row==22 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==8 && prevRow==21 && col==9 && row==21 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==8 && prevRow==20 && col==9 && row==20 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==8 && prevRow==19 && col==9 && row==19 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==8 && prevRow==18 && col==9 && row==18 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==0 && prevRow==17 && col==0 && row==16 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==0 && prevRow==17 && col==0 && row==18 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==0 && prevRow==17 && col==-1 && row==17 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==1 && prevRow==18 && col==0 && row==18 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==1 && prevRow==18 && col==1 && row==19 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==2 && prevRow==18 && col==2 && row==19 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==3 && prevRow==18 && col==3 && row==19 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==4 && prevRow==18 && col==4 && row==19 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==5 && prevRow==18 && col==5 && row==19 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==1 && prevRow==16 && col==0 && row==16 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==1 && prevRow==16 && col==1 && row==15 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==2 && prevRow==16 && col==2 && row==15 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==3 && prevRow==16 && col==3 && row==15 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==4 && prevRow==16 && col==4 && row==15 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==5 && prevRow==16 && col==5 && row==15 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==7 && prevRow==16 && col==7 && row==15 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==8 && prevRow==15 && col==7 && row==15 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==8 && prevRow==14 && col==7 && row==14 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==8 && prevRow==13 && col==7 && row==13 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==8 && prevRow==11 && col==7 && row==11 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==8 && prevRow==10 && col==7 && row==10 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==7 && prevRow==9 && col==7 && row==10 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==6 && prevRow==9 && col==6 && row==10 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==5 && prevRow==9 && col==5 && row==10 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==5 && prevRow==9 && col==4 && row==9 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==8 && prevRow==23 && col==8 && row==24 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==4 && prevRow==8 && col==4 && row==9 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==3 && prevRow==8 && col==3 && row==9 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==2 && prevRow==8 && col==2 && row==9 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==1 && prevRow==8 && col==1 && row==9 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==1 && prevRow==8 && col==0 && row==8 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==0 && prevRow==7 && col==0 && row==6 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==0 && prevRow==7 && col==0 && row==8 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==0 && prevRow==7 && col==-1 && row==7 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==1 && prevRow==7 && col==1 && row==6 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==2 && prevRow==7 && col==2 && row==6 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==3 && prevRow==7 && col==3 && row==6 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==5 && prevRow==7 && col==5 && row==6 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==6 && prevRow==6 && col==5 && row==6 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==6 && prevRow==5 && col==5 && row==5 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==6 && prevRow==4 && col==5 && row==4 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==6 && prevRow==3 && col==5 && row==3 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==6 && prevRow==2 && col==5 && row==2 ) {
			col=prevCol;
			row=prevRow;
		}
		if(prevCol==6 && prevRow==2 && col==6 && row==1 ) {
			col=prevCol;
			row=prevRow;
		}


	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
}
