package garlic;

public class Cluedo {

	private final Tokens tokens = new Tokens();
	private final Weapons weapons = new Weapons();
	private final UI ui = new UI(tokens,weapons);
	
	private void testUI() {
		
	}
	
	



	public static void main(String[] args) {
		Cluedo game = new Cluedo();
		Moves move = new Moves();
		
		System.exit(0);
	}
}
