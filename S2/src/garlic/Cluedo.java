package garlic;

public class Cluedo {

	private void testUI() {
		
	}
	
	
	private void inputNames()
	{
		String personName;
        int numPlayers=0;
        
        Token white = tokens.get("White");
        Token scarlett = tokens.get("Scarlett");
        Token plum = tokens.get("Plum");
        Token peacock = tokens.get("Peacock");
        Token mustard = tokens.get("Mustard");
        Token green = tokens.get("Green");
   
        do {
        	
        	ui.displayString("Enter the name of the character you would like to be?\n(Example: White)\n(Enter quit into command if you are finished entering players!!)");
            command = ui.getCommand();
            ui.displayString(command);
            command=command.toLowerCase();
            
            numPlayers++;
            
            while( !command.equals("white") && !command.equals("scarlett") && ! command.equals("plum") 
            		&& !command.equals("peacock") && !command.equals("mustard") && !command.equals("green")) 
            {
            	ui.displayString("Error entering character type!!"
            			+ "\nEnter the name of the character you would like to be?(Example: White)");
                command = ui.getCommand();
                ui.displayString(command);
                command=command.toLowerCase();
            }
            
            ui.displayString("Enter your player name: ");
            personName = ui.getCommand();
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
            
            ui.display();
            
        } while (!command.equals("quit") && numPlayers<6);
		
		
		
		Moves start = new Moves();
	}


	public static void main(String[] args) {
		Cluedo game = new Cluedo();
		
		game.inputNames();
		System.exit(0);
	}
}
