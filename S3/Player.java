package S3;

public class Player {

	public final Notes notes = new Notes();
	
	private final String name;
	private final Token token;
//	private final Notes note;
	private int turn;

	Player(String name, Token token) {
		this.name = name;
		this.token = token;
	}

	
	//sets the turn for that token based on when that character was chosen
	public void setTurn(int turn)
	{
		this.turn = turn;
	}
	
	//returns the turn value
	public int getTurn()
	{
		return turn;
	}
	
	public boolean hasName(String name) {
		return this.name.toLowerCase().equals(name.trim());
	}

	public String getName() {
		return name;
	}

	public Token getToken() {
		return token;
	}

	@Override
	public String toString() {
		return name + " " + token.getName();
	}


}
