package garlic;

public class Cluedo {

	private final Tokens tokens = new Tokens();
	private final Weapons weapons = new Weapons();
	private final UI ui = new UI(tokens,weapons);

	private void testUI() {
		String command = "";
//		Token turn = tokens.get("White");
		Weapon dagger = weapons.get("Dagger");
		do {
			int i = 0;
			for(Token turn : tokens)
			{
				turn = tokens.get(i);
				command = ui.getCommand();
				ui.displayString(command);

				if(command.equals("d")) turn.moveBy(new Coordinates(0,+1));
				if(command.equals("l")) turn.moveBy(new Coordinates(-1,0));
				if(command.equals("r")) turn.moveBy(new Coordinates(+1,0));
				if(command.equals("u")) turn.moveBy(new Coordinates(0,-1));
				i++;
				ui.display();
			}
			

			dagger.moveBy(new Coordinates(+1,0));


			ui.display();
		} while (!command.equals("quit"));
	}

	public static void main(String[] args) {
		Cluedo game = new Cluedo();
		game.testUI();
		System.exit(0);
	}
}
