package src.Garlic;

import java.util.Random;

public class Moves 
{

	private final static Tokens tokens = new Tokens();
	private final static Weapons weapons = new Weapons();
	final static UI ui = new UI(tokens,weapons);
	String roll = "";

	Moves()
	{
		inputNames();
		roll();
		turns();
		
	}

	private void roll() {
		Random dice = new Random();
        do {
          Moves.ui.displayString("type roll to roll dice");
        	 roll = Moves.ui.getCommand();
        }while(!roll.equals("roll"));
       
        int n = dice.nextInt(10) + 2;
		String numberAsString = Integer.toString(n);
		Moves.ui.displayString(numberAsString);
		
	}

	private void turns()
	{
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

	private void inputNames()
	{
		String personName;
		String command;
		int numPlayers=0;

		Token white = tokens.getName("White");
		Token scarlett = tokens.getName("Scarlett");
		Token plum = tokens.getName("Plum");
		Token peacock = tokens.getName("Peacock");
		Token mustard = tokens.getName("Mustard");
		Token green = tokens.getName("Green");

		do {

			ui.displayString("Enter the name of the character you would like to be?\n(Example: White)\n(Enter quit into command if you are finished entering players!!)");
			command = ui.getCommand();
			ui.displayString(command);
			command=command.toLowerCase();

			while( !command.equals("white") && !command.equals("scarlett") && ! command.equals("plum") 
					&& !command.equals("peacock") && !command.equals("mustard") && !command.equals("green") 
					&& !command.equals("quit")) 
			{
				ui.displayString("Error entering character type!!"
						+ "\nEnter the name of the character you would like to be?(Example: White)");
				command = ui.getCommand();
				ui.displayString(command);
				command=command.toLowerCase();
			}

			if(!command.equals("quit")){
				ui.displayString("Enter your player name: ");
				personName = ui.getCommand();
				numPlayers++;
				ui.displayString(personName);
				personName=personName.toLowerCase();
				System.out.println(command);
				System.out.println(personName);
				System.out.println(numPlayers);


				if(command.equals("white")) {

					white.setPlayerName(personName);
					ui.displayString("Player White is: "+white.getPlayerName());

				}else if(command.equals("scarlett")) {

					scarlett.setPlayerName(personName);
					ui.displayString("Player Scarlett is: "+scarlett.getPlayerName());

				}else if(command.equals("plum")) {

					plum.setPlayerName(personName);
					ui.displayString("Player Plum is: "+plum.getPlayerName());

				}else if(command.equals("peacock")) {

					peacock.setPlayerName(personName);
					ui.displayString("Player Peacock is: "+peacock.getPlayerName());

				}else if(command.equals("mustard")) {

					mustard.setPlayerName(personName);
					ui.displayString("Player Mustard is: "+mustard.getPlayerName());

				}else if(command.equals("green")) {

					green.setPlayerName(personName);
					ui.displayString("Player Green is: "+green.getPlayerName());

				}
			}

			ui.display();

		} while (!command.equals("quit") && numPlayers<6);

	}
}
